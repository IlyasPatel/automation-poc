Meta:
@tag feature:Job Application

Narrative:
As a existing jobseeker
I would like to apply for jobs
So I can earn more money

Scenario: After applying for a job, valid jobs are appearing in interested and jobs matching profile sections on the application success page.

Given I go to a job directly
When I apply for this job
And I enter <email> and <password> and click on the login button
Then apply for the job
And 4 jobs that I may be interested in are displayed
And 4 jobs that match my profile are displayed

Examples:
|email|password|interestedJobTitle|profileJobsLocation|
|test(dataset)@mailinator.com|testing123|Internal job|London|