package stepDefinitions;

import java.rmi.server.LogStream;
import java.util.List;

import org.w3c.dom.UserDataHandler;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class dataDriven {
	@Given("User is on the practice page")
	public void user_is_on_the_practice_page() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("User is at the practice page");
	}
	@When("User fills the data on the form")
	public void user_fills_the_data_on_the_form(List<String> data) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    System.out.println(data.get(0));
	    System.out.println(data.get(1));
	    System.out.println(data.get(2));
	    System.out.println(data.get(3));
	    
	}
	@Then("User logs in")
	public void user_logs_in() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User logs in");
	}

}
