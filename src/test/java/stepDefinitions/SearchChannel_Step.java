package stepDefinitions;

import static org.testng.Assert.assertEquals;

//import org.junit.jupiter.api.extension.ExtendWith;
import org.testng.Assert;

import driverManager.DriverManager;
import hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SearchChannel;
//import utilities.DriverProvider;

//@ExtendWith(DriverProvider.class)
public class SearchChannel_Step {
	
	AndroidDriver driver = DriverManager.getDriver();
	SearchChannel SearchChannelPage = new SearchChannel(driver);
	
	@Given("The User is on the skytube home page")
	public void the_user_is_on_the_skytube_home_page() {
		System.out.println("user is in home page"); 
	}

	@When("The User Click on the hamburger menu on left side of home page")
	public void the_user_click_on_the_hamburger_menu_on_left_side_of_home_page() throws InterruptedException {
		SearchChannelPage.clickHamburgermenu();
	}

	@Then("The User will land on subscription page with search channel options")
	public void the_user_will_land_on_subscription_page_with_search_channel_options() {
		SearchChannelPage.Searchchannel();
	}

	@Given("The User is on the subscription page with search channel options")
	public void the_user_is_on_the_subscription_page_with_search_channel_options() {
		System.out.println("The User is on the subscription page with search channel options"); 
		//SearchChannelPage.TypeonSearchBar();
		//driver.navigate().back();
		//SearchChannelPage.subscribeChannel();
	}

	@When("The User type the valid subscribed channel {string} in the search tab")
	public void the_user_type_the_valid_subscribed_channel_in_the_search_tab(String string) throws InterruptedException {
		SearchChannelPage.subscribeChannel();
		SearchChannelPage.clickHamburgermenu();
		SearchChannelPage.TypesearchChannel();
	}

	@Then("The User can see the searched subscribed channel below the search bar")
	public void the_user_can_see_the_searched_subscribed_channel_below_the_search_bar() {
		String expChannelName = SearchChannelPage.CheckSubscribedChannel(SearchChannelPage.getChannelName());
	    String actSubscribedChannelName = SearchChannelPage.CheckSubscribedChannel(SearchChannelPage.getChannelName());
	    assertEquals(actSubscribedChannelName, expChannelName);
	}

	@When("The User type the non subscribed channel {string} in the search tab")
	public void the_user_type_the_non_subscribed_channel_in_the_search_tab(String string) throws InterruptedException {
		SearchChannelPage.clickHamburgermenu();
		SearchChannelPage.TypesearchChannelNonsubscribe();
	}

	@Then("The user can see empty column below the search tab")
	public void the_user_can_see_empty_column_below_the_search_tab() {
		SearchChannelPage.isChannelVisible();
	}

	@When("The User type the special character {string} in the search tab")
	public void the_user_type_the_special_character_in_the_search_tab(String string) throws InterruptedException {
		SearchChannelPage.clickHamburgermenu();
		SearchChannelPage.TypesearchChannelSplchar();
	    
	}




}
