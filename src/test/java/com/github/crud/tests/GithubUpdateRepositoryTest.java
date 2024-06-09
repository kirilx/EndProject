package com.github.crud.tests;

import com.github.crud.base.MainTest;
import com.github.crud.pages.*;

import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CsvReader;

import java.io.IOException;

public class GithubUpdateRepositoryTest extends MainTest {

    @Test(dataProvider = "Update-repository-name" , priority = 4)
    public void testUpdateRepository(String username, String password, String repositoryName) throws InterruptedException {
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
        repositories.clickRepoLink();

        UpdateRepository updateRepository = new UpdateRepository();

        updateRepository.clickSettingTab();
        updateRepository.setRepositoryName(repositoryName);
        updateRepository.clickRenameButton();

        String actualRepoName = repositories.getRepoNameText();
        Assert.assertEquals(actualRepoName,"testkaska");
    }

    @DataProvider(name = "Update-repository-name")
    public Object[][] RepositoryUpdateDataProvider() throws IOException, CsvException {
        // Read valid user details from a CSV file or any other source
        return CsvReader.readCsvFile("src/test/resources/update-repository-name.csv");
    }
}
