Meta:

Narrative:
As a jobseeker
I would like to register to MyEfc
So that my personal information is secure

Scenario: Verify header counts in the header menu on FO and MyEfc are zero

Given I am a jobseeker on the FO home page
When I click Register from the header menu
And I enter my choice of credentials and click on the register button
Then all the sections in the header menu begin from zero
When I go to FO home page
Then all the sections in the header menu begin from zero