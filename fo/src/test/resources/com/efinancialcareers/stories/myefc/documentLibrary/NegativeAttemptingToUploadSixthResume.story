Meta:

Narrative:
As a jobseeker
I should not be able to upload more than 5 resumes

Scenario: An existing user attempting to upload more than 5 resumes

Given I directly go to the document library URL and successfully login with <email> and <password>
When I attempt to select a resume to upload
Then I am notified that I already have 5 resumes uploaded and need to delete an existing one
When I try to upload a resume from the profile section
Then I am notified that I already have 5 resumes uploaded and need to delete an existing one

Examples:
|email|password|document|
|testuser(dataset)@test.com|testing123|SmokeTestResumeInPDFFormat.pdf|

