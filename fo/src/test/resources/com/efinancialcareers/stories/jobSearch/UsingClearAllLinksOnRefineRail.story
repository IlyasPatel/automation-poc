Meta:
@tag miscellaneous:using clear links

Narrative:
As a tester
I would like to confirm the "Reset Filters" link is working on the refine rail

Scenario: Clearing all facets using the clear all link

Given I directly go to the Saved Job Searches URL and successfully login with <email> and <password>
And I have all facets saved as part of my job alert
When I run the search by clicking on the alert name
And I "Reset Filters"
And I save this search and go to the job alerts page
Then my job alert is only left with the keyword refinement

Examples:
|email|password|
|test(dataset)@mailinator.com|testing123|