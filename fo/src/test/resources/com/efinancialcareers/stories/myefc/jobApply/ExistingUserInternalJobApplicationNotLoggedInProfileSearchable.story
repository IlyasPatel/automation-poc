Meta:
@tag feature:Job Application
@issue ODT0221-12703,ODT0221-13074,ODT0221FO-646

Narrative:
As a existing jobseeker
I would like to apply for jobs
So I can earn more money

Scenario: From the OP, an existing jobseeker logs in using their normal account to apply for the job. The jobseeker already has a completed searchable profile.

Given I go to a job directly
When I apply for this job
And I enter <email> and <password> and click on the login button
Then I am taken to the "Apply for a Job" page
And "I'm interested in being contacted" checkbox is not displayed as my profile is already searchable
And then apply for the job
Then my application is sent to the recruiter successfully
When I go to the application history page
Then I can see my application at the top of the list on page 1

Examples:
|email|password|
|test(dataset)@mailinator.com|testing123|