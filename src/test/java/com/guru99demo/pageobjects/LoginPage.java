package com.guru99demo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver xdriver;

    public LoginPage(WebDriver driver) {
        xdriver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "uid")
    WebElement userIDField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(name = "btnLogin")
    WebElement loginButton;

    public String getLoginPageTitle(){

        return xdriver.getTitle();// GTPL Bank Home Page
    }

    public void enterUserName(String uName){
        userIDField.sendKeys(uName);
    }

    public void enterPassword(String pwd){
        passwordField.sendKeys(pwd);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

}
