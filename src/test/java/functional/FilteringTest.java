package functional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class FilteringTest extends AbstractTest{

    Logger logger = LoggerFactory.getLogger(FilteringTest.class);

    @Test(priority = 1)
    public void filteringByVisualTest() {
        logger.info("FilteringByVisualTest STARTED");
        openDetskiyMir();
        openChildDressPage();
        ChildDressPage childDressPage = new ChildDressPage(browser);
        Assert.assertTrue(childDressPage.isOpened());
        logger.info("FilteringByVisualTest ENDED");
    }

    @Test(priority = 2)
    public void filteringByNewStateTest() {
        logger.info("FilteringByNewStateTest STARTED");
        openDetskiyMir();
        openChildDressPage();
        ChildDressPage childDressPage = new ChildDressPage(browser);
        Assert.assertTrue(childDressPage.sortByNew());
        logger.info("FilteringByNewStateTest ENDED");
    }

    @Test(priority = 3)
    public void filteringByPriceRange() {
        logger.info("FilteringByPriceRangeTest STARTED");
        openDetskiyMir();
        openChildDressPage();
        ChildDressPage childDressPage = new ChildDressPage(browser);
        childDressPage.setPriceRange(300, 400);
        childDressPage.clickRandomItemInResults();
        ItemPage itemPage = new ItemPage(browser);
        Assert.assertTrue(itemPage.isPriceInPriceRage(300, 400));
        logger.info("FilteringByPriceRangeTest ENDED");
    }

    public void openDetskiyMir() {
        HomePage homePage = new HomePage(browser);
        homePage.open();
        homePage.openDetskiyMir();
        ChildPage childPage = new ChildPage(browser);
        Assert.assertTrue(childPage.isOpened());
    }

    public void openChildDressPage() {
        ChildPage childPage = new ChildPage(browser);
        childPage.openDetskayaOdezhda();
    }

}