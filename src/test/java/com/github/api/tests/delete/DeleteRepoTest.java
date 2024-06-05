package com.github.api.tests.delete;


import com.github.api.base.ApiBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;

public class DeleteRepoTest extends ApiBase {

    static final String REPO_EP = "/repos/kirilz-ta/testcreate-updated";

    @Test(description = "Delete a repo", priority = 6)
    void deleteTest() {

        Response deleteResponse = RestAssured
                .given()
                .when()
                .delete(REPO_EP)
                .then()
                .statusCode(204)
                .extract()
                .response();


        Response getResponse = given()
                .when()
                .get(REPO_EP)
                .then()
                .statusCode(404)
                .body("message", not(emptyOrNullString()))
                .extract()
                .response();


    }
}
