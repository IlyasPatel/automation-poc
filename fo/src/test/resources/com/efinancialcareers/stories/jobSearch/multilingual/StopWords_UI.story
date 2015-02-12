Meta:

Narrative:
As a QA
I want to check that stop words are ignored during search

Scenario: Stop Words verification. All Stop Words should be ignored

Given I am a jobseeker on the FO home page
When I directly go to Search Result Page
Then I verify Stop Words for language <lang>


Examples:
|lang|
|EN|
|DE|
|FR|
