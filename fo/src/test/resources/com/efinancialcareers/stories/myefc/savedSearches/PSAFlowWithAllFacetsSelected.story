Meta:
@tag feature:Save Job Alerts

Narrative:
As a jobseeker
I would like to save my job search
So I can be notified about similar jobs by email

Scenario: Save a job search with all refinements selected as an existing user and trigger email. User logs in after refinements have been selected.

Given I want to create a saved search so I can receive similar jobs via email
When I perform job search with keyword <keyword> and location <location>
And I sort by "Location" alphanumerically (A-Z)
And I use specific criteria to narrow my job search <jobSearchCriteria>
And I save this search as <alertName> with notifications set to <notificationInterval>
And I enter <email> and <password> and click on the login button
Then I am taken back to the search results page with my results displayed
When I go to manage my job alerts
Then my search is saved correctly
When I execute the search by clicking on the alert name
Then I am taken back to the search results page with my results displayed
When I trigger the <notificationInterval> PSA mailer for this user only
Then PSA email(s) are sent to my inbox containing jobs posted *(not refreshed)* in the last 24 hours matching my search criteria
When I select "View All New Jobs" in my PSA email
Then I am taken to the SRP with only new jobs displayed

Examples:
|email|password|keyword|location|jobSearchCriteria|alertName|notificationInterval|expectedNumberOfNewJobs|
|test(dataset)@mailinator.com|testing123|(dataset)|London|SrpFormJobAlerts|{random}|Daily|12|


Scenario: Save a job search with all refinements selected as a new user and trigger email. User registers after refinements have been selected.

Given I want to create a saved search so I can receive similar jobs via email
When I perform job search with keyword <keyword> and location <location>
And I use specific criteria to narrow my job search <jobSearchCriteria>
And I save this search as <alertName> with notifications set to <notificationInterval>
And I register a new account
Then I am taken back to the search results page with my results displayed
When I go to manage my job alerts
Then my search is saved correctly
When I execute the search by clicking on the alert name
Then I am taken back to the search results page with my results displayed

Examples:
|keyword|location|jobSearchCriteria|alertName|notificationInterval|
|(dataset)|London|SrpFormJobAlerts|{random}|Daily|



