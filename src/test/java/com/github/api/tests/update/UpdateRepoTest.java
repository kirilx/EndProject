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

        var repoPatched = new Repository( "testcreate-patched");


        Response response = RestAssured
                .given()
                .auth()
                .oauth2(TOKEN)
                .body(repoPatched)
                .when()
                .patch("https://api.github.com/repos/kirilz-ta/testcreate")
                .then()
                .statusCode(200)
                .extract()
                .response();


    }
}
