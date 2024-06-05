package com.github.ui.tests;

import utils.CsvReader;
import com.github.ui.pages.GitHubVerifyPage;
import com.github.ui.base.MainTest;
import com.github.ui.pages.GitHubSignupPage;
import com.github.ui.pages.GitHubHomePage;
import com.opencsv.exceptions.CsvException;
import io.qameta.allure.Epic;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static java.lang.Thread.sleep;

@Epic("Verification")
public class GitHubGitHubVerifyPageTest extends MainTest {

    @Test(dataProvider = "valid-verify-page-data")
    public void testVerifyPage(String email, String password, String username, String expectedText) throws InterruptedException {
        GitHubHomePage signUpPage = new GitHubHomePage();
        signUpPage.clickSignUpButton();

        GitHubSignupPage gitHubSignupPage = new GitHubSignupPage();

        gitHubSignupPage.setEmail(email);
        gitHubSignupPage.clickButton();

        gitHubSignupPage.setPassword(password);
        gitHubSignupPage.clickButtonPassword();

        gitHubSignupPage.setUsername(username);
        gitHubSignupPage.clickContinueButtonForId();

        gitHubSignupPage.clickCheckbox();
        sleep(5000);
        gitHubSignupPage.clickContinueCheckboxButton();




        GitHubVerifyPage gitHubVerifyPage = new GitHubVerifyPage();

        gitHubVerifyPage.switchToParentIframe();
        gitHubVerifyPage.switchToChildIframe();
        gitHubVerifyPage.switchToSecondChildIframe();


        gitHubVerifyPage.clickVerifyButton();

        SoftAssert softAssert = new SoftAssert();


        softAssert.assertTrue(gitHubVerifyPage.isMatchGameDisplayed(), "Match game is not displayed.");
        softAssert.assertTrue(gitHubVerifyPage.isSubmitButtonDisplayed(), "Submit button is not displayed.");
        softAssert.assertTrue(gitHubVerifyPage.isAudioButtonDisplayed(), "Audio button is not displayed.");

        gitHubVerifyPage.switchToDefaultContent();

        softAssert.assertAll();
        softAssert.assertEquals(gitHubVerifyPage.getVerifyPageText(), expectedText, "Verification text does not match.");
    }

    @DataProvider(name = "valid-verify-page-data")
    public static Object[][] validVerifyDataProvider() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/valid-verify-page-data.csv");
    }



    }
