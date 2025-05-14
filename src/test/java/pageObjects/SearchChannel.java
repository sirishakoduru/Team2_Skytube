package pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchChannel {
	
	AndroidDriver driver;

    
    @AndroidFindBy (xpath = "//android.widget.ImageButton[@content-desc=\"SkyTube Extra\"]")
    WebElement HamBurgerMenu;

    @AndroidFindBy (xpath = "(//android.widget.ImageButton[@resource-id=\"free.rm.skytube.extra:id/options_button\"])[1]")
    WebElement OptionBtn;
    
    @AndroidFindBy (xpath ="(//android.widget.LinearLayout[@resource-id=\"free.rm.skytube.extra:id/content\"])[6]")
    WebElement ChannelOption;
    
    @AndroidFindBy (xpath ="//android.widget.TextView[@resource-id=\"free.rm.skytube.extra:id/title\" and @text=\"Subscribe\"]")
    WebElement SubscribeOption;
    
    @AndroidFindBy (id="free.rm.skytube.extra:id/search_src_text")
    WebElement SearchOption;
    
    @AndroidFindBy (id = "com.android.permissioncontroller:id/permission_allow_button")
	WebElement AllowBtn;
    
    @AndroidFindBy (xpath ="//android.widget.Button[@resource-id=\"android:id/button3\"]")
    WebElement okBtn;
    
    @AndroidFindBy (xpath="//android.widget.TextView[@resource-id=\"free.rm.skytube.extra:id/sub_channel_name_text_view\"]")
    WebElement Channelname;
    
    @AndroidFindBy(id="free.rm.skytube.extra:id/menu_search")
    WebElement SearchIcon;
    
    @AndroidFindBy(id="free.rm.skytube.extra:id/search_src_text")
    WebElement SearchTab;
    
    @AndroidFindBy (xpath="(//android.widget.ImageButton[@resource-id=\"free.rm.skytube.extra:id/options_button\"])[2]")
	WebElement ThreeDots;
    
    @AndroidFindBy(id="free.rm.skytube.extra:id/submenuarrow")
    WebElement ChannelArrow;
    
    @AndroidFindBy (xpath="//android.widget.TextView[@resource-id=\"free.rm.skytube.extra:id/title\" and @text=\"Channel...\"]")
	WebElement channelIcon;
    
    @AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"free.rm.skytube.extra:id/title\" and @text=\"Subscribe\"]")
    WebElement Subscribe;
    
    public SearchChannel(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
    
        

public void clickHamburgermenu() throws InterruptedException {
	Thread.sleep(2000);
	HamBurgerMenu.click();
}

public void clickonAllow() {
	AllowBtn.click();
}

public boolean Searchchannel() {
    try {
        return SearchOption.isDisplayed();
    } catch (NoSuchElementException e) {
        return false;
    }
}
public void TypesearchChannel() {
	SearchOption.sendKeys("Red");
}

public void TypesearchChannelNonsubscribe() {
	SearchOption.sendKeys("ESPN");
}

public void TypesearchChannelSplchar() {
	SearchOption.sendKeys("&%4");
}



public void TypeonSearchBar() {	
	
	SearchIcon.click();
	SearchTab.sendKeys("Red");
	try {
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
    } catch (Exception e) {
        System.out.println("ENTER key press failed, trying alternative.");
    }
}

public void subscribeChannel() {
	
	ThreeDots.click();
	channelIcon.click();
	Subscribe.click();
}

public boolean isChannelVisible() {
    try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> videos = wait.until(
            ExpectedConditions.visibilityOfAllElements(Channelname)
        );
        return !videos.isEmpty();
    } catch (TimeoutException e) {
        // In case elements are not visible within the timeout
        System.out.println("No Channel found.");
        return false;
    }
    
    
}
public WebElement getChannelName() {
	return Channelname;
}
public String CheckSubscribedChannel(WebElement ele) {
	 String Channelname = ele.getText();
	 return Channelname;
}


}


