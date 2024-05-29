package com.github.ui.pages;

import com.github.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step; // Import Allure's Step annotation

public class VerifyPage extends BasePage {

    @FindBy(xpath = "//*[@id='captcha-and-submit-container']/div[1]")
    private WebElement verifyPageElement;

    @FindBy(xpath = "//button[contains(text(),'Verify')]")
    private WebElement verifyButton;

    @FindBy(css = ".match-game")
    private WebElement matchGame;

    @FindBy(css = "button.sc-nkuzb1-0.yuVdl")
    private WebElement submitButton;

    @FindBy(css = ".audio-button")
    private WebElement audioButton;


    @FindBy(css = "iframe[title='Please verify by completing this captcha.']")
    WebElement verificationParentIframe;

    @FindBy(css = "iframe[title='Verification challenge']")
    WebElement verificationChildFirstIframe;

    @FindBy(css = "#game-core-frame")
    WebElement verificationChildSecondIframe;

   @Step("Get verify page text")
   public String getVerifyPageText() {
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

    @Step("Switch to verification iframe")
    public void switchToParentIframe() {
        switchToIframeWhenItReady(By.cssSelector("iframe[title='Please verify by completing this captcha.']"));
    }

    @Step("Switch to child iframe")
    public void switchToChildIframe() {
        switchToIframeWhenItReady(By.cssSelector("iframe[title='Verification challenge']"));
    }

    @Step("Switch to second child iframe")
    public void switchToSecondChildIframe() {
        switchToIframeWhenItReady(By.cssSelector("#game-core-frame"));
    }
}