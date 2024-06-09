package com.github.crud.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ReadRepository {

    @FindBy(css = "div[class='AppHeader-user']")
    private WebElement headerMenuButton;

    @FindBy(css = "a[id='item-416b5c0f-42e9-4d48-ba2d-70b7c75ac1f0']")
    private WebElement repositoriesList;

    @Step("Click on the header menu button")
    public void clickHeaderMenuButton() {
        headerMenuButton.click();
    }

    @Step("Click on the repositories list")
    public void clickRepositoriesList() {
        repositoriesList.click();
    }
}





