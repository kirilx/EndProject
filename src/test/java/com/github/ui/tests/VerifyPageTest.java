package com.github.ui.tests;

import Utils.CsvReader;
import com.github.ui.pages.VerifyPage;
import com.github.ui.base.MainTest;
import com.github.ui.pages.RegistrationPage;
import com.github.ui.pages.SingUpPage;
import com.opencsv.exceptions.CsvException;
import io.qameta.allure.Epic;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static java.lang.Thread.sleep;

@Epic("Verification")
public class VerifyPageTest extends MainTest {

    @Test(dataProvider = "valid-verify-page-data")
    public void testVerifyPage(String email, String password, String username, String expectedText) throws InterruptedException {
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
        sleep(5000);
        registrationPage.clickContinueCheckboxButton();




        VerifyPage verifyPage = new VerifyPage();

        verifyPage.switchToParentIframe();
        verifyPage.switchToChildIframe();
        verifyPage.switchToSecondChildIframe();


        verifyPage.clickVerifyButton();

        SoftAssert softAssert = new SoftAssert();


        softAssert.assertTrue(verifyPage.isMatchGameDisplayed(), "Match game is not displayed.");
        softAssert.assertTrue(verifyPage.isSubmitButtonDisplayed(), "Submit button is not displayed.");
        softAssert.assertTrue(verifyPage.isAudioButtonDisplayed(), "Audio button is not displayed.");
        verifyPage.switchToDefaultContent();

        softAssert.assertAll();
        softAssert.assertEquals(verifyPage.getVerifyPageText(), expectedText, "Verification text does not match.");
    }

    @DataProvider(name = "valid-verify-page-data")
    public static Object[][] validVerifyDataProvider() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/valid-verify-page-data.csv");
    }



    }
