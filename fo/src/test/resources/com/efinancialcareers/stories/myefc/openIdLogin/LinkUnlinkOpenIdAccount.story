Meta:
@issue ODT0221FO-552

Narrative:
As a tester
I would like to link/unlink an openId account. Once the account is unlinked then
I want to make sure it is not possible to log in with that account.

Scenario: Check link/unlink OpenId account

Given I am a jobseeker on the MyEfc login page
When I select <provider> then enter <email> and <password> and click login button
And I link my account with my eFinancialCareers account using password <password>
Then I am logged in with <displayEmail>
When I select the logout button
And I directly go to the account settings URL and successfully login with <email> and <password>
Then I can see I have successfully linked my <provider> account
When I delete my linked account
Then in my account section I have no linked accounts
When I select the logout button
And I close the browser and reopen it going back to my previous URL with cookies cleared
And I directly go to MyEfc homepage
And I select <provider> then enter <email> and <password> and click login button
Then the link account page is displayed as the account was unlinked

Examples:
|provider|email|password|displayEmail|
|Google|linkeduser234242@gmail.com|testing123$|linkeduser234242@gmail.com|

