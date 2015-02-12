Meta:
@tag feature:OpenId Registration

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
Flow 1 is flawed as the user never created a password for their eFinancialCareers account so they can only login with their OpenId details. The purpose of creating an eFinancialCareers account is to create a record in the Jobseeker table.

Scenario: Flow 1. Confirm OpenId registration. OpenId provider DOES NOT return an email address during registration, therefore, the jobseeker is asked to enter a new eFinancialCareers email address in order for us to create a jobseeker record.

Given I am a jobseeker on the MyEfc registration page
And I register for the first time using my OpenId account
When I select <provider> then enter <email> and <password> and click login button
And I create an eFinancialCareers account to complete my registration by entering my email
Then I am logged in as an unverified eFinancialCareers user, OpenId login is fine

Examples:
| email                   | password    | provider  | openIdIdentifierToSetupTest                  |
| timHotAuto3@hotmail.com | testing124$ | Microsoft | http://cid-2cccf2f00731394d.spaces.live.com/ |

Scenario: Flow 2. Confirm OpenId registration. OpenId provider DOES return an email address during registration, therefore, the jobseeker record is automatically created.

Given I am a jobseeker on the MyEfc registration page
And I register for the first time using my OpenId account
When I select <provider> then enter <email> and <password> and click login button
And I create an eFinancialCareers account to complete my registration
Then I am logged in

Examples:
| email                 | password    | provider | openIdIdentifierToSetupTest                           |
| timgooauto3@gmail.com | testing123$ | Google   | https://www.google.com/profiles/112040707768620661312 |

Scenario: Confirm registration page DOES NOT change when a jobseeker fails to register using their OpenId account. A negative flow.

Given I am a jobseeker on the MyEfc registration page
When I select <provider> then enter <email> and <password> and click login button
Then I am still on registration page

Examples:
| email                 | password         | provider |
| timgooauto1@gmail.com | Wrongtesting123$ | Google   |

Scenario: Confirm registration fails when attempting to link an account using invalid eFinancialCareers password. A negative flow.

Given I am a jobseeker on the MyEfc registration page
And I register using my OpenId account although my email already exists on the eFinancialCareers database as I have registered before
When I select <provider> then enter <email> and <password> and click login button
And I enter an invalid eFinancialCareers password when attempting to link my account
Then login should be unsuccessful

Examples:
| email                 | password    | provider | invalidPassword    |
| timgooauto2@gmail.com | testing123$ | Google   | invalidPassword123 |

Scenario: Confirm registration fails when attempting to create an eFinancialCareers account using an email address which is already in use by another jobseeker. A negative flow.

Given I am a jobseeker on the MyEfc registration page
And I register using my OpenId account although my email already exists on the eFinancialCareers database as I have registered before
When I select <provider> then enter <email> and <password> and click login button
And I enter an email which is already in use by another jobseeker
Then I am told that the Email address is already in use

Examples:
| email                   | password    | provider  | invalidEmail      |
| timHotAuto2@hotmail.com | testing123$ | Microsoft | selusr01@dice.com |

