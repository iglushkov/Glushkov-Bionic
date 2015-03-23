package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webdriver.Browser;

public class HomePage extends AbstractPage{

    Logger logger = LoggerFactory.getLogger(HomePage.class);

    private static final By childWorldLink = By.cssSelector("a[data-code='detskiy-mir']");
    private static final By addNewAdvertLink = new By.ByXPath("//*[@id=\"postNewAdLink\"]/span");
    private static final By searchField = new By.ById("headerSearch");
    private static final By searchButton = new By.ById("submit-searchmain");

    public HomePage(Browser driver) {
        super(driver);
    }

    public void open() {
        driver.get("http://olx.ua/uk/");
        logger.info("Home page opened");
    }

    public void clickAddNewAdvert(){
        driver.findElement(addNewAdvertLink).click();
        logger.info("AddNewAdvert page opened");
        waitSomeTime(1500);
    }

    public void openDetskiyMir() {
        driver.findElement(childWorldLink).click();
        logger.info("DetskiyMir page opened");
    }

    public void find(String query) {
        driver.findElement(searchField).sendKeys(query);
        driver.findElement(searchButton).click();
        logger.info("Searching Nexus");
    }

}