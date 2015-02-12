Meta:
@tag job search:job overview page

Narrative:
As a job seeker
I would like to view the company details of a job
So that I can find out more information about the company

Scenario: Confirming all company information is displayed in the expected areas.

Given I want to view the company information for a job
When I perform a job search <keyword>
And refine by the company I am interested in <brandName>
And select the job I am interested in
Then the correct company information should be displayed

Examples:
|keyword|brandName|contactFirstName|contactLastName|contactEmail|contactPhone|contactFax|contactAddress1|contactURL|
|(dataset)|Finance Automation|Contact First Name|Contact Last Name|contactEmail@mailinator.com|0207-888-8888|0207-888-9999|Fifth FloorTelephone House69-77 Paul Street EC2A 4NW London EnglandUK|http://www.efinancialcareers.com|

Scenario: Confirming the job is anonymous on SRP and OP. Confirm there is no link to view all jobs by this company.

Given I want to view a job where the company information is set as anonymous
When I perform a job search <keyword>
And select "Include non-disclosed companies"
And select the anonymous job I am interested in
Then the company information should NOT be displayed
And there should be no link to view all jobs by this company

Examples:
|keyword|
|(dataset)|

Scenario: Confirm the "View All Jobs" link takes a jobseeker to all jobs by this company. Also paginate through some of these jobs via Job Overview Page

Given I go to a job directly
When I would like to view all jobs by this brand
Then the SRP displays jobs only for this brand
When I select the last job and then use the "Previous" link to peruse through the jobs
Then the jobs displayed should only be from <brandName>

Examples:
|brandName|
|Finance Automation|