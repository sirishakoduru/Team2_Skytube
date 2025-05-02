package pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SubscribeUnsubscribe {
	
	@AndroidFindBy(id="android:id/button3")
	WebElement versionUpdateAlert;
	
	@AndroidFindBy(xpath="((//android.view.ViewGroup[@resource-id=\"free.rm.skytube.extra:id/channel_layout\"])[1]")
	WebElement channelName;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id=\"free.rm.skytube.extra:id/channel_thumbnail_image_view\"]")
	WebElement channelTitle;
	
	@AndroidFindBy (xpath="(//android.widget.ImageButton[@resource-id=\"free.rm.skytube.extra:id/options_button\"])[2]")
	WebElement moreOptions;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@resource-id=\"free.rm.skytube.extra:id/title\" and @text=\"Channel...\"]")
	WebElement channelIcon;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"free.rm.skytube.extra:id/title\" and @text=\"Subscribe\"]")
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
	
	
	
	AndroidDriver driver;
	
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
	
	public String getSubscribedAlert() {
		return subscribeMessage.getText();
	}
	
	public void clickMenuIcon() {
		hamburgerIcon.click();
	}
	
	public void selectSubscribedChannel() {
		selectSubscribedChanel.click();;
	}
	
	public void clickunsubscribeButton() {
		unsubscribeButton.click();
	}
	
	public void getUnsubscribedMessage() {
		unsubscribeMessage.getText();
	}
	
	
	
//	xpath for selecting channel = //android.widget.TextView[@resource-id="free.rm.skytube.extra:id/channel_text_view" and @text="House of Highlights"]
//		id for subscribe button clicking=	free.rm.skytube.extra:id/channel_subscribe_button
//		xpath for subscribe button clicking = 	//android.widget.Button[@resource-id="free.rm.skytube.extra:id/channel_subscribe_button"]
//		
//				id for unsubscribe button clicking=free.rm.skytube.extra:id/channel_subscribe_button
//				xpath for unsubscribe button clicking =//android.widget.Button[@resource-id="free.rm.skytube.extra:id/channel_subscribe_button"]
//				
    
}
