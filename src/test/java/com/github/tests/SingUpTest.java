package com.github.tests;

import com.github.base.MainTest;
import com.github.pages.RegistrationPage;
import com.github.pages.SingUpPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;


import static org.testng.AssertJUnit.assertTrue;

@Epic("Signup")
public class SingUpTest extends MainTest {

@Test
@Description("Test for verifying the signup process")
@Feature("Signup Feature")
    public void testSingUp () {
   SingUpPage singUpPage= new SingUpPage();

   singUpPage.clickSignUpButton();

    RegistrationPage registrationPage = new RegistrationPage();
    assertTrue(registrationPage.isRegistrationFormDisplayed());

}
}
