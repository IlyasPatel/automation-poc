Meta:

Narrative:
As a jobseeker
I would like to login to MyEfc
So that my personal information is secure

Scenario: Check a valid user can sign in and sign out remember me checked (default)

Given I am a jobseeker on the MyEfc login page
When I enter <email> and <password> and click on the login button
Then I am logged in with <displayEmail>
When I select the logout button
Then I am logged out
And my email address <email> is entered in the email field on the login page

Examples:
|email|password|displayEmail|
|selusr01@dice.com|selusr123|selusr01@dice.com|

Scenario: Check a valid user can sign in and sign out with remember me unchecked

Given I am a jobseeker on the MyEfc login page
When I enter <email> and <password> and click on the login button with Remember Me Unchecked
Then I am logged in with <displayEmail>
When I select the logout button
Then I am logged out
And my email address is NOT entered in the email field on the login page

Examples:
|email|password|displayEmail|
|selusr01@dice.com|selusr123|selusr01@dice.com|

Scenario: Check validation for invalid login credentials via FO

Given I am a jobseeker on the FO home page
When I click Sign In from the header menu
And I enter an invalid <email> and <password>, click on the login button
Then login should be unsuccessful

Examples:
|email|password|
|incorrect@dice.com|testing123|
