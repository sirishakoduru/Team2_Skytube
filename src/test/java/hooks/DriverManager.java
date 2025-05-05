package hooks;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class DriverManager {
	private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    public static void setDriver(AndroidDriver driverInstance) {
        driver = driverInstance;
    }

    private static void initializeDriver() {
        File f = new File("src/test/resources/apk");
        File fs = new File(f, "SkyTube-Extra-2.995.apk");

        UiAutomator2Options options = new UiAutomator2Options()
                .setAppWaitActivity("*")
                .setUdid("emulator-5554")
                .setApp(fs.getAbsolutePath())
                .setNoReset(true)
                .setFullReset(false);

        try {
//            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
