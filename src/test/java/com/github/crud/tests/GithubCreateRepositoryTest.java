package com.github.crud.tests;

import com.github.crud.base.MainTest;
import com.github.crud.pages.*;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CsvReader;

import java.io.IOException;

public class GithubCreateRepositoryTest extends MainTest {


    @Test(dataProvider = "Create-repository-name", priority = 3)
    public void testCreateRepository(String username, String password,String repositoryName) throws InterruptedException {
        GithubHomePage githubHomePage = new GithubHomePage();

        githubHomePage.clickSignIn();

        GithubLoginPage loginPage = new GithubLoginPage();

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickSignInButton();

        GithubDashboardPage githubDashboardPage = new GithubDashboardPage();

        githubDashboardPage.clickRepositoryDropDownMenu();
        githubDashboardPage.clickNewRepositoryDropDownButton();

        CreateRepository createRepository = new CreateRepository();


        createRepository.setRepositoryName(repositoryName);
        createRepository.clickCheckedBox();

        createRepository.clickCreateRepositoryButton();

        Repositories repositories = new Repositories();

        String actualRepoName = repositories.getRepoNameText();
        Assert.assertEquals(actualRepoName,"kaska");




    }
        @DataProvider(name = "Create-repository-name")
        public Object[][] RepositoryDataProvider () throws IOException, CsvException {
            // Read valid user details from a CSV file or any other source
            return CsvReader.readCsvFile("src/test/resources/repository-name.csv");
        }
    }
