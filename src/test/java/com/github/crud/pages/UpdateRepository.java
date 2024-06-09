package com.github.crud.pages;

import com.github.crud.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class UpdateRepository extends BasePage {

    private WebDriver driver;

    @FindBy(css = "#settings-tab")
    private WebElement settingTab;

    @FindBy(css = "input[name='new_name']")
    private WebElement repositoryNameField;

    @FindBy(css = "button[data-disable-with='Renaming...']")
    private WebElement renameButton;

    @FindBy(css = "strong[itemprop='name']")
    private WebElement repoText;



    @Step("Click Setting Tab")
    public void clickSettingTab() {
        settingTab.click();
    }

    @Step("Set Repository Name: {0}")
    public void setRepositoryName(String newName) {
        repositoryNameField.clear();
        repositoryNameField.sendKeys(newName);
    }

    @Step("Click Rename Button")
    public void clickRenameButton() {
        waitToBeClickable(renameButton);
        renameButton.click();
    }

    @Step("Get Repository Text")
    public String getRepositoryText() {
        return repoText.getText();
    }
}