package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Hooks {
	
	@Before("@hooks")
	public void user_active_ldap() {
		System.out.println("________________________________________________________");
		System.out.println("User is active in LDAP");
	}
	
	@After("@hooks")
	public void user_closes_browser()
	{
		System.out.println("User closes browser");
		System.out.println("#################################################################");
	}

	@Given("User is at the login page")
	public void user_at_login_page()
	{
		System.out.println("user is at login page");		
	}
	
	@When("User enters credentials and clicks login")
	public void user_enters_credentials()
	{
		System.out.println("User enters credentials and clicks login");		
	}
	
	@Then("UCM dashboard is displayed")
	public void ucm_page_displayed()
	{
		System.out.println("UCM page is displayed");		
	}
	
	@Then("URM dashboard is displayed")
	public void urm_page_displayed()
	{
		System.out.println("URM page is displayed");		
	}
	
	@Then("UPM dashboard is displayed")
	public void upm_page_displayed()
	{
		System.out.println("UPM page is displayed");		
	}
	
}
