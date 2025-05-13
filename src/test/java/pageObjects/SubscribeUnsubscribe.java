package pageObjects;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SubscribeUnsubscribe {
	AndroidDriver driver;
	
	@AndroidFindBy(id="android:id/button3")
	WebElement versionUpdateAlert;
	
	@AndroidFindBy(xpath="((//android.view.ViewGroup[@resource-id=\"free.rm.skytube.extra:id/channel_layout\"])[0]")
	WebElement channelName;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id=\"free.rm.skytube.extra:id/channel_thumbnail_image_view\"]")
	WebElement channelTitle;
	
	@AndroidFindBy (xpath="(//android.widget.ImageButton[@resource-id=\"free.rm.skytube.extra:id/options_button\"])[2]")
	WebElement moreOptions;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@resource-id=\"free.rm.skytube.extra:id/title\" and @text=\"Channel...\"]")
	WebElement channelIcon;
	
	@AndroidFindBy (xpath="//android.widget.ListView/android.widget.LinearLayout[2]")
	WebElement subscribeButton;
	
	@AndroidFindBy(xpath="//android.widget.Toast[1]") 
	WebElement subscribeMessage;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc=\"SkyTube Extra\"]")
	WebElement hamburgerIcon;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"free.rm.skytube.extra:id/sub_channel_name_text_view\"]")
	WebElement selectSubscribedChanel;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"free.rm.skytube.extra:id/channel_subscribe_button\"]")
	WebElement unsubscribeButton;
	
	@AndroidFindBy(xpath="//android.widget.Toast[2]")
	WebElement unsubscribeMessage;
	
	
	
	public SubscribeUnsubscribe(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickOkButton() {
		versionUpdateAlert.click();
	}
	
	public void clickChannelName() {
		moreOptions.click();
		channelIcon.click();
//		channelName.click();
		
	}
	
	public boolean isOnSelectedChannel() {
		return channelTitle.isDisplayed();
	}
	
	public void clickSubscribeBtn() {
		subscribeButton.click();
	}
	
	public String getToastMessageSubscribe() {
		subscribeButton.click();
		
		By toastLocator = By.xpath("//android.widget.Toast[1]");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String toastMessage = wait.until(ExpectedConditions.presenceOfElementLocated(toastLocator)).getText();
        System.out.println("Toast Message: " + toastMessage);
        return toastMessage;
        
	}
	
	public String getSubscribedAlert() {
		return subscribeMessage.getText();
	}
	
	public void clickMenuIcon() {
		hamburgerIcon.click();
	}
	
	public String CheckSubscribedChannel(WebElement ele) {
		 String channelName = ele.getText();
		 return channelName;
	}
	public boolean issubscribedChannelDisplayed() {
		return channelName.isDisplayed();
	}
	
	public WebElement getChannelName() {
		return channelName;
	}
	public WebElement getSubscribedChannel() {
		return selectSubscribedChanel;
	}
	
	public void selectSubscribedChannel() {
		selectSubscribedChanel.click();;
	}
	
	public boolean isUnsubscribeButtonDisplayed() {
		return unsubscribeButton.isDisplayed();
	}
	
	public void clickunsubscribeButton() {
		unsubscribeButton.click();
	}
	
	public void getUnsubscribedMessage() {
		unsubscribeMessage.getText();
	}
	
	public String getToastMessageUnSubscribe() {
		unsubscribeButton.click();

		By toastLocator = By.xpath("//android.widget.Toast[1]");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String toastMessage = wait.until(ExpectedConditions.presenceOfElementLocated(toastLocator)).getText();
        System.out.println("Toast Message: " + toastMessage);
        return toastMessage;
        
	}
	
	
    
}
