
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage{

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public void open()
    {
        driver.get("http://olx.ua/uk/");
    }

    public void openDetskiyMir()
    {
        driver.findElement(By.cssSelector("a[data-code='detskiy-mir']")).click();
    }

}