package com.github.crud.tests;

import com.github.crud.base.MainTest;
import com.github.crud.pages.GithubHomePage;
import com.github.crud.pages.GithubLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GithubHomePageTest extends MainTest {

    @Test(priority = 1)
    public void testSignInButton() {

        GithubHomePage githubHomePage = new GithubHomePage();


        githubHomePage.clickSignIn();


        GithubLoginPage githubLoginPage = new GithubLoginPage();






        Assert.assertEquals(githubLoginPage.getUsernamePasswordText (),"Username or email address");
    }
}