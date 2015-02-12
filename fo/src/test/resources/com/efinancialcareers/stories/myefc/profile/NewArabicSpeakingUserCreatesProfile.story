Meta:
@tag feature:Fill Profile
@issue ODT0221FO-1738

Narrative:
As a new jobseeker
I would like to create a profile
So recruiters can see my up-to-date details

Scenario: Create a new profile as a new Arabic speaking user

Given I register a new account
Then "Is Arabic your first language" is set to "No" in the drop-down box
When I fill in my profile
Then "Is Arabic your first language" is set to "Yes" in the drop-down box
When I logout and re-login again
Then "Is Arabic your first language" is displayed showing "Yes"
And "Is Arabic your first language" is set to "Yes" in the drop-down box

Examples:
|myEfcUserBeanName|
|ArabicSpeakingUserWithMandatoryFieldsBefore|