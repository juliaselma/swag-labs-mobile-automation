package steps;

import pages.*;
import io.appium.java_client.AppiumDriver;
public class TestContext {
    public AppiumDriver driver;

    public LoginScreen loginScreen;
    public ProductScreen productScreen;
    public CartScreen cartScreen;
    public CheckoutInformationScreen checkoutInformationScreen;
    public CheckoutOverviewScreen checkoutOverviewScreen;
    public ConfirmationScreen confirmationScreen;

    public TestContext() {
    }
}