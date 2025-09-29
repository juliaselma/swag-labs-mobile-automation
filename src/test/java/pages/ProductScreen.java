package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ProductScreen extends BasePage{
    public ProductScreen(AppiumDriver driver) {
        super(driver);
    }
    private final By productsPage = AppiumBy.xpath("//android.widget.TextView[@text='PRODUCTS']");

    public boolean areProductsVisible() {
        return driver.findElement(productsPage).isDisplayed();
    }
}
