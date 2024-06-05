package com.github.ui.tests;

import com.github.ui.base.MainTest;
import com.github.ui.pages.GitHubHomePage;
import com.github.ui.pages.GitHubSignupPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


@Epic("Signup")
public class GitHubHomePageTest extends MainTest {


    @Test
    @Description("Test for verifying the signup process")
    @Feature("Signup Feature")
    public void testSingUp() {
        GitHubHomePage gitHubHomePage = new GitHubHomePage();

        gitHubHomePage.clickSignUpButton();

        GitHubSignupPage gitHubSignupPage = new GitHubSignupPage();
        assertTrue(gitHubSignupPage.isRegistrationFormDisplayed());

    }
}