Meta:

Narrative:
As a JobSeeker
I want to find Jobs by Skills, Jobs should contain Skill synonym in description

Scenario: Job search using Skills and Synonyms using direct calls to SOLR

Given I am waiting while Jobs will be available
Then I am checking that related to Skills Jobs with <lang> Synonyms in Description have been returned by SOLR



Examples:
|lang   |
|EN     |
|FR     |
|DE     |
