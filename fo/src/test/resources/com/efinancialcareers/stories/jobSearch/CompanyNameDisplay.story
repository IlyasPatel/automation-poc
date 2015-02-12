Meta:
@tag job search important business rule:SOLR API

Narrative:
As a recruiter
I want to activate several jobs
So I can check the correct company name is being returned from the API

Scenario: Individual job displays NO company or brand name as the job is set to be anonymous in the back-office

Given I activate a job which has been set to *NOT display the company name*
When I go to the job directly (<jobId>)
Then the company name should *NOT* be available and therefore anonymous

Examples:
|jobId|
|6282|

Scenario: Individual job displays *company name* as *NO contact brand name* was ticked in the back-office

Given I activate a job which is not anonymous AND has *NOT* been set to display contact brand name (<jobId>)
When I go to the job directly (<jobId>)
Then the company name should be <companyName>

Examples:
|companyName|jobId|
|Finance|6287|

Scenario: Individual job displays *brand name* as *contact brand name* was ticked in the back-office

Given I activate a job which is not anonymous AND has been set to display contact brand name
When I go to the job directly (<jobId>)
Then the company name should be <companyName>

Examples:
|companyName|jobId|
|Example Company|6290|