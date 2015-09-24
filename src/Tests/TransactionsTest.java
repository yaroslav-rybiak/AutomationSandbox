package Tests;

import Data.Helper;
import Pages.HomePage;
import Pages.TransactionsPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TransactionsTest {

    protected static WebDriver driver = new FirefoxDriver();
    HomePage homePage = new HomePage(driver);
    TransactionsPage transactionsPage = new TransactionsPage(driver);
    private String email = Helper.getEmail();
    private String password = Helper.getPassword();

    @BeforeClass
    public static void setup() {
        driver.manage().window().maximize();
    }

    @Test
    public void open_page_test() {
        homePage.login(email, password);
        transactionsPage.open();
        Assert.assertTrue(transactionsPage.isOpened());
    }

    @AfterClass
    public static void close() {
        driver.quit();
    }
}
