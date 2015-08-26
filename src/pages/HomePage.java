package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;
    private String URL = "https://homemoney.ua/";

    By loginSwitch = By.cssSelector("div.landing-main-log-switch");
    By emailField = By.id("ctl00_Main_login");
    By passwordField = By.id("ctl00_Main_password");
    By loginButton = By.id("ctl00_Main_LoginButton");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void open() {
        driver.get(URL);
    }

    public void switchToLogin() {
        driver.findElement(loginSwitch).click();
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
}