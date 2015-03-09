package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import utils.PropertyLoader;
import webdriver.Browser;

public class AddNewAdvertPage extends AbstractPage {

    private String imagePath = PropertyLoader.loadProperty("project.path") + "/src/test/resources/image.jpg";
    private String title = "";
    private String itemPrice = "";
    private String description = "";
    private String contactPerson = "";
    private String email = "";

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
    private static final By closeButton = new By.ById("fancybox-close");

    public AddNewAdvertPage(Browser driver) {
        super(driver);
    }

    public void generateAdvertData() {
        title = RandomStringUtils.randomAlphabetic(5).toLowerCase();
        itemPrice = RandomStringUtils.randomNumeric(3);
        description = RandomStringUtils.randomAlphabetic(50).toLowerCase();
        contactPerson = RandomStringUtils.randomAlphabetic(5).toLowerCase();
        email = RandomStringUtils.randomAlphabetic(5).toLowerCase() + "@gmail.com";
    }

    public void fillInAllFields() {
        driver.findElement(titleField).sendKeys(title);
        driver.findElement(addImage).sendKeys(imagePath);
        driver.findElement(categorySelector).click();
        driver.findElement(childrenWorld).click();
        driver.findElement(otherChildrenStuff).click();
        driver.findElement(closeButton).click();
        driver.findElement(price).sendKeys(itemPrice);
        driver.findElement(descriptionField).sendKeys(description);
        driver.findElement(contactPersonField).sendKeys(contactPerson);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(state).click();
        driver.findElement(stateNew).click();
        driver.findElement(owner).click();
        driver.findElement(ownerOwner).click();
        driver.findElement(region).click();
        driver.findElement(regionKievskiy).click();
        driver.findElement(city).click();
        driver.findElement(kiev).click();
        driver.findElement(agreeCheckbox).click();
    }

    public void openPreview() {
        driver.findElement(previewLink).click();
    }

}