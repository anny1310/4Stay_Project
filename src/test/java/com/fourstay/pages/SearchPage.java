package com.fourstay.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class SearchPage {
	
	
	
	public SearchPage(){
		PageFactory.initElements(Driver.getInstance(),this);
	}
	
			
	@FindBy(id="iLocName")
	public WebElement schoolName;
	
	@FindBy(id="rentoutfrom2")
	public WebElement moveIn;
	
	@FindBy(id="rentoutto2")
	public WebElement moveOut;
	
	@FindBy(xpath="//div[@class='intercom-borderless-dismiss-button']")
	public WebElement dismisIframeButton;
	
	@FindBy(xpath="//th[@class='next']")
	public WebElement nextMonthButton;
		
	@FindBy(id="themates")
	public WebElement clickOnBeds;
	
	@FindBy(id="inputGroupSuccess1")
	public WebElement numberOfBeds;
	
	@FindBy(xpath="//h3[@class='ng-binding']")
	public List<WebElement> customerStays;
	
	@FindBy(id="search")
	public WebElement searchButton;
	
	@FindBy(id="rentoutfrom3")
	public WebElement fromDate;
		
	@FindBy(xpath="//a[@class='list-option-select']")
	public WebElement bedsMenu;
	
	
	@FindBy(css=".col-md-12>p")
	public List<WebElement> allStates; 
	
	@FindBy(xpath="//div[@class='col-md-6 col-xs-6 zrl-padding availability']//h5[1]")
	public WebElement avalbFrom; 
	

	@FindBy(xpath="//div[@class='col-md-6 col-xs-6 zrl-padding availability']//h5[2]")
	public WebElement avalbTo; 
	
	@FindBy(id="hLocName")
	public WebElement searchCampus; 
	
	@FindBy(xpath="//span[@class='price-bold ng-binding']")
	public List<WebElement> allPrices;
	
	@FindBy(xpath="//div[@class='col-sm-6 col-xs-6 xxs-12']")
	public List<WebElement> allResults;
	
	
	
	
	
	
	
	
	
	
	

}

