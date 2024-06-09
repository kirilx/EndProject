package com.github.crud.pages;

import com.github.crud.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GithubDashboardPage extends BasePage {
    @FindBy(css = ".d-flex  h2[data-target = 'feed-container.feedTitle']")
    private WebElement homeText;

    @FindBy(css = "#global-create-menu-anchor .Button-content")
    private WebElement repositoryDropDownMenu;

    @FindBy(css = ".Box-sc-g0xbh4-0 span[id=':r5:--label']")
    private WebElement newRepositoryDropDownButton;

    @FindBy(css = ".AppHeader-user button[aria-label='Open user account menu']")
    private WebElement userAccountMenuButton;

    @FindBy(xpath = "//a[@href='/kirilz-ta?tab=repositories']")
    private WebElement repositoriesButton;

    @Step("Get the dashboard header text")
    public String getDashboardHeaderText() {
        waitForElementToBeVisible(homeText);
        return homeText.getText();
    }

    @Step("Click the repository drop-down menu")
    public void clickRepositoryDropDownMenu() {
        repositoryDropDownMenu.click();
    }

    @Step("Click the new repository drop-down button")
    public void clickNewRepositoryDropDownButton() {
        newRepositoryDropDownButton.click();
    }

    @Step("Click the user account menu button")
    public void clickUserAccountMenuButton() {
        userAccountMenuButton.click();
    }

    @Step("Click the repositories button")
    public void clickRepositoriesButton() {
        waitForElementToBeEnabled(repositoriesButton);
        repositoriesButton.click();
    }
}
