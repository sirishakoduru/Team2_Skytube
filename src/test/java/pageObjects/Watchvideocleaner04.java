package pageObjects;

import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Watchvideocleaner04 {
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc=\"More options\"]")
	WebElement threedotsmoreoption;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"free.rm.skytube.extra:id/title\" and @text=\"Watched Video Cleaner\"]")
	WebElement videocleaneroption;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id=\"free.rm.skytube.extra:id/md_root\"]")
	WebElement videocleanerbox;
	
	@AndroidFindBy(id="free.rm.skytube.extra:id/md_buttonDefaultPositive")
	WebElement cleanButton;
	
	@AndroidFindBy(id="free.rm.skytube.extra:id/md_buttonDefaultNegative")
	WebElement cancelButton;
	
	@AndroidFindBy(className = "android.widget.CheckBox")
	List<WebElement> allCheckboxes;
	
	
	@AndroidFindBy(id="free.rm.skytube.extra:id/clean_watched_downloads")
	WebElement checkBoxDownload;
	
	@AndroidFindBy(xpath="//android.widget.CheckBox[@resource-id=\"free.rm.skytube.extra:id/clean_watched_bookmarks\"]")
	WebElement checkBoxBookmark;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"BOOKMARKS\"]")
	WebElement bookmarkTab;
	
AndroidDriver driver;
	
	public Watchvideocleaner04(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void moreoption_click() {
		
		 threedotsmoreoption.click();
	}
	
	public boolean videoCleanerIsVisible() {
		
		return videocleaneroption.isDisplayed();
		
	}
	
	public void videoCleaneroption_click() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(videocleaneroption));
		videocleaneroption.click();
	}
	
   public boolean videoCleanerMessageboxIsVisible() {
	   
		
		return videocleanerbox.isDisplayed();
		
	}

   public boolean MessageboxWithCleanOptionsIsVisible() {
		
		return cleanButton.isDisplayed();
		
	
		
	}

   public boolean MessageboxWithCancelOptionIsVisible() {
		
	
		return cancelButton.isDisplayed();
		
	}
   
   public boolean checkboxDownloadIsVisible() {
		
		return cleanButton.isDisplayed();
		
	
		
	}
   
   public void BookmarksTab() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(bookmarkTab)).click();
	    }

  public boolean checkboxBookmarkIsVisible() {
		
	
		return cancelButton.isDisplayed();
		
	}
  public void selectVideoCheckbox() {
	  
	  checkBoxDownload.click();
	  checkBoxBookmark.click();
  }

  public void clickCleanButton() {
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
      wait.until(ExpectedConditions.visibilityOf( cleanButton));
	  cleanButton.click();
  }

  public void uncheckAllCheckboxes() {
      for (WebElement checkbox : allCheckboxes) {
          if (checkbox.isSelected()) {
              checkbox.click();
          }
      }
  }

  public boolean NegativeVideoCleanerToastVisible(String expectedToast) {
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
  
  public boolean PositiveVideoCleanerToastVisible(String expectedToast) {
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
