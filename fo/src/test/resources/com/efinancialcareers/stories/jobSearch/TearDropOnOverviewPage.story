Meta:

Narrative:
As a jobseeker
I want to see active interest in a job
So that I can see how popular a job is

#Test order is important for these tests!#

Scenario: Tear drop is first displayed after a job receives 3 or more page views.

Given I go to a job directly
When I refresh this page
Then no tear drop appears as it has less than 3 views
When I refresh the page again
Then the tear drop appears displaying 3 people are currently viewing this job
When I refresh the page again
Then the tear drop appears displaying 4 people are currently viewing this job

Scenario: Confirm for an INTERNAL job the last job application date does not appear when a job is not applied to but the apply button was clicked.

Given I am a jobseeker on the FO home page and I login with my normal account
And I go to a job directly
And I update the database to have 9 applications already and refresh the page
When I click on the apply button for this job
And I deliberately don't complete the application process and go back to the job overview page
Then the last application date is NOT displayed on the job overview page

Examples:
|email|password|
|selusr01@dice.com|selusr123|

Scenario: Tear drop displays last job application date after 10th successful application. Tear drop also displays a message that the job has 10 or more job applications.

Given I go to a job directly
And I update the database to have 9 applications already and refresh the page
When I apply for this job as an existing user
Then go back to the job I just applied to
Then the last application date is displayed on the job overview page
And the expected number of job applications are displayed which is <totalNumberOfApplications>

Examples:
|email|password|totalNumberOfApplications|
|selusr01@dice.com|selusr123|10|

Scenario: Tear drop displays message that job has 20 or more job views.

Given I go to a job directly
And I update the database to have 19 job views and refresh the page
Then the tear drop appears displaying 20 people have viewed this job
When I refresh the page again
Then the tear drop appears displaying 21 people have viewed this job

Scenario: Tear drop rotates between 4 different messages (this test depends on the previous tests running).

Given I go to a job directly
Then the tear drop rotates between 4 different messages