Meta:

@issue ODT0221FO-706

Narrative:
As a tester
I would like to check "Create your Profile" button works as expected on the homepage

Scenario: When clicking on "Create your Profile" not logged in then I am asked to log in and I am taken to "Profile" page

Given I am a jobseeker on the FO home page
When I click "Create your Profile"
And I enter <email> and <password> and click on the login button
Then I am taken to "Profile" page

Examples:
|email|password|
|selusr01@dice.com|selusr123|

Scenario: When clicking on "Create your Profile" while already logged in with completed profile then I am taken to "Profile" page

Given I am a jobseeker on the FO home page
When I click Sign In from the header menu
And I enter <email> and <password> and click on the login button
Then I am logged in
When I go to the homepage and click "Create your Profile"
Then I am taken to "Profile" page

Examples:
|email|password|displayEmail|
|selusr01@dice.com|selusr123|selusr01@dice.com|

Scenario: When clicking on "Create your Profile" while already logged in with empty profile then I am taken to "Profile" page

Given I am a jobseeker on the FO home page
When I click Sign In from the header menu
And I enter <email> and <password> and click on the login button
Then I am logged in
When I go to the homepage and click "Make My Profile Searchable"
Then I am taken to "Settings" page

Examples:
|email|password|displayEmail|
|test(dataset)@test.com|testing123|