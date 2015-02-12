Meta:

Narrative:
As a jobseeker
I would like to login to MyEfc to update my password
So that my personal information remains secure

Scenario: Check user's can update their password and login with new details

Given I directly go to the account settings URL and successfully login with <email> and <password>
When I change my current password <password> to my new password <newPassword> in Account Settings
Then my password has been changed successfully
When I logout and re-login with my new password to confirm it has changed successfully
Then I am logged in with <displayEmail>

Examples:
|email|password|newPassword|displayEmail|
|test(dataset)@test.com|testing123|testing124|test(dataset)@test.com|