package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webdriver.Browser;

import java.util.List;
import java.util.Random;

public class ChildDressPage extends AbstractPage{

    Logger logger = LoggerFactory.getLogger(ChildDressPage.class);

    private static final By paramState = By.cssSelector("#param_state>div>a");
    private static final By newState = By.cssSelector("#f-new_state");
    private static final By a = By.cssSelector("a");
    private static final By priceFrom = By.xpath("//*[@id=\"param_price\"]/div/div[1]/a");
    private static final By priceFromField = By.xpath("//*[@id=\"param_price\"]/div/div[1]/label/input");
    private static final By priceTo = By.xpath("//*[@id=\"param_price\"]/div/div[2]/a");
    private static final By priceToField = By.xpath("//*[@id=\"param_price\"]/div/div[2]/label/input");
    private static final By items = By.xpath("//tbody//td/table/tbody//h3/a/span");


    public ChildDressPage(Browser driver){super(driver);}

    public boolean isOpened(){
        return (driver.getCurrentUrl().contains("detskiy-mir/detskaya-odezhda/"));
    }

    public boolean sortByNew(){
        driver.findElement(paramState).click();
        waitSomeTime(1000);
        driver.findElement(newState).click();
        waitSomeTime(4000);
        logger.info("Sorting items by New");
        clickRandomItemInResults();
        logger.info("Random item clicked");
        waitSomeTime(4000);
        List<WebElement> elements = driver.findElements(a);
        logger.info("All a found");
        boolean ok = false;
        for (int i=0; i<elements.size(); i++) {
            if (elements.get(i).getText().equalsIgnoreCase("Нові")) {
                ok = true;
                logger.info("NOVI found");
            }
        }
        if (ok == true) {
            logger.info("Items sorted by New");
        } else {
            logger.info("Items NOT sorted by New");
        }
        return ok;
    }

    public void setPriceRange(int from, int to) {
        logger.info("Setting price range");
        driver.findElement(priceFrom).click();
        waitSomeTime(1000);
        logger.info("PriceFrom clicked");
        driver.findElement(priceFromField).sendKeys(Integer.toString(from));
        waitSomeTime(4500);
        logger.info("PriceFrom filled");
        driver.findElement(priceTo).click();
        waitSomeTime(1000);
        logger.info("PriceTo clicked");
        driver.findElement(priceToField).sendKeys(Integer.toString(to));
        waitSomeTime(4500);
        logger.info("PriceTo filled");
    }

    public void clickRandomItemInResults() {
        List<WebElement> elements = driver.findElements(items);
        int randomIndex = new Random().nextInt(elements.size());
        elements.get(randomIndex).click();
        logger.info("Random item selected");
    }

}