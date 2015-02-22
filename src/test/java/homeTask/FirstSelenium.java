package homeTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FirstSelenium {

    public WebDriver driver;

    @BeforeSuite
    public void initDriver() {
        driver = new FirefoxDriver();
    }

    @Test
    public void wikiTest() {
        driver.get("https://github.com/login");
        WebElement id = driver.findElement(By.id("login_field"));
        WebElement tabindex = driver.findElement(By.id("password"));
        WebElement button = driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[3]/input[3]"));

        id.sendKeys("TestGlushkov");
        tabindex.sendKeys("TestGlushkov1");
        button.click();

        WebElement logout = driver.findElement(By.xpath("//*[@id=\"user-links\"]/li[5]/form/button/span"));

        Assert.assertTrue(logout.isDisplayed());

     }
        @AfterSuite
        public void shutEnv() {
            driver.quit();
        }
    }

//}