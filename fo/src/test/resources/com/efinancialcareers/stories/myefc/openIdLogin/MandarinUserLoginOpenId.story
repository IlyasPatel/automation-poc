Meta:

Narrative:
As a jobseeker
I would like to login to MyEfc using an openId account
So that my personal information is secure

Scenario: Check user's login credentials for different openId accounts

Given I am a jobseeker on the MyEfc login page
When I select <provider> then enter <email> and <password> and click login button
Then I am logged in with <displayEmail>
When I select the logout button
Then I am logged out

Examples:
|provider|email|password|displayEmail|
|Google|timgooauto1|testing123$|timgooauto1@gmail.com|

