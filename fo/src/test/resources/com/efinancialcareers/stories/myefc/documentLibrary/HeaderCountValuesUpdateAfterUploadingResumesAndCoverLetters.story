Meta:

Narrative:
As a tester
Want to check that header count values have updated once cover letters and CV's have been added

Scenario: Check counts in the menu are updated correctly when Resumes and Cover Letters have been added

Given I directly go to the document library URL and successfully login with <email> and <password>
Then all the sections in the header menu begin from zero
When I create <coverLetters> cover letters
And I upload <cvs> resumes
And I go to FO home page
Then correct counts are shown for my account in the header menu

Examples:
|email|password|cvs|coverLetters|searchAlerts|savedJobs|appliedJobs|profileCompleteness|document|
|test(dataset)@test.com|testing123|2|3|0|0|0|20|SmokeTestResumeInDocxFormat.docx|