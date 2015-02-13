Meta:
@tag feature:Job Application

Narrative:
As a existing jobseeker
I would like to apply for jobs
So I can earn more money

Scenario: From the SRP, an existing jobseeker who is already logged in using their normal account before applying for a job. The profile for this jobseeker is completed but missing "Willingness to travel" which used to be mandatory. User remains unsearchable.

Given I am a jobseeker on the FO home page and I login with my normal account
When I search for this job using the job search component and click on the apply button
Then I am taken to the "Apply for a Job" page
And I untick "I'm interested in being contacted" checkbox
And then apply for the job
Then my application is sent to the recruiter successfully
And my profile is still non searchable

Examples:
|email|password|
|testuserSerenity1@mailinator.com|testing123|