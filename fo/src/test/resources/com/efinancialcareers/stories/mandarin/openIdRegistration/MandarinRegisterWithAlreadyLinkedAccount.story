Meta:

Narrative:
As a QA
I want to check that User is unable to register already linked OpenId account

Scenario: Registration with already linked OpenId account

Given I am a jobseeker on the MyEfc registration page
When I select <provider> then enter <email> and <password> and click login button
Then I am logged in with <displayEmail>

Examples:
|email                              |password       |provider   |displayEmail                   |
|efcusertest@gmail.com              |testing1234$    |Google     |efcusertest@gmail.com         |