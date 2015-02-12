Meta:
@tag feature:Job Application

Narrative:
As a tester
I would like to attempt to apply to the same job
which is not allowed

Scenario: Attempt to apply for a job which has already been applied to.

Given I want to apply for a specific job
When I enter <email> and <password> and click on the login button
Then I am notified I have already applied for this job
When I search for this job again using the job search component
Then the SRP will show me this job is already applied for
When I go to the job directly
Then the job overview page tells me this job is already applied for
When I go directly to the application history page URL
And I delete the job from the application history page
Then my application is no longer listed
When I go to the job directly
And I click on the "Apply" button on job overview page
Then I am notified I have already applied for this job

Examples:
|email|password|
|test(dataset)@mailinator.com|testing123|
