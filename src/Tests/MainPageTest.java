package Tests;

import org.junit.AfterClass;
//import org.junit.Assert;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainPageTest {
    private static WebDriver driver;

    @BeforeClass
    public static void OpenBrowser() {
        driver = new FirefoxDriver();
    }

    @Test
     public void GoogleLogin() {
        driver.get("https://www.google.com.ua/");
        driver.findElement(By.xpath("//div[3]/div/a")).click();
        driver.findElement(By.id("Email")).sendKeys("yaroslav.rybiak");
        driver.findElement(By.id("next")).click();
        driver.switchTo().frame("cc_iframe_parent");
        driver.findElement(By.id("Passwd")).sendKeys("666");
        driver.findElement(By.id("id=PersistentCookie")).click();
        driver.findElement(By.id("signIn")).click();
    }


    //@Test
    public void YandexLogin() {
        driver.get("https://www.yandex.ua/");
        driver.findElement(By.xpath("//button[@type='button']")).click();
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("ihaveabomb");
        driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("666");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.linkText("ihaveabomb@ya.ru")).getText().equals("ihaveabomb@ya.ru"));
    }
    @AfterClass
    public static void CloseBrowser() {
        driver.quit();
    }
}
