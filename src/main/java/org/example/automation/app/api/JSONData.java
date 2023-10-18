package org.example.automation.app.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class JSONData {
//    public void getUsername(){
//        String json = getCreateUser().toString();
//        String jsonString = json; //assign your JSON String here
//        JsonObject obj = new JsonObject(jsonString);
//        String pageName = obj.getAsJsonObject("createUser").getAsString("username");
//        JsonArray arr = obj.getAsJsonArray("username"); // notice that `"posts": [...]`
//        for (int i = 0; i < arr.length(); i++)
//        {
//            String post_id = arr.getJSONObject(i).getString("post_id");
//    ......
//        }
//    }

    static public String getCreateUser(String username, String password) {
        JsonObject createUser = new JsonObject();
        createUser.add("jsonrpc", new JsonPrimitive("2.0"));
        createUser.add("method", new JsonPrimitive("createUser"));
        createUser.add("id", new JsonPrimitive(15));

        JsonObject params = new JsonObject();
        params.add("username", new JsonPrimitive(username));
        params.add("password", new JsonPrimitive(password));

        createUser.add("params", params);

        return createUser.toString();

    }

    static public String removeUser(String userId) {
        JsonObject createUser = new JsonObject();
        createUser.add("jsonrpc", new JsonPrimitive("2.0"));
        createUser.add("method", new JsonPrimitive("removeUser"));
        createUser.add("id", new JsonPrimitive(15));

        JsonObject params = new JsonObject();
        params.add("user_id", new JsonPrimitive(userId));

        createUser.add("params", params);

        return createUser.toString();

    }

    static public String createProject(String userId, String projectName) {
        JsonObject createUser = new JsonObject();
        createUser.add("jsonrpc", new JsonPrimitive("2.0"));
        createUser.add("method", new JsonPrimitive("createProject"));
        createUser.add("id", new JsonPrimitive(15));

        JsonObject params = new JsonObject();
        params.add("name", new JsonPrimitive(projectName));
        params.add("owner_id", new JsonPrimitive(userId));

        createUser.add("params", params);

        return createUser.toString();

    }
    static public String addUserToProject(String projectId, String userId) {
        JsonObject createUser = new JsonObject();
        createUser.add("jsonrpc", new JsonPrimitive("2.0"));
        createUser.add("method", new JsonPrimitive("addProjectUser"));
        createUser.add("id", new JsonPrimitive(15));

        JsonObject params = new JsonObject();
        params.add("project_id", new JsonPrimitive(projectId));
        params.add("user_id", new JsonPrimitive(userId));

        createUser.add("params", params);

        return createUser.toString();

    }

    static public String removeProject(String projectId) {
        JsonObject createUser = new JsonObject();
        createUser.add("jsonrpc", new JsonPrimitive("2.0"));
        createUser.add("method", new JsonPrimitive("removeProject"));
        createUser.add("id", new JsonPrimitive(15));

        JsonObject params = new JsonObject();
        params.add("project_id", new JsonPrimitive(projectId));

        createUser.add("params", params);

        return createUser.toString();

    }
    static public String createTask(String projectId) {
        JsonObject createUser = new JsonObject();
        createUser.add("jsonrpc", new JsonPrimitive("2.0"));
        createUser.add("method", new JsonPrimitive("createTask"));
        createUser.add("id", new JsonPrimitive(15));

        JsonObject params = new JsonObject();
        params.add("title", new JsonPrimitive("Test Task"));
        params.add("project_id", new JsonPrimitive(projectId));

        createUser.add("params", params);

        return createUser.toString();

    }

    static public String removeTask(String taskId) {
        JsonObject createUser = new JsonObject();
        createUser.add("jsonrpc", new JsonPrimitive("2.0"));
        createUser.add("method", new JsonPrimitive("removeTask"));
        createUser.add("id", new JsonPrimitive(15));

        JsonObject params = new JsonObject();
        params.add("task_id", new JsonPrimitive(taskId));

        createUser.add("params", params);

        return createUser.toString();

    }

}
