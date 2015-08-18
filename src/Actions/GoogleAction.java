package Actions;

import Pages.GooglePage;
import org.openqa.selenium.WebDriver;

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

}
