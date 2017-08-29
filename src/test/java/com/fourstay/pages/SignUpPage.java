package com.fourstay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.fourstay.utilities.Driver;

public class SignUpPage {
	
	public SignUpPage(){
	PageFactory.initElements(Driver.getInstance(),this);
	}
	
	@FindBy(xpath="//li[@class='btn menu btn-log zl-margin not-login'][2]")
	public WebElement signUpLink;
	
	@FindBy(id="FirstName")
	public WebElement name;
	
	@FindBy(id="LastName")
	public WebElement lastName;
	
	
	@FindBy(xpath="(//input[@id='email'])[3]")
	public WebElement email;
	
	
	@FindBy(xpath="(//input[@id='key'])[2]")
	public WebElement password;
	
	@FindBy(id="btn-signup")
	public WebElement signupButton;
	
		//Account details page
	
	@FindBy(xpath="(//a[@class='dropdown-toggle'])[3]")
    public WebElement profileButton;
	
    
	@FindBy(linkText="Edit Profile")    
    public WebElement editProfile;

	
	
	@FindBy(xpath="//input[@ng-model='$parent.other.FirstName']")
    public WebElement accountName;
	

	@FindBy(xpath="//input[@ng-model='$parent.other.LastName']")
    public WebElement accountLastName;
	
	@FindBy(xpath="(//input[@name='phone'])[2]")
	public WebElement phoneNumb;
	
    
			
	
	
}


