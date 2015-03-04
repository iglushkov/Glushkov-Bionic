package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ReviewAdPage extends AbstractPage {
    public ReviewAdPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(By.xpath(".//*[@id='innerLayout']/div[3]/div/p[1]")).isDisplayed();
    }
}