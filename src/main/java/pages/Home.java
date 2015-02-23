package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {

    WebDriver browser;

    public Home(WebDriver driver) {

        this.browser = driver;
    }

        By search = new By.ById("headerSearch");
        By button = new By.ById("submit-searchmain");
        By nazva = new By.ByXPath("//*[@id=\"offers_table\"]/tbody/tr[3]/td/table/tbody/tr/td[3]/h3/a/span");


    public void find(String zapros) {
        browser.findElement(search).sendKeys(zapros);
        browser.findElement(button).click();
    }

    public boolean isFound(String stroka) {
        return browser.findElement(nazva).getText().contains(stroka);
    }



}