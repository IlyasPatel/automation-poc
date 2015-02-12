Meta:
@tag partner feed:redirects
@issue ODT0221-11390

Narrative:
As a legacy external partner site
I would like to be redirected to the relative Front-Office site
So that I can continue searching for jobs

Scenario: Testing all 301 redirects set at load balancer‎ level for partner sites

Given I have a csv file <filename> with old URLs and new URLs
When I request each old URL in this file
Then I am redirected to the new URL with a 301 HTTP response header
When I follow the Location header URL
Then I receive a 200 HTTP response header

Examples:
|filename|
|ExternalPartners.csv|