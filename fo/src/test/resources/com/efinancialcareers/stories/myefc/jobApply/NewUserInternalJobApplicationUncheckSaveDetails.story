Meta:
@tag feature:Job Application

Narrative:
As a new jobseeker
I would like to apply for jobs
So I can find a new job

Scenario: From the SRP, a new jobseeker selects a job to apply to and then registers a normal account. Mandatory information is filled in to complete job application but jobseeker chooses not to save this information to their profile.

Given I want to apply for a specific job
When I register a new account to apply for this job
Then I am taken to the "Apply for a Job" page
And I enter my personal details
And I uncheck "I want to save these details to my profile"
And I upload my resume <document>
And then apply for the job
Then my application is sent to the recruiter successfully
And the option to "Complete your profile" is displayed
When I go to the application history page
Then I can see my application at the top of the list on page 1
And confirm all my details in my profile are empty as I chose not to save them to my profile earlier in the flow

Examples:
|document|
|SmokeTestResumeInDocFormat.doc|