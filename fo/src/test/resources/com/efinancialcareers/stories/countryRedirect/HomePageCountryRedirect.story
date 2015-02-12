Meta:
@issue ODT0221-10521

Narrative:
As a jobseeker
I would like the homepage to recognise my country
So I can be prompted to choose the country site I am interested in

Scenario: Country Redirect - Flow 1

Given I am in <country>
When I go to the <siteUri> homepage
Then I do not receive the country picker as this is the default site for my country

Examples:
|country|siteUri|
|US|us-en|

Scenario: Country Redirect - Flow 2

Given I am in <country>
When I go to the <siteUri> homepage
Then I should receive the country picker modal box as this is not the default site for my country
When I select "Remember this site" and continue
Then my site preference is remembered by setting the "countrySelectorModalShown" Cookie on this domain for future visits
When I select the same site again from the the footer
Then I should not receive the country picker again for this session
And my site Cookie preference is removed

Examples:
|country|siteUri|
|US|cn-cn|

Scenario: Country Redirect - Flow 3

Given I am in <country>
When I go to the <siteUri> homepage
Then I should receive the country picker modal box as this is not the default site for my country
When I select "Remember this site" and continue
Then my site preference is remembered by setting the "countrySelectorModalShown" Cookie on this domain for future visits
When I change the site to <siteUri1> from the footer links
Then I should receive the country picker modal box as this is not the default site for my country
When I select "Remember this site" and continue
Then my site preference is remembered by setting the "countrySelectorModalShown" Cookie on this domain for future visits

Examples:
|country|siteUri|siteUri1|
|US|fr-fr|de-de|

Scenario: Country Redirect - Flow 4

Given I am in <country>
When I go to the <siteUri> homepage
Then I should receive the country picker modal box as this is not the default site for my country
When I select "Remember this site" and continue
Then my site preference is remembered by setting the "countrySelectorModalShown" Cookie on this domain for future visits
When I change my site to <siteUri1> from the footer links
Then I should receive the country picker modal box as this is not the default site for my country
When I de-select "Remember this site" and continue
Then my site preference is NOT remembered
When I revisit the <siteUri1> homepage in a new session
Then I should receive the country picker modal box as this is not the default site for my country

Examples:
|country|siteUri|siteUri1|
|US|sg-en|au-en|

Scenario: Country Redirect - Flow 5

Given I am in <country>
When I go to the <siteUri> homepage
Then I should receive the country picker modal box as this is not the default site for my country
When I select "Remember this site" and continue
Then my site preference is remembered by setting the "countrySelectorModalShown" Cookie on this domain for future visits
When I revisit the same site again in a new session
Then I should not receive the country picker as my site cookie preference is set from a previous visit

Examples:
|country|siteUri|
|US|fr-fr|

Scenario: Country Redirect - Flow 6

Given I am in <country>
When I go to the <siteUri> homepage
Then I should receive the country picker modal box as this is not the default site for my country
When I de-select "Remember this site" and continue
Then my site preference is NOT remembered
When I refresh the page
Then I should not receive the country picker again for the current session
When I revisit the same site again in a new session
Then I should receive the country picker modal box as this is not the default site for my country

Examples:
|country|siteUri|
|US|jp-en|

Scenario: Country Redirect - Flow 7

Given I am in <country>
When I go to the <siteUri> SRP page
Then I should not receive the country picker as this is only displayed on the homepage

Examples:
|country|siteUri|
|US|sg-en|

Scenario: Country Redirect - Flow 8

Given I am in <country>
When I go to the <siteUri> homepage
Then I should receive the country picker modal box as this is not the default site for my country
When I change the site to <siteUri1> which also does not belong in my country
And I select "Remember this site" and continue
Then I should receive the country picker modal box as this is not the default site for my country
When I select "Remember this site" and continue
Then my site preference is remembered by setting the "countrySelectorModalShown" Cookie on this domain for future visits
When I revisit the <siteUri> homepage in a new session
Then I am directly taken to <siteUri1>

Examples:
|country|siteUri|siteUri1|
|US|uk-en|ru-en|