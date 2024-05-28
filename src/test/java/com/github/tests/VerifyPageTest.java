package com.github.tests;

import Utils.CsvReader;
import com.github.base.MainTest;
import com.github.pages.RegistrationPage;
import com.github.pages.SingUpPage;
import com.github.pages.VerifyPage;
import com.opencsv.exceptions.CsvException;
import io.qameta.allure.Epic;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
@Epic("Verification")
public class VerifyPageTest extends MainTest {

    @Test(dataProvider = "valid-verify-page-data")
    public void testVerifyPage(String email, String password, String username, String expectedText) {
        SingUpPage signUpPage = new SingUpPage();
        signUpPage.clickSignUpButton();

        RegistrationPage registrationPage = new RegistrationPage();

        registrationPage.setEmail(email);
        registrationPage.clickButton();

        registrationPage.setPassword(password);
        registrationPage.clickButtonPassword();

        registrationPage.setUsername(username);
        registrationPage.clickContinueButtonForId();

        registrationPage.clickCheckbox();
        registrationPage.clickContinueCheckboxButton();


        VerifyPage verifyPage = new VerifyPage();


        verifyPage.clickVerifyButton();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(verifyPage.getVerifyPageText(), expectedText, "Verification text does not match.");
        softAssert.assertTrue(verifyPage.isMatchGameDisplayed(), "Match game is not displayed.");
        softAssert.assertTrue(verifyPage.isSubmitButtonDisplayed(), "Submit button is not displayed.");
        softAssert.assertTrue(verifyPage.isAudioButtonDisplayed(), "Audio button is not displayed.");


        softAssert.assertAll();
    }

    @DataProvider(name = "valid-verify-page-data")
    public static Object[][] validVerifyDataProvider() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/valid-verify-page-data.csv");
    }
}
