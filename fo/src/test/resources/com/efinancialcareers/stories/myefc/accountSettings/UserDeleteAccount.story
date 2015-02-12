Meta:

Narrative:
As a jobseeker
I would like to delete my account as I now have a job

Scenario: Delete MyEfc Account

Given I directly go to the account settings URL and successfully login with <email> and <password>
When I select delete my account option on MyEfc
Then an account delete email is sent to my inbox
When I open the delete account email and click confirm deletion button
Then I am taken to the account deleted page
When I confirm my account is deleted successfully, I attempt to re-login
Then login should be unsuccessful
When I go to my email inbox
Then I should have received a confirmation message that my account is deleted

Examples:
|email|password|
|test(dataset)@mailinator.com|testing123|