package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutInformationScreen extends BaseScreen{
    private final By pageTitleLocator = AppiumBy.xpath("//android.widget.TextView[@text='CHECKOUT: INFORMATION']");

    private final By firstNameField = AppiumBy.accessibilityId("test-First Name");
    private final By lastNameField = AppiumBy.accessibilityId("test-Last Name");
    private final By postalCodeField = AppiumBy.accessibilityId("test-Zip/Postal Code");
    private final By cancelButton = AppiumBy.accessibilityId("test-CANCEL");
    private final By continueButton = AppiumBy.accessibilityId("test-CONTINUE");
    public CheckoutInformationScreen(AppiumDriver driver) {
        super(driver);
    }
    public boolean isCheckoutTitleDisplayed() {
        return isElementVisible(pageTitleLocator, 10);
    }

    public void enterUsername(String username){
        waitForElementVisibility(firstNameField,5);
        WebElement element = driver.findElement(firstNameField);
        element.sendKeys(username);
    }
    public void enterLastName(String lastname){
        waitForElementVisibility(lastNameField,5);
        WebElement element = driver.findElement(lastNameField);
        element.sendKeys(lastname);
    }
    public void enterPostalCode (String zipCode){
        waitForElementVisibility(postalCodeField,5);
        WebElement element = driver.findElement(postalCodeField);
        element.sendKeys(zipCode);
    }
    /*public void tapButton (String buttonName){
        if (getButtonLocator(buttonName).equals("CONTINUE")) {tapContinue();}
        else if (getButtonLocator(buttonName).equals("CANCEL")) {tapCancel();}
    }*/
    public CheckoutOverviewScreen tapContinue(){
        //driver.findElement(continueButton).click();
        tapButton("CONTINUE");
        return new CheckoutOverviewScreen (driver);
    };
    public ProductScreen tapCancel(){
        tapButton("CANCEL");
        //driver.findElement(cancelButton).click();
        return new ProductScreen (driver);
    };

}
