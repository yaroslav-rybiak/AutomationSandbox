package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class GooglePage {

    private static WebElement element = null;

    public static WebElement LoginButton(WebDriver driver){
        element = driver.findElement(By.xpath("//div[3]/div/a"));
        return element;
    }

    public static WebElement EmailField(WebDriver driver){
        element = driver.findElement(By.id("Email"));
        return element;
    }

    public static WebElement NextButton(WebDriver driver){
        element = driver.findElement(By.id("next"));
        return element;
    }

    public static WebElement PasswordField(WebDriver driver){
        element = driver.findElement(By.id("Passwd"));
        return element;
    }

    public static WebElement SignInButton(WebDriver driver){
        element = driver.findElement(By.id("signIn"));
        return element;
    }

}
