Meta:
@tag feature:Fill Profile

Narrative:
As a new jobseeker
I would like to create a profile
So recruiters can see my up-to-date details

Scenario: Create a new profile as a new user filling in the mandatory details only

Given I register a new account
When I fill in my profile
And I logout and re-login again
Then the mandatory fields in my profile are still correctly populated

Examples:
|myEfcUserBeanName|
|MyEfcUserWithMandatoryFieldsBefore|