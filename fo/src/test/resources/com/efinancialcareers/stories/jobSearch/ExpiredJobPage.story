Meta:

Narrative:
As a tester
I would like to check the expired job page is working as expected

Scenario: Check an expired job redirects correctly and check that total job counts are within range of total jobs on SRP.

Given I have arrived on the job expired page
When I make a note of total jobs
And I click on the total jobs link on job expired page
Then I am taken to SRP with valid amount of jobs displayed

Examples:
|jobId|
|644790|

Scenario: Check an expired job redirects correctly and check that total job within last 3 days are within range of total jobs on SRP.

Given I have arrived on the job expired page
When I make a note of jobs posted within the last 3 days
And I click on the jobs posted within the last 3 days link on the job expired page
Then I am taken to SRP with valid job count for jobs posted in the last 3 days

Examples:
|jobId|
|644790|

