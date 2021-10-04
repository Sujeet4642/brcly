package Stepdefs;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import PageObjects.SignUpPageObjects;
import WebDriverFactory.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefs {
	
	WebDriver driver;
	String baseurl = "http://justdial.com";
	int implicit_wait_time=20;
	Scenario scn;
	
	SignUpPageObjects signUpPage;
	
	@Before
	public void setUp(Scenario scn) throws Exception{
		this.scn = scn;
		String browsername = WebDriverFactory.getBrowserName();
		driver = WebDriverFactory.getWebdriverforbrowser(browsername);
		
		signUpPage = new SignUpPageObjects(driver);
		
	}
	
	@After(order=1)
	public void cleanUp() {
		WebDriverFactory.quitBrowser();
	}
	
	@After(order=2)
	public void takeScreenShot(Scenario s) {
		if(s.isFailed()) {
			TakesScreenshot scrnsht = (TakesScreenshot)driver;
			byte[] data = scrnsht.getScreenshotAs(OutputType.BYTES);
			scn.attach(data, "img/png","failed step name: " +s.getName());
		}
		else {
			scn.log("text case is passed, no screenshot captured");
		}
	}
	
//SignUp...........
	@Given("User navigated to the link of the application")
	public void user_navigated_to_the_link_of_the_application() {
		WebDriverFactory.navigateToUrl(baseurl);
		signUpPage.validateWebsite();
	   
	}

	@When("User clicks on the signUp link")
	public void user_clicks_on_the_sign_up_link() {
	  signUpPage.clickOnSignUp();
	}

	@When("User enters name as {string} and mobile as {string} and clicks on submit button")
	public void user_enters_name_as_and_mobile_as_and_clicks_on_submit_button(String name, String mob) {
	    signUpPage.setSignUpBox(name, mob);
	    signUpPage.clickOnOtpBtn();
	}

	@Then("User is displayed with the message as {string}")
	public void user_is_displayed_with_the_message_as(String msg) {
	   signUpPage.msgDisplayed(msg);
	}
	

	@When("User clicks on the logIn link of the application")
	public void user_clicks_on_the_log_in_link_of_the_application() {
	    signUpPage.clickOnLogIn();
	}


	@Then("User is able to enter only {string} digits in the Mobile text field")
	public void user_is_able_to_enter_only_digits_in_the_mobile_text_field(String num) {
	   signUpPage.checkMobLength(num);
	}

	@When("User clicks on the logIn link")
	public void user_clicks_on_the_log_in_link() {
	   signUpPage.clickOnLogIn();
	}

	@Then("User is able to logIn")
	public void user_is_able_to_log_in() {
	  signUpPage.logInConfirm();
	}
	
	//side Menu..............
	/*@When("User clicks on the {string}")
	public void user_clicks_on_the(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User is navigates to the corresponding links")
	public void user_is_navigates_to_the_corresponding_links() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	//search Product...................
	@When("User type {string} in the search box")
	public void user_type_in_the_search_box(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User shows the result related to the {string}")
	public void user_shows_the_result_related_to_the(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User enters {string} in search text box")
	public void user_enters_in_search_text_box(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User is able to see the drop down under search text box with all the items with text {string}")
	public void user_is_able_to_see_the_drop_down_under_search_text_box_with_all_the_items_with_text(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User enters {string} in the search box")
	public void user_enters_in_the_search_box(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User clicks links on the drop down")
	public void user_clicks_links_on_the_drop_down() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User is able to show the appropriate results")
	public void user_is_able_to_show_the_appropriate_results() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}*/

}
