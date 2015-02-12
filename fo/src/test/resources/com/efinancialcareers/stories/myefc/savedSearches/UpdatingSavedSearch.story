Meta:
@tag feature:Update Job Alert

Narrative:
As a existing jobseeker
I would like to update my search
So I can be notified of similar jobs in the future

Scenario: Existing jobseeker is able to update a saved search alert.

Given I directly go to the Saved Job Searches URL and login with <email> and <password>
When I update my search alert to receive "Weekly" alerts
And I execute the search by clicking on the alert name
Then my alert is correctly set to receive "Weekly" alerts
When I use specific criteria to narrow my job search <jobSearchCriteria>
And I save this search with notifications set to "Daily"
When I go to manage my job alerts
Then my search is saved correctly
When I trigger the <notificationInterval> PSA mailer for this user only
Then I receive <numberOfPSAsExpected> PSA emails which match my saved search alerts
And PSA email(s) are sent to my inbox containing jobs posted *(not refreshed)* in the last 24 hours matching my search criteria
When I select any PSA email and select a job link
Then I am taken to the correct job overview page

Examples:
|email|password|notificationInterval|jobSearchCriteria|numberOfPSAsExpected|
|test(dataset)@mailinator.com|testing123|Daily|SrpFormUpdateJobAlerts|2|
