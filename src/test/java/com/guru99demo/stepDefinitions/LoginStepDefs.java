package com.guru99demo.stepDefinitions;

import com.guru99demo.pageobjects.HomePage;
import com.guru99demo.pageobjects.LoginPage;
import io.cucumber.java.en.*;
import org.apache.commons.configuration.PropertiesConfiguration;
//import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.*;
import org.junit.Assert;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.By;

//import java.util.logging.Logger;


public class LoginStepDefs extends BaseObject{

    Logger logger;
    @Given("I open the Guru99 Banking website {string}")
    public void open_guru99_bankApp(String url) throws InterruptedException {

        logger = Logger.getLogger("Guru99_DemoBankApp-CucumberProject");
        PropertyConfigurator.configure("log4j.properties");

        openChromeDriver();
        //driver.get(url);//If using the one passed from Feature file
        driver.get(baseurl);//got this directly from BaseObject class- which in turn gets it frm readConf-which gets it from config.properties

        loginPageObject = new LoginPage(driver);
        Assert.assertEquals("GTPL Bank Home Page",loginPageObject.getLoginPageTitle());
        //System.out.println("The login page has opened successfully");

        logger.info("The login page has opened successfully");
        Thread.sleep(5000);

        driver.switchTo().frame("gdpr-consent-notice");
        driver.findElement(By.xpath("//*[@id=\"save\"]")).click();
    }


    @When("I enter {string} and {string}")
    public void fill_Username_And_Password(String uName, String pwd) {
        //loginPageObject.enterUserName(uName);//getting it from Feature file
        //loginPageObject.enterPassword(pwd);//getting it from Feature file

        //Getting it directly from BaseObject class- which in turn gets it frm readConf-which gets it from config.properties
        loginPageObject.enterUserName(userName);
        loginPageObject.enterPassword(password);
    }


    @When("I click on Login button")
    public void click_login_button() {
        loginPageObject.clickLoginButton();
    }


    @Then("I should successfully login and reach Home Page of Banking website")
    public void verify_home_page_opens() {

        homePageObject = new HomePage(driver);
        Assert.assertEquals("GTPL Bank Manager HomePage",homePageObject.getHomePageTitle());
        logger.info("The user has successfully logged in & reached Home page...");
    }

    @And("I Logout and Close Browser")
    public void logout_and_closeBrowser() throws InterruptedException {
        homePageObject.clickLogout();
       Assert.assertEquals("You Have Succesfully Logged Out!!", driver.switchTo().alert().getText());
        logger.info("We have logged out successfully & Alert also has opened up..");
        Thread.sleep(3000);

        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        logger.info("Clicked on OK on alert message");

        closeBrowser();

        //https://www.toolsqa.com/selenium-cucumber-framework/cucumber-extent-report/
    }




}
