package com.selenium.brandmaker.base;

import driver.DriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

@Slf4j

public class TestUtil {
    private String url;
    private String browser;
    private int implicitWait;
    public WebDriver driver;

//  Read configuration properties from config.properties
    @BeforeSuite
    public void readConfigProperties() {
        try(FileInputStream configFile = new FileInputStream("src/test/resources/config.properties")){
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("url");
            implicitWait = Integer.parseInt(config.getProperty("implicitWait"));
            browser = config.getProperty("browser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//  Before test setup browser's driver and load url
    @BeforeTest
    public void initTest(){
        setupBrowserDriver(browser);
        loadUrl();
    }

//  Close driver after test
    @AfterTest
    public void closeDriver(){
        driver.quit();
    }

// Setup browser's drivers
    public void setupBrowserDriver(String browser){
        switch(browser.toLowerCase(Locale.ROOT)){
            case "firefox":
                driver = DriverFactory.getFirefoxDriver(implicitWait);
                break;
            case "chrome":
                driver = DriverFactory.getChromeDriver(implicitWait);
                break;
            default:
                throw new IllegalStateException("Unexpected browser name value: " + browser);

        }
    }

//  Load url
    public void loadUrl(){
        driver.get(url);
    }
}
