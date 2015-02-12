Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Single company link returns jobs for the selected company.

Given I am a jobseeker on the Site Map page
When I select any one of the <linkType> links to view jobs in this company
Then the SRP only displays jobs by the company I selected

Examples:
|linkType|
|SINGLE_BRAND|

Scenario: Single sector link returns jobs for the selected sector.

Given I am a jobseeker on the Site Map page
When I select any one of the <linkType> links to view jobs in this sector
Then the SRP only displays jobs by the sector I selected

Examples:
|linkType|
|SECTOR|

Scenario: Single subsector link returns jobs for the selected subsector.

Given I am a jobseeker on the Site Map page
When I select any one of the <linkType> links to view jobs in this subsector
Then the SRP only displays jobs by the subsector I selected

Examples:
|linkType|
|SUBSECTOR|

Scenario: Single country link returns jobs for the selected country.

Given I am a jobseeker on the Site Map page
When I select any one of the <linkType> links to view jobs in this country
Then the SRP only displays jobs in the country I selected

Examples:
|linkType|
|COUNTRY|

Scenario: Single city link returns jobs for the selected city.

Given I am a jobseeker on the Site Map page
When I select any one of the <linkType> links to view jobs in this city
Then the SRP only displays jobs in the city I selected

Examples:
|linkType|
|CITY|