package com.github.ui.tests;

import com.github.ui.base.MainTest;
import com.github.ui.pages.RegistrationPage;
import com.github.ui.pages.SingUpPage;
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
