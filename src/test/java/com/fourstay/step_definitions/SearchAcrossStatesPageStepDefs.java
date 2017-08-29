package com.fourstay.step_definitions;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import com.fourstay.pages.SearchPage;
import com.fourstay.utilities.BrowserUtilities;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SearchAcrossStatesPageStepDefs {

	private SearchPage searchPage = new SearchPage();

	@Given("^I enter school name \"([^\"]*)\"$")
	public void i_enter_school_name(String school) throws Throwable {
//		 Thread.sleep(3000);
//		 List<WebElement> iframes =
//		 Driver.getInstance().findElements(By.xpath("//iframe"));
//		 Driver.getInstance().switchTo().frame(iframes.size() - 1);
//		 searchPage.dismisIframeButton.click();
//		 Driver.getInstance().switchTo().defaultContent();
		searchPage.schoolName.sendKeys(school);

	}

	@Given("^I enter dates \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_dates_and(String start, String end) throws Throwable {
		searchPage.moveIn.click();
		searchPage.moveIn.sendKeys(start);
		searchPage.moveOut.click();
		searchPage.moveOut.sendKeys(end);
	}

	// @When("^search by bad type$")
	// public void search_by_bad_type() throws Throwable {
	//
	// search.clickOnBeds.click();
	//
	// List<WebElement> list =
	// Driver.getInstance().findElements(By.xpath("//a[@class='list-option-select']"));
	// list.get(0).click();
	// search.searchButton.click();
	// }

	@Given("^I click the search button$")
	public void i_click_the_search_button() throws Throwable {
		searchPage.searchButton.click();
		Thread.sleep(5000);
	}

	@Then("^the results should contain$")
	public void the_results_should_contain(List<String> states) throws Throwable {
		BrowserUtilities.switchTabs("search");
		BrowserUtilities.waitForPageLoad();

		Set<String> actualStates = new HashSet<>();
		for (WebElement element : searchPage.allStates) {
			actualStates.add(element.getText());

		}
		System.out.println(actualStates);

      Assert.assertTrue(actualStates.containsAll(states));

	}
	
	@When("^I enter this search criteria$")
	public void i_enter_this_search_criteria(List<Map<String,String>> searchCriteria) throws Throwable {
		Map<String,String> input=searchCriteria.get(0);
		searchPage.schoolName.sendKeys(input.get("school"));
		searchPage.moveIn.sendKeys(input.get("start"));
		searchPage.moveOut.sendKeys(input.get("end"));
		searchPage.searchButton.click();
		
	  
	}
}
