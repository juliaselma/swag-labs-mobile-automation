package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ProductScreen extends BaseScreen{
    public ProductScreen(AppiumDriver driver) {
        super(driver);
    }
    private final By productsTitle = AppiumBy.xpath("//android.widget.TextView[@text='PRODUCTS']");
    private By getProductButtonTextLocator(String productName, String expectedText) {
        return AppiumBy.xpath(String.format(
                "//*[@text='%s']" +
                        "/ancestor::android.view.ViewGroup" +
                        "//*[contains(@text, '%s')]",
                productName,
                expectedText
        ));
    }
    private final By cartNavigationButton = AppiumBy.accessibilityId("test-Cart");
    private final By cartBadgeTextLocator = AppiumBy.xpath("//*[@content-desc='test-Cart']//android.widget.TextView");
    public void clickAddToCartButton(String productName) {
        By locator = getProductButtonTextLocator(productName, "ADD TO CART");
        waitForElementClickable(locator, 10).click();
    }
    public void clickRemoveButton(String productName) {
        By locator = getProductButtonTextLocator(productName, "REMOVE");
        waitForElementClickable(locator, 10).click();
    }
    public int getCartBadgeCount() {

        if (isElementVisible(cartBadgeTextLocator, 1)) { // Use a very short wait to check for existence
            try {
                WebElement badge = waitForElementVisibility(cartBadgeTextLocator, 1);
                String countText = badge.getText();
                return Integer.parseInt(countText);

            } catch (Exception e) {
                System.err.println("Cart badge visible but text is not a valid number: " + e.getMessage());
                return 0;
            }
        }
        return 0;
    }
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
    public boolean isProductButtonTextDisplayed(String productName, String expectedText) {
        By locator = getProductButtonTextLocator(productName, expectedText);
        return isElementVisible(locator, 5);
    }

    public CartScreen clickCartIcon() {
        waitForElementClickable(cartNavigationButton, 10).click();
        return new CartScreen(driver);
    }
}
