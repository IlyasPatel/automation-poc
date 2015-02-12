Meta:

Narrative:
As a tester
I would like to confirm HTML meta tags are correct.

----------------------------------------------------------------------------------
|description | <meta name="description" content="...                             |
----------------------------------------------------------------------------------
|JOB         | Company, Location job: Apply for Job Title in Company, Location.  |
|            | Sector jobs available with Efinancialcareers.                     |
----------------------------------------------------------------------------------
|SEC_LOC     | Sector jobs in Location - Count jobs in Sector, Location.         |
|            | Latest job posted on Date. Read job details before applying       |
----------------------------------------------------------------------------------

Scenario: Confirm meta tag is correct on the job Overview Page.

Given I am a jobseeker on the FO home page
When I select one of the top Sector links
And I select the first job
Then I check Meta Tag is correct for Job

Scenario: Confirm meta tag is correct on the SRP.

Given I am a jobseeker on the Site Map page
When I select any one of the <linkType> links to view jobs in this sector
Then I check Meta Tag is correct for Sector Location

Examples:
|linkType|
|SECTOR|