package Tests;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Pages.HomePage;
import Pages.AppPage;
import Data.Credentials;

public class LoginTest {

    protected static WebDriver driver = new FirefoxDriver();
    HomePage homePage = new HomePage(driver);
    AppPage appPage = new AppPage(driver);
    private String email = Credentials.getEmail();
    private String password = Credentials.getPassword();

    @BeforeClass
    public static void setup() {
        driver.manage().window().maximize();
    }

    @Test
    public void test_valid_login() {
        homePage.open();
        homePage.switchToLogin();
        homePage.inputEmail(email);
        homePage.inputPassword(password);
        homePage.clickLoginButton();
        Assert.assertTrue(appPage.isOpened());
        appPage.clickLogoutButton();
    }

    @AfterClass
    public static void close() {
        driver.quit();
    }
}