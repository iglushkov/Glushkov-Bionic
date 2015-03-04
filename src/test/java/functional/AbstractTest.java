package functional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;
import utils.PropertyLoader;
import webdriver.Browser;


import java.io.File;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {
    protected WebDriver driver;
    protected HomePage home;
    public Browser browser;

    @BeforeSuite
    public void initEnv(){

        driver = new FirefoxDriver();
        home = new HomePage(driver).open();
        driver.manage().window().maximize();
    }
/*      if (PropertyLoader.loadProperty("browser").equals("firefox"))
            browser = new Browser(new FirefoxDriver());
        else if (PropertyLoader.loadProperty("browser").equals("chrome")) {
            File file = new File("/Users/admin/Applications/chromedriver");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            browser = new Browser(new ChromeDriver());
        }
*/
    @AfterSuite
    public void shutEnv(){
//        if (driver!= null){
//            driver.quit();
//        }
    }
}