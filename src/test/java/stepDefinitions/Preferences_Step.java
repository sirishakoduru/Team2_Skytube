package stepDefinitions;

import org.junit.Assert;
//import org.junit.jupiter.api.extension.ExtendWith;

import driverManager.DriverManager;
//import utilities.DriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.Preferences;
import io.cucumber.java.en.Then;

//@ExtendWith(DriverProvider.class)
public class Preferences_Step {
	
	AndroidDriver driver = DriverManager.getDriver();
	Preferences Preferences = new Preferences(driver);
	
	@Given("User on the skytube home page")
	public void user_on_the_skytube_home_page() {
		System.out.println("user is in home page");
	}

	@When("User clicks on the three dots on the top right corner of home page and clicks on preferences")
	public void user_clicks_on_the_three_dots_on_the_top_right_corner_of_home_page_and_clicks_on_preferences() {
		Preferences.clickMoreOptions();
		Preferences.clickPreferences();
	}

	@Then("User is navigated to the preferences tab")
	public void user_is_navigated_to_the_preferences_tab() {
		Assert.assertTrue("User is present on preference Tab: ", Preferences.isInPreferenceTab());
	}

	@Given("User is on the preference tab")
	public void user_is_on_the_preference_tab() {
	   
		System.out.println("User is on the preference tab");
	}

	@Then("User should see the menu options {string}.")
	public void user_should_see_the_menu_options(String MenuOptions) {
		Preferences.clickMoreOptions();
		Preferences.clickPreferences();
		boolean isDisplayed = Preferences.isMenuOptionsDisplayed(MenuOptions);
	   assert isDisplayed : "Menu option '" + MenuOptions + "' is not displayed!";;
	}


}
