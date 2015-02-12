Meta:
@tag miscellaneous:current refinement tags
@issue ODT0221FO-1858

Narrative:
As a tester
I want to confirm current refinement tags appear as I select each facet.

Scenario: Confirm current refinement tags appear in the refine rail as I select each refinement. These tags appear at the top of the refine rail on SRP.

Given I perform an empty job search
When I select any date posted
Then the last x number of days in the current refinements section
When I select a Salary Currency
Then the Salary Currency appears in the current refinements section
When I select a Salary Band
Then the Salary Band appears in the current refinements section
When I select a Position Type
Then the Position Type appears in the currenct refinements section
When I select Sector
Then the Sector appears in the current refinements section
When I select a Brand
Then the Brand appears in the current refinements section
When I select an Employment Type
Then the Employment Type appears in the current refinements section
When I select a Work Experience
Then the Work Experience appears in the current refinements section
