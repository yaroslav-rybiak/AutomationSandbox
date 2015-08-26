package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppPage {

    WebDriver driver;
    private String URL = "https://homemoney.ua/app/";
    By logoutLink = By.id("ctl00_ctl00_Top_LV2_LoginStatus2");


    public AppPage(WebDriver driver){
        this.driver = driver;
    }

    public void open() {
        driver.get(URL);
    }

    public boolean isOpened() {
        return driver.getCurrentUrl().equals(URL);
    }

    public void clickLogoutButton() {
        driver.findElement(logoutLink).click();
    }

}