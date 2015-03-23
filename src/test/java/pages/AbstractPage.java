package pages;


import webdriver.Browser;

public class AbstractPage {

    protected Browser driver;

    public AbstractPage(Browser driver) {
        this.driver = driver;
    }

    public static void waitSomeTime(Integer time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}