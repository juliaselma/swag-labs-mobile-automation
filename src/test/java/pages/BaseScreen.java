package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseScreen {
    protected io.appium.java_client.AppiumDriver driver;
    public BaseScreen(AppiumDriver driver) {
        this.driver = driver;
    }


    /**
     * Waits for an element to be visible and returns it.
     * @param locator The By locator of the element.
     * @param timeoutInSeconds The maximum time to wait.
     * @return The visible WebElement.
     */
    public WebElement waitForElementVisibility(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Checks if an element is visible within a specified timeout.
     * Used mainly for soft assertions (e.g., checking if an error message appears).
     * @param locator The By locator of the element.
     * @param timeoutInSeconds The maximum time to wait.
     * @return True if the element is visible, false otherwise.
     */
    public boolean isElementVisible(By locator, int timeoutInSeconds) {
        try {
            waitForElementVisibility(locator, timeoutInSeconds);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Waits for an element to be clickable.
     * @param locator The By locator of the element.
     * @param timeoutInSeconds The maximum time to wait.
     * @return The clickable WebElement.
     */
    public WebElement waitForElementClickable(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        // Waits for element to be visible AND enabled
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
