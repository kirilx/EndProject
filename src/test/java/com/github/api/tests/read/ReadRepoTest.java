package com.github.api.tests.read;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadRepoTest {
    static final String TOKEN = "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";
    private static final String BASE_URL = "https://api.github.com";
    private static final String USERNAME = "kirilz-ta";

    @Test(description = "List user repos", priority = 2)
    void getReposTest() {
        Response response = RestAssured
                .given()
                .log().all()
                .auth()
                .oauth2(TOKEN)
                .when()
                .get(BASE_URL + "/user/repos")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();

        Assert.assertNotNull(response.getBody().asString(), "Response body should not be null");
    }

    @Test(description = "Get specific repo details", priority = 3)
    void getRepoTest() {
        String repoName = "testcreate";

        Response response = RestAssured
                .given()
                .auth()
                .oauth2(TOKEN)
                .when()
                .get(String.format("/repos/%s/%s", USERNAME, repoName))
                .then()
                .statusCode(200)
                .extract()
                .response();

        Assert.assertEquals(response.path("name"), repoName, "Incorrect repository name");
        Assert.assertEquals(response.path("owner.login"), USERNAME, "Incorrect repository owner");
    }
}
