package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import driverManager.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import pageObjects.Videoblockersetup03;

public class Videoblockersetup_step {
	
	AndroidDriver driver = DriverManager.getDriver();
    Videoblockersetup03 vb = new Videoblockersetup03(driver);


	@Given("User is on SkyTube Homepage")
	public void user_is_on_sky_tube_homepage() {
	    
		
		
	}

	@When("User clicks  hamburger icon top right corner of application")
	public void user_clicks_hamburger_icon_top_right_corner_of_application() {
	    
		vb.clickHamburgerMenu();
		
		
	}

	@Then("User is able to see Video blocker set up message box")
	public void user_is_able_to_see_video_blocker_set_up_message_box() {
	   
		Assert.assertTrue(vb.isVideoBlockerMessageVisible(), "Video blocker message box is not visible.");
		
	}

	@Given("User is on Video blocker set up message box")
	public void user_is_on_video_blocker_set_up_message_box() {
	   
		Assert.assertTrue(vb.isVideoBlockerMessageVisible(), "Not on Video blocker message box.");
		
		
	}

	@When("User clicks set option of video blocker")
	public void user_clicks_set_option_of_video_blocker() {
		 vb.clickHamburgerMenu();
		 vb.clickSetOnVideoBlockerMessage();
		
	}


	@Then("User is able to see different options for setup")
	public void user_is_able_to_see_different_options_for_setup() {
	   
		Assert.assertTrue(vb.isSetupOptionVisible(), "Setup options not visible after clicking set.");
		
		
	}	
	
	
	
}
