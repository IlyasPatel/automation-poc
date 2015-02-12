Meta:

Narrative:
As a JobSeeker from other than EN speaking countries
I want to search Jobs with Language Specific symbols

Scenario: Lnaguage specific symbols

Given I am waiting while Jobs will be available
And I am a jobseeker on the FO home page
When I directly go to Search Result Page
Then I verify language specific symbols for language <lang>


Examples:
|lang|
|FR|
|DE|
