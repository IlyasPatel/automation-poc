Meta:
@issue ODT0221-11584

Narrative:
Check that once a user is logged in to either MyEfc or FO when they switch sites
they remain logged in.

Scenario: When a user has signed into FO then they should also be signed into MyEfc (FO -> MyEfc)

Given I am a jobseeker on the FO home page
When I click Sign In from the header menu
And I enter <email> and <password> and click on the login button
Then I am logged in with <email>
When I directly go to the profile page
Then I am still logged in with <email>
When I select the logout button
Then I am logged out
When I directly go to MyEfc homepage
Then I am logged out

Examples:
|email|password|displayEmail|
|selusr01@dice.com|selusr123|selusr01@dice.com|

Scenario: When a user has signed into MyEfc then they should also be signed into FO (MyEfc -> FO)

Given I am a jobseeker on the MyEfc login page
When I enter <email> and <password> and click on the login button
Then I am logged in with <email>
When I directly go to MyEfc homepage
Then I am still logged in with <email>

Examples:
|email|password|displayEmail|
|selusr01@dice.com|selusr123|selusr01@dice.com|