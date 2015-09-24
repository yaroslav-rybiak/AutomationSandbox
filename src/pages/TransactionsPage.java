package Pages;

import org.openqa.selenium.WebDriver;

public class TransactionsPage extends Page {

    public TransactionsPage(WebDriver driver){
        super(driver);
        URL = "https://homemoney.ua/app/transactions.aspx";
    }

}