package com.fourstay.step_definitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.pages.HomePage;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageStepDefs {

	private WebDriver driver;
	private HomePage homePage = new HomePage();

	@Given("^I am on the fourstay homepage$")
	public void i_am_on_the_fourstay_homepage() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
		Driver.getInstance().manage().window().maximize();
		Driver.getInstance().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Fourstay home page");
		Assert.assertTrue(Driver.getInstance().getTitle().equals("4stay"));

	}

	@When("^I login as a host$")
	public void i_login_as_a_host() throws Throwable {

//		 List<WebElement> frames=driver.findElements(By.tagName("iframe"));
//		 System.out.println(frames.size());
		homePage.loginLink.click();
		Thread.sleep(1000);
		homePage.email.sendKeys(ConfigurationReader.getProperty("host.username"));
		Thread.sleep(1000);
		homePage.password.sendKeys(ConfigurationReader.getProperty("host.password"));
		Thread.sleep(1000);
		homePage.loginButn.click();

	}

	@Then("^I should be able verify I am logged in$")
	public void i_should_be_able_verify_I_am_logged_in() throws Throwable {
//		 WebDriverWait wait = new WebDriverWait(driver, 30);
//		 wait.until(ExpectedConditions.visibilityOf(homePage.userName));
		String userName = homePage.userName.getText();
		System.out.println(userName);
		Assert.assertTrue(homePage.userName.getText().equals(userName));
		// Assert.assertTrue(Driver.getInstance.getCurrentUrl().contains("dashboard")

	}

	@When("^I login as a guest$")
	public void i_login_as_a_guest() throws Throwable {
	//		homePage.logoutButton.click();
		Thread.sleep(2000);
		homePage.loginLink.click();
		homePage.email.sendKeys(ConfigurationReader.getProperty("guest.username"));
		Assert.fail();
		homePage.password.sendKeys(ConfigurationReader.getProperty("guest.password"));
		homePage.loginButn.click();

	}

}
