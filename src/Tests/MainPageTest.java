package Tests;

import Actions.GoogleAction;
import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        GoogleAction.GoTo(driver);
        GoogleAction.ClickLoginButton(driver);
        GoogleAction.InputEmail(driver, googleLogin);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
        GoogleAction.InputPassword(driver, googlePassword);
        Assert.assertTrue(driver.findElement(By.linkText(googleLogin)).getText().equals(googleLogin));
    }

    @AfterClass
    public static void CloseBrowser() {
        driver.quit();
    }

}