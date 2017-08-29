package com.fourstay.step_definitions;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import com.fourstay.pages.HomePage;
import com.fourstay.pages.SearchPage;
import com.fourstay.utilities.BrowserUtilities;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SearchForPrice_StepDefs {
	HomePage homepage = new HomePage();
	SearchPage page = new SearchPage();

	@When("^search for \"([^\"]*)\" and click on search button$")
	public void search_for_and_click_on_search_button(String campus) throws Throwable {
		page.searchCampus.sendKeys(campus + Keys.ENTER);

	}

	@Then("^Result page will be opened with stays meeting search criteria$")
	public void result_page_will_be_opened_with_stays_meeting_search_criteria() throws Throwable {
		BrowserUtilities.waitForPageLoad();
		int totalResults=page.allResults.size();
		int totalPriceRes=page.allPrices.size();
		System.out.println("Total search results:"+page.allResults.size());
		System.out.println("Total price results:"+page.allPrices.size());
		Assert.assertEquals(totalResults,  totalPriceRes);
		
	

}
}


