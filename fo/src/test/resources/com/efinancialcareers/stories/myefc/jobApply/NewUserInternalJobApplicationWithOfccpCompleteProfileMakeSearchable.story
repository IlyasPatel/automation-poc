Meta:
@tag feature:Job Application

Narrative:
As a new jobseeker
I would like to apply for jobs
So I can find a new job. The job contains OFCCP information.
I also complete my profile during the apply process so it is searchable to recruiters.

Scenario: From the SRP, a new jobseeker selects a job to apply to and then registers a normal account. This particular job is posted with OFCCP compliance and the jobseeker completes their profile to make it searchable to recruiters. Jobseeker tries to submit an empty application.

Given I want to apply for a specific job
When I register a new account to apply for this job
Then I am taken to the "Apply for a Job" page
And I submit my application without entering details
And then the "Apply for a Job" page is displayed with error messages
And I upload my resume <document>
And I correct the errors by entering my personal details
And I enter OFCCP information
And then apply for the job
Then my application is sent to the recruiter successfully
And details in my profile are populated

Examples:
|document|
|SmokeTestResumeInDocFormat.doc|