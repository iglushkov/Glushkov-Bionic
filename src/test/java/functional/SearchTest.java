package functional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;

public class SearchTest extends AbstractTest {

    Logger logger = LoggerFactory.getLogger(SearchTest.class);

    @Test
    public void searchTest() {
        logger.info("SearchTest STARTED");
        HomePage homePage = new HomePage(browser);
        homePage.open();
        homePage.find("Nexus");
        SearchResultsPage searchResultsPage = new SearchResultsPage(browser);
        Assert.assertTrue(searchResultsPage.isFound("Nexus"));
        logger.info("SearchTest ENDED");
    }

}