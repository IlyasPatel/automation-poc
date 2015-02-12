Meta:


Narrative:
As a jobseeker
I would like to unsave my job

Scenario: An existing openId user unsaves job from OP

Given I delete Saved jobs for <email> so they have no saved jobs for the start of the test
And I find a job I am interested in
When I click on the "Save a Job" button on the SRP
And I select <provider> then enter <email> and <password> and click login button
Then I am logged in with <displayEmail>
And I am taken back to the search results page with my results displayed
And the job I saved has now got the option to Unsave on the SRP
When I click Unsave for my job on the SRP
Then the job I Unsaved has now got the option to Save on the SRP
When I directly go to Saved Jobs page
Then I should not have any saved jobs

Examples:
|provider|email|password|displayEmail|
|Google|timgooauto1|testing123$|timgooauto1@gmail.com|