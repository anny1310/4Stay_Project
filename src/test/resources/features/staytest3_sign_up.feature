@staytest_3 
Feature: As a new user, I should be able to see my information 
	displayed correctly on the user profile page.

Scenario: User's name information should be displayed correctly 
	Given I am on the fourstay homepage 
	And user is on the FourStay sign up dialog
	And the user enters enter first name "John" and last name "Smith" 
	And the user enters any unregistered email and password 
	And click on the Sign up button 
	When the user goes the account details page 
	Then first name "John" and last name "Smith" should be displayed in the right fields