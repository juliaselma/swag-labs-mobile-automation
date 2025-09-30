package core;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import java.net.URL;
import java.time.Duration;
import java.net.MalformedURLException;
import utils.ConfigurationManager;

public class DriverSetup {

    public static ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();

    public static AppiumDriver initializeAndGetDriver() {
        try {
            String platformName = ConfigurationManager.getProperty("platformName");
            String deviceName = ConfigurationManager.getProperty("deviceName");
            String appiumUrl = ConfigurationManager.getProperty("appiumServerURL");
            int timeout = ConfigurationManager.getIntProperty("newCommandTimeoutSeconds");
            String appPackage = ConfigurationManager.getProperty("appPackage");
            String appActivity = ConfigurationManager.getProperty("appActivity");

            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName(platformName)
                    .setDeviceName(deviceName)
                    .setAppPackage(appPackage)
                    .setAppActivity(appActivity)
                    .setNewCommandTimeout(Duration.ofSeconds(timeout));

            URL appiumServerURL = new URL(appiumUrl);

            AndroidDriver newDriver = new AndroidDriver(appiumServerURL, options);
            System.out.println("Appium Driver initialized successfully.");

            return newDriver;

        } catch (MalformedURLException e) {
            System.err.println("Error setting up driver: Malformed URL.");
            e.printStackTrace();
            throw new RuntimeException("Malformed Appium URL.", e);
        } catch (Exception e) {
            System.err.println("Error setting up driver: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Driver setup failed.", e);
        }
    }

    public static AndroidDriver getDriver() {
        return driver.get();
    }
}