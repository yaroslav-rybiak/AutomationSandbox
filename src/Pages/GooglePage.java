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

    public static WebElement LoggedMenu(WebDriver driver){
        element = driver.findElement(By.linkText("yaroslav.rybiak@gmail.com"));
        return element;
    }

    public static WebElement SignOut(WebDriver driver){
        element = driver.findElement(By.id("gb_71"));
        return element;
    }

    public static WebElement ErrorMessage(WebDriver driver){
        element = driver.findElement(By.id("errormsg_0_Passwd"));
        return element;
    }

}
