Meta:

Narrative:
As a tester
I want to check that anchor links in the header menu work correct when user is logged in

Scenario: Check links in the header menu are correct on FO and MyEfc

Given I am a jobseeker on the FO home page
When I click Sign In from the header menu
And I successfully login with <email> and <password>
Then clicking on "Document Library" in the header menu takes user to "Document Library" page
And clicking on "Applications" in the header menu takes user to "Applications" page
And clicking on "Job Alerts" in the header menu takes user to "Job Alerts" page
And clicking on "Account Settings" in the header menu takes user to "Settings" page
And clicking on "Compare Me" in the header menu takes me to "Compare Me" page

Examples:
|email|password|
|timgooauto2@gmail.com|testing123$|