package Pages;

import Data.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AppPage extends Page {

    By logoutLink = By.xpath("//a[contains(text(),'Sign out')]");
    By incomeSwitcher = By.xpath("(//a[contains(text(),'Income')])[2]");
    By moneyField = By.id("OperationAdd_total");
    By CategoryDropdown = By.cssSelector("#OperationAdd_categoryInc_chzn > a:nth-child(1) > div:nth-child(2) > b:nth-child(1)");
    By CategoryDropdownSelect = By.cssSelector("#OperationAdd_categoryInc_chzn_o_1");
    By addButton = By.id("OperationAdd_btnAdd");
    By lastOperation = By.xpath("//div/div[5]/div/div/div[3]");

    public AppPage(WebDriver driver){
        super(driver);
        URL = "https://homemoney.ua/app/";
    }

    public void clickLogoutButton() {
        driver.findElement(logoutLink).click();
    }

    public void switchToIncome() {
        driver.findElement(incomeSwitcher).click();
    }

    public void addMoneyAmount(String moneyAmount) {
        driver.findElement(moneyField).sendKeys(moneyAmount);
    }

    public void selectCategory() {
        driver.findElement(CategoryDropdown).click();
        driver.findElement(CategoryDropdownSelect).click();
    }

    public void clickAddButton() {
        driver.findElement(addButton).click();
    }

    public String getAmount() {
        return driver.findElement(lastOperation).getText();
    }

}