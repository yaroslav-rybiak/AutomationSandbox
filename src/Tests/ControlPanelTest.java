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

public class ControlPanelTest {

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
    public void adding_income_test() {
        String moneyAmount = Helper.getRandomCash();
        homePage.login(email, password);
        Assert.assertTrue(appPage.isOpened());
        appPage.switchToIncome();
        appPage.addMoneyAmount(moneyAmount);
        appPage.selectCategoryIncome();
        appPage.clickAddButton();
        Assert.assertTrue(appPage.checkMoneyAmount().equals(moneyAmount));
        appPage.deleteLastOperation();
        appPage.clickLogoutButton();
    }

    @Test
    public void adding_expense_test() {
        String moneyAmount = Helper.getRandomCash();
        homePage.login(email, password);
        Assert.assertTrue(appPage.isOpened());
        appPage.addMoneyAmount(moneyAmount);
        appPage.selectCategoryExpense();
        appPage.clickAddButton();
        Assert.assertTrue(appPage.checkMoneyAmount().equals(moneyAmount));
        appPage.deleteLastOperation();
        appPage.clickLogoutButton();
    }

    @AfterClass
    public static void close() {
        driver.quit();
    }
}