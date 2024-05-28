package com.github.tests;

import Utils.CsvReader;
import com.github.base.MainTest;
import com.github.pages.RegistrationPage;
import com.opencsv.exceptions.CsvException;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Arrays;
@Epic("Registration")
public class RegistrationPageTest extends MainTest {

    @Test(dataProvider = "invalid-email", priority = 1)
    public void testInvalidEmailFormat(String email) {
        RegistrationPage registrationPage = new RegistrationPage();

        registrationPage.clickSignUpButton();
        registrationPage.setEmail(email);

        String actualErrorMessage = registrationPage.getEmailErrorMessage();
        Assert.assertEquals(actualErrorMessage, "Email is invalid or already taken");
    }

    @DataProvider(name = "invalid-email")
    public static Object[][] invalidEmailProvider() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/invalid-email.csv");
    }

    @Test(dataProvider = "generated-invalid-short-passwords", priority = 2)
    public void testInvalidPassword(String email, String password) {
        RegistrationPage registrationPage = new RegistrationPage();
        SoftAssert softAssert = new SoftAssert();

        registrationPage.clickSignUpButton();
        registrationPage.setEmail(email);
        registrationPage.clickButton();
        registrationPage.setPassword(password);

        String passwordErrorMessage = registrationPage.getPasswordErrorMessage();
        String expectedPasswordErrorMessage = "Password is too short";

        softAssert.assertEquals(passwordErrorMessage, expectedPasswordErrorMessage);

        softAssert.assertTrue(registrationPage.isPasswordValidityShortDisplayed());

        String passwordErrorMessageText = registrationPage.getPasswordErrorMessageText();
        String passwordErrorExpectedMessageText = "Make sure it's at least 15 characters OR at least 8 characters including a number and a lowercase letter.";

        softAssert.assertEquals(passwordErrorMessageText, passwordErrorExpectedMessageText);

        softAssert.assertAll();
    }

    @DataProvider(name = "generated-invalid-short-passwords")
    public static Object[][] invalidPasswordDataProvider() throws IOException, CsvException {
        Object[][] data = CsvReader.readCsvFile("src/test/resources/generated-invalid-short-passwords.csv");
        return Arrays.copyOfRange(data, 1, data.length);
    }

    @Test(dataProvider = "invalid-passwords-alphabet", priority = 3)
    public void testInvalidAlphabetPassword(String email, String password) {
        RegistrationPage registrationPage = new RegistrationPage();
        SoftAssert softAssert = new SoftAssert();

        registrationPage.clickSignUpButton();
        registrationPage.setEmail(email);
        registrationPage.clickButton();
        registrationPage.setPassword(password);

        String passwordErrorMessage = registrationPage.getPasswordErrorMessage();
        String expectedPasswordErrorMessage = "Password needs a number and lowercase letter";
        Assert.assertEquals(passwordErrorMessage, expectedPasswordErrorMessage);

        softAssert.assertEquals(passwordErrorMessage, expectedPasswordErrorMessage);

        softAssert.assertTrue(registrationPage.isPasswordValidityShortDisplayedYellow());

        String passwordErrorMessageText = registrationPage.getPasswordErrorMessageText();
        String passwordErrorExpectedMessageText = "Make sure it's at least 15 characters OR at least 8 characters including a number and a lowercase letter.";

        softAssert.assertEquals(passwordErrorMessageText, passwordErrorExpectedMessageText);

        softAssert.assertAll();
    }

    @DataProvider(name = "invalid-passwords-alphabet")
    public static Object[][] invalidAlphabetPasswordDataProvider() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/invalid-password-alphabet.csv");
    }

    @Test(dataProvider = "invalid-username", priority = 4)
    public void testInvalidUsername(String email, String password, String username) {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickSignUpButton();

        registrationPage.setEmail(email);
        registrationPage.clickButton();

        registrationPage.setPassword(password);
        registrationPage.clickButtonPassword();

        registrationPage.setUsername(username);

        String expectedUsernameErrorMessage = "Username may only contain alphanumeric characters or single hyphens, and cannot begin or end with a hyphen.";
        String actualUsernameErrorMessage = registrationPage.getUsernameErrorMessageText();

        Assert.assertEquals(actualUsernameErrorMessage, expectedUsernameErrorMessage);
    }

    @DataProvider(name = "invalid-username")
    public static Object[][] invalidUsernameDataProvider() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/invalid-username.csv");
    }

    @Test(dataProvider = "invalid-username-too-long", priority = 5)
    public void testInValidIdTooLong(String email, String password, String username, String expectedErrorMessage) {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickSignUpButton();

        registrationPage.setEmail(email);
        registrationPage.clickButton();

        registrationPage.setPassword(password);
        registrationPage.clickButtonPassword();

        registrationPage.setUsername(username);

        Assert.assertEquals(registrationPage.getUsernameTooLongErrorMessage(), expectedErrorMessage);
    }

    @DataProvider(name = "invalid-username-too-long")
    public static Object[][] InValidIdTooLongProvider() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/invalid-username-too-long.csv");
    }

    @Test(dataProvider = "valid-id", priority = 6)
    public void testValidId(String email, String password, String username) {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickSignUpButton();

        registrationPage.setEmail(email);
        registrationPage.clickButton();

        registrationPage.setPassword(password);
        registrationPage.clickButtonPassword();

        registrationPage.setUsername(username);
        registrationPage.clickContinueButtonForId();
        registrationPage.clickCheckbox();
        Assert.assertTrue(registrationPage.isCheckboxSelected());
    }

    @DataProvider(name = "valid-id")
    public static Object[][] validIdDataProvider() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/valid-id.csv");
    }
}
