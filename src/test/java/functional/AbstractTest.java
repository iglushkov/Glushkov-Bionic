package functional;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import webdriver.Browser;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class AbstractTest {
    public Browser driver;

    @BeforeSuite
    public void initEnv()
    {
        File file = new File("/Users/admin/Applications/chromedriver");
        System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
        driver = new Browser(new ChromeDriver());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void shutEnv()
    {
        if (driver != null)
            driver.quit();
    }
}