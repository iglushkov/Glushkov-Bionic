package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChildDressPage extends AbstractPage{
    public ChildDressPage(WebDriver driver){
        super(driver);
    }
    public boolean isOpened(){
        return (driver.getCurrentUrl().contains("/detskiy-mir/detskaya-odezhda/")
                && driver.findElement(By.id("main-category-choose-label"))
                .getText().contains("Детская одежда"));
    }
}