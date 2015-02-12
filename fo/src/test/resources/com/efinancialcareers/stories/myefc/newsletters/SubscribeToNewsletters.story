Meta:

Narrative:
As a jobseeker
I would like to subscribe to all newsletters

Scenario: Subscribe to all newsletters

Given I directly go to the account settings URL and successfully login with <email> and <password>
When I subscribe to all American newsletters
Then I am subscribed to all twelve American newsletters
When I subscribe to all EMEA newsletters for the three regions
Then I am subscribed to all nineteen EMEA newsletters
When I subscribe to all APAC newsletters
Then I am subscribed to all seven APAC newsletters
When I unsubscribe to all newsletters
Then no newsletters are selected

Examples:
|email|password|
|test(dataset)@mailinator.com|testing123|