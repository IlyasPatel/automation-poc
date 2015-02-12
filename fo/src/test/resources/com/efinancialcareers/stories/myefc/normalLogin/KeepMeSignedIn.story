Meta:

Narrative:
As a tester
I would like to either be remembered by eFinancialCareers when I select "keep me signed in"
or not remembered when I don't select this option on the login form

Scenario: When "keep me signed" is checked, user remains logged in when closing and re-opening the browser

Given I am a jobseeker on the FO home page
When I login
And I collect the cookies from front-office
And I directly go to the saved searches URL
And I collect the cookies from MyEfc
When I close the browser and reopen it beginning from the homepage
Then I am logged in with <displayEmail>
When I directly go to MyEfc and inject cookies into the browser
Then I am logged in with <displayEmail>
Given I would like to create a new Personal Search Alert (PSA)
When I perform job search with keyword <keyword> and location <location>
And I save this search as <alertName> with notifications set to <notificationInterval>
And I go to manage my job alerts
Then my search is saved correctly

Examples:
|email|password|displayEmail|alertName|notificationInterval|keyword|location|
|selusr01@dice.com|selusr123|selusr01@dice.com|{random}|Daily|Java|London|

Scenario: When "keep me signed" in is NOT checked user is logged out when closing and re-opening the browser

Given I am a jobseeker on the FO home page
When I click Sign In from the header menu
And I enter <email> and <password> and click on the login button with Remember Me Unchecked
And I collect the cookies from front-office
And I directly go to the saved searches URL
And I collect the cookies from MyEfc
When I close the browser and reopen it beginning from the homepage
Then I am logged out
When I directly go to MyEfc and inject cookies into the browser
Then I am logged out

Examples:
|email|password|displayEmail|
|selusr01@dice.com|selusr123|selusr01@dice.com|