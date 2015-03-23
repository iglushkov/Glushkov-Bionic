package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webdriver.Browser;

public class SearchResultsPage extends AbstractPage {

    Logger logger = LoggerFactory.getLogger(SearchResultsPage.class);

    private static final By firstItemInResults = new By.ByXPath("//*[@id=\"offers_table\"]//tr[2]//td[3]//span");

    public SearchResultsPage(Browser driver) {
        super(driver);
    }

    public boolean isFound(String string) {
        boolean isFound = driver.findElement(firstItemInResults).getText().toLowerCase().contains(string.toLowerCase());
        if (isFound) {
            logger.info("First item in results contains Nexus");
        } else {
            logger.info("First item in results NOT contains Nexus");
        }
        return isFound;
    }

}