package com.github.api.tests.update;

import api.restassuredpresets.Repository;
import com.github.api.base.ApiBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.emptyOrNullString;

public class UpdateRepoTest extends ApiBase {

    static final String REPO_EP = "/repos/kirilz-ta/testcreate";

    @Test(description = "Update a repo", priority = 5)
    void updateTest() {
        var repo = new Repository("testcreate-updated");

        Response updateResponse = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(repo)
                .when()
                .patch(REPO_EP)
                .then()
                .statusCode(200)
                .body("name", not(emptyOrNullString()))
                .extract()
                .response();

    }
}
