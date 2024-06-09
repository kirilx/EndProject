package com.github.crud.pages;

import com.github.crud.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateRepository extends BasePage {
    @FindBy(css = "h1[class='Heading__StyledHeading-sc-1c1dgg0-0 jsAuBe']")
    private WebElement headingText;

    @FindBy(xpath = " //*[@id=':r4:']")
    private WebElement repositoryNameInputField;

    @FindBy(css = "input[aria-checked='true']")
    private WebElement checkedBox;

    @FindBy(xpath = "//*[text()='Create repository']")
    private WebElement createButton;

    @Step("Get heading text")
    public String getHeadingText() {
        return headingText.getText();
    }

    @Step("Set repository name: {repositoryName}")
    public void setRepositoryName(String repositoryName) {
        waitForElementToBeVisible(repositoryNameInputField);
        repositoryNameInputField.clear();
        repositoryNameInputField.sendKeys(repositoryName);
    }

    @Step("Click checkbox")
    public void clickCheckedBox() {
        checkedBox.click();
    }

    @Step("Check if checkbox is present")
    public boolean isCheckedBoxPresent() {
        return checkedBox.isSelected();
    }

    @Step("Click 'Create' repository button")
    public void clickCreateRepositoryButton() throws InterruptedException {
        scrollIntoViewWithJS(createButton);
        Thread.sleep(3000);
        createButton.click();
    }

    @Step("Click checkbox")
    public void clickCheckbox() {
        waitForElementToBeVisible(checkedBox);
        checkedBox.click();
    }
}