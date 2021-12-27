package com.guru99demo.stepDefinitions;

import com.guru99demo.pageobjects.HomePage;
import com.guru99demo.pageobjects.LoginPage;

import com.guru99demo.utilities.ReadConfig;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.scf4j.props.PropertyConfigurator;

import java.util.logging.Logger;


public class BaseObject {

    ReadConfig readConfObj = new ReadConfig() ;

    WebDriver driver;
    LoginPage loginPageObject;
    HomePage homePageObject;
    String baseurl = readConfObj.getApplicationURL();
    String userName= readConfObj.getUserName();
    String password= readConfObj.getPassword();



    public void openChromeDriver(){
        System.setProperty("webdriver.chrome.driver","src/test/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }
    public void openFirefoxDriver(){
        System.setProperty("webdriver.gecko.driver","src/test/Drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    public void openEdgeDriver(){
        System.setProperty("webdriver.edge.driver","src/test/Drivers/msedgedriver.exe");
        driver = new EdgeDriver();
    }

    public void closeBrowser(){
        driver.quit();
    }






}
