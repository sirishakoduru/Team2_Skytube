package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class DownLoadFeature {
	
	AndroidDriver driver;

    public DownLoadFeature(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy (xpath = "(//android.widget.ImageButton[@resource-id=\"free.rm.skytube.extra:id/options_button\"])[1]")
    WebElement Threedots;
    @AndroidFindBy (xpath = "(//android.widget.LinearLayout[@resource-id=\"free.rm.skytube.extra:id/content\"])[5]")
    WebElement downloadBtn;    
	@AndroidFindBy(id="android:id/button3") 
	WebElement UpdatePopup;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='DOWNLOADS']") 
	WebElement DwonloadPagebtn;	
	@AndroidFindBy (id = "com.android.permissioncontroller:id/permission_allow_button")
	WebElement PermissionAllowBtn;
	@AndroidFindBy (id = "free.rm.skytube.extra:id/options_button")
	WebElement ThreedotinDownloadPage;
	@AndroidFindBy (id = "//android.widget.TextView[@text=\"DOWNLOADS\"]")
	WebElement videoTitle;
	
	@AndroidFindBy (xpath = "(//android.widget.LinearLayout[@resource-id=\"free.rm.skytube.extra:id/content\"])[5]")
	WebElement deleteDownloadBtn;
	
	@AndroidFindBy (id = "free.rm.skytube.extra:id/noDownloadedVideosText")
	WebElement noDownloadedVideoMessage;
	
	public void VideoDownload() throws InterruptedException {
		Thread.sleep(2000); 
		Threedots.click();
		
		 downloadBtn.click();
		 
		 
//		 if (PermissionAllowBtn.isDisplayed()) {
//			    PermissionAllowBtn.click();
//			}
		 DwonloadPagebtn.click();
	}
	 
	 public void DeleteDownloadedVideo() {
		 //ThreedotinDownloadPage.click();
		 deleteDownloadBtn.click();
	}
	 
	 public void ClickdownloadButton() {
		downloadBtn.click();
	}
	 
	 public void ClickPermissionToAccessFiles() {
		 PermissionAllowBtn.click();
		
	}
	 
	 public void downloadPage() {
		 DwonloadPagebtn.click();
	}
	 
	 public void AssertDownloadedVideo() {
		String videotitle = videoTitle.getText();
		Assert.assertEquals(videotitle, "Andor | Season 2 Trailer | Streaming April 22 on Disney+");
	}
	 
	 public void AssertDeletingDownloads() {
		 String message = noDownloadedVideoMessage.getText();
		 Assert.assertEquals(message, "Download some videos to find them here.");
	}
	 public boolean isVideoVisible() {
		    try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        List<WebElement> videos = wait.until(
		            ExpectedConditions.visibilityOfAllElements(videoTitle)
		        );
		        return !videos.isEmpty();
		    } catch (TimeoutException e) {
		        // In case elements are not visible within the timeout
		        System.out.println("No Video found.");
		        return false;
		    }
		    
	}
	 public void ClickonOption() {
		 ThreedotinDownloadPage.click();
	} 
	 public boolean isDeleteoptionVisible() {
		    try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        List<WebElement> videos = wait.until(
		            ExpectedConditions.visibilityOfAllElements(downloadBtn)
		        );
		        return !videos.isEmpty();
		    } catch (TimeoutException e) {
		        // In case elements are not visible within the timeout
		        System.out.println("No Video found.");
		        return false;
		    }
		    
	}
	 
	 public boolean NodownloadvideVisible() {
		    try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        List<WebElement> videos = wait.until(
		            ExpectedConditions.visibilityOfAllElements(noDownloadedVideoMessage)
		        );
		        return !videos.isEmpty();
		    } catch (TimeoutException e) {
		        // In case elements are not visible within the timeout
		        System.out.println("No Video found.");
		        return false;
		    }
		    
	}
}

	

