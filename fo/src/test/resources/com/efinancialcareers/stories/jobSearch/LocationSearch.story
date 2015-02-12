Meta:

Narrative:
As a jobseeker
I would like to search for jobs in a specific locations

Scenario: Search for jobs in a specific location and check that jobs on SRP are in that location

Given I search for jobs in a specific location on <siteUri> site
When I perform a location search in <locationSearch>
Then the jobs are displayed with expected location <displayedLocation>

Examples:
|siteUri|locationSearch|displayedLocation|
|uk-en|Glasgow|Glasgow, Scotland, United Kingdom|
|de-de|Berlin|Berlin, Deutschland|
|fr-fr|Puteaux|Puteaux, Île-de-France, France|
|us-en|Stamford|Stamford, CT, USA|

Scenario: Search for jobs in a multiple locations and check that jobs on SRP are in that location

Given I search for jobs in a specific location on <siteUri> site
When I perform a location search in <locationSearch>
Then locations appear as expected in current refinements section

Examples:
|siteUri|locationSearch|displayedLocation|
|uk-en|London,Glasgow|Glasgow, Scotland, United Kingdom|
|de-de|Berlin,London|Berlin, Deutschland|