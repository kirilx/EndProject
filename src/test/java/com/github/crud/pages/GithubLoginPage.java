package com.github.crud.pages;

import com.github.crud.base.BasePage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GithubLoginPage extends BasePage {
    private WebDriver driver;

    @FindBy(css = "label[for='login_field']")
    private WebElement usernamePasswordText;


    @FindBy(id = "login_field")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "input[type='submit']")
    private WebElement signInButton;

    @Step("Get the username and password text")
    public String getUsernamePasswordText() {
        return usernamePasswordText.getText();
    }

    @Step("Enter the username")
    public void enterUsername(String username) {
        loginField.clear();
        loginField.sendKeys(username);
    }

    @Step("Enter the password")
    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @Step("Click the sign-in button")
    public void clickSignInButton() {
        signInButton.click();
    }
}