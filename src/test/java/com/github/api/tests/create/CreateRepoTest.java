package com.github.api.tests.create;


import api.restassuredpresets.Repository;
import com.github.api.base.ApiBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.testng.Assert.assertEquals;


public class CreateRepoTest extends ApiBase {

    static final String REPO_EP = "/user/repos";
    private final String username = "kirilz-ta";
    private final String repoName = "testcreate";

    @Test(description = "Delete repo if exists", priority = 1)
    void deleteRepoIfExistsTest() {
        if (doesRepoExist(username, repoName)) {
            deleteRepo(username, repoName);
        } else {
            System.out.println("Repository does not exist, no need to delete.");
        }
    }

    @Test(description = "Create a repo", priority = 2)
    void createTest() {

        var repo = new Repository("testcreate");

        Response createResponse = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(repo)
                .when()
                .post(REPO_EP)
                .then()
                .statusCode(201)
                .body("name", not(emptyOrNullString()))
                .extract()
                .response();

        String nameRepo = createResponse.jsonPath().getString("name");
        boolean isPrivate = createResponse.jsonPath().getBoolean("private");

        assertEquals(nameRepo, "testcreate");
        assertEquals(isPrivate, false);
    }
}