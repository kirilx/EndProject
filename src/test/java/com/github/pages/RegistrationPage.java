package com.github.pages;

import com.github.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;

public class RegistrationPage extends BasePage {

    @FindBy(className = "js-continue-container")
    private WebElement registrationForm;

    @FindBy(partialLinkText = "Sign up")
    private WebElement signUpButton;

    @FindBy(id = "email")
    private WebElement emailInputField;

    @FindBy(css = " #email-container .js-continue-button")
    private WebElement continueButtonEmail;

    @FindBy(css = "#password-container .js-continue-button")
    private WebElement continueButtonPassword;

    @FindBy(css = "#username-container .js-continue-button")
    private WebElement continueButtonId;

    @FindBy(css = "#opt-in-container .js-continue-button")
    private WebElement continueButtonCheckbox;

    @FindBy(css = "#password")
    private WebElement passwordInputField;

    @FindBy(css = "#login")
    private WebElement usernameId;

    @FindBy(css = "#email-err .mb-0")
    private WebElement emailErrorMessage;

    @FindBy(xpath = "//*[@id='password-err']/p[1]")
    private WebElement passwordErrorMessage;

    @FindBy(css = "#login-err div.mb-1")
    private WebElement usernameInvalidSymbolErrorMessage;

    @FindBy(css = "#login-err .m-1")
    private WebElement usernameTooLongError;


    @FindBy(className = "password-validity-pill-fail")
    private WebElement passwordErrorValidityIndicator;

    @FindBy(xpath = "//*[@id='password-err']/div/span[2]")
    private WebElement passwordErrorValidityIndicatorYellow;

    @FindBy(xpath = "//*[@id='password-err']/p[2]")
    private WebElement passwordErrorMessageText;

    @FindBy(id = "opt_in")
    private WebElement checkbox;



    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+[]{}|;:,.<>?/";

    private static final SecureRandom random = new SecureRandom();

    public boolean isRegistrationFormDisplayed() {
        return registrationForm.isDisplayed();
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }

    public void setEmail(String email) {
        waitToBeClickable(By.id("email"));
        emailInputField.clear();
        emailInputField.sendKeys(email);
    }

    public void clickButton() {
        waitToBeClickable(By.cssSelector(" #email-container .js-continue-button"));
        continueButtonEmail.click();
    }

    public void clickButtonPassword() {
        waitToBeClickable(By.cssSelector("#password-container .js-continue-button"));
        continueButtonPassword.click();
    }

    public void setPassword(String password) {
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
    }

    public void setUsername(String username) {
        waitToBeClickable(By.cssSelector("#login"));
        usernameId.clear();
        usernameId.sendKeys(username);
    }

    public void clickContinueButtonForId() {
        waitToBeClickable(By.cssSelector("#username-container .js-continue-button"));
        continueButtonId.click();
    }

    public String getEmailErrorMessage() {
        return emailErrorMessage.getText();
    }


    public String getPasswordErrorMessage() {
        return passwordErrorMessage.getText();
    }

    public String getUsernameErrorMessageText() {
        return usernameInvalidSymbolErrorMessage.getText();
    }

    public String getUsernameTooLongErrorMessage() {
        return usernameTooLongError.getText();

    }

    public boolean isPasswordValidityShortDisplayed() {
        return passwordErrorValidityIndicator.isDisplayed();
    }

    public String getPasswordErrorMessageText() {
        return passwordErrorMessageText.getText();
    }

    public boolean isPasswordValidityShortDisplayedYellow() {
        return passwordErrorValidityIndicatorYellow.isDisplayed();
    }

    public void clickCheckbox() {
        checkbox.click();
    }

    public boolean isCheckboxSelected() {
        return checkbox.isSelected();

    }
    public void clickContinueCheckboxButton() {
        continueButtonCheckbox.click();
}
    //Генериране на неправилни пароли + правелен емайл
    public String generateInvalidPassword() {
        int length = 4; // Short password length

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int choice = random.nextInt(3);
            switch (choice) {
                case 0:
                    password.append(LOWER.charAt(random.nextInt(LOWER.length())));
                    break;
                case 1:
                    password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
                    break;
                case 2:
                    password.append(SPECIAL.charAt(random.nextInt(SPECIAL.length())));
                    break;
            }
        }

        return password.toString();
    }

    public void exportEmailPasswordPairsToCSV(int numPairs, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("Email,InvalidPassword\n");
            for (int i = 0; i < numPairs; i++) {
                String email = generateRandomEmail();
                String password = generateInvalidPassword();
                writer.append(email).append(",").append(password).append("\n");
            }
            System.out.println("Email and password pairs exported to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String generateRandomEmail() {
        StringBuilder email = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            email.append(LOWER.charAt(random.nextInt(LOWER.length())));
        }
        email.append("@example.com"); // Use a common domain for simplicity
        return email.toString();
    }
}
