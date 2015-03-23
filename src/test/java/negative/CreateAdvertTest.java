package negative;

import entities.Advertisement;
import functional.AbstractTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddNewAdvertPage;
import pages.HomePage;

public class CreateAdvertTest extends AbstractTest {

    Logger logger = LoggerFactory.getLogger(CreateAdvertTest.class);

    @Test
    public void creatingAdvertTest() {
        logger.info("CreatingAdvert test STARTED");
        HomePage homePage = new HomePage(browser);
        homePage.open();
        homePage.clickAddNewAdvert();
        Advertisement adv = new Advertisement(false);
        AddNewAdvertPage addNewAdvertPage = new AddNewAdvertPage(browser);
        addNewAdvertPage.setAdv(adv);
        Assert.assertTrue(addNewAdvertPage.isErrorPresent());
        logger.info("CreatingAdvert test ENDED");
    }

}