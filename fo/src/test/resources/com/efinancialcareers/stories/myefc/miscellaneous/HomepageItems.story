Meta:
@issue ODT0221-11707

Narrative:
As a tester
I want to check that the header page is displaying correct items

Scenario: Check Homepage is displaying correct items

Given I directly go to FO site <siteUri>
Then then Homepage is displaying elements as expected

Examples:
|siteUri|
|uk-en|
|de-de|
|fr-fr|
|us-en|