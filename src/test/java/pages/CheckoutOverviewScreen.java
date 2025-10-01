package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class CheckoutOverviewScreen extends BaseScreen{
    public CheckoutOverviewScreen(AppiumDriver driver) {
        super(driver);
    }
    private final By pageTitleLocator = AppiumBy.xpath("//android.widget.TextView[@text='CHECKOUT: OVERVIEW']");
    private final By cartScrollContainerLocator = AppiumBy.accessibilityId("test-CHECKOUT: OVERVIEW");

    private final By finishButtonLocator = AppiumBy.accessibilityId("test-FINISH");
    public boolean isScreenDisplayed() {
        return isElementVisible(pageTitleLocator, 10);
    }
    public ConfirmationScreen tapFinishButton(){
        scrollIntoViewAndClick(finishButtonLocator, cartScrollContainerLocator, 5);
        return new ConfirmationScreen(driver);
    }
}
