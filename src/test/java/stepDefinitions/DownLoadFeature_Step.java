package stepDefinitions;

import driverManager.DriverManager;

import static org.testng.Assert.assertEquals;


import org.testng.Assert;


import hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DownLoadFeature;

import driverManager.DriverManager;
public class DownLoadFeature_Step {
	
	AndroidDriver driver = DriverManager.getDriver();
	DownLoadFeature DLF = new DownLoadFeature(driver);
	
	
	@When("The User click on the Downlaod menu in the home page")
	public void the_user_click_on_the_downlaod_menu_in_the_home_page() 
	throws InterruptedException {
		DLF.VideoDownload();
		
	}

	@Then("The user can see the downloaded videos below")
	public void the_user_can_see_the_downloaded_videos_below() {
		DLF.isVideoVisible();
	}

	@Given("The User is on the Download page on skyTube application")
	public void the_user_is_on_the_download_page_on_sky_tube_application() {
	   DLF.downloadPage();
	}

	@When("The User click on the three dot on the videos")
	public void the_user_click_on_the_three_dot_on_the_videos() {
	    DLF.ClickonOption();
	}

	@Then("The user will see multiple option with Delete download option")
	public void the_user_will_see_multiple_option_with_delete_download_option() {
	   DLF.isDeleteoptionVisible();
	}

	@Given("The User is on the mulitple options page")
	public void the_user_is_on_the_mulitple_options_page() {
		System.out.println("The User is on the mulitple options page"); 
	}

	@When("The User click on the delete download option")
	public void the_user_click_on_the_delete_download_option() {
		driver.navigate().back();
	    //DLF.DeleteDownloadedVideo();
	}

	@Then("The user will see the selected will be deleted from there")
	public void the_user_will_see_the_selected_will_be_deleted_from_there() {
		DLF.isDeleteoptionVisible();
	}
	
	@Then("The user will see {string} message")
	public void the_user_will_see_message(String string) {
		DLF.NodownloadvideVisible();
	    
	}





}
