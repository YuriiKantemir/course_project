package org.example.automation.base;

import io.restassured.http.ContentType;
import org.example.automation.Config;
import org.example.automation.Session;
import com.codeborne.selenide.WebDriverRunner;
import org.example.automation.app.api.JSONData;
import org.example.automation.app.api.Login;
import org.example.automation.app.api.ProjectDataGenerator;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseGUITest
{
    protected String userId;
    protected String projectId;
    String taskId;
    Login login = new Login();
    String testProject;
    @BeforeClass
    public void setUp(){

        String userId = login.request()
                .contentType(ContentType.JSON)
                .body(JSONData.getCreateUser(ProjectDataGenerator.getUniqueUserName(),"test01"))
                .post()
                .path("result").toString();

        this.userId = userId;

        String projectId = login.request()
                .contentType(ContentType.JSON)
                .body(JSONData.createProject(userId))
                .post()
                .path("result").toString();

        this.projectId = projectId;


        login.request()
                .contentType(ContentType.JSON)
                .body(JSONData.addUserToProject(projectId, userId))
                .post()
                //.then().log().body().toString();
                .path("result").toString();

        this.projectId = projectId;
    }
    @BeforeMethod(alwaysRun = true)
    public void before() {
        this.wd().get(String.format("http://%s:%s",
                Config.HTTP_BASE_HOST.value,
                Config.HTTP_BASE_PORT.value
        ));
        WebDriverRunner.setWebDriver(this.wd());
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        Session.get().close();
    }

    protected WebDriver wd() {
        return Session.get().webdriver();
    }

    @AfterClass
    public void setUpDelete(){

        login.request()
                .contentType(ContentType.JSON)
                .body(JSONData.removeProject(projectId))
                .post()
                .then().statusCode(200)
                .body("result", Matchers.equalTo(true));
        System.out.println();


        login.request()
                .contentType(ContentType.JSON)
                .body(JSONData.removeUser(userId))
                .post()
                .then().statusCode(200)
                .body("result", Matchers.equalTo(true));
    }
}
