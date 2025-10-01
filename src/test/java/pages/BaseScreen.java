package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class BaseScreen {
   protected AppiumDriver driver;
    public BaseScreen(AppiumDriver driver) {
        this.driver = driver;
    }
    public WebElement waitForElementVisibility(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public boolean isElementVisible(By locator, int timeoutInSeconds) {
        try {
            waitForElementVisibility(locator, timeoutInSeconds);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public WebElement waitForElementClickable(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void scrollIntoViewAndClick(By locator, By scrollContainerLocator, int maxScrolls) {
        WebElement scrollElement;
        try {
            scrollElement = new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                    ExpectedConditions.presenceOfElementLocated(scrollContainerLocator)
            );
        } catch (TimeoutException e) {
            Assert.fail("Cart scroll container not found within 10 seconds: " + scrollContainerLocator.toString(), e);
            return;
        }

        String scrollElementId = ((RemoteWebElement) scrollElement).getId();

        Map<String, Object> scrollArgs = new HashMap<>();
        scrollArgs.put("elementId", scrollElementId);
        scrollArgs.put("direction", "down");
        scrollArgs.put("percent", 0.5);
        scrollArgs.put("speed", 500);

        for (int i = 0; i < maxScrolls; i++) {
            try {
                WebElement targetElement = new WebDriverWait(driver, Duration.ofSeconds(1)).until(
                        ExpectedConditions.elementToBeClickable(locator)
                );
                targetElement.click();
                return; // Success
            } catch (Exception e) {
                if (i < maxScrolls - 1) {
                    driver.executeScript("mobile: scrollGesture", scrollArgs);
                }
            }
        }
    Assert.fail("Could not find and click CHECKOUT button after " + maxScrolls + " scrolls: " + locator.toString());
    }
    public By getButtonLocator(String buttonName) {
        String fullId = "test-" + buttonName.toUpperCase();
        return AppiumBy.accessibilityId(fullId);
    }

    public void tapButton(String buttonName) {
        By buttonLocator = getButtonLocator(buttonName);

        final int MAX_SCROLLS = 3;

        for (int i = 0; i < MAX_SCROLLS; i++) {
            try {
                // 2. Find and click the element using the generic locator
                driver.findElement(buttonLocator).click();
                System.out.println("Tapped button: " + buttonName);
                return;
            } catch (NoSuchElementException e) {
                if (i == MAX_SCROLLS - 1) {
                    // If max scrolls reached, throw the error
                    throw new NoSuchElementException("Failed to find and tap " + buttonName + " button after max scrolls.");
                }
                // 3. Scroll and try again
                //scrollHelper.scrollDownSmall();
                scrollIntoViewAndClick(buttonLocator,buttonLocator,MAX_SCROLLS);
            }
        }
    }

}
