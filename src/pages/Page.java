package Pages;

import org.openqa.selenium.WebDriver;

public class Page {

    protected WebDriver driver;
    protected String URL;

    public void open() {
        driver.get(URL);
    }

    public boolean isOpened() {
        return driver.getCurrentUrl().contains(URL);
    }

    public Page (WebDriver driver) {
        this.driver = driver;
    }
}