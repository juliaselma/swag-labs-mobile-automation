package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;


public class CartScreen extends BaseScreen {
    private final By cartTitleLocator = AppiumBy.xpath("//android.widget.TextView[@text='YOUR CART']");

    public CartScreen(AppiumDriver driver) {
        super(driver);
    }
    public boolean isCartTitleDisplayed() {
        return isElementVisible(cartTitleLocator, 10);
    }
}