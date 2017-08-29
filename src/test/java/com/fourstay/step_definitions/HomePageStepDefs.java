package com.fourstay.step_definitions;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepDefs {
	WebDriver driver;

	@Given("^the user is on fourstay home page$")
	public void the_user_is_on_fourstay_home_page() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
		Driver.getInstance().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.getInstance().get("https://fourstay.herokuapp.com/");

	}

	@When("^the user clicks on the login link$")
	public void the_user_clicks_on_the_login_link() throws Throwable {
		Driver.getInstance().findElement(By.cssSelector(".not-login")).click();
          
		
	}

	@Then("^the email field should be displayed$")
	public void the_email_field_should_be_displayed() throws Throwable {
		System.out.println("Email field is now displayed");
		Assert.assertTrue(Driver.getInstance().findElement(By.id("email")).isDisplayed());
	   
	}

}
