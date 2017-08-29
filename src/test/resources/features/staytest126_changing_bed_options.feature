Feature: Guest is looking at the search results 


Scenario: Search results should update if the user changes the number of beds 



	Given I am on the fourstay homepage 
	And I enter school name "Georgetown university" 
	And I enter dates "07/29/2017" and "09/22/2017" 
	And I click the search button 
	And I verify search results with one bad
	When I changing number of beds to "2 Beds" 
	Then search results should update 
 