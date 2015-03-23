package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webdriver.Browser;

public class PreviewPage extends AbstractPage {

    Logger logger = LoggerFactory.getLogger(PreviewPage.class);

    private static final By previewText = new By.ByXPath("//*[@id=\"innerLayout\"]/div[3]/div/p[1]");

    public PreviewPage(Browser driver) {
        super(driver);
    }

    public boolean previewIsOpened() {
        Boolean isOpened = driver.findElement(previewText).getText().contains("Це прев'ю Вашого оголошення");
        if (isOpened) {
            logger.info("New advert added");
        } else {
            logger.info("New advert NOT added");
        }
        return isOpened;

    }

}