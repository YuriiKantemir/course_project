package org.example.automation.app.api;

import io.restassured.specification.RequestSpecification;
import org.example.automation.Config;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class Login
{
    public  RequestSpecification request() {
        return this.request(null, null);
    }
    public RequestSpecification request(String username, String password) {
        username = username != null ? username : Config.API_USER_NAME.value;
        password = password != null ? password : Config.API_USER_TOKEN.value;

        return RestAssured.given()
                .baseUri(Config.getBaseURL().toString())
                .auth()
                .basic(username, password);
    }
}
