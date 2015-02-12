Meta:
@tag feature:Save Job Alerts

Narrative:
As a tester
I would like to save my job search with comma used in a keyword search
So I can be notified about similar jobs by email

Scenario: As a new user, I save a job search with comma used in keyword search. Trigger PSA mailer and check email contains correct number of jobs.

Given I want to create a saved search so I can receive similar jobs via email
When I perform a job search <keyword>
Then {expectedNumberOfJobsFromDataSet} jobs are returned with each one containing at least one of my keywords
When I save this search as <alertName> with notifications set to <notificationInterval>
And I enter <email> and <password> and click on the login button
Then I am taken back to the search results page with my results displayed
And {expectedNumberOfJobsFromDataSet} jobs are returned with each one containing at least one of my keywords
When I trigger the <notificationInterval> PSA mailer for this user only
Then PSA email(s) are sent to my inbox containing jobs posted *(not refreshed)* in the last 24 hours matching my search criteria
And {expectedNumberOfJobsFromDataSet} jobs are in my email with each one containing at least one of my keywords
When I click on "Edit your alert" button
Then I am taken back to the search results page with my results displayed
And {expectedNumberOfJobsFromDataSet} jobs are returned with each one containing at least one of my keywords

Examples:
|email|password|keyword|alertName|notificationInterval|expectedNumberOfJobsFromDataSet|
|test(dataset)@mailinator.com|testing123|(dataset)|Lorem|Daily|4|




