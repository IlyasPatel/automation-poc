Meta:
@tag partner feed:redirects
@issue ODT0221-11389,ODT0221-11756

Narrative:
As a legacy outbound job feed user
I would like to be redirected to the new job feed URL powered by Solr
So that I can continue receiving jobs

Scenario: Testing all 301 redirects set at load balancer‎ level are working

Given I have a csv file <filename> with URLs
When I request each URL in this file

Examples:
|filename|
|OtherRedirects.csv|