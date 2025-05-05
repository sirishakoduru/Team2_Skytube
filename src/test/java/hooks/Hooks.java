package hooks;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	public static AndroidDriver driver;
	
	static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down driver...");
            DriverManager.quitDriver();
        }));
    }
	
	@Before
	public void setup() {
		
		DriverManager.getDriver();
//		File f = new File("src/test/resources/apk");
//		File fs = new File(f,"SkyTube-Extra-2.995.apk");
//		
//		UiAutomator2Options options = new UiAutomator2Options()
//				.setAppWaitActivity("*")
//			    .setUdid("emulator-5554")
//			    .setApp(fs.getAbsolutePath());
//		
//
//			try {
//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
//				driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
//			} catch (MalformedURLException | URISyntaxException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
	}
	@After
	public void teardown(Scenario scenario) {
		 driver = DriverManager.getDriver();
		   if (scenario.isFailed()) {
	            // Clean scenario name for filename
	            String safeName = scenario.getName().replaceAll(" ", "_");

	            // Take screenshot
	            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            File screenshotDest = new File("target/screenshots/" + safeName + ".png");

	            try {
	                Files.createDirectories(Paths.get("target/screenshots"));
	                Files.copy(screenshotFile.toPath(), screenshotDest.toPath(), StandardCopyOption.REPLACE_EXISTING);

	                // Attach screenshot to report
	                byte[] screenshotBytes = Files.readAllBytes(screenshotFile.toPath());
	                scenario.attach(screenshotBytes, "image/png", safeName);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
//		 if (driver != null) {
//		        driver.quit();
//		    }
	
	}
//	public static AndroidDriver getDriver() {
//		// TODO Auto-generated method stub
//		return driver;
//	}
}
