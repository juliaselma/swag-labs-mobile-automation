package pages;

import io.appium.java_client.AppiumDriver;

public class BasePage {
    protected io.appium.java_client.AppiumDriver driver;
    public BasePage(AppiumDriver driver) {
        this.driver = driver;
    }
}
