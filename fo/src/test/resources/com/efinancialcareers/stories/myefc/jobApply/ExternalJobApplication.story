Meta:
@tag feature:Job Application

Narrative:
As a existing jobseeker
I would like to apply for jobs
So I can earn more money

Scenario: From the SRP, apply for an external job as an existing jobseeker using normal login.

Given I want to apply for a specific job
And the job is external
When I login and expect to be redirected
Then I am shown a redirect page and taken to site <externalSiteUrl> as this is an external job

Examples:
|email|password|externalSiteUrl|
|test(dataset)@mailinator.com|testing123|https://www.google.co.uk/|

Scenario: From the SRP, apply for an external job as a new jobseeker using normal registration.

Given I want to apply for a specific job
And the job is external
When I register a new account to apply for this external job
Then I am shown a redirect page and taken to site <externalSiteUrl> as this is an external job

Examples:
|externalSiteUrl|
|https://www.google.co.uk/|

Scenario: From the OP, apply for an external job as an existing jobseeker using OpenID login.

Given I go to a job directly
When I apply for this external job
And I select <provider> then enter <email> and <password>, click login button and expect to be redirected
Then I am shown a redirect page and taken to site <externalSiteUrl> as this is an external job

Examples:
|provider|email|password|displayEmail|externalSiteUrl|
|Google|timgooauto1@gmail.com|testing123$|timgooauto1@gmail.com|https://www.google.co.uk/|

Scenario: From the OP, apply for an external job as a new jobseeker using OpenID login.

Given I go to a job directly
When I apply for this external job
And then register on eFinancialCareers using an OpenID account
And I select <provider> then enter <email> and <password>, click login button and expect to be redirected
And I create an eFinancialCareers account to complete my registration
Then I am shown a redirect page and taken to site <externalSiteUrl> as this is an external job

Examples:
| provider | email                     | password    | displayEmail              | externalSiteUrl           | openIdIdentifierToSetupTest                           |
| Google  | timTwitterAuto2@gmail.com | testing123$ | timTwitterAuto2@gmail.com | https://www.google.co.uk/ | http://twitter.com/account/profile?user_id=2873511330 |

