package com.herokuapp.internet.pages;

import com.herokuapp.internet.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(id = "username")
    WebElement username;

    @CacheLookup
    @FindBy(id = "password")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//i[contains(text(),'Login')]")
    WebElement loginText;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"content\"]/div/h2")
    WebElement verifyMessage;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Your username is invalid!')]")
    WebElement errorMessage;

   @CacheLookup
   @FindBy(xpath = "//div[contains(text(),'Your password is invalid!')]")
   WebElement errorMessage1;


    public void enterUserName(String username2) {
        Reporter.log("enterUserName"+ username.toString());
        sendTextToElement(username, username2);
    }

    public void enterPassword(String password1) {
        Reporter.log("passwordField"+ password.toString());
        sendTextToElement(password, password1);
    }

    public void clickOnSignInButton() {
        Reporter.log("signInButton"+ loginText.toString());
        clickOnElement(loginText);
    }

    public String verifyText() {
        Reporter.log("verifyText"+ verifyMessage.toString());
        return getTextFromElement(verifyMessage);

    }

    public String getErrorMessage() {
        Reporter.log("ErrorMessage"+ errorMessage.toString());
        return getTextFromElement(errorMessage);

    }

    public String getErrorMessage1() {
        Reporter.log("ErrorMessage1"+ errorMessage1.toString());
        return getTextFromElement(errorMessage1);
    }
}





