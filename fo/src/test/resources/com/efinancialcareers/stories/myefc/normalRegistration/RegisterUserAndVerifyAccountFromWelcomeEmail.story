Meta:

Narrative:
As a jobseeker
I would like to register to MyEfc
So that my personal information is secure

Scenario: Register a new user and verify the account from the "Welcome to eFinancialCareers". Checks user can login using the login form as the verification step auto-logs the user in after email verification link clicked.

Given I am a jobseeker on the MyEfc registration page
When I enter my choice of credentials and click on the register button
Then I am logged in as an unverified user
When I select the logout button
And I go to my email inbox
And I open the welcome email and click the verify account button
Then I am automatically logged in
And to confirm my account is verified successfully, I logout and login successfully

