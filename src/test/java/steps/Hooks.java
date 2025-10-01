package steps;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import core.DriverSetup;
import pages.LoginScreen;
public class Hooks {
    private final TestContext context;
    public Hooks(TestContext context) {
        this.context = context;
    }
    @Before
    public void setupScenario() {
        AppiumDriver appiumDriver = DriverSetup.initializeAndGetDriver();
        context.driver = appiumDriver;
        context.loginScreen = new LoginScreen(context.driver);
        System.out.println("Appium Driver and LoginScreen assigned to TestContext.");
    }
    @After
    public void tearDownScenario() {
        if (DriverSetup.getDriver() != null) {
            DriverSetup.getDriver().quit();
        }
    }
}
