package pageObjects;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Preferences {
	
AndroidDriver driver;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"More options\"]")
	WebElement moreOptions;
	
	@AndroidFindBy(xpath = "(//android.widget.LinearLayout[@resource-id=\"free.rm.skytube.extra:id/content\"])[3]")
	WebElement Preferences;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"free.rm.skytube.extra:id/action_bar\"]")
	WebElement preferencesTab;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Video Player\"]")
	WebElement videoPlayer;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Video Blocker\"]")
	WebElement videoBlocker;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"SponsorBlock\"]")
	WebElement sponserBlock;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Import/Export\"]")
	WebElement importOrexport;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Privacy\"]")
	WebElement privacy;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Network and Downloads\"]")
	WebElement networkAndDownloads;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Others\"]")
	WebElement others;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"About\"]")
	WebElement about;
	
	
	public Preferences (AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickMoreOptions() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(moreOptions));
		moreOptions.click();
	}
	
	public void clickPreferences() {
		Preferences.click();
	}
	
	public boolean isInPreferenceTab() {
		return preferencesTab.isDisplayed();
	}
	
//	public boolean isMenuOptionsDisplayed(String optionsText) {
//		try {
//			
//			WebElement Options = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='\" + optionsText + \"']"));
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	        wait.until(ExpectedConditions.visibilityOf(Options));
//			return Options.isDisplayed();
//		} catch
//			(Exception e) {
//	            return false;
//		}
	public boolean isMenuOptionsDisplayed(String optionsText) {
	    try {
	        String preferenceOptions = "//android.widget.TextView[@resource-id='android:id/title' and @text='" + optionsText + "']";
	        WebElement option = driver.findElement(By.xpath(preferenceOptions));
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(option));
	        return option.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}

	}
	
	

	


