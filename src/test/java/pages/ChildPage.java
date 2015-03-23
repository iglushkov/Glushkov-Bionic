package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webdriver.Browser;

public class ChildPage extends AbstractPage{

    Logger logger = LoggerFactory.getLogger(ChildPage.class);

    private static final By openDetskayaOdezhdaLink = By.id("cat-539");

    public ChildPage(Browser driver) {
        super(driver);
    }


    public boolean isOpened() {
        return driver.findElement(openDetskayaOdezhdaLink).isDisplayed();
    }

    public void openDetskayaOdezhda() {
        driver.findElement(openDetskayaOdezhdaLink).click();
        logger.info("DetskayaOdezhda page opened");
        waitSomeTime(4000);
    }

}