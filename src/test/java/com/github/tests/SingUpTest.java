package com.github.tests;

import com.github.base.MainTest;
import com.github.pages.RegistrationPage;
import com.github.pages.SingUpPage;
import org.testng.annotations.Test;


import static org.testng.AssertJUnit.assertTrue;

public class SingUpTest extends MainTest {

@Test
    public void testSingUp () {
   SingUpPage singUpPage= new SingUpPage();

   singUpPage.clickSignUpButton();

    RegistrationPage registrationPage = new RegistrationPage();
    assertTrue(registrationPage.isRegistrationFormDisplayed());

}
}
