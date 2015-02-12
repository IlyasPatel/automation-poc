Meta:

@issue ODT0221-11707

Narrative:
As a jobseeker
I have forgotten my password so I would like to reset it using my Mailinator account

Scenario: Forgotten password

Given I am a jobseeker on the MyEfc login page
And I have forgotten my password
When I enter <email> into the password reset form
Then I am notified an email has been sent
When I go to my email inbox
When I open the password change email and click reset password button
And I reset my password with <newPassword>
Then I am able to login to my account using this newPassword

Examples:
|email|newPassword|
|test(dataset)@mailinator.com|newPasswordTesting456|