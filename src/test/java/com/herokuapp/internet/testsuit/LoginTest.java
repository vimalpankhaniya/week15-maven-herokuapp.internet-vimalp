package com.herokuapp.internet.testsuit;

import com.herokuapp.internet.pages.LoginPage;
import com.herokuapp.internet.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){ loginPage = new LoginPage();}
    @Test (groups = {"sanity","regression"})
    public void UserShouldLoginSuccessfullyWithValidCredentials(){

        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnSignInButton();
        String expected="Secure Area";
       Assert.assertEquals(loginPage.verifyText(),"Secure Area","not verify");

    }
    @Test (groups = {"smoke","regression"})
    public void verifyTheUsernameErrorMessage(){
        loginPage.enterUserName("tomsmith1");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnSignInButton();
        //String expected = "Your username is invalid!";
        //Assert.assertEquals(loginPage.verifyText()," Your username is invalid!","not verify");
        String expectedText = "Your username is invalid!\n" +
                "×";
        String actualText = loginPage.getErrorMessage();
       // Assert.assertEquals(actualText,expectedText,"Your username is invalid!");
        Assert.assertEquals(1,2);

    }

    @Test (groups = {"regression"})
    public void verifyThePasswordErrorMessage(){
        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword");
        loginPage.clickOnSignInButton();
        //String expected = "Your password is invalid!";
        //Assert.assertEquals(loginPage.verifyText()," Your password is invalid!","Your password is invalid!");
        String expectedText = "Your password is invalid!\n" +
                "×";
        String actualText = loginPage.getErrorMessage1();
        Assert.assertEquals(actualText,expectedText,"Your password is invalid!");
    }
}

