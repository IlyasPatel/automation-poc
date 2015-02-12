Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: A new jobseeker on the Gulf site applies for a Gulf job.

Given I directly go to FO site <siteUri>
When I want to apply for a specific job
And I register a new account to apply for this job
Then I upload my resume <document>
And I enter my personal details
And I enter my nationality (this field is displayed and mandatory only if any of the four following conditions are met; I am on the Gulf site, or the job is located in the Gulf, if I live in a Gulf region or I registered on the Gulf site)
And then apply for the job
Then my application is sent to the recruiter successfully

Examples:
|siteUri|document|
|gulf-en|SmokeTestResumeInDocFormat.doc|

Scenario: A new jobseeker on the UK site applies for a job which is located in the Gulf.

Given I directly go to FO site <siteUri>
When I want to apply for a specific job
And I register a new account to apply for this job
Then I upload my resume <document>
And I enter my personal details
And I enter my nationality (this field is displayed and mandatory only if any of the four following conditions are met; I am on the Gulf site, or the job is located in the Gulf, if I live in a Gulf region or I registered on the Gulf site)
And then apply for the job
Then my application is sent to the recruiter successfully

Examples:
|siteUri|document|
|uk-en|SmokeTestResumeInDocFormat.doc|