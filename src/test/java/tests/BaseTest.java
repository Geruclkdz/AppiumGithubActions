package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest extends AbstractTestNGCucumberTests {

    public static AppiumDriver driver;

    public static void Android_setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setPlatformVersion("16.0");
        options.setDeviceName("Pixel9(Android Emulator)");
        options.setApp(System.getProperty("user.dir") + "/apps/ToDo.apk");

        driver = new AndroidDriver(new URL("http://localhost:4723/"), options);
    }

    public static void iOS_setUp(String port, String deviceName, String udid, int wdaLocalPort) throws MalformedURLException {

        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("iOS");
        options.setAutomationName("XCUITest");
        options.setPlatformVersion("18.5");
        options.setDeviceName(deviceName);
        options.setApp(System.getProperty("user.dir") + "/apps/DailyCheck.app");
        options.setWdaLocalPort(wdaLocalPort);
        options.setUdid(udid);

        driver = new IOSDriver(new URL("http://localhost:" + port + "/"), options);
    }

    @AfterTest
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
