Meta:

Narrative:
As a tester
I would like to confirm the "See All" modal boxes on SRP remember their selections

Scenario: Check the location tag appears and can be removed by selecting the x

Given I perform job search with location <location>
Then the refine rail has the <location> tag displayed
When I select the x on this location tag
Then the tag is removed
And SRP is updated with a new job count

Examples:
|location|
|London|

Scenario: Check the location tag appears and can be removed by un-selecting the location from the location modal

Given I perform an empty job search
When I enter a <location> in the refine rail typeahead
Then the refine rail has the <location> tag displayed
When I un-select the location from the location modal
Then the tag is removed
And SRP is updated with a new job count

Examples:
|location|
|London|

Scenario: Check a blank job search does not return facets with 0 results

Given I perform an empty job search
Then there are no facets with 0 results