Meta:
@tag feature:Save a Job
@issue ODT0221FO-739

Narrative:
As a tester
I want to save a job and during the process switch language, when unsaving check translation is in the correct language

Scenario: An existing jobseeker saves a job. The jobseeker changes language sites to their preferred language on the homepage.

Given I directly go to FO site <siteUri>
And I select a specific language from the header
Then I am on the expected language site
When I perform a BLANK job search
And I click on the "Save" button on the SRP
And I successfully login with <email> and <password>
Then I am taken back to the search results page with my results displayed
And I am on the expected language site
When I click Unsave for my job on the SRP
Then the job I Unsaved has now got the option to Save on the SRP with the correct language displayed

Examples:
|siteUri|email|password|newSiteUri|
|lu-de|selusr01@dice.com|selusr123|lu-fr|
|be-fr|selusr01@dice.com|selusr123|be-en|
|ch-fr|selusr01@dice.com|selusr123|ch-de|