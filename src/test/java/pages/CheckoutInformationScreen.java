package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class CheckoutInformationScreen extends BaseScreen{
    private final By pageTitleLocator = AppiumBy.xpath("//android.widget.TextView[@text='CHECKOUT: INFORMATION']");
    public CheckoutInformationScreen(AppiumDriver driver) {
        super(driver);
    }
    public boolean isCheckoutTitleDisplayed() {
        return isElementVisible(pageTitleLocator, 10);
    }
}
