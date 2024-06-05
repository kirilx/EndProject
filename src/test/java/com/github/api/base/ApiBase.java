package com.github.api.base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApiBase {

    static final String BASE_URI = "https://api.github.com";
    static String TOKEN;

    @BeforeMethod
    public void setUp() throws IOException {
        Properties properties = new Properties();


        try (FileInputStream input = new FileInputStream("src/test/resources/configapi.properties")) {
            properties.load(input);
        }

        TOKEN = properties.getProperty("github.token");

        if (TOKEN == null || TOKEN.isEmpty()) {
            throw new IllegalStateException("GitHub token is not set in configapi.properties.");
        }

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
