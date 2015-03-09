package pages;

import org.openqa.selenium.By;
import webdriver.Browser;

public class PreviewPage extends AbstractPage {

    private static final By previewText = new By.ByXPath("//*[@id=\"innerLayout\"]/div[3]/div/p[1]");

    public PreviewPage(Browser driver) {
        super(driver);
    }

    public boolean previewIsOpened() {
        return driver.findElement(previewText).getText().contains("Це прев'ю Вашого оголошення");
    }

}