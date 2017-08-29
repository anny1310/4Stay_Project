@staytest_36
Feature: As a guest I should be able to see prices on the stay 
	So that stay meets my price requirements,
	I can decide which property I should rent 
	based on price shown on result page 
	
	Scenario: Guest searches for a stay, 
	guest should be able to see pricing of the 
	stay on the result page. 
	
    Given I am on the fourstay homepage
    When I login as a host
    Then I should be able verify I am logged in
    And search for "Montgomery College" and click on search button
    Then Result page will be opened with stays meeting search criteria
	
    