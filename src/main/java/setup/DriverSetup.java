package setup;


import enums.Properties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;

import static enums.Browsers.CHROME;
import static enums.Browsers.SAFARI;
import static enums.ErrorMessages.UNKNOWN_APPLICATION;
import static enums.ErrorMessages.UNKNOWN_PLATFORM;
import static io.appium.java_client.remote.MobileCapabilityType.*;

/**
 * Initialize a driver with test properties
 */
public class DriverSetup extends TestProperties {

    private static AppiumDriver driverSingleton = null;
    private static WebDriverWait waitSingleton;

    protected DesiredCapabilities capabilities;
    protected String SUT; // site under testing
    // Properties to be read
    private String AUT; // (mobile) app under testing
    private String TEST_PLATFORM;
    private String DRIVER;
    private String DEVICE_NAME;
    private String UDID;
    private String APP_PACKAGE;
    private String APP_ACTIVITY;

    private java.util.Properties properties;

    /**
     * Initialize driver with appropriate capabilities depending on platform and application
     * * @throws Exception
     */
    protected void prepareDriver() throws Exception {

        String resourcePath = "src/main/resources/";
        String mobileAppName = getProp(Properties.AUT.value);
        AUT = mobileAppName == null ? null : resourcePath + mobileAppName;
        String t_sut = getProp(Properties.SUT.value);
        SUT = t_sut == null ? null : "https://" + t_sut;
        TEST_PLATFORM = getProp(Properties.TEST_PLATFORM.value);
        DRIVER = getProp(Properties.DRIVER.value);
        DEVICE_NAME = getProp(Properties.DEVICE_NAME.value);
        UDID = getProp(Properties.UDID.value);
        APP_PACKAGE = getProp(Properties.APP_PACKAGE.value);
        APP_ACTIVITY = getProp(Properties.APP_ACTIVITY.value);
        String browserName;

        capabilities = new DesiredCapabilities();
        capabilities.setCapability(Properties.APP_PACKAGE.value, APP_PACKAGE);
        capabilities.setCapability(Properties.APP_ACTIVITY.value, APP_ACTIVITY);
        capabilities.setCapability(MobileCapabilityType.UDID, UDID);
        capabilities.setCapability(PLATFORM_NAME, TEST_PLATFORM);

        // Setup test platform: Android or iOS. Browser also depends on a platform.
        switch (TEST_PLATFORM) {
            case "Android":
                browserName = CHROME.browserName;
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME); // default Android emulator
                break;
            case "iOS":
                browserName = SAFARI.browserName;
                break;
            default:
                throw new Exception(UNKNOWN_PLATFORM.value);
        }

        // Setup type of application: mobile, webTests (
        if (AUT != null && SUT == null) {
            // Native
            File app = new File(AUT);
            capabilities.setCapability(APP, app.getAbsolutePath());
        } else if (SUT != null && AUT == null) {

            // Web
            capabilities.setCapability(BROWSER_NAME, browserName);
        } else {
            throw new Exception(UNKNOWN_APPLICATION.value);
        }

        // Init driver for local Appium server with capabilities
        switch (TEST_PLATFORM) {
            case "Android":
                driverSingleton = new AndroidDriver(new URL(DRIVER), capabilities);
                break;
            case "iOS":
                driverSingleton = new IOSDriver(new URL(DRIVER), capabilities);
                break;
            default:
                throw new Exception(UNKNOWN_PLATFORM.value);
        }

        // Set an object to handle timeouts
        if (waitSingleton == null) {
            waitSingleton = new WebDriverWait(driver(), 10);
        }
    }

    protected AppiumDriver driver() throws Exception {
        if (driverSingleton == null) {
            prepareDriver();
        }
        return driverSingleton;
    }

    protected WebDriverWait driverWait() throws Exception {
        return waitSingleton;
    }
}
