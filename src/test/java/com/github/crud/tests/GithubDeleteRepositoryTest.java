package com.github.crud.tests;

import com.github.crud.base.MainTest;
import com.github.crud.pages.*;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CsvReader;

import java.io.IOException;

public class GithubDeleteRepositoryTest extends MainTest {

    @Test(dataProvider = "Delete-repository-name", priority = 5)
    public void testDeleteRepository(String username, String password, String repositoryDelete) throws InterruptedException {
        GithubHomePage githubHomePage = new GithubHomePage();
        githubHomePage.clickSignIn();

        GithubLoginPage loginPage = new GithubLoginPage();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickSignInButton();

        GithubDashboardPage githubDashboardPage = new GithubDashboardPage();
        githubDashboardPage.clickUserAccountMenuButton();
        githubDashboardPage.clickRepositoriesButton();

        Repositories repositories = new Repositories();
        repositories.clickRenamedRepoLink();

        DeleteRepository deleteRepository = new DeleteRepository();

        deleteRepository.clickSettingTab();
        deleteRepository.clickDeleteButton();
        deleteRepository.clickReadAndUnderstandFirst();
        deleteRepository.clickReadAndUnderstandSecond();
        deleteRepository.enterVerificationText(repositoryDelete);
        deleteRepository.clickConfirmRepoDeletion();

        String actualDeleteMessage = deleteRepository.getSuccessfullyDeletedText();
        String expectedMessage = "Your repository 'kirilz-ta/testkaska' was successfully deleted.";


        actualDeleteMessage = actualDeleteMessage.replace("\"", "'");
        expectedMessage = expectedMessage.replace("\"", "'");

        Assert.assertEquals(actualDeleteMessage, expectedMessage);



    }

    @DataProvider(name = "Delete-repository-name")
    public Object[][] repositoryDeleteNameDataProvider() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/delete-repository.csv");
    }
}
