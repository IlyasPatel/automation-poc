Meta:

Narrative:
As a jobseeker
I want to see active interest in a job
So that I can see how popular a job is

Scenario: Confirm for an EXTERNAL job the last job application date appears when a job is not applied to but the apply button was clicked.

Given I go to a job directly
And I update the database to have 9 applications already and refresh the page
When I apply for this external job
And I deliberately don't complete the application process and go back to the job overview page
Then the last application date is displayed on the job overview page
And the expected number of job applications are displayed which is <totalNumberOfApplications>

Examples:
|email|password|totalNumberOfApplications|
|selusr01@dice.com|selusr123|10|

