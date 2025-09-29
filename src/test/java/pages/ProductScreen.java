package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ProductScreen extends BaseScreen{
    public ProductScreen(AppiumDriver driver) {
        super(driver);
    }
    private final By productsTitle = AppiumBy.xpath("//android.widget.TextView[@text='PRODUCTS']");

    public boolean isProductsTitleVisible() {
        return driver.findElement(productsTitle).isDisplayed();
    }
    private By getProductTitleLocator(String productName) {
        return AppiumBy.xpath(String.format(
                "//*[@content-desc='%s' or @text='%s']",
                productName,
                productName
        ));
    }

    public boolean isProductListed(String productName) {
        By locator = getProductTitleLocator(productName);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
