package functional;

import entities.Advertisement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAdPage;
import pages.ReviewAdPage;


public class CreateAdTest extends AbstractTest {
    @Test
    public void createAdTest(){
        CreateAdPage createAd = home.openCreateAd();
        createAd.setAd(new Advertisement());
        createAd.acceptLicenseAgreement();
        ReviewAdPage review = createAd.createAd();
        Assert.assertTrue(review.isOpened());
    }
}
