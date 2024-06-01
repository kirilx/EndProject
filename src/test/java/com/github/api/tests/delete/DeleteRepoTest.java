package com.github.api.tests.delete;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;

public class DeleteRepoTest {

    static final String TOKEN = "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";
    static final String REPO_EP ="https://api.github.com/user/repos" ;

    @Test(description = "Delete a repo" , priority = 5)
    void deleteTest() {
        // Deleting the repository
        RestAssured
                .given()
                .auth()
                .oauth2(TOKEN)
                .when()
                .delete("https://api.github.com/repos/kirilz-ta/testcreate-patched")
                .then()
                .statusCode(204);


        given()
                .auth()
                .oauth2(TOKEN)
                .when()
                .get("https://api.github.com/repos/kirilz-ta/testcreate-patched")
                .then()
                .statusCode(404) // Expecting 404 Not Found
                .body("message", not(emptyOrNullString()));
    }
}
