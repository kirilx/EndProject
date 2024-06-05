package com.github.api.base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;

public class ApiBase {

    static final String BASE_URI = "https://api.github.com";
    static final String TOKEN = " ";

    @BeforeMethod
    public void setUp() {



        RestAssured.baseURI = BASE_URI;
        RestAssured.authentication = RestAssured.oauth2(TOKEN);
    }

    public boolean doesRepoExist(String username, String repoName) {
        Response response = RestAssured
                .given()
                .pathParam("username", username )
                .pathParam("repo", repoName)
                .get("/repos/{username}/{repo}");

        return response.getStatusCode() == 200;
    }

    public void deleteRepo(String user, String repoName) {
        RestAssured
                .given()
                .pathParam("user",user)
                .pathParam("repo", repoName)
                .delete("/repos/{user}/{repo}")
                .then()
                .statusCode(204);
    }
}
