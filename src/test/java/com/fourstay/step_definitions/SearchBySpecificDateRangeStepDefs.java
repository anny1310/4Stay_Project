package com.fourstay.step_definitions;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.fourstay.pages.SearchPage;
import com.fourstay.utilities.BrowserUtilities;
import com.fourstay.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SearchBySpecificDateRangeStepDefs {
	SearchPage page = new SearchPage();

	@Given("^Navigate to \"([^\"]*)\"$")
	public void navigate_to(String url) throws Throwable {
		Driver.getInstance().get(url);

	}

	@Given("^specify date in \"([^\"]*)\" and date out \"([^\"]*)\" and click search$")
	public void specify_date_in_and_date_out_and_click_search(String moveIn, String moveOut) throws Throwable {
		page.moveIn.sendKeys(moveIn);
		page.moveOut.sendKeys(moveOut);
		page.searchButton.click();

	}

	@Then("^Result page will give a list of stays that meet searching criteria$")
	public void result_page_will_give_a_list_of_stays_that_meet_searching_criteria() throws Throwable {
		BrowserUtilities.switchTabs("search");
		BrowserUtilities.waitForPageLoad();
		// clicking on 2nd search result
		Driver.getInstance().findElement(By.xpath("//img[@class='img-responsive']")).click();
		BrowserUtilities.switchTabs("58a3e35b48d8230021ba7ee9");
		BrowserUtilities.waitForPageLoad();
		List<WebElement> iframes = Driver.getInstance().findElements(By.xpath("//iframe"));
		Driver.getInstance().switchTo().frame(iframes.size() - 1);
		page.dismisIframeButton.click();
		Driver.getInstance().switchTo().defaultContent();
		String avaliableFrom = page.avalbFrom.getText();
		System.out.println(avaliableFrom);
		String avaliableTo = page.avalbTo.getText();
		System.out.println(avaliableTo);
		Assert.assertTrue("03/01/2018".equals(avaliableFrom));
		Assert.assertTrue("03/02/2018".equals(avaliableTo));
		

	}

}
