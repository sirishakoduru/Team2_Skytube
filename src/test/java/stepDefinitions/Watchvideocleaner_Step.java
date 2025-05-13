package stepDefinitions;

import org.testng.Assert;


import hooks.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Bookmark01;
import pageObjects.Watchvideocleaner04;
import pageObjects.Bookmark01;

public class Watchvideocleaner_Step {
	
	AndroidDriver driver =  DriverManager.getDriver();
	Watchvideocleaner04 vc;
	
	
	@Given("User sees SkyTube Homepage")
	public void user_sees_sky_tube_homepage() {
	   
		vc = new Watchvideocleaner04(driver);
		
	}

	@When("User sees  three dots on top right corner of application and clicks on it")
	public void user_sees_three_dots_on_top_right_corner_of_application_and_clicks_on_it() {
	   
		vc = new Watchvideocleaner04(driver);
		vc.moreoption_click();
		
		
	}

	@Then("User is able to see watched video cleaner option")
	public void user_is_able_to_see_watched_video_cleaner_option() {
	  
		Assert.assertTrue(vc.videoCleanerIsVisible());
		
	}

	@Given("User sees video cleaner option after clicking three dots of application")
	public void user_sees_video_cleaner_option_after_clicking_three_dots_of_application() {
	   
		System.out.println("video cleaner option is displayed");
		
	}

	@When("User clicks watched video cleaner option")
	public void user_clicks_watched_video_cleaner_option() {
	   
		vc = new Watchvideocleaner04(driver);
		vc.videoCleaneroption_click();
		
	}

	@Then("User is able to see watched video cleaner message box with options")
	public void user_is_able_to_see_watched_video_cleaner_message_box_with_options() {
	   
		Assert.assertTrue(vc.videoCleanerMessageboxIsVisible());
		
		
	}
	
	@Given("User is able to see watched video cleaner message box")
	public void user_is_able_to_see_watched_video_cleaner_message_box() {
	    
		vc = new Watchvideocleaner04(driver);
		
		vc.videoCleanerMessageboxIsVisible();
		
		
	}
	
	@When("User clicks on clean option")
	public void user_clicks_on_clean_option() {
		
		vc = new Watchvideocleaner04(driver);
		vc.clickCleanButton();
	}
	
	@Then("User sees {string}")
	public void user_sees(String string) {
	   
		vc.NegativeVideoCleanerToastVisible("zero videos deleted message");
		
	}


	@Given("User sees watched video cleaner message box with options")
	public void user_sees_watched_video_cleaner_message_box_with_options() {
		
		vc = new Watchvideocleaner04(driver);
		vc.BookmarksTab();
		vc.moreoption_click();
		vc.videoCleaneroption_click();
		vc.videoCleanerMessageboxIsVisible();
		
		
	}
	@When("User selects the checkboxes in the box and clicks on clean option")
	public void user_selects_the_checkboxes_in_the_box_and_clicks_on_clean_option() {
		
		//vc = new Watchvideocleaner(driver);
				//vc.selectVideoCheckbox();
				vc.clickCleanButton();
	}

	@Then("User sees message {string}")
	public void user_sees_message(String string) {
		
		vc.PositiveVideoCleanerToastVisible("videos removed from boookmark and downloads");
		
	}


}
