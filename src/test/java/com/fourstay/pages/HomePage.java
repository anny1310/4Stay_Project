package com.fourstay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;



public class HomePage {
	
	
	public HomePage(){
		PageFactory.initElements(Driver.getInstance(),this);
	}
	
	@FindBy(css=".not-login")
	public WebElement loginLink;
	
	@FindBy(id="email")
	public WebElement email;
	
	@FindBy(id="key")
	public WebElement password;
	
	@FindBy(id="btn-login")
	public WebElement loginButn;
	
	@FindBy(xpath="//h3[@class='user-name ng-binding']")
	public WebElement userName;
	
	
	@FindBy(xpath="//span[.='LOGOUT']")
	public WebElement logoutButton;
	
	
	
	

}
