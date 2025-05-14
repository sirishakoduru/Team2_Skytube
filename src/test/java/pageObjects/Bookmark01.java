package pageObjects;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class Bookmark01 {
	
	@AndroidFindBy(xpath="(//android.widget.ImageView[@resource-id='free.rm.skytube.extra:id/thumbnail_image_view'])[2]")
	WebElement VideoName;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.android.permissioncontroller:id/grant_dialog\"]/android.widget.LinearLayout[2]")
	WebElement Notification;
	
	//@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")
	//WebElement notificationAllow;
	
	@AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_button")
	WebElement notificationAllow;
	
	@AndroidFindBy(xpath="(//android.widget.ImageView[@resource-id=\"free.rm.skytube.extra:id/thumbnail_image_view\"])[2]")
	WebElement videoPlay;
	

	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button3\"]")
	WebElement okButton;
	
	
	@AndroidFindBy(xpath="(//android.widget.ImageButton[@resource-id=\"free.rm.skytube.extra:id/options_button\"])[1]")
	WebElement threeDotsButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"free.rm.skytube.extra:id/title\" and @text=\"Bookmark\"]")
	WebElement bookmarkOption;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id=\"free.rm.skytube.extra:id/options_button\"]")
	WebElement threeDotsButtonUnbookmark;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"free.rm.skytube.extra:id/title\" and @text=\"Unbookmark\"]")
	WebElement unbookmarkOption;
	
	@AndroidFindBy(xpath="//android.widget.Toast[1]")
	WebElement bookmarkMessage; 
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"BOOKMARKS\"]")
	WebElement bookmarkModule;
	
//	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id=\"free.rm.skytube.extra:id/thumbnail_image_view\"]")
//	WebElement bookmarkedVideos;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id=\"free.rm.skytube.extra:id/thumbnail_image_view\"]")
	WebElement bookmarkedVideos;
//	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"free.rm.skytube.extra:id/sub_channel_name_text_view\"]")
//	WebElement selectSubscribedChanel;
//	
//@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"free.rm.skytube.extra:id/channel_subscribe_button\"]")
//	WebElement unsubscribeButton;
//	
//	@AndroidFindBy(xpath="//android.widget.Toast[2]")
//	WebElement unsubscribeMessage;

	@AndroidFindBy(id="free.rm.skytube.extra:id/menu_badge_icon")
	WebElement hamburgerIcon;
	
	
	AndroidDriver driver;
	
	public Bookmark01(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void dismissStartupPopupIfPresent() {
		 try {
		        Thread.sleep(5000); // wait for popup manually
		        if (okButton.isDisplayed()) {
		            okButton.click();
		        }
		    } catch (Exception e) {
		        // Do nothing
		    }
		}
	
	public void handlePermissionIfPresent() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.visibilityOf(notificationAllow));
	        notificationAllow.click();
	        System.out.println("Permission 'Allow' button clicked.");
	    } catch (TimeoutException e) {
	        System.out.println("No permission popup appeared.");
	    }

	}
	
	public void numberOfVideos() {
		
		
       // By thumbnailsLocator = By.xpath("(//android.widget.ImageView[@resource-id=\"free.rm.skytube.extra:id/thumbnail_image_view\"])[2]");
        
		By thumbnailsLocator = By.xpath("(//android.widget.ImageView[@resource-id='free.rm.skytube.extra:id/thumbnail_image_view'])[1]");

        // Wait until at least one thumbnail is visible
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(thumbnailsLocator));

        List<WebElement> videoThumbnails = driver.findElements(thumbnailsLocator);

        System.out.println("Found thumbnails: " + videoThumbnails.size());
        
	}
	
	public boolean isVideoPlaying() {
	    // Replace with the actual resource-id or UI element on the playback screen
	    By videoPlayingIndicator = By.id("free.rm.skytube.extra:id/player_view");

	    try {
	        new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.visibilityOfElementLocated(videoPlayingIndicator));
	        return true;
	    } catch (TimeoutException e) {
	        return false;
	    }
	}
	
	
	 public void clickThreeDotsAndBookmark() {
	        new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.elementToBeClickable(threeDotsButton))
	            .click();

	        new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.elementToBeClickable(bookmarkOption))
	            .click();
	    }
	
//	public void clickUnbookmarkoption() {
//		
//		unbookmarkOption.click();
//		
//	}
	
	 public boolean isBookmarkedToastVisible(String expectedToast) {
	        By toastLocator = By.xpath("//android.widget.Toast[1]");

	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	            String toastMessage = wait.until(ExpectedConditions.presenceOfElementLocated(toastLocator)).getText();
	            System.out.println("Toast Message: " + toastMessage);
	            return toastMessage.equals(expectedToast);
	        } catch (Exception e) {
	            System.out.println("Toast not found or mismatched: " + e.getMessage());
	            return false;
	        }
	    }
	 
	 public void openBookmarksTab() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(bookmarkModule)).click();
	    }

	    // Step 4: Verify bookmarked videos exist
	 public boolean isBookmarkedVideoVisible() {
		    try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        List<WebElement> videos = wait.until(
		            ExpectedConditions.visibilityOfAllElements(bookmarkedVideos)
		        );
		        return !videos.isEmpty();
		    } catch (TimeoutException e) {
		        // In case elements are not visible within the timeout
		        System.out.println("No bookmarked videos found.");
		        return false;
		    }
		}
	 
	 
	 public void clickThreeDotsAndUnbookmark() {
	        new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.elementToBeClickable(threeDotsButtonUnbookmark))
	            .click();

	        new WebDriverWait(driver, Duration.ofSeconds(5))
	            .until(ExpectedConditions.elementToBeClickable(unbookmarkOption))
	            .click();
	    }

	 
		
	
public boolean isBookmarkeremovedToastVisible(String expectedToast) {
    By toastLocator = By.xpath("//android.widget.Toast[1]");

    try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String toastMessage = wait.until(ExpectedConditions.presenceOfElementLocated(toastLocator)).getText();
        System.out.println("Toast Message: " + toastMessage);
        return toastMessage.equals(expectedToast);
    } catch (Exception e) {
        System.out.println("Toast not found or mismatched: " + e.getMessage());
        return false;
    }
}

}
