package stepDefinitions;


import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import driverManager.DriverManager;
import hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SubscribeUnsubscribe;

public class SubscribeUnsubscribe_Step {
	
	private AndroidDriver driver;
    private SubscribeUnsubscribe SubscribeUnsubscribepage;
    
	   public SubscribeUnsubscribe_Step() {
	        driver = DriverManager.getDriver();  // Retrieve the driver from DriverManager
	        SubscribeUnsubscribepage = new SubscribeUnsubscribe(driver);  // Initialize page object
	    }
	
	@Given("User is on the skytube home page")
	public void user_is_on_the_skytube_home_page() {
	    System.out.println("user is in home page");
//		SubscribeUnsubscribepage.clickOkButton();
	}

	@When("User selects the vedio to be played and clicks on the options of the vedio to subscribe")
	public void User_selects_the_vedio_to_be_played_and_clicks_on_the_options_of_the_vedio_to_subscribe() {
	    
		SubscribeUnsubscribepage.clickChannelName();
	    
	}

	@Then("Then User should see {string} message")
	public void then_user_should_see_message(String string) {
		
	    String Actual = SubscribeUnsubscribepage.getToastMessageSubscribe();
		Assert.assertEquals(string,Actual);
	    
	}


	@When("User clicks on the hamburger menu on the top left corner and navigates to subscribed channel tab")
	public void user_clicks_on_the_hamburger_menu_on_the_top_left_corner_and_navigates_to_subscribed_channel_tab() {
//		SubscribeUnsubscribepage.clickChannelName();
		SubscribeUnsubscribepage.clickMenuIcon();
	}

	@Then("User should see the subscribed channel")
	public void user_should_see_the_subscribed_channel() {
		String expChannelName = SubscribeUnsubscribepage.CheckSubscribedChannel(SubscribeUnsubscribepage.getChannelName());
	    String actSubscribedChannelName = SubscribeUnsubscribepage.CheckSubscribedChannel(SubscribeUnsubscribepage.getSubscribedChannel());
	    assertEquals(actSubscribedChannelName, expChannelName);
//		Assert.assertTrue(SubscribeUnsubscribepage.issubscribedChannelDisplayed());
	    
	}

	@When("User clicks on the hamburger menu on the top left corner and selectes the subscribed channel in the subscriptions tab")
	public void user_clicks_on_the_hamburger_menu_on_the_top_left_corner_and_selectes_the_subscribed_channel_in_the_subscriptions_tab() {
		SubscribeUnsubscribepage.clickMenuIcon();
//		SubscribeUnsubscribepage.selectSubscribedChannel();
	}

	@Then("User shouls see the unsubscribe button")
	public void user_shouls_see_the_unsubscribe_button() {
		//SubscribeUnsubscribepage.clickMenuIcon();
		SubscribeUnsubscribepage.selectSubscribedChannel();
		Assert.assertTrue(SubscribeUnsubscribepage.isUnsubscribeButtonDisplayed());
		
	    
	}

	@Given("User is on the subscribed channel")
	public void user_is_on_the_subscribed_channel() {
//		driver.navigate().back();
		SubscribeUnsubscribepage.clickMenuIcon();
		SubscribeUnsubscribepage.selectSubscribedChannel();
		System.out.println("User is on the subscribed channel");
	    
	}

	@When("User clicks on the unsubscribe button")
	public void user_clicks_on_the_unsubscribe_button() {
//		SubscribeUnsubscribepage.clickunsubscribeButton();
	    
	}

	@Then("User should see the message {string}")
	public void user_should_see_the_message(String string) {
//		SubscribeUnsubscribepage.clickunsubscribeButton();
	    String Actual = SubscribeUnsubscribepage.getToastMessageUnSubscribe();
		Assert.assertEquals(string,Actual);  
	    
	}


}
