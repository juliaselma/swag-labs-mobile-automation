package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class LoginScreen extends BaseScreen {
    public LoginScreen(AppiumDriver driver) {
        super(driver);
    }
    private final By usernameField = AppiumBy.accessibilityId("test-Username");
    private final By passwordField = AppiumBy.accessibilityId("test-Password");
    private final By loginButton   = AppiumBy.accessibilityId("test-LOGIN");
    private final By errorMessageTextLocator = AppiumBy.xpath("//*[@content-desc='test-Error message']//android.widget.TextView");
    public void enterUsername(String username){
        waitForElementVisibility(usernameField,5);
        WebElement element = driver.findElement(usernameField);
        element.sendKeys(username);
    }
    public void enterPassword(String password) {
        WebElement element = driver.findElement(passwordField);
        element.sendKeys(password);
    }
    public ProductScreen clickLoginButton() {
        driver.findElement(loginButton).click();
        return new ProductScreen(driver);
    }
    public String getErrorMessage() {
        WebElement errorMessageElement = waitForElementVisibility(errorMessageTextLocator,5);
        return errorMessageElement.getText().trim();
    }
}
