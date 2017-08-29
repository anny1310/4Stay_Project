Feature: Displaying user information

Background: 
  Given I am on the fourstay login dialog
  
  
Scenario: Verify host user information
And I enter email "testscooper@test.mail.com"
And I enter password "password"
When I click on the login button
Then the user name should be "Sheldon Cooper"

Scenario: Verify host user information
And I enter email "testafowler@test.mail.com"
And I enter password "password"
When I click on the login button
Then the user name should be "Amy Fowler"

@Staytest_124
Scenario Outline: Verify host user information
And I enter email "<email>"
And I enter password "<password>"
When I click on the login button
Then the user name should be "<name>"

Examples: 

|name                |email                         |password         |
|Amy Fowler          |testafowler@test.mail.com     |password         |
|Sheldon Cooper      |testscooper@test.mail.com     | password        |
|Amy Fowler          |testafowler@test.mail.com     |password         |
|Sheldon Cooper      |testscooper@test.mail.com     |password         |
|Orlando Wolf        |OrlandoWolf@test.mail.com     |Orlandob74cf     |
|Lenora Ferry        |LenoraFerry@test.mail.com     |Lenoradb1d1      |
|Ethel MacGyver      |EthelMacGyver@test.mail.com   |Ethelbb8ed       |
      




