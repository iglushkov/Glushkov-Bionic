package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.Browser;

import java.util.List;

public class ChildDressPage extends AbstractPage{

    private static final By paramState = By.cssSelector("#param_state>div>a");
    private static final By newState = By.cssSelector("#f-new_state");
    private static final By detailsLink = By.cssSelector(".marginright5.link.linkWithHash.detailsLink>span");
    private static final By a = By.cssSelector("a");

    public ChildDressPage(Browser driver){super(driver);}

    public boolean isOpened(){
        return (driver.getCurrentUrl().contains("detskiy-mir/detskaya-odezhda/")
                && driver.findElement(By.id("main-category-choose-label")).getText().contains("Дитячий одяг"));
    }

    public Boolean sortByNew(){
        driver.findElement(paramState).click();
        driver.findElement(newState).click();
        driver.findElement(detailsLink).click();
        List<WebElement> elements = driver.findElements(a);
        Boolean ok = false;
        for (int i=0; i<elements.size(); i++) {
            if (elements.get(i).getText().equalsIgnoreCase("Нові")) {
                ok = true;
            }
        }
        driver.navigate().back();
        return ok;
    }

}