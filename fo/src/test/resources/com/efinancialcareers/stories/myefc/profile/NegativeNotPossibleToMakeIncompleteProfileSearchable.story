Meta:

Narrative:
As a tester
it is not possible to make incomplete profile searchable

Scenario: Check it is not possible to make incomplete profile searchable

Given I directly go to "Privacy Settings" URL and successfully login with <email> and <password> with incomplete profile
Then my profile privacy setting is set to "Non-searchable"
And it is not possible to select "Searchable but Anonymous" or "Searchable" as my profile is incomplete

Examples:
|email|password|
|test(dataset)@test.com|testing123|