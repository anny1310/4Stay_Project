package com.fourstay.step_definitions;

import org.junit.Assert;
import com.fourstay.pages.SearchPage;
import com.fourstay.utilities.BrowserUtilities;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchResUpdate_StepDefs {
	SearchPage page = new SearchPage();
	 int userOptions1;
	 int userOptions2;

	@Given("^I verify search results with one bad$")
	public void i_verify_search_results_with_one_bad() throws Throwable {
		BrowserUtilities.switchTabs("search");
		BrowserUtilities.waitForPageLoad();

		int userOptions1=page.customerStays.size();
		System.out.println("Search results #1"+userOptions1);
		
	}

	@When("^I changing number of beds to \"([^\"]*)\"$")
	public void i_changing_number_of_beds_to(String beds) throws Throwable {
		page.numberOfBeds.click();
		page.numberOfBeds.sendKeys(beds);
		page.numberOfBeds.click();

	}

	@Then("^search results should update$")
	public void search_results_should_update() throws Throwable {
		int userOptions2=page.customerStays.size();
		System.out.println("Search results #2"+userOptions2);
		
		Assert.assertFalse(userOptions1==userOptions2);
		


	}
		

	}


