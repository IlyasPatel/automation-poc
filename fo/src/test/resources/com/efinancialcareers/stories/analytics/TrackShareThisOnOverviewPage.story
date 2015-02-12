Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Confirm the "Share" this job button is tracked.

Given I select any job to view
When I click on the "Share" button
Then the GTM Data Layer is correctly populated

