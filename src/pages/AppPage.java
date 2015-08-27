package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppPage extends Page {

    By logoutLink = By.xpath("//a[contains(text(),'Sign out')]");

    public AppPage(WebDriver driver){
        super(driver);
        URL = "https://homemoney.ua/app/";
    }

    public void clickLogoutButton() {
        driver.findElement(logoutLink).click();
    }

}