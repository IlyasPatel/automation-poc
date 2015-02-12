Meta:

Narrative:
As a new jobseeker
I would like to be able to change my profile privacy settings

Scenario: Update profile privacy settings with a user that has a completed profile

Given I directly go to the account settings URL and successfully login with <email> and <password>
Then my profile privacy setting is set to "Searchable"
When I change my privacy settings to "Non-searchable" and click Submit
Then my profile privacy setting is set to "Non-searchable"
When I change my privacy settings to "Searchable but Anonymous" and click Submit
Then my profile privacy setting is set to "Searchable but Anonymous"
When I change my privacy settings to "Non-searchable" and click Submit
Then my profile privacy setting is set to "Non-searchable"
When I change my privacy settings to "Searchable" and click Submit
Then my profile privacy setting is set to "Searchable"
When I change my privacy settings to "Non-searchable" and click Submit
Then my profile privacy setting is set to "Non-searchable"
And my profile privacy setting is displayed as "Non-searchable" on the Front-Office

Examples:
|email|password|
|test(dataset)@test.com|testing123|