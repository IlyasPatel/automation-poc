Meta:

Narrative:
As a jobseeker
I would like to login to MyEfc using an openId account
So that my personal information is secure

Scenario: Confirm user can login and logout using an OpenId account.

Given I am a jobseeker on the MyEfc login page
When I select <provider> then enter <email> and <password> and click login button
Then I am logged in with <displayEmail>
When I select the logout button
Then I am logged out

Examples:
|provider|email|password|displayEmail|
|Google|timgooauto1|testing123$|timgooauto1@gmail.com|

Scenario: Confirm user can login using OpenId accounts.

Given I am a jobseeker on the MyEfc login page
When I select <provider> then enter <email> and <password> and click login button
Then I am logged in with <displayEmail>

Examples:
|provider|email|password|displayEmail|
|Microsoft|timHotAuto1@hotmail.com|testing123$|timHotAuto1@hotmail.com|
|Twitter|TimSmithAuto1|testing123$|timTwitterAuto1@gmail.com|
|Facebook|447760663284|testing123$|timFacebookAuto1@mailinator.com|

Scenario: Confirm jobseeker is able to login from the registration page as they have already created their account previously.

Given I am a jobseeker on the MyEfc registration page
When I select <provider> then enter <email> and <password> and click login button
Then I am logged in with <displayEmail>

Examples:
|email|password|provider|displayEmail|
|timgooauto1@gmail.com|testing123$|Google|timgooauto1@gmail.com|