Meta:
@issue ODT0221-11584

Narrative:
Check that once a user is logged in to either MyEfc or FO when they switch sites
they remain logged in.

Scenario: When a user has signed into FO using OpenId then they should also be signed into MyEfc (FO -> MyEfc)

Given I am a jobseeker on the FO home page
When I click Sign In from the header menu
And I select <provider> then enter <email> and <password> and click login button
Then I am logged in with <displayEmail>
When I directly go to MyEfc homepage
Then I am still logged in with <displayEmail>
When I select the logout button
Then I am logged out
When I go to FO home page
Then I am logged out

Examples:
|provider|email|password|displayEmail|
|Microsoft|jonnie350@hotmail.com|cyprus1980|jonnie350@hotmail.com|


Scenario: When a user has signed into MyEfc using OpenId then they should also be signed into FO (MyEfc -> FO)

Given I am a jobseeker on the MyEfc login page
When I select <provider> then enter <email> and <password> and click login button
Then I am logged in with <displayEmail>
When I go to FO home page
Then I am still logged in with <displayEmail>

Examples:
|provider|email|password|displayEmail|
|Microsoft|jonnie350@hotmail.com|cyprus1980|jonnie350@hotmail.com|