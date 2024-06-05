package com.github.api.tests.read;

import api.restassuredpresets.Repository;

import com.github.api.base.ApiBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ReadRepoTest extends ApiBase {

    static final String REPO_EP = "/user/repos";

    @Test(description = "List user repos", priority = 3)
    void getReposTest() {
        Response response = RestAssured
                .given()
                .when()
                .get(REPO_EP)
                .then()
                .statusCode(200)
                .extract()
                .response();



        Assert.assertNotNull(response.getBody().asString(), "Response body should not be null");
    }

    @Test(description = "Get specific repo details", priority = 4)
    void getRepoTest() {
        var repoName = new Repository("testcreate");
        String expectedRepoName = repoName.getRepoName();

        Response response = RestAssured
                .given()
                .when()
                .get("/repos/kirilz-ta/" + expectedRepoName)
                .then()
                .statusCode(200)
                .extract()
                .response();

        Assert.assertEquals(response.path("name"), expectedRepoName, "Incorrect repository name");
    }
}
