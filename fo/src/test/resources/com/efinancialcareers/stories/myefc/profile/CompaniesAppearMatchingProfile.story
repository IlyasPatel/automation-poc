Meta:
@tag feature:Companies Matching Profile


Narrative:
As a new jobseeker
I would like to see companies that match my profile when applying for a job updating my profile.

Scenario: Companies matching my profile are displayed after applying for a job

Given I go to a job directly
When I apply for this job
And I enter <email> and <password> and click on the login button
Then I am taken to the "Apply for a Job" page
And then apply for the job
And I can see companies that match my profile as my profile matches a live RSA in company Demo Finance

Examples:
|email|password|matchingCompany|
|test(dataset)@mailinator.com|testing123|Demo Finance|

Scenario: Companies matching my profile are displayed when updating my profile

Given I go to my profile
When I edit my profile title to company with a matching RSA
Then I can see companies that match my profile as my updated profile title matches a live RSA in company Demo Finance

Examples:
|email|password|profileTitle|
|test(dataset)@mailinator.com|testing123|dataset|