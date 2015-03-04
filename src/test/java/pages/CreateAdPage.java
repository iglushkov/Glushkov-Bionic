package pages;

import entities.Advertisement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class CreateAdPage extends AbstractPage{
    private static final By NEW_OFFER_TEXT = By.xpath(".//*[@id='newOffer']/div/h1");
    private static final By ACCEPT_AGREEMENT_CHECKBOX = By.xpath(".//*[@id='accept']/div/div[2]/div/label");
    private static final By PREVIEW_LINK = By.xpath(".//*[@id='preview-link']/span");
    private static final By TITLE_TEXT_FIELD = By.xpath(".//*[@id='add-title']");
    private static final By RUBRIC_DROPDOWN = By.xpath(".//*[@id='targetrenderSelect1-0']/dt/a");
    private static final By CHILD_WORLD_RUBRIC = By.xpath(".//*[@id='cat-36']/span[1]");
    private static final By CHILD_DRESS_RUBRIC = By.xpath(".//*[@id='category-36']/div[2]/div[2]/div/ul/li[1]/a/span[1]");
    private static final By BOYS_DRESS_RUBRIC = By.xpath(".//*[@id='category-539']/div[2]/div[2]/div/ul/li[1]/a/span[1]");
    private static final By FREE_OF_CHARGE_PRISE = By.xpath(".//*[@id='parameter-div-price']/div[2]/div/div[1]/p[1]/label[1]");
    private static final By STATE_DROPDOWN = By.xpath(".//*[@id='targetparam13']/dt/a");
    private static final By SECOND_HAND = By.xpath(".//*[@id='targetparam13']/dd/ul/li[2]/a");
    private static final By SIZE_TEXT_FIELD = By.xpath(".//*[@id='parameter-div-size']/div[2]/div/input");
    private static final By BUSINESS_DROPDOWN = By.xpath(".//*[@id='targetid_private_business']/dt/a");
    private static final By PRIVATE_PERSON = By.xpath(".//*[@id='targetid_private_business']/dd/ul/li[2]/a");
    private static final By DESCRIPTION_TEXTFIELD = By.xpath(".//*[@id='add-description']");
    private static final By ADD_FILE = By.xpath(".//*[@id='add-file-1']/div/a/span");
    private static final By REGION_DROPDOWN = By.xpath(".//*[@id='targetregion-id-select']/dt/a");
    private static final By DNEPR_REGION = By.xpath("//*[@id=\"targetregion-id-select\"]/dd/ul/li[4]/a");
    private static final By SUBREGION_DROPDOWN = By.xpath(".//*[@id='targetsubregion-id-select']/dt/a");
    private static final By DNEPR_SUBREGION = By.xpath("//*[@id=\"targetsubregion-id-select\"]/dd/ul/li[6]/a");
    private static final By NAME_TEXT_FIELD = By.xpath(".//*[@id='add-person']");
    private static final By EMAIL_TEXT_FIELD = By.xpath(".//*[@id='add-email']");
    private static final By ERROR_MESSAGE = By.className("error");

    protected WebDriverWait wait;

    public CreateAdPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 30);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(NEW_OFFER_TEXT).isDisplayed();
    }

    public void setAd(Advertisement ad)
    {
        setTitle(ad.title);
        setRubric();
        setPrise();
        setState();
        setSize(ad.size);
        setBusiness();
        setDescription(ad.description);
        //addPhoto(ad.photoUrl);
        setRegion();
        setName(ad.name);
        setEmail(ad.email);
    }

    public void acceptLicenseAgreement(){
        driver.findElement(ACCEPT_AGREEMENT_CHECKBOX).click();
    }

    public ReviewAdPage createAd(){
        driver.findElement(PREVIEW_LINK).click();
        wait.withTimeout(3, TimeUnit.SECONDS);
        return new ReviewAdPage(driver);
    }

    private void setTitle(String title){
        driver.findElement(TITLE_TEXT_FIELD).sendKeys(title);
    }

    private void setRubric(){
        driver.findElement(RUBRIC_DROPDOWN).click();
        waitAndClick(CHILD_WORLD_RUBRIC);
        waitAndClick(CHILD_DRESS_RUBRIC);
        driver.findElement(BOYS_DRESS_RUBRIC).click();
    }
    private void waitAndClick(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    private void setPrise(){
        waitAndClick(FREE_OF_CHARGE_PRISE);
    }

    private void setState(){
        driver.findElement(STATE_DROPDOWN).click();
        driver.findElement(SECOND_HAND).click();
    }

    private void setSize(int size){
        driver.findElement(SIZE_TEXT_FIELD).sendKeys(Integer.toString(size));
    }

    private void setBusiness(){
        driver.findElement(BUSINESS_DROPDOWN).click();
        driver.findElement(PRIVATE_PERSON).click();
    }

    private void setDescription(String description){
        driver.findElement(DESCRIPTION_TEXTFIELD).sendKeys(description);
    }

    private void addPhoto(String url){
        driver.findElement(ADD_FILE).click();
        setClipboardData(url);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.setAutoDelay(900);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    private static void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    private void setRegion(){
        driver.findElement(REGION_DROPDOWN).click();
        driver.findElement(DNEPR_REGION).click();
        driver.findElement(SUBREGION_DROPDOWN).click();
        driver.findElement(DNEPR_SUBREGION).click();
    }

    private void setName(String name){
        driver.findElement(NAME_TEXT_FIELD).sendKeys(name);
    }

    private void setEmail(String email){
        driver.findElement(EMAIL_TEXT_FIELD).sendKeys(email);
    }

    public boolean errorIsPresent(){
        return driver.findElement(ERROR_MESSAGE).isDisplayed();
    }
}