Feature: Testing Person API

Scenario: Testing a status code
Given the content type is JSON
  When a user adds a new person 
  Then the status code reads 200
 
Scenario Outline: Testing add new Person
  Given the content type is JSON
  When a user creates a person with fname "<fname>", lname "<lname>"
  And a user retrieves all the persons
  Then the person with fname "<fname>" must be there  
Examples:
    | fname | lname |
    | Big | Veedu |
    | Small | Veedu |
    | Long | Veedu 1 |
    | Short | Veedu 2 |
  
Scenario: Testing the API using parameters
Given a person exists with the ID 1
  When a user retrieves the person by the id 1
  Then the status code reads 200
  And the name is "Big"
  
Scenario Outline: Testing the API using a table
   Given a person exists with the ID <id>
When a user retrieves the person by the id <id>
  Then the status code reads 200
   And the name is equal to "<fname>"
   
Examples:
    | id | fname |
    | 1 | Big |
    | 2 | Small |
    | 3 | Long |
    | 4 | Short |
#Scenario Outline: Testing all the people
#Given the content type is JSON
#  When a user retrieves all the people
#  Then all the "<name>" are valid
#Examples:
#    | name |
#    | Big |
#    | Small |
#    | Veedu 2 |
#    | Veedu 3 |