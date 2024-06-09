package com.github.crud.tests;

import com.github.crud.base.MainTest;
import com.github.crud.pages.GithubDashboardPage;
import com.github.crud.pages.GithubHomePage;
import com.github.crud.pages.GithubLoginPage;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CsvReader;

import java.io.IOException;

public class GithubLoginPageTest extends MainTest {

    @Test(dataProvider = "validUserDetails", priority = 2)
    public void testLoginWithValidCredentials(String username, String password) {
        GithubHomePage githubHomePage = new GithubHomePage();

        githubHomePage.clickSignIn();

        GithubLoginPage loginPage = new GithubLoginPage();

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickSignInButton();

        GithubDashboardPage githubDashboardPage = new GithubDashboardPage();


        String actualHeaderText = githubDashboardPage.getDashboardHeaderText();
        String expectedHeaderText = "Home";
        Assert.assertEquals(actualHeaderText, expectedHeaderText);
    }


    @DataProvider(name = "validUserDetails")
    public Object[][] validUserDetailsDataProvider() throws IOException, CsvException {
        // Read valid user details from a CSV file or any other source
        return CsvReader.readCsvFile("src/test/resources/valid-user-details.csv");
    }
}
