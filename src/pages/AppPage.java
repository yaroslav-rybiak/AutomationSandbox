package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AppPage extends Page {

    WebDriverWait wait = new WebDriverWait(driver, 3);

    By logoutLink = By.xpath("//a[contains(text(),'Sign out')]");
    By incomeSwitcher = By.xpath("(//a[contains(text(),'Income')])[2]");
    By moneyField = By.id("OperationAdd_total");
    By CategoryDropdown = By.cssSelector("#OperationAdd_categoryInc_chzn > a:nth-child(1) > div:nth-child(2) > b:nth-child(1)");
    By CategoryDropdownSelect = By.cssSelector("#OperationAdd_categoryInc_chzn_o_1");
    By addButton = By.id("OperationAdd_btnAdd");
    By lastChangesTab = By.linkText("Last changes");
    By lastOperationX = By.xpath("//div[@id='ctl00_ctl00_Main_Main_DashBoardViewOperations1_LastOperationModify_last_transactions']/div/div/div[2]/a[3]");
    By lastOperationValue = By.xpath("//div[2]/div[5]/div/div/div[3]");

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

    public void deleteLastOperation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastChangesTab));
        driver.findElement(lastChangesTab).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastOperationValue));
    }

    public String checkMoneyAmount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastChangesTab));
        driver.findElement(lastChangesTab).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastOperationValue));
        return driver.findElement(lastOperationValue).getText().substring(0, driver.findElement(lastOperationValue).getText().lastIndexOf('.'));
    }
}