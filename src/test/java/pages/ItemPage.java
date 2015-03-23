package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webdriver.Browser;

public class ItemPage extends AbstractPage {

    Logger logger = LoggerFactory.getLogger(ItemPage.class);

    private static final By priceLabel = new By.ByXPath("//*[@id=\"offeractions\"]/div[1]/div[1]/div[1]/strong");

    public ItemPage(Browser driver) {
        super(driver);
    }

    public boolean isPriceInPriceRage(int from, int to) {
        String priceLableText = driver.findElement(priceLabel).getText();
        int price = Integer.parseInt(priceLableText.substring(0, priceLableText.length() - 5));
        boolean priceInRange = false;
        if ((price >= from) && (price <= to)) {
            priceInRange = true;
            logger.info("Price is in a range");
        } else {
            logger.info("Price is NOT in a range");
        }
        return priceInRange;
    }
}