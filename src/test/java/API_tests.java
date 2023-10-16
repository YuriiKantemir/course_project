import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.asynchttpclient.Request;
import org.example.automation.Config;
import org.example.automation.app.api.JSONData;
import org.example.automation.app.api.Login;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.regex.Matcher;

public class API_tests {

    String userId;
    String projectId;
    String taskId;
    Login login = new Login();

    @Test(groups = {"API_tests"})
    public void createUser() {

       String userId = login.request()
                .contentType(ContentType.JSON)
                .body(JSONData.getCreateUser("TestUser","test01"))
                .post()
                .then()
                .statusCode(200)
                .extract()
                .path("result").toString();

        Assert.assertNotEquals(userId, "false");

        this.userId = userId;
        System.out.println(userId);
    }

    @Test(groups = {"API_tests"}, dependsOnMethods = "removeProject")
    public void removeUser() {

                 login.request()
                .contentType(ContentType.JSON)
                .body(JSONData.removeUser(userId))
                .post()
                .then().statusCode(200)
                .body("result", Matchers.equalTo(true));
    }

    @Test(groups = {"API_tests"}, dependsOnMethods = "createUser")
    public void createProject(){
        String projectId = login.request()
                .contentType(ContentType.JSON)
                .body(JSONData.createProject(userId))
                .post()
                .then()
                .statusCode(200)
                .extract()
                .path("result").toString();

        Assert.assertNotEquals(projectId, "false");

        this.projectId = projectId;

    }
    @Test(groups = {"API_tests"}, dependsOnMethods = "removeTask")
    public void removeProject() {
        login.request()
                .contentType(ContentType.JSON)
                .body(JSONData.removeProject(projectId))
                .post()
                .then().statusCode(200)
                .body("result", Matchers.equalTo(true));
    }

    @Test(groups = {"API_tests"}, dependsOnMethods = "createProject")
    public void createTask() {

        String taskId = login.request()
                .contentType(ContentType.JSON)
                .body(JSONData.createTask(projectId))
                .post()
                .then()
                .statusCode(200)
                .extract()
                .path("result").toString();

        Assert.assertEquals(taskId, taskId);

        this.taskId = taskId;
    }

    @Test(groups = {"API_tests"}, dependsOnMethods = "createTask")
    public void removeTask() {
        login.request()
                .contentType(ContentType.JSON)
                .body(JSONData.removeTask(taskId))
                .post()
                .then().statusCode(200)
                .body("result", Matchers.equalTo(true));
    }


}
