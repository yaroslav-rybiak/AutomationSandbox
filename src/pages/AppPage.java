package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppPage extends Page {

    By logoutLink = By.id("ctl00_ctl00_Top_LV2_LoginStatus2");

    public AppPage(WebDriver driver){
        super(driver);
        URL = "https://homemoney.ua/app/";
    }

    public void clickLogoutButton() {
        driver.findElement(logoutLink).click();
    }

}