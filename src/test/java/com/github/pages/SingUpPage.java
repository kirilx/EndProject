package com.github.pages;

import com.github.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SingUpPage extends BasePage {

    @FindBy(partialLinkText = "Sign up")
    private WebElement signUpButton;

    public void clickSignUpButton () {
        signUpButton.click();
    }
}