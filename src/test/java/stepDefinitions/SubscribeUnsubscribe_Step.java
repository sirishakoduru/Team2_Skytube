package stepDefinitions;


import org.testng.Assert;

import hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SubscribeUnsubscribe;

public class SubscribeUnsubscribe_Step {
	
	AndroidDriver driver = Hooks.getDriver();
	SubscribeUnsubscribe SubscribeUnsubscribepage = new SubscribeUnsubscribe(driver);
	
	@Given("User is on the skytube home page")
	public void user_is_on_the_skytube_home_page() {
	    
		SubscribeUnsubscribepage.clickOkButton();
	}

	@When("User selects the vedio to be played and clicks on the options of the vedio to subscribe")
	public void User_selects_the_vedio_to_be_played_and_clicks_on_the_options_of_the_vedio_to_subscribe() {
	    
		SubscribeUnsubscribepage.clickChannelName();
	    
	}

	@Then("Then User should see {string} message")
	public void then_user_should_see_message(String string) {
		
	    String Actual = SubscribeUnsubscribepage.getSubscribedAlert();
		Assert.assertEquals(string,Actual);
	    
	}


	@When("User clicks on the hamburger menu on the top left corner and navigates to subscribed channel tab")
	public void user_clicks_on_the_hamburger_menu_on_the_top_left_corner_and_navigates_to_subscribed_channel_tab() {
	    
	}

	@Then("User should see the subscribed channel")
	public void user_should_see_the_subscribed_channel() {
	    
	    
	}

	@When("User clicks on the hamburger menu on the top left corner and selectes the subscribed channel in the subscriptions tab")
	public void user_clicks_on_the_hamburger_menu_on_the_top_left_corner_and_selectes_the_subscribed_channel_in_the_subscriptions_tab() {
	    
	}

	@Then("User shouls see the unsubscribe button")
	public void user_shouls_see_the_unsubscribe_button() {
	    
	    
	}

	@Given("User is on the subscribed channel")
	public void user_is_on_the_subscribed_channel() {
	    
	    
	}

	@When("User clicks on the unsubscribe button")
	public void user_clicks_on_the_unsubscribe_button() {
	    
	    
	}

	@Then("User should see the message {string}")
	public void user_should_see_the_message(String string) {
	    
	    
	}


}
