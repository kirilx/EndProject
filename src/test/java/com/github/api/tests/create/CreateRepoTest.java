package com.github.api.tests.create;

import api.prestassured.Repository;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class CreateRepoTest {
    static final String TOKEN = "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";
    static final String REPO_EP ="https://api.github.com/user/repos" ;

    @Test(description = "Create a repo",priority = 1)
    void postTest() {
        var repo = new Repository("testcreate");

        RestAssured
                .given()
                .auth()
                .oauth2(TOKEN)
                .body(repo)
                .when()
                .post(REPO_EP)
                .then()
                .statusCode(201);
    }

}
