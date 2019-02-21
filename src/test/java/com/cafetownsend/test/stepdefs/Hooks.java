package com.cafetownsend.test.stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void beforeAllScenario() throws MalformedURLException {
//        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "http://dee-app2:4444/wd/hub");
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://dee-app2:4444/wd/hub"),cap );
        driver.manage().window().maximize();
    }

    @After
    public void afterAllScenario() {
        driver.quit();
    }

}
