Meta:
@issue ODT0221FO-55,ODT0221FO-469

Narrative:
As a jobseeker
I would like to search for jobs clicking links in the search module on the homepage.

Scenario: Top "Sectors" link returns global jobs for the selected sector. Location has been removed as part of ticket ODT0221FO-55

Given I select one of the top "Sectors" link on the homepage
Then the SRP shows jobs in the selected sector and relevant country

Scenario: Top "Skills" link returns jobs for the selected skill in the default location of this site

Given I select one of the top "Skills" link on the homepage
Then the SRP shows jobs in the selected skill and relevant country

Scenario: Top "Locations" link returns jobs for the selected location

Given I select one of the top "Locations" link on the homepage
Then the SRP shows jobs in the selected location


Scenario: Sector link from "View all" modal returns global jobs for the selected sector. Location has been removed as part of ticket ODT0221FO-55

Given I select one of the Sector links from "View all" modal on the homepage
Then the SRP shows jobs in the selected sector and relevant country

Scenario: Skill link from "View all" modal returns jobs for the selected skill in the default location of the site

Given I select one of the Skill links from "View all" modal on the homepage
Then the SRP shows jobs in the selected skill and relevant country

Scenario: Location link from "View all" modal returns jobs for the selected location.

Given I select one of the Location links from "View all" modal on the homepage
Then the SRP shows jobs in the selected location


Scenario: Sector header link from homepage search module performs Global job search (ODT0221FO-55)

Given I select the "Sectors" header link from the homepage search module
Then the SRP shows Global jobs

Scenario: Skills header link from homepage search module performs search in the default location of this site

Given I select the "Skills" header link from the homepage search module
Then the SRP shows jobs in the selected location

Scenario: Location header link from homepage search module performs search in the default location of this site

Given I select the "Locations" header link from the homepage search module
Then the SRP shows jobs in the selected location