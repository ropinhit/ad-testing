package com.cafetownsend.test.stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void beforeAllScenario() {
       // System.setProperty("webdriver.gecko.driver", "C:\\Users\\attdang\\Downloads\\Software\\geckodriver-v0.20.1-win64\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\attdang\\Downloads\\Driver\\chromedriver.exe");

         driver = new ChromeDriver();
       // driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @After
    public void afterAllScenario() {
        driver.quit();
    }

}
