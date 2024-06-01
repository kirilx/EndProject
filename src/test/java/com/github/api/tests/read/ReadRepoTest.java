package com.github.api.tests.read;

import api.prestassured.Repository;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadRepoTest {
    static final String TOKEN = "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";
    static final String BASE_URI= "https://api.github.com";
    static final String REPO_EP = "https://api.github.com/user/repos";

    @Test(description = "List user repos", priority = 2)
    void getReposTest() {
        Response response = RestAssured
                .given()
                .auth()
                .oauth2(TOKEN)
                .when()
                .get( REPO_EP)
                .then()
                .statusCode(200)
                .extract()
                .response();

        Assert.assertNotNull(response.getBody().asString(), "Response body should not be null");
    }

    @Test(description = "Get specific repo details", priority = 3)
    void getRepoTest() {
        var repoName = new Repository("testcreate");
        String expectedRepoName = repoName.getRepoName();

        Response response = RestAssured
                .given()
                .auth()
                .oauth2(TOKEN)
                .when()
                .get( BASE_URI + "/repos/kirilz-ta/" + expectedRepoName)
                .then()
                .statusCode(200)
                .extract()
                .response();

        Assert.assertEquals(response.path("name"), expectedRepoName, "Incorrect repository name");
    }
}
