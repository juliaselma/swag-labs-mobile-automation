package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverSetup {
    public static AppiumDriver driver;
    public static LoginPage LoginPage;
    public static void initializeDriver() {
        try {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName("Android")
                    .setDeviceName("emulator-5554")
                    .setAppPackage("com.swaglabsmobileapp")
                    .setAppActivity("com.swaglabsmobileapp.MainActivity")
                    .setAutomationName("UiAutomator2")
                    .setApp("C:/Users/Usuario/Documents/codigo/swag-labs-mobile-automation-betsson/app/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk")
                    .setNewCommandTimeout(Duration.ofSeconds(180))
                    .setNoReset(true);

            URL appiumServerURL = new URL("http://127.0.0.1:4723");
            driver = new AndroidDriver(appiumServerURL, options);
            setUpStartApp();

            System.out.println("Appium Driver initialized successfully.");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Error setting up driver: " + e.getMessage());
        }
    }

    public static void setUpStartApp() {
        LoginPage = new LoginPage(getDriver());
    }

    public static AppiumDriver getDriver() {
        return driver;
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}