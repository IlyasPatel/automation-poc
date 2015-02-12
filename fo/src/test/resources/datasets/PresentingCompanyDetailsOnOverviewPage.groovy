package datasets

import org.apache.commons.lang.RandomStringUtils

putDataset("MyEfcLiveJobsWithUser") {

    def random = RandomStringUtils.randomAlphabetic(10);

    final Calendar jobAllocationStartDate1 = Calendar.getInstance();
    final Calendar jobAllocationStartDate2 = Calendar.getInstance();
    final Calendar jobAllocationStartDate3 = Calendar.getInstance();
    final Calendar jobAllocationStartDate4 = Calendar.getInstance();
    final Calendar jobAllocationStartDate5 = Calendar.getInstance();
    final Calendar jobAllocationStartDate6 = Calendar.getInstance();
    final Calendar jobAllocationStartDate7 = Calendar.getInstance();
    final Calendar jobAllocationStartDate8 = Calendar.getInstance();
    final Calendar jobAllocationStartDate9 = Calendar.getInstance();
    final Calendar jobAllocationStartDate10 = Calendar.getInstance();
    final Calendar jobAllocationStartDate11 = Calendar.getInstance();

    final Calendar jobAllocationExpirationDate1 = Calendar.getInstance();
    final Calendar jobAllocationExpirationDate2 = Calendar.getInstance();
    final Calendar jobAllocationExpirationDate3 = Calendar.getInstance();
    final Calendar jobAllocationExpirationDate4 = Calendar.getInstance();
    final Calendar jobAllocationExpirationDate5 = Calendar.getInstance();
    final Calendar jobAllocationExpirationDate6 = Calendar.getInstance();
    final Calendar jobAllocationExpirationDate7 = Calendar.getInstance();
    final Calendar jobAllocationExpirationDate8 = Calendar.getInstance();
    final Calendar jobAllocationExpirationDate9 = Calendar.getInstance();
    final Calendar jobAllocationExpirationDate10 = Calendar.getInstance();
    final Calendar jobAllocationExpirationDate11 = Calendar.getInstance();

    jobAllocationStartDate1.add(Calendar.HOUR, -2);
    jobAllocationStartDate2.add(Calendar.DAY_OF_MONTH, -1);
    jobAllocationStartDate3.add(Calendar.DAY_OF_MONTH, -4);
    jobAllocationStartDate4.add(Calendar.DAY_OF_MONTH, -5);
    jobAllocationStartDate5.add(Calendar.DAY_OF_MONTH, -6);
    jobAllocationStartDate6.add(Calendar.DAY_OF_MONTH, -7);
    jobAllocationStartDate7.add(Calendar.HOUR, -8);
    jobAllocationStartDate8.add(Calendar.DAY_OF_MONTH, -9);
    jobAllocationStartDate9.add(Calendar.DAY_OF_MONTH, -13);
    jobAllocationStartDate10.add(Calendar.HOUR, -3);
    jobAllocationStartDate11.add(Calendar.HOUR, -3);

    jobAllocationExpirationDate1.add(Calendar.DAY_OF_MONTH, 1);
    jobAllocationExpirationDate2.add(Calendar.MONTH, 2);
    jobAllocationExpirationDate3.add(Calendar.WEEK_OF_MONTH, 1);
    jobAllocationExpirationDate4.add(Calendar.DAY_OF_MONTH, 4);
    jobAllocationExpirationDate5.add(Calendar.MONTH, 5);
    jobAllocationExpirationDate6.add(Calendar.DAY_OF_MONTH, 6);
    jobAllocationExpirationDate7.add(Calendar.MONTH, 7);
    jobAllocationExpirationDate8.add(Calendar.DAY_OF_MONTH, 8);
    jobAllocationExpirationDate9.add(Calendar.MONTH, 9);
    jobAllocationExpirationDate10.add(Calendar.DAY_OF_MONTH, 1);
    jobAllocationExpirationDate11.add(Calendar.MONTH, 11);

    Job(uid: "Job1UID", positionType: "PERMANENT",
            employmentType: "PART_TIME",
            currency: "GBP",
            yearsExperience: "THREE_FIVE_YEARS_EXPERIENCE",
            salaryBand: "FIRST_TIER",
            jobReference: "${random}",
            jobApplicationMethod: "BACK_OFFICE",
            externalApplicationURL: "http://www.google.co.uk",
            autoReply: true,
            screenQuestionary: false,
            locationId: "2643743",
            dbCompanyName: "Demo Finance",
            dbUserEmail: "automation1@mailinator.com",
            dbBrandName: "Finance Automation")
            {
                contactDetails(
                        contactFirstName: "Contact First Name",
                        contactLastName: "Contact Last Name",
                        contactEmail: "contactEmail@mailinator.com",
                        contactPhone: "0207-888-8888",
                        contactFax: "0207-888-9999",
                        contactCompanyName: "My contact company",
                        contactAddress1: "Fifth Floor, Telephone House, 69-77 Paul Street",
                        contactAddress2: "address2",
                        contactAddress3: "address3",
                        contactCity: "London",
                        contactRegion: "Contact Region",
                        contactPostCode: "EC2A 4NW",
                        contactCountry: "England, UK",
                        contactURL: "http://www.efinancialcareers.com",
                        displayContactFirstName: true,
                        displayContactLastName: true,
                        displayContactEmail: true,
                        displayContactPhone: true,
                        displayContactFax: true,
                        displayContactCompanyName: true,
                        displayContactAddress1: true,
                        displayContactAddress2: true,
                        displayContactAddress3: true,
                        displayContactCity: true,
                        displayContactRegion: true,
                        displayContactPostCode: true,
                        displayContactCountry: true,
                        displayContactURL: true,
                        displayContactBrandImage: true,
                        hideContactDetails: false
                )
                primarySector(
                        sectorCode: "ACCOUNTING_FINANCE",
                        subSectorCode: "ACCOUNTING_FINANCE__AUDIT"
                )
                secondarySector(
                        sectorCode: "ACCOUNTING_FINANCE",
                        subSectorCode: "ACCOUNTING_FINANCE__FD_CFO"
                )
                tertiarySector(
                        sectorCode: "ACCOUNTING_FINANCE",
                        subSectorCode: "ACCOUNTING_FINANCE__FINANCIAL_ADVISORY_SERVICES"
                )
                defaultDescription(
                        title: "CIB – F&BM – Business Manager – Associate/VP – Global Credit Markets - London ${random}",
                        description: "We are looking for a newly qualified ACA candidate with Financial Services audit experience to join Collateral Optimisation Product Control. This person will become a key member of the team, liaising regularly with members of the FO, Finance, Risk and other areas within the bank.",
                        summary: "default summary job ${random}",
                        salaryDescription: "45,000 - 65,000 ${random}",
                        workPermitRequirements: "default perm requirements job ${random}",
                        languageCode: "EN"
                )

            }

    JobAllocation(uid: "JobAllocation1UID",
            startDate: jobAllocationStartDate1.getTime(),
            expirationDate: jobAllocationExpirationDate1.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job1UID")

    }

    Job(uid: "Job2UID", positionType: "PERMANENT",
            employmentType: "PART_TIME",
            currency: "GBP",
            yearsExperience: "THREE_FIVE_YEARS_EXPERIENCE",
            salaryBand: "FIRST_TIER",
            jobReference: "${random}",
            jobApplicationMethod: "BACK_OFFICE",
            externalApplicationURL: "http://www.google.co.uk",
            autoReply: true,
            screenQuestionary: false,
            locationId: "2643743",
            dbCompanyName: "Demo Finance",
            dbUserEmail: "automation1@mailinator.com",
            dbBrandName: "Finance Automation")
            {
                contactDetails(
                        contactFirstName: "Contact First Name",
                        contactLastName: "Contact Last Name",
                        contactEmail: "contactEmail@mailinator.com",
                        contactPhone: "0207-888-8888",
                        contactFax: "0207-888-9999",
                        contactCompanyName: "My contact company",
                        contactAddress1: "Fifth Floor, Telephone House, 69-77 Paul Street",
                        contactAddress2: "address2",
                        contactAddress3: "address3",
                        contactCity: "London",
                        contactRegion: "Contact Region",
                        contactPostCode: "EC2A 4NW",
                        contactCountry: "England, UK",
                        contactURL: "http://www.efinancialcareers.com",
                        displayContactFirstName: true,
                        displayContactLastName: true,
                        displayContactEmail: true,
                        displayContactPhone: true,
                        displayContactFax: true,
                        displayContactCompanyName: true,
                        displayContactAddress1: true,
                        displayContactAddress2: true,
                        displayContactAddress3: true,
                        displayContactCity: true,
                        displayContactRegion: true,
                        displayContactPostCode: true,
                        displayContactCountry: true,
                        displayContactURL: true,
                        displayContactBrandImage: true,
                        hideContactDetails: true
                )
                primarySector(
                        sectorCode: "ACCOUNTING_FINANCE",
                        subSectorCode: "ACCOUNTING_FINANCE__AUDIT"
                )
                secondarySector(
                        sectorCode: "ACCOUNTING_FINANCE",
                        subSectorCode: "ACCOUNTING_FINANCE__FD_CFO"
                )
                tertiarySector(
                        sectorCode: "ACCOUNTING_FINANCE",
                        subSectorCode: "ACCOUNTING_FINANCE__FINANCIAL_ADVISORY_SERVICES"
                )
                defaultDescription(
                        title: "Anonymous Test Job 2",
                        description: "We are looking for a newly qualified ACA candidate with Financial Services audit experience to join Collateral Optimisation Product Control. This person will become a key member of the team, liaising regularly with members of the FO, Finance, Risk and other areas within the bank.",
                        summary: "default summary job ${random}",
                        salaryDescription: "45,000 - 65,000 ${random}",
                        workPermitRequirements: "default perm requirements job ${random}",
                        languageCode: "EN"
                )

            }

    JobAllocation(uid: "JobAllocation2UID",
            startDate: jobAllocationStartDate2.getTime(),
            expirationDate: jobAllocationExpirationDate2.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job2UID")
    }

    Job(uid: "Job3UID", positionType: "PERMANENT",
            employmentType: "PART_TIME",
            currency: "GBP",
            yearsExperience: "THREE_FIVE_YEARS_EXPERIENCE",
            salaryBand: "FIRST_TIER",
            jobReference: "${random}",
            jobApplicationMethod: "BACK_OFFICE",
            externalApplicationURL: "http://www.google.co.uk",
            autoReply: true,
            screenQuestionary: false,
            locationId: "2643743",
            dbCompanyName: "Demo Finance",
            dbUserEmail: "automation1@mailinator.com",
            dbBrandName: "Finance Automation")
            {
                contactDetails(
                        contactFirstName: "Contact First Name",
                        contactLastName: "Contact Last Name",
                        contactEmail: "contactEmail@mailinator.com",
                        contactPhone: "0207-888-8888",
                        contactFax: "0207-888-9999",
                        contactCompanyName: "My contact company",
                        contactAddress1: "Fifth Floor, Telephone House, 69-77 Paul Street",
                        contactAddress2: "address2",
                        contactAddress3: "address3",
                        contactCity: "London",
                        contactRegion: "Contact Region",
                        contactPostCode: "EC2A 4NW",
                        contactCountry: "England, UK",
                        contactURL: "http://www.efinancialcareers.com",
                        displayContactFirstName: true,
                        displayContactLastName: true,
                        displayContactEmail: true,
                        displayContactPhone: true,
                        displayContactFax: true,
                        displayContactCompanyName: true,
                        displayContactAddress1: true,
                        displayContactAddress2: true,
                        displayContactAddress3: true,
                        displayContactCity: true,
                        displayContactRegion: true,
                        displayContactPostCode: true,
                        displayContactCountry: true,
                        displayContactURL: true,
                        displayContactBrandImage: true,
                        hideContactDetails: false
                )
                primarySector(
                        sectorCode: "ACCOUNTING_FINANCE",
                        subSectorCode: "ACCOUNTING_FINANCE__AUDIT"
                )
                secondarySector(
                        sectorCode: "ACCOUNTING_FINANCE",
                        subSectorCode: "ACCOUNTING_FINANCE__FD_CFO"
                )
                tertiarySector(
                        sectorCode: "ACCOUNTING_FINANCE",
                        subSectorCode: "ACCOUNTING_FINANCE__FINANCIAL_ADVISORY_SERVICES"
                )
                defaultDescription(
                        title: "Global Credit Markets London ${random}",
                        description: "We are looking for a newly qualified ACA candidate with Financial Services audit experience to join Collateral Optimisation Product Control. This person will become a key member of the team, liaising regularly with members of the FO, Finance, Risk and other areas within the bank.",
                        summary: "default summary job ${random}",
                        salaryDescription: "45,000 - 65,000 ${random}",
                        workPermitRequirements: "default perm requirements job ${random}",
                        languageCode: "EN"
                )

            }

    JobAllocation(uid: "JobAllocation3UID",
            startDate: jobAllocationStartDate3.getTime(),
            expirationDate: jobAllocationExpirationDate3.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job3UID")

    }
}

