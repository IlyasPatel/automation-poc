Meta:

Narrative:
As a jobseeker
I should not be able to create more than 5 cover letters

Scenario: An existing user attempting to create more than 5 cover letters

Given I directly go to the document library URL and successfully login with <email> and <password>
When I try to create a 6th cover letter
Then I am notified that I already have 5 cover letters created and need to delete an existing one

Examples:
|email|password|
|test(dataset)@test.com|testing123|