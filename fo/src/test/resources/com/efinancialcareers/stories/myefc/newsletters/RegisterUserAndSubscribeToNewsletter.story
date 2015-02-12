Meta:

Narrative:
As a jobseeker
I want to subscribe to newsletter for the country site I am on
and subscribe to all other messages
So that I can be kept up-to-date with the latest news

Scenario: Subscribe to newsletters and other messages via normal registration.

Given I am a jobseeker on the MyEfc registration page
When I select the option to "Receive other relevant career related info and highlights from selected companies"
And I select the option to "Receive eFinancialCareers newsletter(s)"
And I enter my choice of credentials and click on the register button
Then I am subscribed to the correct newsletter for the country site I am in
And I am subscribed to receive internal eFinancialCareers messages
And I am subscribed to receive third party messages
And my preferred email format is HTML by default

Scenario: Subscribe to newsletters and other messages via OpenId registration.

Given I am a jobseeker on the MyEfc registration page
And I register for the first time using my OpenId account
When I select <provider> then enter <email> and <password> and click login button
And I select the option to "Receive eFinancialCareers newsletter(s)"
And I select the option to "Receive other relevant career related info and highlights from selected companies"
And I create an eFinancialCareers account
Then I am subscribed to the correct newsletter for the country site I am in
And I am subscribed to receive internal eFinancialCareers messages
And I am subscribed to receive third party messages
And my preferred email format is HTML by default

Examples:
|email|password|provider|openIdIdentifierToSetupTest|
|timgooauto5@gmail.com|testing123$|Google|https://www.google.com/profiles/108936653061949037169|
