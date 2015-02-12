Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: An existing jobseeker who originally registered on the Gulf site applies for a job located in the UK on the UK site.

Given I directly go to FO site <siteUri>
When I want to apply for a specific job
And I enter <email> and <password> and click on the login button
Then I confirm my partner Id belongs to the Gulf site
And I submit my application without entering nationality
And the "Apply for a Job" page is displayed with an empty nationality validation error message
And I enter my nationality (this field is displayed and mandatory only if any of the four following conditions are met; I am on the Gulf site, or the job is located in the Gulf, if I live in a Gulf region or I registered on the Gulf site)
And then apply for the job
Then my application is sent to the recruiter successfully

Examples:
|siteUri|email|password|
|uk-en|test(dataset)@mailinator.com|testing123|