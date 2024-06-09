package com.github.crud.pages;

import com.github.crud.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GithubHomePage extends BasePage {
    @FindBy(linkText = "Sign in")
    private WebElement signInButton;

    @Step("Click the Sign In button")
    public void clickSignIn() {
        signInButton.click();
    }
}


