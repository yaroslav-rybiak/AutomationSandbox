package Tests;

import Actions.GoogleAction;
import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleLoginTest {
    private static WebDriver driver;
    public String googleLogin = "br59241@gmail.com";
    public String googlePassword = "oDo94oZmbB";

    @BeforeClass
    public static void OpenBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    //login attempt with valid email and password
    public void GoogleLoginSuccess() throws Exception {
        GoogleAction.GoTo(driver);
        GoogleAction.ClickLoginButton(driver);
        GoogleAction.TryToChangeAccount(driver);
        GoogleAction.InputEmail(driver, googleLogin);
        GoogleAction.WaitForPasswordField(driver);
        GoogleAction.InputPassword(driver, googlePassword);
        Assert.assertTrue(GoogleAction.AssertSuccessLogin(driver, googleLogin));
        GoogleAction.SignOut(driver, googleLogin);
        Assert.assertTrue(GoogleAction.AssertSuccessLogout(driver));
    }

    @Test
    //login attempt with valid login and invalid password
    public void GoogleLoginInvalidPassword() throws Exception {
        GoogleAction.GoTo(driver);
        GoogleAction.ClickLoginButton(driver);
        GoogleAction.TryToChangeAccount(driver);
        GoogleAction.InputEmail(driver, googleLogin);
        GoogleAction.WaitForPasswordField(driver);
        GoogleAction.InputPassword(driver, googlePassword + "fail");
        Assert.assertTrue(GoogleAction.AssertFailurePassword(driver));
    }

    @Test
    //login attempt with invalid login
    public void GoogleLoginInvalidEmail() throws Exception {
        GoogleAction.GoTo(driver);
        GoogleAction.ClickLoginButton(driver);
        GoogleAction.TryToChangeAccount(driver);
        GoogleAction.InputEmail(driver, googleLogin + "fail");
        Assert.assertTrue(GoogleAction.AssertFailureLogin(driver));
    }

    @AfterClass
    public static void CloseBrowser() {
        driver.quit();
    }

}