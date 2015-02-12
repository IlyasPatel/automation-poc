Meta:
@tag partner feed:redirects
@issue ODT0221-12726

Narrative:
As a legacy outbound job feed user
I would like to be redirected to the new job feed URL powered by Solr
So that I can continue receiving jobs

Scenario: Testing direct Outbound Feed URLs work

Given I have a csv file <filename> with old URLs and new URLs
When I request each old URL in this file using HTTP GET
Then I receive a 200 HTTP response header

Examples:
|filename|
|OutboundFeedDirectUrls.csv|