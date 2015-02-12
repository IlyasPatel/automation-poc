Meta:

Narrative:
As a tester
I would like to check that ordering of jobs is correct when sorting by relevance, salary and newest.
Assertions are based on job title ordering from a known dataset.

Scenario: Run a search for specific jobs and check sorting is correct with Newest job when jobs are posted on same day but different times

Given I directly go to FO site <siteUri>
When I perform a job search <keyword>
And I sort by newest job
Then jobs are displayed in the expected order by newest job
And broaden your search link does not appear as a single keyword was used

Examples:
|siteUri|keyword|firstJobTitle|allJobTitlesOnPage|
|fr-fr|dataset|Test Job 4 FR|Test Job 4 FR, Test Job 3 DE, Test Job 2 FR {0}, Test Job 1 EN {0} {0}|
|uk-en|dataset|Test Job 4 FR|Test Job 4 FR, Test Job 3 DE, Test Job 2 FR {0}, Test Job 1 EN {0} {0}|
|de-de|dataset|Test Job 4 FR|Test Job 4 FR, Test Job 3 DE, Test Job 2 FR {0}, Test Job 1 EN {0} {0}|


Scenario: Run a search for specific jobs and check sorting is correct with location and language (relevant sort by)

Given I directly go to FO site <siteUri>
When I perform a job search <keyword>
Then jobs are displayed in the expected order by location and language
And <jobCountValue> jobs are displayed in the job search count

Examples:
|siteUri|keyword|firstJobTitle|allJobTitlesOnPage|jobCountValue|
|fr-fr|dataset|Test Job 2 FR {0}|Test Job 2 FR {0}, Test Job 4 FR, Test Job 1 EN {0} {0}, Test Job 3 DE|4|
|uk-en|dataset|Test Job 1 EN {0} {0}|Test Job 1 EN {0} {0}, Test Job 2 FR {0}, Test Job 3 DE, Test Job 4 FR|4|
|de-de|dataset|Test Job 3 DE|Test Job 3 DE, Test Job 1 EN {0} {0}, Test Job 2 FR {0}, Test Job 4 FR|4|


Scenario: Run a search for specific jobs and check sorting is correct with salary lowest to highest

Given I directly go to FO site <siteUri>
When I perform a job search <keyword>
Then the "Salary Band" option should NOT appear in the "Sort by" drop-down list as no currency has been specified (Business Rule)
When I select a currency from the refine rail
Then the "Salary Band" option should NOW appear in the "Sort by" drop-down list
When I sort by "Salary Band" lowest to highest
Then the jobs are displayed in the expected order by salary lowest to highest salary band

Examples:
|siteUri|keyword|firstJobTitle|allJobTitlesOnPage|
|fr-fr|dataset|Test Job 1 EN {0} {0}|Test Job 1 EN {0} {0}, Test Job 3 DE, Test Job 2 FR {0}, Test Job 4 FR|
|uk-en|dataset|Test Job 1 EN {0} {0}|Test Job 1 EN {0} {0}, Test Job 3 DE, Test Job 2 FR {0}, Test Job 4 FR|
|de-de|dataset|Test Job 1 EN {0} {0}|Test Job 1 EN {0} {0}, Test Job 3 DE, Test Job 2 FR {0}, Test Job 4 FR|