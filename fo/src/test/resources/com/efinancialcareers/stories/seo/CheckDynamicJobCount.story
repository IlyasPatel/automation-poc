Meta:

Narrative:
As a QA
I want to check that total number of jobs in the header of the page on both FO and MyEfc parts
 are equal to total number of jobs on SRP


Scenario: Comparision of total number of Jobs on FO header and SRP with empty search

Given I am a jobseeker on the FO home page
When I store total number of jobs in the header of the page
And I perform search with empty keywords
And I store total number of jobs on SRP
Then number of Jobs in the header and on SRP are equal

Scenario: Comparision of total number of Jobs on MyEfc header and SRP with empty search

Given I am a jobseeker on the FO home page
When I click Sign In from the header menu
And I enter <email> and <password> and click on the login button
And I am logged in with <displayEmail>
And I perform search with empty keywords
And I store total number of jobs on SRP
And I directly go to Saved Jobs page
And I store total number of jobs in the header of the page
Then number of Jobs in the header and on SRP are equal

Examples:
|email|password|displayEmail|
|selusr01@dice.com|selusr123|selusr01@dice.com|