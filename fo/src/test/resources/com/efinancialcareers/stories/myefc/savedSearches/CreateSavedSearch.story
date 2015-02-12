Meta:
@tag feature:Save New Job Alert

Narrative:
As a jobseeker
I would like to save my search
So I can be notified of similar jobs in the future

Scenario: An existing jobseeker who is not logged in, saves a job alert using their Open ID account.

Given I want to create a saved search so I can view similar jobs later
When I perform job search with keyword <keyword> and location <location>
And I save this search as <alertName> with notifications set to <notificationInterval>
And I select <provider> then enter <email> and <password> and click login button
Then I am taken back to the search results page with my results displayed
When I directly go to the saved searches URL
Then I can see my saved search at the top of page 1

Examples:
|provider|email|password|keyword|location|alertName|notificationInterval|
|Google|timgooauto1@gmail.com|testing123$|project manager|London|{random}|Daily|

Scenario: An existing jobseeker who is not logged in, saves a job alert.

Given I want to create a saved search so I can view similar jobs later
When I perform job search with keyword <keyword> and location <location>
And I save this search as <alertName> with notifications set to <notificationInterval>
And I enter <email> and <password> and click on the login button
Then I am taken back to the search results page with my results displayed
When I directly go to the saved searches URL
Then I can see my saved search at the top of page 1

Examples:
|email|password|keyword|location|alertName|notificationInterval|
|selusr01@dice.com|selusr123|t&a technology|london|{random}|Daily|

Scenario: A new jobseeker who is not logged in, saves a job alert.

Given I want to create a saved search so I can view similar jobs later
When I perform job search with keyword <keyword> and location <location>
And I save this search as <alertName> with notifications set to <notificationInterval>
And I register a new account
Then I am taken back to the search results page with my results displayed
When I directly go to the saved searches URL
Then I can see my saved search at the top of page 1
When I remove all my job alerts using the bulk delete option
Then I have no job alerts

Examples:
|keyword|location|alertName|notificationInterval|
|scrum|London|{random}|Daily|

Scenario: A new jobseeker who is not logged in, saves a job alert using their OpenID account.

Given I want to create a saved search so I can view similar jobs later
When I perform job search with keyword <keyword> and location <location>
And I save this search as <alertName> with notifications set to <notificationInterval>
And then register on eFinancialCareers using an OpenID account
And I select <provider> then enter <email> and <password> and click login button
And I create an eFinancialCareers account
Then I am taken back to the search results page with my results displayed
When I directly go to the saved searches URL
Then I can see my saved search at the top of page 1
When I select the "Delete" button to remove this saved job alert
Then I have no job alerts

Examples:
|provider|email|password|keyword|location|alertName|notificationInterval|
|Google|timgooauto4@gmail.com|testing123$|java|London|{random}|Daily|