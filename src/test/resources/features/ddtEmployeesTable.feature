@regression
Feature: FourStay login with multiple data

Background: 
  Given I am on the fourstay login dialog
  	
	Scenario Outline: Verify user information in General Account Settings
	And I enter email "<email>"
    And I enter password "<password>"
    When I click on the login button
    Then verify first name, last name,phone number for each user is correctly displayed
    
    
    
    Examples:
    
    | email                 | password |
    | sking@testmail.com    | password |
    | dlorentz@testmail.com | password |
    | daustin@testmail.com  | password |
    | isciarra@testmail.com | password |	
    | imikkili@testmail.com | password |
    | jnayer@testmail.com	| password |
    | shiggins@testmail.com | password |
    | acabrio@testmail.com  | password |
    | rperkins@testmail.com | password |
    | doconnel@testmail.com | password |