Meta:

Narrative:
As a tester
Check that once a user has logged in, the counts for CV, Cover Letters, Searches & Alerts, Saved, Applied jobs and profile completeness are correct

Scenario: Check counts in the menu are correct on FO and MyEfc (2.17 Resume and Cover Letter count has been removed)

Given I go to my profile
When I edit my profile title and save
Then correct counts are shown for my account in the header menu
When I go to FO home page
Then correct counts are shown for my account in the header menu

Examples:
|email|password|cvs|coverLetters|searchAlerts|savedJobs|appliedJobs|profileCompleteness|profileTitle|
|test(dataset)@test.com|testing123|4|5|0|3|1|72|test|