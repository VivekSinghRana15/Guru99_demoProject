package com.guru99demo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    WebDriver xdriver;

    public HomePage(WebDriver driver){
        xdriver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement logOutLink;

    public String getHomePageTitle(){
        return xdriver.getTitle();// GTPL Bank Manager HomePage
    }

    public void clickLogout(){
        logOutLink.click();
    }
}
