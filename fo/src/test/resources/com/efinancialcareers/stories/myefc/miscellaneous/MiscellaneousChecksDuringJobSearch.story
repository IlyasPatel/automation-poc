Meta:
@tag miscellaneous:miscellaneous

Narrative:
As a tester
I want to perform miscellaneous checks during a job search
So I don't clutter existing tests

Scenario: Confirm broaden your search link appears, next/previous buttons disabled and breadcrumb displays correct text.

Given I perform a job search with $keyword from the homepage
Then confirm "broaden your search" link appears
And confirm next and previous links are disabled on SRP
And confirm correct bread crumb is displayed

Examples:
|keyword|
|(dataset)|

