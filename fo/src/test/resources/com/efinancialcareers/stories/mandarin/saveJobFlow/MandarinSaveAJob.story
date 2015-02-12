Meta:
@tag feature:Save a Job

Narrative:
As a job seeker
I want to save jobs I am interested
So that I can apply for them later
(投资经理 = investment manager, 上海 = Shanghai)

Scenario: A new jobseeker who is not logged in, is able to save a job from SRP.

Given I perform a job search and narrow my search using the refine rail
When I click on the "Save" button on the SRP
And then register on eFinancialCareers
Then I am taken back to the search results page with my results displayed
And the job I saved has now got the option to "Unsave" on the SRP
When I go to Saved Jobs page in MyEfc
Then my job is saved in my account
When I select the "Delete" button to delete my saved job
Then my job is deleted

Examples:
|keyword|location|jobSearchCriteria|
|投资经理|上海|SrpFormStandardJobSearchMandarin|

Scenario: An existing jobseeker who is not logged in, is able to save a job from SRP.

Given I perform a job search and narrow my search using the refine rail
When I click on the "Save" button on the SRP
And I successfully login with <email> and <password>
Then I am taken back to the search results page with my results displayed
And the job I saved has now got the option to "Unsave" on the SRP

Examples:
|email|password|keyword|location|jobSearchCriteria|
|selusr01@dice.com|selusr123|投资经理|上海|SrpFormStandardJobSearchMandarin|

Scenario: A new jobseeker who is not logged in, is able to save a job using their Open Id account from OP.

Given I find a job I am interested in
When I select the first job
And I click on the "Save" button on the OP
And then register on eFinancialCareers using an OpenID account
And I select <provider> then enter <email> and <password> and click login button
And I create an eFinancialCareers account
Then the job I saved has now got the option to "Unsave" on the OP

Examples:
|email|password|provider|keyword|location|jobSearchCriteria|
|testmyefc@gmail.com|Password_987|Google|java|London|SrpFormStandardJobSearchMandarin|

Scenario: An existing jobseeker who is not logged in, is able to save a job using their Open Id account from OP.

Given I find a job I am interested in
When I select the first job
And I click on the "Save" button on the OP
And I select <provider> then enter <email> and <password> and click login button
Then the job I saved has now got the option to "Unsave" on the OP

Examples:
|provider|email|password|
|Google|timgooauto1|testing123$|