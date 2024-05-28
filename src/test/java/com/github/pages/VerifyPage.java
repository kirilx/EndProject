package com.github.pages;

import com.github.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step; // Import Allure's Step annotation

public class VerifyPage extends BasePage {

    @FindBy(css = "#captcha-and-submit-container .text-mono")
    private WebElement verifyPageElement;

    @FindBy(xpath = "//button[contains(text(),'Verify')]")
    private WebElement verifyButton;

    @FindBy(css = ".match-game")
    private WebElement matchGame;

    @FindBy(css = "button.sc-nkuzb1-0.yuVdl")
    private WebElement submitButton;

    @FindBy(css = ".audio-button")
    private WebElement audioButton;

    @Step("Get verify page text")
    public String getVerifyPageText() {
        waitForElementToBeVisible(verifyPageElement);
        return verifyPageElement.getText();
    }

    @Step("Click verify button")
    public void clickVerifyButton() {
        waitToBeClickable(By.xpath("//button[contains(text(),'Verify')]"));
        verifyButton.click();
    }

    @Step("Check if match game is displayed")
    public boolean isMatchGameDisplayed() {
        return matchGame.isDisplayed();
    }

    @Step("Check if submit button is displayed")
    public boolean isSubmitButtonDisplayed() {
        return submitButton.isDisplayed();
    }

    @Step("Check if audio button is displayed")
    public boolean isAudioButtonDisplayed() {
        return audioButton.isDisplayed();
    }
}
