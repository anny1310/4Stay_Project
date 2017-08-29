package com.fourstay.step_definitions;

import java.util.UUID;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.pages.SignUpPage;
import com.fourstay.utilities.BrowserUtilities;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignUp_Step_Defs {

	final String randomEmail = randomEmail();
	SignUpPage signUpPage = new SignUpPage();

	private static String randomEmail() {
		return "john" + UUID.randomUUID().toString() + "@gmail.com";
	}

	@Given("^user is on the FourStay sign up dialog$")
	public void user_is_on_the_FourStay_sign_up_dialog() throws Throwable {
		signUpPage.signUpLink.click();

	}

	@Given("^the user enters enter first name \"([^\"]*)\" and last name \"([^\"]*)\"$")
	public void the_user_enters_enter_first_name_and_last_name(String firstName, String lastName) throws Throwable {
		signUpPage.name.sendKeys(firstName);
		Thread.sleep(2000);
		signUpPage.lastName.sendKeys(lastName);

	}

	@Given("^the user enters any unregistered email and password$")
	public void the_user_enters_any_unregistered_email_and_password() throws Throwable {
		Thread.sleep(3000);
		signUpPage.email.sendKeys(randomEmail);
		signUpPage.password.sendKeys("John1234567");

	}

	@Given("^click on the Sign up button$")
	public void click_on_the_Sign_up_button() throws Throwable {
		signUpPage.signupButton.click();
	}

	@When("^the user goes the account details page$")
	public void the_user_goes_the_account_details_page() throws Throwable {
		BrowserUtilities.waitForPageLoad();
		signUpPage.profileButton.click();
		signUpPage.editProfile.click();
	}

	@Then("^first name \"([^\"]*)\" and last name \"([^\"]*)\" should be displayed in the right fields$")
	public void first_name_and_last_name_should_be_displayed_in_the_right_fields(String name1, String lastName1) throws Throwable {
		String name = signUpPage.accountName.getAttribute("value");
		System.out.println(name);
		String lastName = signUpPage.accountLastName.getAttribute("value");
		System.out.println(lastName);
		Assert.assertEquals(name, name1);
		Assert.assertEquals(lastName, lastName1);
		Assert.assertTrue(signUpPage.accountName.isDisplayed());
		Assert.assertTrue(signUpPage.accountLastName.isDisplayed());

	}
}
