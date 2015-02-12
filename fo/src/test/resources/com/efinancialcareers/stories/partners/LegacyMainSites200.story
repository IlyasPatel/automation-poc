Meta:
@tag partner feed:redirects
@issue ODT0221-11390

Narrative:
As a legacy site
I would like to be redirected to the correct new url

Scenario: Testing all 301 redirects set at load balancer‎ level for main sites

Given I have a csv file <filename> with old URLs and new URLs
When I request each old URL in this file using HTTP GET
Then I receive a 200 HTTP response header

Examples:
|filename|
|MainSites.csv|