package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class implementationSteps {
	
	@Given("User is at the MyMDM Login page")
	public void user_is_at_the_pro_go_login_page() {
	   System.out.println("User is at the MyMDM Login page");
	}
	
	@When("User enters credentials {string} and Password {string} and clicks login")
	public void user_enters_credentials_and_password_and_clicks_login(String username, String password) {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("User " + username +" enters password "+password+" and logs in");
	} 
	
	@Then("User is taken to the masters dashboard")
	public void user_is_taken_to_the_masters_dashboard() {
		System.out.println("User is at the masters dashboard");
	}


}
