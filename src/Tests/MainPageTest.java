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
    public void GoogleLoginSuccess() {
        GoogleAction.GoTo(driver);
        GoogleAction.ClickLoginButton(driver);
        GoogleAction.InputEmail(driver, googleLogin);
        GoogleAction.WaitForPasswordField(driver);
        GoogleAction.InputPassword(driver, googlePassword);
        Assert.assertTrue(GoogleAction.AssertSuccessLogin(driver, googleLogin));
        GoogleAction.SignOut(driver);
        Assert.assertTrue(GoogleAction.AssertSuccessLogout(driver));

    }

    @Test
    public void GoogleLoginFailure() {
        GoogleAction.GoTo(driver);
        GoogleAction.ClickLoginButton(driver);
        GoogleAction.InputEmail(driver, googleLogin);
        GoogleAction.WaitForPasswordField(driver);
        GoogleAction.InputPassword(driver, googlePassword+"fail");
        Assert.assertTrue(GoogleAction.AssertFailure(driver));

    }

    @AfterClass
    public static void CloseBrowser() {
        driver.quit();
    }

}