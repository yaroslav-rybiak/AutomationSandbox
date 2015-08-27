package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {

    By loginSwitch = By.cssSelector("div.landing-main-log-switch");
    By emailField = By.id("ctl00_Main_login");
    By passwordField = By.id("ctl00_Main_password");
    By loginButton = By.id("ctl00_Main_LoginButton");
    By errorMessage = By.id("tooltip-loginRegister");

    public HomePage(WebDriver driver){
        super(driver);
        URL = "https://homemoney.ua/";
    }

    public void switchToLogin() {
        try {
            driver.findElement(emailField).isDisplayed();
        }
        catch (Exception e){
            driver.findElement(loginSwitch).click();
        }
    }

    public void inputEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void inputPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void login(String email, String password){
        open();
        switchToLogin();
        inputEmail(email);
        inputPassword(password);
        clickLoginButton();
    }

    public boolean errorMessageIsPresent() {
        return driver.findElement(errorMessage).isDisplayed();
    }
}