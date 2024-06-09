package com.github.crud.pages;

import com.github.crud.base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

public class DeleteRepository extends BasePage {

    @FindBy(css = "#settings-tab")
    private WebElement settingTab;

    @FindBy(css = "#dialog-show-repo-delete-menu-dialog")
    private WebElement deleteButton;

    @FindBy(css = "#repo-delete-proceed-button-container")
    private WebElement readAndUnderstandButtonFirst;

    @FindBy(css = ".Overlay-footer #repo-delete-proceed-button .Button-label")
    private WebElement readAndUnderstandButtonSecond;

    @FindBy(css = "#verification_field")
    private WebElement verificationField;

    @FindBy(css = "#repo-delete-proceed-button")
    private WebElement repoConfirmDeleteButton ;

    @FindBy(css = " #sudo_password")
    private WebElement passwordField ;

    @FindBy(css = "button[type='submit']")
    private WebElement passwordConfirmButton;

    @FindBy(css = "#js-flash-container div[aria-atomic='true']")
    private WebElement successfullyDeletedText;

    @Step("Click on Setting Tab")
    public void clickSettingTab() {
        settingTab.click();
    }

    @Step("Click on Delete Button")
    public void clickDeleteButton() {
        scrollIntoViewWithJS(deleteButton);
        deleteButton.click();
    }

    @Step("Click on First Read and Understand Button")
    public void clickReadAndUnderstandFirst() {
        readAndUnderstandButtonFirst.click();
    }

    @Step("Click on Second Read and Understand Button")
    public void clickReadAndUnderstandSecond() {
        readAndUnderstandButtonSecond.click();
    }

    @Step("Enter Verification Text")
    public void enterVerificationText(String text) {
        verificationField.sendKeys(text);
    }

    @Step("Enter Password")
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    @Step("Click on Confirm Repository Deletion Button")
    public void clickConfirmRepoDeletion() {
        waitToBeClickable(repoConfirmDeleteButton);
        repoConfirmDeleteButton.click();
    }

    @Step("Confirm Deletion")
    public void confirmPasswordDeletion() {
        passwordConfirmButton.click();
    }

    @Step("Confirm Deletion with Enter Key")
    public void confirmDeletionWithEnterKey() {
        passwordConfirmButton.sendKeys(Keys.RETURN);
    }

    @Step("Get Successfully Deleted Text")
    public String getSuccessfullyDeletedText() {
        return successfullyDeletedText.getText();
    }
}
