Feature: To have a working backend with customisable options
  As an admin
  I want to add, remove and update my data on my database
  So that I can go on to host correct data for other applications

Scenario: Add a User to the database
  Given that you are on the create UserScreen
  When the User details are entered on the Create UserScreen 
  And the details are submitted on the Create UserScreen
  Then the Username should be visible on the UsersScreen

Scenario Outline: Add a User to the database
  Given that you are on the create UserScreen
  When the User details "<Username>" username, "<Password>" password, "<ConfirmPassword>" confirm Password, "<FullName>" Fullname and "<EmailAddress>" EmailAddress are entered on the Create UserScreen 
  And the details are submitted on the Create UserScreen
  Then the "<Username>" username should be visible on the UsersScreen
  
Examples:
  | Username | Password | ConfirmPassword | FullName | EmailAddress |
  | Chris95 | guest | guest | Christopher Perrins | christopher.perrins@qa.com |
  | M4TT | chick3nWing | chick3nWing | matthewhunt | matthew.hunt@qa.com |
  | D£v | D@T@ | D@T@ | Dev Gonsai | dev.gonsai@qa.com | 
  | matthewhunt | chick3nWing | chick3nWing | Matttt | matthew.hunt@qa.com |
  
Scenario Outline: View the details of a User on a database
  Given the "<Username>" username is visible on the UsersScreen
  When the "<Username>" username is clicked on the UserScreen
  Then the User Profile should display the "<UserName>" username on the ProfileScreen
  
Examples:
  | Username |
  | Chris95 |
  | D£v |
  | MatthewHunt |
  
Scenario Outline: Updating the email address of a User
  Given the "<Username>" Username's profile page has been loaded
  And the configure button has been clicked on the profile page
  When I change the old email address on the Configure Page to a new email address "<NewEmail>"
  And I save the changes to the Configure Page
  Then the Configure Page should show the new email address "<NewEmail>"
  
Examples:
  | Username | NewEmail |
  | Chris95 | chris@qa.com |
  | M4TT | matt@qa.com |
  | D£v | dev@qa.com |
  