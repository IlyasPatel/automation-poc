Meta:

Narrative:
As a JobSeeker
I want to find Jobs by Skills, Jobs should contain Skill synonym in description

Scenario: Job search using Skills and English Synonyms

Given I am waiting while Jobs will be available
When I directly go to Search Result Page
Then I perform KeyWordSearch for language EN  and check that refined Jobs contain synonyms
