Meta:

Narrative:
As a tester
I want to confirm there is a good level of validation when registering as a new user

Scenario: Register with email already in use

Given I am a jobseeker on the MyEfc registration page
When I enter my choice of credentials that already exist and click on the register button
Then I am told that the Email address is already in use

Examples:
|email|
|jneville@efinancialcareers.com|

Scenario: Confirming validation is working when registering

Given I am a jobseeker on the MyEfc registration page
When I attempt to submit an empty registration form
Then I am told that I need to enter an Email address and password
When I enter an email address
And I attempt to submit the registration form
Then I am told to enter a password
When I enter a password
And I attempt to submit the registration form
Then I am told the passwords do not match
When I enter an incorrect confirmation password
Then I am told the passwords do not match
When I correct the confirmation password
And enter any value for Kaptcha as this is disabled for test automation
Then I am logged in as an unverified user