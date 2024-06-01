package com.github.api.tests.update;

import api.prestassured.Repository;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateRepoTest {

    static final String TOKEN = "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";
    static final String REPO_EP = "https://api.github.com/user/repos";

    @Test(description = "Update a repo" ,priority = 4)
    void patchTest() {
        String updatedRepoName = "testcreate-patched";
        var repo = new Repository(updatedRepoName);


        Response response = RestAssured
                .given()
                .auth()
                .oauth2(TOKEN)
                .body(repo)
                .when()
                .patch("https://api.github.com/repos/kirilz-ta/kirotest")
                .then()
                .statusCode(200)
                .extract()
                .response();


        String actualRepoName = response.jsonPath().getString("name");
        Assert.assertEquals(actualRepoName, updatedRepoName, "Repository name does not match");
    }
}
