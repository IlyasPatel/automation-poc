Meta:

Narrative:
As a job seeker
I want to save jobs I am interested
So that I can apply for them later

Scenario: An existing user saves a job openId

Given I delete Saved jobs for <email> so they have no saved jobs for the start of the test
And I find a job I am interested in
When I click on the "Save a Job" button on the SRP
And I select <provider> then enter <email> and <password> and click login button
Then I am logged in with <displayEmail>
And I am taken back to the search results page with my results displayed
And the job I saved has now got the option to Unsave on the SRP
When I directly go to Saved Jobs page
Then my job is saved in my account
When I select the remove button to delete my saved job
Then my job is deleted

Examples:
|provider|email|password|displayEmail|
|Google|timgooauto1|testing123$|timgooauto1@gmail.com|