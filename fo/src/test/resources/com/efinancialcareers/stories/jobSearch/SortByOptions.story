Meta:
@tag job search:sort by options
@issue ODT0221-7732,ODT0221-10177,ODT0221-11845,ODT0221-12609

Narrative:
As a job seeker
I would like to sort my search results in different ways
So that I can quickly find relevant job

Scenario: Performing a search and sorting by location

Given I want to view jobs grouped by location
When I perform a job search <keyword>
And I sort by "Location" alphanumerically (A-Z)
Then the SRP should first display locations alphanumerically
When I reverse the sort ordering for location (Z-A)
Then the jobs sort order for location should be reversed (Z-A)
When I sort by "Location" alphanumerically (A-Z)
Then the SRP should first display locations alphanumerically

Examples:
|keyword|
|(dataset)|

Scenario: Performing a search and sorting by job refresh date

Given I want to view jobs grouped by newest date
When I perform a job search <keyword>
And I sort by newest job
Then the SRP should display newest jobs first
When I sort by "Company name" alphanumerically (A-Z)
Then the SRP should first display companies alphanumerically
When I sort by newest job
Then the SRP should display newest jobs first

Examples:
|keyword|
|(dataset)|

Scenario: Performing a search and sorting by Company Name

Given I want to view jobs grouped by company name
When I perform a job search <keyword>
And I sort by "Company name" alphanumerically (A-Z)
Then the SRP should first display companies alphanumerically
And ANONYMOUS companies should appear after all the NON-ANONYMOUS companies are displayed
When I reverse the sort ordering for company name (Z-A)
Then the jobs sort order should be reversed by company name (Z-A)
And ANONYMOUS companies should appear after all the NON-ANONYMOUS companies are displayed

Examples:
|keyword|
|(dataset)|