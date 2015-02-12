Meta:

Narrative:
As a tester
I would like to check that its not possible to change account email to one that already exists for another MyEfc User

Scenario: Update MyEfc Account to email already in use

Given I directly go to the account settings URL and successfully login with <email> and <password>
When I update my email to <updatedEmail> which already in use
Then I am notified that this email address is already registered with another account

Examples:
|email|password|updatedEmail|
|test(dataset)@mailinator.com|testing123|jneville@efinancialcareers.com|