package TestingOLX;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.Home;

public class Olx {

    public WebDriver driver;

    @BeforeSuite
    public void initDriver() {

        driver = new FirefoxDriver();

    }

    @Test
    public void OLXTest() {

        driver.get("http://olx.ua/");
        Home home = new Home(driver);
        home.find("Roland td-4");
        Assert.assertTrue(home.isFound("Roland td-4"));

    }

    @AfterSuite
    public void shutEnv() {
        driver.quit();
    }

}

