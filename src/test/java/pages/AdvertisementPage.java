package pages;

import entities.Advertisement;
import org.openqa.selenium.By;
import webdriver.Browser;

public class AdvertisementPage extends AbstractPage {

    private static final By createAdvertisementLink = By.id("post-new-ad");
    private static final By advTitle = By.id("add-title");
    private static final By advCategory = By.cssSelector("#targetrenderSelect1-0>dt>a");
    private static final By category = By.id("cat-36");
    private static final By childrenWorld = By.cssSelector("a[data-category = '69']");
    private static final By childrenWear = By.cssSelector("a[data-category = '1']");
    private static final By price = By.className("paramPriceInput");
    private static final By state = By.xpath(".//*[@id='targetparam13']/dt/a");
    private static final By chooseState = By.xpath(".//*[@id='targetparam13']/dd/ul/li[3]/a");
    private static final By email = By.id("add-email");

    public AdvertisementPage(Browser browser) {
        super(browser);
    }

    public void setAdv(Advertisement adv) {
        driver.findElement(advTitle).sendKeys(adv.title);
        driver.findElement(email).sendKeys(adv.email);
    }

}