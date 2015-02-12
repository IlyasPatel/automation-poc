Meta:

Narrative:
As a tester
I would like to check that footer links are displaying and go to the correct place

Scenario: Check footer links

Given I am a jobseeker on the FO home page
When I click "Site Map" link from the footer
Then I am taken to the "Site Map" page
When I go to FO home page
And I click "Job Search" from the footer
Then I am taken to search results page
When I go to FO home page
And I click "Candidate Sign In" from the footer
Then I am taken to the login page
When I click "IT Finance" from the footer
Then the search results page is displayed with sector IT Finance
And there are thirteen links in the Footer