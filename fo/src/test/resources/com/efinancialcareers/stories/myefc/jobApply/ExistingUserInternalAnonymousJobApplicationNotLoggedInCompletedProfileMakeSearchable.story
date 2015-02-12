Meta:
@tag feature:Job Application
@issue ODT0221-12703,ODT0221FO-1183

Narrative:
As a existing jobseeker
I would like to apply for jobs
So I can earn more money

Scenario: From the OP, an existing jobseeker logs in using their normal account to apply for this anonymous job. The profile is already completed so the jobseeker makes it searchable from the "Your application" page.

Given I go to a job directly
When I apply for this anonymous job
And I enter <email> and <password> and click on the login button
Then I am taken to the "Apply for a Job" page
And "I'm interested in being contacted" is checked by default
And then apply for the job
Then my application is sent to the recruiter successfully
And my profile is searchable
When I click on the "privacy settings" link
Then my profile privacy setting is set to "Searchable"

Examples:
|email|password|interestedJobTitle|
|test(dataset)@mailinator.com|testing123|T&A Technology|