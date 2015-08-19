package Actions;

import Pages.GooglePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailAction {

    private static String URL = "https://mail.google.com/";

    public static void GoTo(WebDriver driver){
        driver.get(URL);
    }
}
