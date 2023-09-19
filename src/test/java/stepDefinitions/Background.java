package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Background {
	
	@Given("User is active in LDAP")
	public void user_active_ldap()
	{
		System.out.println("********************************");
		System.out.println("User is active in LDAP");
	}
	
	@Given("User is active in CEEP")
	public void user_active_ceep()
	{
		System.out.println("User is active in CEEP");
	}
	
	@When("User is at the MyMDM page")
	public void user_is_at_mymdm_page()
	{
		System.out.println("User is at mymdm page");
	}
	
	@Given("^PM enters credentials (.+) and (.+)$")
	public void user_login(String username, Integer pwd)
	{
		System.out.println("PM logs in with username " + username + " and password " + pwd );
	}

	@When("PM clicks lodin")
	public void pm_clicks_login()
	{
		System.out.println("User clicks login");
	}
	
	@Then("PM is at masters dashboard")
	public void pm_at_masters_dashboard()
	{
		System.out.println("User is at the masters dashboard");
	}
}
