Meta:

Narrative:
As a QA
I want to check that related BreadCrumbs are displayed correctly
    for Job link, Sector link and Sector_location link
      |Page type| Template                      |
       -----------------------------------------
      |JOB page | TLKW > Sector > Job Role      |
      |SECTOR   | TLKW > Sector                 |
      |SEC_LOC  | TLKW > Sector > Location      |
       -----------------------------------------

Scenario: Check BreadCrumbs for SECTOR, JOB and SECTOR_LOCATION links

Given I select one of the top "Sectors" link on the homepage
When I check BreadCrumb is correctly displayed for Sector
And I select the first job
And I check BreadCrumb is correctly displayed for Job
And I click "Site Map" link from the footer
And I select first Sector from Site Map
Then I check BreadCrumb is correctly displayed for Sector_Location

