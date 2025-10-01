package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;

public class CartScreen extends BaseScreen {
    public CartScreen(AppiumDriver driver) {
        super(driver);
    }
    private final By cartTitleLocator = AppiumBy.xpath("//android.widget.TextView[@text='YOUR CART']");
    private final By checkoutButtonLocator = AppiumBy.accessibilityId("test-CHECKOUT");
    private final By cartScrollContainerLocator = AppiumBy.accessibilityId("test-Cart Content");

    private By getCartItemLocator(String productName) {
        return AppiumBy.xpath(String.format(
                "//android.widget.ScrollView[@content-desc='test-Cart Content']" +
                        "//android.widget.TextView[contains(@text, '%s')]",
                productName
        ));
    }
    private By getCartItemQuantityLocator(String productName) {
        return AppiumBy.xpath(String.format(
                "//android.widget.TextView[@text='%s']" +
                        "/ancestor::android.view.ViewGroup[contains(@content-desc, 'test-Item')]" +
                        "//android.widget.TextView[preceding-sibling::android.widget.TextView[@text='QTY'] or @text='1']",
                productName
        ));
    }
    private By getCartItemPriceLocator(String productName) {
        return AppiumBy.xpath(String.format(
                "//android.widget.TextView[@text='%s']" +
                        "/ancestor::android.view.ViewGroup[contains(@content-desc, 'test-Item')]" +
                        "//android.widget.TextView[contains(@text, '$')]",
                productName
        ));
    }
    private By getRemoveButtonLocator(String productName) {
        return AppiumBy.xpath(String.format(
                "//android.widget.TextView[@text='%s']" +
                        "/ancestor::android.view.ViewGroup//android.widget.TextView[@text='REMOVE']",
                productName
        ));
    }

    public boolean isCartTitleDisplayed() {
        return isElementVisible(cartTitleLocator, 10);
    }
    public boolean isProductListed(String productName) {
        return isElementVisible(getCartItemLocator(productName), 5);
    }
    public boolean isProductNotListed(String productName) {
        return !isElementVisible(getCartItemLocator(productName), 2);
    }
    public String getProductQuantity(String productName) {
        WebElement element = waitForElementVisibility(getCartItemQuantityLocator(productName), 5);
        return element.getText();
    }
    public String getProductPrice(String productName) {
        WebElement element = waitForElementVisibility(getCartItemPriceLocator(productName), 5);
        return element.getText();
    }
    public void clickRemoveButton(String productName) {
        waitForElementClickable(getRemoveButtonLocator(productName), 10).click();
    }
    public CheckoutInformationScreen clickCheckoutButton() {
        scrollIntoViewAndClick(checkoutButtonLocator, cartScrollContainerLocator, 5);
        return new CheckoutInformationScreen(driver);
    }
}