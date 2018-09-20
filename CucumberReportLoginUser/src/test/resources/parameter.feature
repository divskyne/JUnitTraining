Feature: Login as User
As a User
I want to add new people to a website
So that I can login as them and do dodgy stuff

   Scenario Outline: Go to website
   Given I go to website
   When add new user with "<user>" "<password>"
   Then I should be able to login as that "<user>" with "<password>"
   
Examples:
    | user   | password |
	| Andrew | pass1 |
	| Shaun | pass2 |
	| Jordan | pass3 |