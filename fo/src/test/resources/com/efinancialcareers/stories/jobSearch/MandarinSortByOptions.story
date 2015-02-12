Meta:
@tag job search:sort by options
@issue ODT0221-7732,ODT0221-10177,ODT0221-11845,ODT0221-12609

Narrative:
As a job seeker
I would like to sort my search results in different ways
So that I can quickly find relevant job

Scenario: Performing a search and sorting by job refresh date

Given I want to view jobs grouped by newest date
When I perform a job search <keyword>
And I sort by newest job
Then the SRP should display newest jobs first

Examples:
|keyword|
|(dataset)|
