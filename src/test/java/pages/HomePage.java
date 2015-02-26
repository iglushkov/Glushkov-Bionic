package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.Browser;

public class HomePage extends AbstractPage{

    private static final By childWorldLink = By.cssSelector("a[data-code='detskiy-mir']");


    @FindBy(css = "a[data-code='detskiy-mir']")
    WebElement childPageLink;


    public HomePage(Browser driver)
    {
        super(driver);
    }

    public void open()
    {
        driver.get("http://olx.ua/uk/");
    }

    public void openDetskiyMir()
    {
        driver.findElement(childWorldLink).click();
    }

}