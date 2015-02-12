Meta:
@tag feature:Unsave a Job
@issue ODT0221FO-672

Narrative:
As a jobseeker
I would like to unsave my job

Scenario: Existing jobseeker is able to unsave a job from SRP.

Given I search for a job that has already been saved
When I login
Then the job I saved has now got the option to "Unsave"
When I click Unsave for my job on the SRP
Then the job I Unsaved has now got the option to "Save" on the SRP
When I go to Saved Jobs page in MyEfc
Then I should not have any saved jobs

Examples:
|email|password|
|(dataset)@mailinator.com|testing123|

Scenario: Existing jobseeker is able to unsave a job using their OpenID account from SRP.

Given I find a job I am interested in
When I click on the "Save" button on the SRP
And I select <provider> then enter <email> and <password> and click login button
Then I am taken back to the search results page with my results displayed
And the job I saved has now got the option to "Unsave" on the SRP
When I click Unsave for my job on the SRP
Then the job I Unsaved has now got the option to "Save" on the SRP

Examples:
|provider|email|password|displayEmail|
|Google|timgooauto1@gmail.com|testing123$|timgooauto1@gmail.com|

