package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChildWorldPage extends AbstractPage{
    private static final By OPEN_CHILDREN_DRESS_LINK = By.id("cat-539");

    public ChildWorldPage(WebDriver driver){super(driver);}

    public ChildDressPage openKidsDress(){
        driver.findElement(OPEN_CHILDREN_DRESS_LINK).click();
        return new ChildDressPage(driver);
    }

    public boolean isOpened(){
        return driver.findElement(OPEN_CHILDREN_DRESS_LINK).isDisplayed();
    }
}