Meta:

Narrative:
As a QA
I want to check that related tooltip is displayed if user hover with mouse
    over Job link, Sector link and Sector_location link
      |Page type| Template                      |
       -----------------------------------------
      |JOB      | Job Title in Company, Location|
      |SECTOR   | Sector jobs                   |
      |SEC_LOC  | Sector jobs in Location       |
       -----------------------------------------

Scenario: Check tooltips for SECTOR and JOB links

Given I am a jobseeker on the FO home page
When I check tooltip for random top sector
And I check tooltip for random sector on All sectors dialog
And I select defined link from View all modal
Then I check tooltip of first Job on SRP
