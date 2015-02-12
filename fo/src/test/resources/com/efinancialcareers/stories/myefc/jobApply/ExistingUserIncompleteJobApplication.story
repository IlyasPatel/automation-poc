Meta:
@tag feature:Job Application

Narrative:
As a jobseeker
I can apply to a job where the application process was previously started but not completed

Scenario: Re-apply for a job when the previous application was incomplete.

Given I go to a job directly
When I apply for this job
And I enter <email> and <password> and click on the login button
Then I am taken to the "Apply for a Job" page
When I go directly to the application history page URL
Then my application is not listed as the job was never applied for
When I search for the job that I started to apply for
Then I can still apply for the job as the previous application was not complete
And then apply for the job
Then my application is sent to the recruiter successfully
When I go to the application history page
Then I can see my application at the top of the list on page 1

Examples:
|email|password|
|test(dataset)@mailinator.com|testing123|