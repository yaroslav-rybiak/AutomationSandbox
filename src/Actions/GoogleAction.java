package Actions;

import Pages.GooglePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleAction {

    private static String URL = "https://www.google.com.ua/";

    public static void GoTo(WebDriver driver){
        driver.get(URL);
    }

    public static void ClickLoginButton(WebDriver driver) {
        GooglePage.LoginButton(driver).click();
    }

    public static void InputEmail(WebDriver driver, String login) {
        GooglePage.EmailField(driver).sendKeys(login);
        GooglePage.NextButton(driver).click();
    }

    public static void InputPassword(WebDriver driver, String password) {
        GooglePage.PasswordField(driver).sendKeys(password);
        GooglePage.SignInButton(driver).click();
    }

    public static void WaitForPasswordField(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
    }

    public static boolean AssertSuccess(WebDriver driver, String googleLogin) {
        if (driver.findElement(By.linkText(googleLogin)).getText().equals(googleLogin)) {
            return true;
        }
        else return false;
    }

}
