Meta:

Narrative:
As a tester
I would like to check that the previous and next job links work on the job overview page

Scenario: Test Next and Previous links work on the Job Overview page

Given I want to check that the Next and Previous Job Links work on the job overview page
When I perform a job search <keyword>
And I sort by newest job
And I make a note of all the job titles on the search results page
And I select the first job
And I click "Next Job" link for a collection of jobs making a note of the titles
Then the ordering of the jobs on the job overview page matches the job titles from the search results page
When I click "Previous Job" link for a collection of jobs making a note of the titles
Then the ordering of the jobs on the job overview page matches the job titles from the search results page in reverse

Examples:
|keyword|
|java|

Scenario: Test Correct job is returned when clicking previous link of the first job on the second page of results

Given I am on the second page of the search results page
When I select the first job from the second page and click the "Previous" link
Then the last job that was on the first page of the search results page is displayed on the overview page
When I click "Back to Search Results" on the job details page
Then I am taken back to my search results with the job displayed

