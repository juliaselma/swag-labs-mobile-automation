package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginScreen extends BaseScreen {
    public LoginScreen(AppiumDriver driver) {
        super(driver);
    }

    private final By usernameField = AppiumBy.accessibilityId("test-Username");
    private final By passwordField = AppiumBy.accessibilityId("test-Password");
    private final By loginButton   = AppiumBy.accessibilityId("test-LOGIN");
    private final By errorMessageTextLocator = AppiumBy.xpath("//*[@content-desc='test-Error message']//android.widget.TextView");


    public void enterUsername(String username){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessageElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(errorMessageTextLocator)
        );
        return errorMessageElement.getText().trim();
    }
}
