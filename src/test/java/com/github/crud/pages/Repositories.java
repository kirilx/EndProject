package com.github.crud.pages;

import com.github.crud.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Repositories extends BasePage {

    @FindBy(xpath = "//*[@id='repo-title-component']/strong/a")
    private WebElement repoName;

    @FindBy(css = ".col-10  a[href='/kirilz-ta/kaska']")
    private WebElement repoLink;

    @FindBy(css = ".col-10  a[href='/kirilz-ta/testkaska']")
    private WebElement repoLinkRenamed;




    @Step("Get the repository name text")
    public String getRepoNameText() {
        waitForElementToBeVisible(repoName);
        return repoName.getText();
    }

    @Step("Click on the repository link")
    public void clickRepoLink() {
        repoLink.click();
    }

    @Step("Click on the renamed repository link")
    public void clickRenamedRepoLink() {
        repoLinkRenamed.click();
    }
}







