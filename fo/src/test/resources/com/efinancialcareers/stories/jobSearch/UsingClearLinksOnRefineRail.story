Meta:
@tag miscellaneous:Using clear links

Narrative:
As a existing tester
I would like to confirm the "Clear" facet links are working on the refine rail

Scenario: Clearing individual facets

Given I directly go to the Saved Job Searches URL and login with <email> and <password>
And I have all facets saved as part of my job alert
When I run the search by clicking on the alert name
And I clear the "Date Posted" facet
And I clear the "Salary" facet
And I save this search and go to the job alerts page
Then the "Salary" facet is removed from my job alert
When I run the search by clicking on the alert name
And I clear the "Location" facet
And I save this search and go to the job alerts page
Then the "Location" facet is removed from my job alert
When I run the search by clicking on the alert name
And I clear the "Position Type" facet
And I save this search and go to the job alerts page
Then the "Position Type" facet is removed from my job alert
When I run the search by clicking on the alert name
And I clear the "Sectors" facet
And I save this search and go to the job alerts page
Then the "Sectors" facet is removed from my job alert
When I run the search by clicking on the alert name
And I clear the "Skills" facet
And I save this search and go to the job alerts page
Then the "Skills" facet is removed from my job alert
When I run the search by clicking on the alert name
And I clear the "Company" facet
And I save this search and go to the job alerts page
Then the "Company" facet is removed from my job alert
When I run the search by clicking on the alert name
And I clear the "Employment Type" facet
And I save this search and go to the job alerts page
Then the "Employment Type" facet is removed from my job alert
And my job alert is only left with the keyword refinement

Examples:
|email|password|
|test(dataset)@mailinator.com|testing123|