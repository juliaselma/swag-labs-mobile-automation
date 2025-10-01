package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class CheckoutOverviewScreen extends BaseScreen{
    public CheckoutOverviewScreen(AppiumDriver driver) {
        super(driver);
    }
    private final By pageTitleLocator = AppiumBy.xpath("//android.widget.TextView[@text='CHECKOUT: OVERVIEW']");
    public boolean isScreenDisplayed() {
        return isElementVisible(pageTitleLocator, 10);
    }
}
