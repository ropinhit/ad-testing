package com.cafetownsend.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(css = "//label[./span[text() = 'Username*']]/input")
    private WebElement txtUsername;

    @FindBy(xpath = "//label[./span[text() = 'Password*']]/input")
    private WebElement txtPassword;

    @FindBy(tagName = "button")
    private WebElement btnLogin;

    @FindBy(css = ".error-message")
    private WebElement msgError;

    private static LoginPage loginPage;

    public LoginPage(WebDriver driver) {
        //This initElements method will create  all WebElements
        PageFactory.initElements(driver, this);
    }

    public static LoginPage getInstance(WebDriver driver) {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public void loginWithUsernameAndPassword(String username, String password) {
        txtUsername.clear();
        txtUsername.sendKeys(username);
        txtPassword.clear();
        txtPassword.sendKeys(password);
        btnLogin.click();
    }


}
