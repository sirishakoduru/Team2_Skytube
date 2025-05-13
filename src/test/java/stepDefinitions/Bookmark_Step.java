package stepDefinitions;

import org.testng.Assert;

//import com.aventstack.extentreports.ExtentTest;

//import Reports.BaseTest;
import hooks.DriverManager;
import hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Bookmark01;


public class Bookmark_Step {
	
	AndroidDriver driver =  DriverManager.getDriver();
	Bookmark01 bm;
	//private static ExtentTest test = BaseTest.extent.createTest("Bookmark video test");

	
	
	@Given("User is on the home page of SkyTube application")
	public void user_is_on_the_home_page_of_sky_tube_application() {
		
		bm = new Bookmark01(driver);
		bm.dismissStartupPopupIfPresent(); 
		
	    
		
	}

	@When("User selects a video to play and clicks on play button")
	public void user_selects_a_video_to_play_and_clicks_on_play_button() {
		
		//bm.handlePermissionIfPresent();
		bm.numberOfVideos();
		
		
	}
	
	

	@Then("User should see the video playing")
	public void user_should_see_the_video_playing() {
		
		System.out.println("Video is playing");
	   
		//Assert.assertTrue(bm.isVideoPlaying(), "Video is not playing.");
		
	}

	@Given("user is on the home page")
	public void user_is_on_the_home_page() {
	   
		bm = new Bookmark01(driver);
		bm.dismissStartupPopupIfPresent(); 
		
	}

	@When("User clicks three dots below the video and able to select Bookmark option")
	public void user_clicks_three_dots_below_the_video_and_able_to_select_bookmark_option() {
	   
		bm.clickThreeDotsAndBookmark();
		
	}

	@Then("User should be able to see message {string}")
	public void user_should_be_able_to_see_message(String string) {
	    
		 boolean isToastVisible = bm.isBookmarkedToastVisible("Bookmarked");
	        Assert.assertTrue(isToastVisible, "Expected toast 'Bookmarked' not visible.");
		
	}

	@Given("User is on  skyTube home page")
	public void user_is_on_sky_tube_home_page() {
	   
		bm = new Bookmark01(driver);
		bm.dismissStartupPopupIfPresent(); 
	}

	@When("User clicks on Bookmark option on homepage")
	public void user_clicks_on_bookmark_option_on_homepage() {
	   
		bm.openBookmarksTab();
		
	}

	@Then("User should be able to see the bookmarked video")
	public void user_should_be_able_to_see_the_bookmarked_video() {
	    
		bm.isBookmarkedVideoVisible();
		
		
	}

	@Given("User sees the bookmarked video in the bookmark page")
	public void user_sees_the_bookmarked_video_in_the_bookmark_page() {
		
		bm = new Bookmark01(driver);
		bm.isBookmarkedVideoVisible();
		
	}

	@When("User clicks on three dots below the video and clicks Unbookmark")
	public void user_clicks_on_three_dots_below_the_video_and_clicks_unbookmark() {
	   
		bm.clickThreeDotsAndUnbookmark();
		//bm.isBookmarkeremovedToastVisible(String expectedToast)
		
	}
	
	@Then("User sees toast message {string}")
	public void user_sees_toast_message(String string) {
	   
		 boolean isToastVisible = bm.isBookmarkedToastVisible("Bookmark removed");
	        Assert.assertTrue(isToastVisible, "Expected toast 'Bookmark removed' not visible.");
		
		
	}

//	


	
	

}
