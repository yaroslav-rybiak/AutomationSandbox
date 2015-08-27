package Tests;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Pages.HomePage;
import Pages.AppPage;
import Data.Helper;

public class LoginTest {

    protected static WebDriver driver = new FirefoxDriver();
    HomePage homePage = new HomePage(driver);
    AppPage appPage = new AppPage(driver);
    private String email = Helper.getEmail();
    private String password = Helper.getPassword();

    @BeforeClass
    public static void setup() {
        driver.manage().window().maximize();
    }

    @Test
    public void positive_login_test() {
        homePage.open();
        homePage.switchToLogin();
        homePage.inputEmail(email);
        homePage.inputPassword(password);
        homePage.clickLoginButton();
        Assert.assertTrue(appPage.isOpened());
        appPage.clickLogoutButton();
    }

    @Test
    public void negative_login_test() {
        homePage.open();
        homePage.switchToLogin();
        homePage.inputEmail(email);
        homePage.inputPassword(password + "fail");
        homePage.clickLoginButton();
        Assert.assertTrue(homePage.errorMessageIsPresent());
    }

    @Test
    public void login_attempt_with_empty_email_field() {
        homePage.open();
        homePage.switchToLogin();
        homePage.inputPassword(password);
        homePage.clickLoginButton();
        Assert.assertTrue(homePage.errorMessageIsPresent());
    }

    @Test
    public void login_attempt_with_empty_password_field() {
        homePage.open();
        homePage.switchToLogin();
        homePage.inputEmail(email);
        homePage.clickLoginButton();
        Assert.assertTrue(homePage.errorMessageIsPresent());
    }

    @AfterClass
    public static void close() {
        driver.quit();
    }
}