package Tests;

import Actions.GoogleAction;
import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainPageTest {
    private static WebDriver driver;
    public String googleLogin = "email";
    public String googlePassword = "password";

    @BeforeClass
    public static void OpenBrowser() {
        driver = new FirefoxDriver();
    }

    @Test
    public void GoogleLogin() {
        GoogleAction.GoTo(driver);
        GoogleAction.ClickLoginButton(driver);
        GoogleAction.InputEmail(driver, googleLogin);
        GoogleAction.WaitForPasswordField(driver);
        GoogleAction.InputPassword(driver, googlePassword);
        Assert.assertTrue(GoogleAction.AssertSuccess(driver, googleLogin));
        if (GoogleAction.AssertSuccess(driver, googleLogin)) {
            System.out.println("Logged in google account successfully.");
        }
        else System.out.println("Test GoogleLogin failed");
    }

    @AfterClass
    public static void CloseBrowser() {
        driver.quit();
    }

}