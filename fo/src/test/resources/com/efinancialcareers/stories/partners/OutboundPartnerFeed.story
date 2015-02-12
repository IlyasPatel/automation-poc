Meta:
@tag partner feed:redirects
@issue ODT0221-11389,ODT0221-11756

Narrative:
As a legacy outbound job feed user
I would like to be redirected to the new job feed URL powered by Solr
So that I can continue receiving jobs

Scenario: Testing all 301 redirects set at load balancer‎ level are working

Given I have a csv file <filename> with old URLs and new URLs
When I request each old URL in this file
Then I am redirected to the new URL with a 301 HTTP response header
When I follow the Location header URL
Then I receive a 200 HTTP response header

Examples:
|filename|
|OutboundFeedOldAndNewURL16Oct2013.csv|