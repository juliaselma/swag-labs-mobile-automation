package pages;

import io.appium.java_client.AppiumDriver;

public class BaseScreen {
    protected io.appium.java_client.AppiumDriver driver;
    public BaseScreen(AppiumDriver driver) {
        this.driver = driver;
    }
}
