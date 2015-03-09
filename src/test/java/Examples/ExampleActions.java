package Examples;

import functional.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleActions extends AbstractTest {

    private static final By googlePlayIcon = new By.ByCssSelector(".icon.block.googleplay");

    @Test
    public void exampleTest() {

        browser.get("http://olx.ua/uk/");
        Actions actions = new Actions(browser.driver);
        actions.moveToElement(browser.findElement(googlePlayIcon));
        actions.perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Assert.fail("Test crushed");
        }

    }

}

