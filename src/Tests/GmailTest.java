package Tests;

import Actions.GmailAction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GmailTest {

    private static WebDriver driver;

    @BeforeClass
    public static void OpenBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    //login attempt with valid email and password
    public void PageOpen() throws Exception {
        GmailAction.GoTo(driver);
    }

    @AfterClass
    public static void CloseBrowser() {
        driver.quit();
    }
}
