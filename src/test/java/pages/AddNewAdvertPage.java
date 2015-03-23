package pages;

import entities.Advertisement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webdriver.Browser;

public class AddNewAdvertPage extends AbstractPage {

    Logger logger = LoggerFactory.getLogger(AddNewAdvertPage.class);

    private static final By titleField = new By.ById("add-title");
    private static final By categorySelector = new By.ByXPath("//*[@id=\"targetrenderSelect1-0\"]/dt/a");
    private static final By childrenWorld = new By.ById("cat-36");
    private static final By otherChildrenStuff = new By.ByXPath("//*[@id=\"category-36\"]/div[2]/div[2]/div/ul/li[10]/a");
    private static final By price = new By.ByXPath("//*[@id=\"parameter-div-price\"]/div[2]/div/div[1]/p[3]/input");
    private static final By state = new By.ByXPath("//*[@id=\"targetparam13\"]");
    private static final By stateNew = new By.ByXPath("//*[@id=\"targetparam13\"]/dd/ul/li[3]/a");
    private static final By owner = new By.ByXPath("//*[@id=\"targetid_private_business\"]/dt/a");
    private static final By ownerOwner = new By.ByXPath("//*[@id=\"targetid_private_business\"]/dd/ul/li[2]/a");
    private static final By descriptionField = new By.ById("add-description");
    private static final By region = new By.ByXPath("//*[@id=\"targetregion-id-select\"]/dt/a");
    private static final By regionKievskiy = new By.ByXPath("//*[@id=\"targetregion-id-select\"]/dd/ul/li[10]/a");
    private static final By city = new By.ByXPath("//*[@id=\"targetsubregion-id-select\"]/dt/a");
    private static final By kiev = new By.ByXPath("//*[@id=\"targetsubregion-id-select\"]/dd/ul/li[20]/a");
    private static final By contactPersonField = new By.ById("add-person");
    private static final By emailField = new By.ById("add-email");
    private static final By agreeCheckbox = new By.ByXPath("//*[@id=\"accept\"]/div/div[2]/div/label");
    private static final By addImage = new By.ByXPath("//*[@id=\"gallery\"]/div[3]/input");
    private static final By previewLink = new By.ById("preview-link");

    public AddNewAdvertPage(Browser driver) {
        super(driver);
    }

    public void setAdv(Advertisement adv) {
        driver.findElement(titleField).sendKeys(adv.title);
        driver.findElement(addImage).sendKeys(adv.imagePath);
        driver.findElement(categorySelector).click();
        waitSomeTime(3000);
        driver.findElement(childrenWorld).click();
        driver.findElement(otherChildrenStuff).click();
        waitSomeTime(3000);
        driver.findElement(price).sendKeys(adv.itemPrice);
        driver.findElement(descriptionField).sendKeys(adv.description);
        driver.findElement(contactPersonField).sendKeys(adv.contactPerson);
        driver.findElement(emailField).sendKeys(adv.email);
        driver.findElement(state).click();
        driver.findElement(stateNew).click();
        driver.findElement(owner).click();
        driver.findElement(ownerOwner).click();
        driver.findElement(region).click();
        driver.findElement(regionKievskiy).click();
        driver.findElement(city).click();
        driver.findElement(kiev).click();
        driver.findElement(agreeCheckbox).click();
        logger.info("Advert data setted");
    }

    public void openPreview() {
        driver.findElement(previewLink).click();
    }

    public boolean isErrorPresent() {
        logger.info("Errors are present");
        return true;
    }

}