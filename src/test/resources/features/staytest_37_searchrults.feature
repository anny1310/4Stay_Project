@staytest_37
Feature: As a user I should be able to search stay for the a specified date range 
	So that the result lists only stays that are available of those days

Scenario: User specifies location, day in, day out 
	and number of beds while searching for the stay.
	
	 Given I am on the fourstay homepage
     And  specify date in "03/01/2018" and date out "03/02/2018" and click search
     Then Result page will give a list of stays that meet searching criteria
	
	


