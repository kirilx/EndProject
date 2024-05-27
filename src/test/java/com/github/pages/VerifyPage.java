package com.github.pages;

import com.github.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VerifyPage extends BasePage {

    @FindBy(css = "#captcha-and-submit-container .text-mono")
    private WebElement verifyPageElement;

    @FindBy(css = ".button.sc-nkuzb1-0")
    private WebElement verifyButton;

    @FindBy(css = ".match-game")
    private WebElement matchGame;

    @FindBy(css = "button.sc-nkuzb1-0.yuVdl")
    private WebElement submitButton;

    @FindBy(css = ".audio-button")
    private WebElement audioButton;


    public String getVerifyPageText() {
        waitForElementToBeVisible(verifyPageElement);
        return verifyPageElement.getText();
    }

    public void clickVerifyButton() {
        waitToBeClickable((By) verifyButton);
        verifyButton.click();
    }

    public boolean isMatchGameDisplayed() {
        return matchGame.isDisplayed();
    }

    public boolean isSubmitButtonDisplayed() {
        return submitButton.isDisplayed();
    }

    public boolean isAudioButtonDisplayed() {
        return audioButton.isDisplayed();
    }


}
