Meta:

Narrative:
As a tester
I would like to check the error pages are appearing as expected

Scenario: Check 404 page appears when entering an invalid url

Given I have arrived on a 404 page by entering an invalid URL
Then the 404 page content is displaying as expected
And there are fourteen links in the Footer

Scenario: Check 500 page is displayed with valid content

Given I have arrived on a 500 page by entering an invalid URL which is known to throw an internal server error
Then the 500 page content is displaying as expected
