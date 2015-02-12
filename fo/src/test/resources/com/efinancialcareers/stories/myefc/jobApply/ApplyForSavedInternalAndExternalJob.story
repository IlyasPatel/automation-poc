Meta:
@tag feature:Job Application

Narrative:
As a existing jobseeker
I would like to apply for jobs
So I can earn more money

Scenario: Apply for an external job which is saved to my account.

Given I directly go to the Saved Jobs URL and successfully login with <email> and <password>
When I apply for this external job saved in my account
Then I am shown a redirect page and taken to site <externalSiteUrl> as this is an external job

Examples:
|email|password|externalSiteUrl|
|test(dataset)@mailinator.com|testing123|https://www.google.co.uk/|

Scenario: Apply for an internal job which is saved to my account.

Given I directly go to the Saved Jobs URL and successfully login with <email> and <password>
When I apply for this internal job saved in my account
Then I am taken to the "Apply for a Job" page
And then apply for the job
Then my application is sent to the recruiter successfully

Examples:
|email|password|
|test(dataset)@mailinator.com|testing123|