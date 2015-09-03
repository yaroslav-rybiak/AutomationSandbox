package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppPage extends Page {

    WebDriverWait wait = new WebDriverWait(driver, 3);

    By logoutLink = By.xpath("//a[contains(text(),'Sign out')]");
    By incomeSwitcher = By.xpath("(//a[contains(text(),'Income')])[2]");
    By moneyField = By.id("OperationAdd_total");
    By CategoryDropdownIncome = By.cssSelector("#OperationAdd_categoryInc_chzn > a:nth-child(1) > div:nth-child(2) > b:nth-child(1)");
    By CategoryDropdownExpense = By.xpath("//div[@id='OperationAdd_categoryExp_chzn']/a/div/b");
    By CategoryDropdownSelectIncome = By.cssSelector("#OperationAdd_categoryInc_chzn_o_1");
    By CategoryDropdownSelectExpense = By.cssSelector("#OperationAdd_categoryExp_chzn_o_5");
    By addButton = By.id("OperationAdd_btnAdd");
    By lastChangesTab = By.linkText("Last changes");
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

    public void selectCategoryIncome() {
        driver.findElement(CategoryDropdownIncome).click();
        driver.findElement(CategoryDropdownSelectIncome).click();
    }

    public void selectCategoryExpense() {
        driver.findElement(CategoryDropdownExpense).click();
        driver.findElement(CategoryDropdownSelectExpense).click();
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