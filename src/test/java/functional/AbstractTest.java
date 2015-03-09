package functional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.PropertyLoader;
import webdriver.Browser;
import java.util.concurrent.TimeUnit;

public class AbstractTest {

    public Browser browser;

    @BeforeSuite
    public void initEnv() {

        if (PropertyLoader.loadProperty("browser").equals("firefox")) {
            browser = new Browser(new FirefoxDriver());
        } else if (PropertyLoader.loadProperty("browser").equals("chrome")) {
            browser = new Browser(new ChromeDriver());
        }
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterSuite
    public void shutEnv() {

        if (browser != null)
            browser.quit();

    }

}