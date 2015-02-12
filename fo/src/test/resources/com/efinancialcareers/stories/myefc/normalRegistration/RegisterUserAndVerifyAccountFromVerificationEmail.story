Meta:

Narrative:
As a jobseeker
I would like to register to MyEfc
So that my personal information is secure

Scenario: Attempt to login as an unverified user and confirm the "Remember to verify your account" email is resent. Checks user can login using the login form as the verification step auto-logs the user in after email verification link clicked.

Given I am a jobseeker on the MyEfc registration page
When I enter my choice of credentials and click on the register button
Then I am logged in as an unverified user
When I logout and attempt to re-login
Then I am notified to verify my account and a verification email is sent to me
When I go to my email inbox
Then I should have two emails, one for the welcome email and the other to verify my account
When I attempt to verify my account using the welcome email
Then I am told my link has expired
When I go to my email inbox
And I open the "Remember to verify your account" email and click the verify account button
Then I am automatically logged in
And to confirm my account is verified successfully, I logout and login successfully