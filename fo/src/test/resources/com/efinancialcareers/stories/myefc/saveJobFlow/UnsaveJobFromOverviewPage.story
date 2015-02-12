Meta:
@tag feature:Unsave a Job

Narrative:
As a jobseeker
I would like to unsave my job

Scenario: Existing jobseeker is able to unsave a job from OP.

Given I go directly to a job I have saved
When I login
Then the job I saved has now got the option to "Unsave"
When I click "Unsave" for my job on the OP
Then the job I Unsaved has now got the option to "Save" on the OP
When I go to Saved Jobs page in MyEfc
Then I should not have any saved jobs

Examples:
|email|password|
|(dataset)@mailinator.com|testing123|