package core;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.time.Duration;
import java.net.MalformedURLException;
import utils.ConfigurationManager;

public class DriverSetup {

    public static ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();

    public static void initializeDriver() {
        try {
            String platformName = ConfigurationManager.getProperty("platformName");
            String deviceName = ConfigurationManager.getProperty("deviceName");
            String appPackage = ConfigurationManager.getProperty("appPackage");
            String appActivity = ConfigurationManager.getProperty("appActivity");
            String automationName = ConfigurationManager.getProperty("automationName");
            String appPath = ConfigurationManager.getProperty("appPath");
            int timeout = ConfigurationManager.getIntProperty("newCommandTimeoutSeconds");
            String appiumUrl = ConfigurationManager.getProperty("appiumServerURL");

            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName(platformName)
                    .setDeviceName(deviceName)
                    .setAppPackage(appPackage)
                    .setAppActivity(appActivity)
                    .setAutomationName(automationName)
                    .setApp(appPath)
                    .setNewCommandTimeout(Duration.ofSeconds(timeout));

            URL appiumServerURL = new URL(appiumUrl);
            driver.set(new AndroidDriver(appiumServerURL, options));

            System.out.println("Appium Driver initialized successfully.");
        } catch (MalformedURLException e) {
            System.err.println("Error setting up driver: Malformed URL.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error setting up driver: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static AndroidDriver getDriver() {
        return driver.get();
    }
}