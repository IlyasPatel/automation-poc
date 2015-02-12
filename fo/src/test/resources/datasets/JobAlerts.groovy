package datasets

import com.efinancialcareers.core.domain.bean.enums.EntityStatus
import com.efinancialcareers.core.domain.bean.enums.FileFormat
import com.efinancialcareers.core.domain.bean.enums.Title
import com.efinancialcareers.core.domain.bean.enums.YearsExperience
import com.efinancialcareers.myefc.qa.utils.fo.FoPropertiesLoader
import org.apache.commons.lang.RandomStringUtils

putDataset("MyEfcLiveJobsWithUser") {

    def random = RandomStringUtils.randomAlphabetic(10);

    final Calendar jobRefreshDate1 = Calendar.getInstance();
    jobRefreshDate1.add(Calendar.HOUR, -2);

    final Calendar jobAllocationStartDate = Calendar.getInstance();
    final Calendar jobAllocationExpirationDate = Calendar.getInstance();

    jobAllocationStartDate.add(Calendar.DAY_OF_MONTH, -8);
    jobAllocationExpirationDate.add(Calendar.DAY_OF_MONTH, 1);




    final Calendar jobAllocationStartDate2 = Calendar.getInstance();
    final Calendar jobAllocationExpirationDate2 = Calendar.getInstance();

    jobAllocationStartDate2.add(Calendar.HOUR, -2);
    jobAllocationExpirationDate2.add(Calendar.DAY_OF_MONTH, 1);

    Job(uid: "Job1UID",
            positionType: "PERMANENT",
            employmentType: "FULL_TIME",
            currency: "GBP",
            salaryBand: "SECOND_TIER",
            jobReference: "${random}",
            jobApplicationMethod: "BACK_OFFICE",
            autoReply: true,
            screenQuestionary: false,
            refresh: jobRefreshDate1.getTime(),
            locationId: "2643743",
            dbCompanyName: "Demo Finance",
            dbUserEmail: "automation1@mailinator.com",
            dbBrandName: "Finance Automation")
            {
                contactDetails(
                        contactFirstName: "Contact First Name",
                        contactLastName: "Contact Last Name",
                        contactEmail: "contactEmail@mailinator.com",
                        contactPhone: "888-888-8888",
                        contactFax: "888-888-8888",
                        contactCompanyName: "A company name",
                        contactAddress1: "address1",
                        contactAddress2: "address2",
                        contactAddress3: "address3",
                        contactCity: "city",
                        contactRegion: "region",
                        contactPostCode: "22201",
                        contactCountry: "USA",
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
                        sectorCode: "FX_MONEY_MARKETS",
                        subSectorCode: "FX_MONEY_MARKETS__SALES_TRADING"
                )
                defaultDescription(
                    title: "Job title 1. Automation Job for job alerts. ${random}",
                    description: "Job description - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    summary: "Job summary. Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                    salaryDescription: "Free text field - 45,000 - 65,000",
                    workPermitRequirements: "Free text field - Work permit requirements",
                    languageCode: "EN"
                )
            }

    JobAllocation(uid: "JobAllocation1UID",
            startDate: jobAllocationStartDate.getTime(),
            expirationDate: jobAllocationExpirationDate.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job1UID")
    }

    Job(uid: "Job2UID", positionType: "PERMANENT",
            employmentType: "FULL_TIME",
            currency: "GBP",
            salaryBand: "THIRD_TIER",
            jobReference: "${random}",
            jobApplicationMethod: "BACK_OFFICE",
            autoReply: true,
            screenQuestionary: false,
            locationId: "2643743",
            dbCompanyName: "Demo Finance",
            dbUserEmail: "automation1@mailinator.com",
            dbBrandName: "Finance Automation")
            {
                contactDetails(
                        contactFirstName: "fname",
                        contactLastName: "lname",
                        contactEmail: "email@test.com",
                        contactPhone: "888-888-8888",
                        contactFax: "888-888-8888",
                        contactCompanyName: "Z company name",
                        contactAddress1: "address1",
                        contactAddress2: "address2",
                        contactAddress3: "address3",
                        contactCity: "city",
                        contactRegion: "region",
                        contactPostCode: "22201",
                        contactCountry: "USA",
                        contactURL: "http://www.efinancialcareers.com",
                        displayContactFirstName: true,
                        displayContactLastName: true,
                        displayContactEmail: false,
                        displayContactPhone: false,
                        displayContactFax: false,
                        displayContactCompanyName: true,
                        displayContactAddress1: true,
                        displayContactAddress2: true,
                        displayContactAddress3: false,
                        displayContactCity: true,
                        displayContactRegion: false,
                        displayContactPostCode: true,
                        displayContactCountry: false,
                        displayContactURL: true,
                        displayContactBrandImage: false,
                        hideContactDetails: false
                )
                primarySector(
                        sectorCode: "FX_MONEY_MARKETS",
                        subSectorCode: "FX_MONEY_MARKETS__SALES_TRADING"
                )
                secondarySector(
                        sectorCode: "GLOBAL_CUSTODY",
                        subSectorCode: "GLOBAL_CUSTODY__SALES_MARKETING"
                )
                tertiarySector(
                        sectorCode: "HEDGE_FUNDS",
                        subSectorCode: "HEDGE_FUNDS__RISK_MANAGEMENT"
                )
                defaultDescription(
                    title: "Job title 2. Automation Job for job alerts. ${random}",
                    description: "Job description - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    summary: "Job summary. Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                    salaryDescription: "Free text field - 45,000 - 65,000",
                    workPermitRequirements: "Free text field - Work permit requirements",
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

    Job(uid: "Job3UID", positionType: "CONTRACT",
            employmentType: "FULL_TIME",
            currency: "GBP",
            salaryBand: "THIRD_TIER",
            jobReference: "${random}",
            jobApplicationMethod: "BACK_OFFICE",
            autoReply: true,
            screenQuestionary: false,
            locationId: "2643743",
            dbCompanyName: "Demo Finance",
            dbUserEmail: "automation1@mailinator.com",
            dbBrandName: "Finance Automation")
            {
                contactDetails(
                        contactFirstName: "fname",
                        contactLastName: "lname",
                        contactEmail: "email@test.com",
                        contactPhone: "888-888-8888",
                        contactFax: "888-888-8888",
                        contactCompanyName: "B company name",
                        contactAddress1: "address1",
                        contactAddress2: "address2",
                        contactAddress3: "address3",
                        contactCity: "city",
                        contactRegion: "region",
                        contactPostCode: "22201",
                        contactCountry: "USA",
                        contactURL: "http://www.efinancialcareers.com",
                        displayContactFirstName: true,
                        displayContactLastName: true,
                        displayContactEmail: false,
                        displayContactPhone: false,
                        displayContactFax: false,
                        displayContactCompanyName: true,
                        displayContactAddress1: true,
                        displayContactAddress2: true,
                        displayContactAddress3: false,
                        displayContactCity: true,
                        displayContactRegion: false,
                        displayContactPostCode: true,
                        displayContactCountry: false,
                        displayContactURL: true,
                        displayContactBrandImage: false,
                        hideContactDetails: false
                )
                primarySector(
                        sectorCode: "CAPITAL_MARKETS",
                        subSectorCode: "CAPITAL_MARKETS__EXECUTION"
                )
                secondarySector(
                        sectorCode: "COMPLIANCE_LEGAL",
                        subSectorCode: "COMPLIANCE_LEGAL__IN_HOUSE_LEGAL"
                )
                tertiarySector(
                        sectorCode: "DEBT_FIXED_INCOME",
                        subSectorCode: "DEBT_FIXED_INCOME__SALES_TRADING"
                )
                defaultDescription(
                    title: "Job title 3. Automation Job for job alerts. ${random}",
                    description: "Job description - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    summary: "Job summary. Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                    salaryDescription: "Free text field - 45,000 - 65,000",
                    workPermitRequirements: "Free text field - Work permit requirements",
                    languageCode: "EN"
                )
            }

    JobAllocation(uid: "JobAllocation3UID",
            startDate: jobAllocationStartDate2.getTime(),
            expirationDate: jobAllocationExpirationDate2.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job3UID")
    }

    Job(uid: "Job4UID", positionType: "TEMPORARY",
            employmentType: "FULL_TIME",
            currency: "GBP",
            salaryBand: "SECOND_TIER",
            jobReference: "${random}",
            jobApplicationMethod: "BACK_OFFICE",
            autoReply: true,
            screenQuestionary: false,
            locationId: "2643743",
            dbCompanyName: "Demo Finance",
            dbUserEmail: "automation1@mailinator.com",
            dbBrandName: "Finance Automation")
            {
                contactDetails(
                        contactFirstName: "fname",
                        contactLastName: "lname",
                        contactEmail: "email@test.com",
                        contactPhone: "888-888-8888",
                        contactFax: "888-888-8888",
                        contactCompanyName: "BZ company name",
                        contactAddress1: "address1",
                        contactAddress2: "address2",
                        contactAddress3: "address3",
                        contactCity: "city",
                        contactRegion: "region",
                        contactPostCode: "22201",
                        contactCountry: "USA",
                        contactURL: "http://www.efinancialcareers.com",
                        displayContactFirstName: true,
                        displayContactLastName: true,
                        displayContactEmail: false,
                        displayContactPhone: false,
                        displayContactFax: false,
                        displayContactCompanyName: true,
                        displayContactAddress1: true,
                        displayContactAddress2: true,
                        displayContactAddress3: false,
                        displayContactCity: true,
                        displayContactRegion: false,
                        displayContactPostCode: true,
                        displayContactCountry: false,
                        displayContactURL: true,
                        displayContactBrandImage: false,
                        hideContactDetails: false
                )
                primarySector(
                        sectorCode: "FX_MONEY_MARKETS",
                        subSectorCode: "FX_MONEY_MARKETS__SALES_TRADING"
                )
                secondarySector(
                        sectorCode: "COMPLIANCE_LEGAL",
                        subSectorCode: "COMPLIANCE_LEGAL__IN_HOUSE_LEGAL"
                )
                tertiarySector(
                        sectorCode: "HEDGE_FUNDS",
                        subSectorCode: "HEDGE_FUNDS__RISK_MANAGEMENT"
                )
                defaultDescription(
                    title: "Job title 4. Automation Job for job alerts. ${random}",
                    description: "Job description - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    summary: "Job summary. Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                    salaryDescription: "Free text field - 45,000 - 65,000",
                    workPermitRequirements: "Free text field - Work permit requirements",
                    languageCode: "EN"
                )
            }

    JobAllocation(uid: "JobAllocation4UID",
            startDate: jobAllocationStartDate2.getTime(),
            expirationDate: jobAllocationExpirationDate2.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job4UID")
    }

    Job(uid: "Job5UID", positionType: "TEMPORARY",
            employmentType: "FULL_TIME",
            currency: "GBP",
            salaryBand: "SECOND_TIER",
            jobReference: "${random}",
            jobApplicationMethod: "BACK_OFFICE",
            autoReply: true,
            screenQuestionary: false,
            locationId: "2643743",
            dbCompanyName: "Demo Finance",
            dbUserEmail: "automation1@mailinator.com",
            dbBrandName: "Finance Automation")
            {
                contactDetails(
                        contactFirstName: "fname",
                        contactLastName: "lname",
                        contactEmail: "email@test.com",
                        contactPhone: "888-888-8888",
                        contactFax: "888-888-8888",
                        contactCompanyName: "C company name",
                        contactAddress1: "address1",
                        contactAddress2: "address2",
                        contactAddress3: "address3",
                        contactCity: "city",
                        contactRegion: "region",
                        contactPostCode: "22201",
                        contactCountry: "USA",
                        contactURL: "http://www.efinancialcareers.com",
                        displayContactFirstName: true,
                        displayContactLastName: true,
                        displayContactEmail: false,
                        displayContactPhone: false,
                        displayContactFax: false,
                        displayContactCompanyName: true,
                        displayContactAddress1: true,
                        displayContactAddress2: true,
                        displayContactAddress3: false,
                        displayContactCity: true,
                        displayContactRegion: false,
                        displayContactPostCode: true,
                        displayContactCountry: false,
                        displayContactURL: true,
                        displayContactBrandImage: false,
                        hideContactDetails: false
                )
                primarySector(
                        sectorCode: "FX_MONEY_MARKETS",
                        subSectorCode: "FX_MONEY_MARKETS__SALES_TRADING"
                )
                secondarySector(
                        sectorCode: "COMPLIANCE_LEGAL",
                        subSectorCode: "COMPLIANCE_LEGAL__IN_HOUSE_LEGAL"
                )
                tertiarySector(
                        sectorCode: "HEDGE_FUNDS",
                        subSectorCode: "HEDGE_FUNDS__RISK_MANAGEMENT"
                )
                defaultDescription(
                    title: "Job title 5. Automation Job for job alerts. ${random}",
                    description: "Job description - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    summary: "Job summary. Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                    salaryDescription: "Free text field - 45,000 - 65,000",
                    workPermitRequirements: "Free text field - Work permit requirements",
                    languageCode: "EN"
                )
            }

    JobAllocation(uid: "JobAllocation5UID",
            startDate: jobAllocationStartDate2.getTime(),
            expirationDate: jobAllocationExpirationDate2.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job5UID")

    }

    Job(uid: "Job6UID", positionType: "TEMPORARY",
            employmentType: "FULL_TIME",
            currency: "GBP",
            salaryBand: "SECOND_TIER",
            jobReference: "${random}",
            jobApplicationMethod: "BACK_OFFICE",
            autoReply: true,
            screenQuestionary: false,
            locationId: "2643743",
            dbCompanyName: "Demo Finance",
            dbUserEmail: "automation1@mailinator.com",
            dbBrandName: "Finance Automation")
            {
                contactDetails(
                        contactFirstName: "fname",
                        contactLastName: "lname",
                        contactEmail: "email@test.com",
                        contactPhone: "888-888-8888",
                        contactFax: "888-888-8888",
                        contactCompanyName: "C company name",
                        contactAddress1: "address1",
                        contactAddress2: "address2",
                        contactAddress3: "address3",
                        contactCity: "city",
                        contactRegion: "region",
                        contactPostCode: "22201",
                        contactCountry: "USA",
                        contactURL: "http://www.efinancialcareers.com",
                        displayContactFirstName: true,
                        displayContactLastName: true,
                        displayContactEmail: false,
                        displayContactPhone: false,
                        displayContactFax: false,
                        displayContactCompanyName: true,
                        displayContactAddress1: true,
                        displayContactAddress2: true,
                        displayContactAddress3: false,
                        displayContactCity: true,
                        displayContactRegion: false,
                        displayContactPostCode: true,
                        displayContactCountry: false,
                        displayContactURL: true,
                        displayContactBrandImage: false,
                        hideContactDetails: false
                )
                primarySector(
                        sectorCode: "CAPITAL_MARKETS",
                        subSectorCode: "CAPITAL_MARKETS__EXECUTION"
                )
                secondarySector(
                        sectorCode: "COMPLIANCE_LEGAL",
                        subSectorCode: "COMPLIANCE_LEGAL__IN_HOUSE_LEGAL"
                )
                tertiarySector(
                        sectorCode: "DEBT_FIXED_INCOME",
                        subSectorCode: "DEBT_FIXED_INCOME__SALES_TRADING"
                )
                defaultDescription(
                    title: "Job title 2. Automation Job for job alerts. ${random}",
                    description: "Job description - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    summary: "Job summary. Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                    salaryDescription: "Free text field - 45,000 - 65,000",
                    workPermitRequirements: "Free text field - Work permit requirements",
                    languageCode: "EN"
                )
            }

    JobAllocation(uid: "JobAllocation6UID",
            startDate: jobAllocationStartDate2.getTime(),
            expirationDate: jobAllocationExpirationDate2.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job6UID")

    }

    Job(uid: "Job7UID", positionType: "TEMPORARY",
            employmentType: "FULL_TIME",
            currency: "GBP",
            salaryBand: "SECOND_TIER",
            jobReference: "${random}",
            jobApplicationMethod: "BACK_OFFICE",
            autoReply: true,
            screenQuestionary: false,
            locationId: "2643743",
            dbCompanyName: "Demo Finance",
            dbUserEmail: "automation1@mailinator.com",
            dbBrandName: "Finance Automation")
            {
                contactDetails(
                        contactFirstName: "fname",
                        contactLastName: "lname",
                        contactEmail: "email@test.com",
                        contactPhone: "888-888-8888",
                        contactFax: "888-888-8888",
                        contactCompanyName: "5 company name",
                        contactAddress1: "address1",
                        contactAddress2: "address2",
                        contactAddress3: "address3",
                        contactCity: "city",
                        contactRegion: "region",
                        contactPostCode: "22201",
                        contactCountry: "USA",
                        contactURL: "http://www.efinancialcareers.com",
                        displayContactFirstName: true,
                        displayContactLastName: true,
                        displayContactEmail: false,
                        displayContactPhone: false,
                        displayContactFax: false,
                        displayContactCompanyName: true,
                        displayContactAddress1: true,
                        displayContactAddress2: true,
                        displayContactAddress3: false,
                        displayContactCity: true,
                        displayContactRegion: false,
                        displayContactPostCode: true,
                        displayContactCountry: false,
                        displayContactURL: true,
                        displayContactBrandImage: false,
                        hideContactDetails: false
                )
                primarySector(
                        sectorCode: "CAPITAL_MARKETS",
                        subSectorCode: "CAPITAL_MARKETS__EXECUTION"
                )
                secondarySector(
                        sectorCode: "COMPLIANCE_LEGAL",
                        subSectorCode: "COMPLIANCE_LEGAL__IN_HOUSE_LEGAL"
                )
                tertiarySector(
                        sectorCode: "DEBT_FIXED_INCOME",
                        subSectorCode: "DEBT_FIXED_INCOME__SALES_TRADING"
                )
                defaultDescription(
                    title: "Job title 7. Automation Job for job alerts. ${random}",
                    description: "Job description - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    summary: "Job summary. Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                    salaryDescription: "Free text field - 45,000 - 65,000",
                    workPermitRequirements: "Free text field - Work permit requirements",
                    languageCode: "EN"
                )
            }

    JobAllocation(uid: "JobAllocation7UID",
            startDate: jobAllocationStartDate2.getTime(),
            expirationDate: jobAllocationExpirationDate2.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job7UID")
    }

    Job(uid: "Job8UID", positionType: "TEMPORARY",
            employmentType: "FULL_TIME",
            currency: "GBP",
            salaryBand: "SECOND_TIER",
            jobReference: "${random}",
            jobApplicationMethod: "BACK_OFFICE",
            autoReply: true,
            screenQuestionary: false,
            locationId: "2643743",
            dbCompanyName: "Demo Finance",
            dbUserEmail: "automation1@mailinator.com",
            dbBrandName: "Finance Automation")
            {
                contactDetails(
                        contactFirstName: "fname",
                        contactLastName: "lname",
                        contactEmail: "email@test.com",
                        contactPhone: "888-888-8888",
                        contactFax: "888-888-8888",
                        contactCompanyName: "x company name",
                        contactAddress1: "address1",
                        contactAddress2: "address2",
                        contactAddress3: "address3",
                        contactCity: "city",
                        contactRegion: "region",
                        contactPostCode: "22201",
                        contactCountry: "USA",
                        contactURL: "http://www.efinancialcareers.com",
                        displayContactFirstName: true,
                        displayContactLastName: true,
                        displayContactEmail: false,
                        displayContactPhone: false,
                        displayContactFax: false,
                        displayContactCompanyName: true,
                        displayContactAddress1: true,
                        displayContactAddress2: true,
                        displayContactAddress3: false,
                        displayContactCity: true,
                        displayContactRegion: false,
                        displayContactPostCode: true,
                        displayContactCountry: false,
                        displayContactURL: true,
                        displayContactBrandImage: false,
                        hideContactDetails: false
                )
                primarySector(
                        sectorCode: "CAPITAL_MARKETS",
                        subSectorCode: "CAPITAL_MARKETS__EXECUTION"
                )
                secondarySector(
                        sectorCode: "COMPLIANCE_LEGAL",
                        subSectorCode: "COMPLIANCE_LEGAL__IN_HOUSE_LEGAL"
                )
                tertiarySector(
                        sectorCode: "DEBT_FIXED_INCOME",
                        subSectorCode: "DEBT_FIXED_INCOME__SALES_TRADING"
                )
                defaultDescription(
                    title: "Job title 8. Automation Job for job alerts. ${random}",
                    description: "Job description - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    summary: "Job summary. Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                    salaryDescription: "Free text field - 45,000 - 65,000",
                    workPermitRequirements: "Free text field - Work permit requirements",
                    languageCode: "EN"
                )
            }

    JobAllocation(uid: "JobAllocation8UID",
            startDate: jobAllocationStartDate2.getTime(),
            expirationDate: jobAllocationExpirationDate2.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job8UID")
    }

    Job(uid: "Job9UID", positionType: "TEMPORARY",
            employmentType: "FULL_TIME",
            currency: "GBP",
            salaryBand: "SECOND_TIER",
            jobReference: "${random}",
            jobApplicationMethod: "BACK_OFFICE",
            autoReply: true,
            screenQuestionary: false,
            locationId: "2643743",
            dbCompanyName: "Demo Finance",
            dbUserEmail: "automation1@mailinator.com",
            dbBrandName: "Finance Automation")
            {
                contactDetails(
                        contactFirstName: "fname",
                        contactLastName: "lname",
                        contactEmail: "email@test.com",
                        contactPhone: "888-888-8888",
                        contactFax: "888-888-8888",
                        contactCompanyName: "b company name",
                        contactAddress1: "address1",
                        contactAddress2: "address2",
                        contactAddress3: "address3",
                        contactCity: "city",
                        contactRegion: "region",
                        contactPostCode: "22201",
                        contactCountry: "USA",
                        contactURL: "http://www.efinancialcareers.com",
                        displayContactFirstName: true,
                        displayContactLastName: true,
                        displayContactEmail: false,
                        displayContactPhone: false,
                        displayContactFax: false,
                        displayContactCompanyName: true,
                        displayContactAddress1: true,
                        displayContactAddress2: true,
                        displayContactAddress3: false,
                        displayContactCity: true,
                        displayContactRegion: false,
                        displayContactPostCode: true,
                        displayContactCountry: false,
                        displayContactURL: true,
                        displayContactBrandImage: false,
                        hideContactDetails: false
                )
                primarySector(
                        sectorCode: "CAPITAL_MARKETS",
                        subSectorCode: "CAPITAL_MARKETS__EXECUTION"
                )
                secondarySector(
                        sectorCode: "COMPLIANCE_LEGAL",
                        subSectorCode: "COMPLIANCE_LEGAL__IN_HOUSE_LEGAL"
                )
                tertiarySector(
                        sectorCode: "DEBT_FIXED_INCOME",
                        subSectorCode: "DEBT_FIXED_INCOME__SALES_TRADING"
                )
                defaultDescription(
                    title: "Job title 9. Automation Job for job alerts. ${random}",
                    description: "Job description - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    summary: "Job summary. Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                    salaryDescription: "Free text field - 45,000 - 65,000",
                    workPermitRequirements: "Free text field - Work permit requirements",
                    languageCode: "EN"
                )
            }

    JobAllocation(uid: "JobAllocation9UID",
            startDate: jobAllocationStartDate2.getTime(),
            expirationDate: jobAllocationExpirationDate2.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job9UID")
    }

    Job(uid: "Job10UID", positionType: "TEMPORARY",
            employmentType: "FULL_TIME",
            currency: "GBP",
            salaryBand: "SECOND_TIER",
            jobReference: "${random}",
            jobApplicationMethod: "BACK_OFFICE",
            autoReply: true,
            screenQuestionary: false,
            locationId: "2643743",
            dbCompanyName: "Demo Finance",
            dbUserEmail: "automation1@mailinator.com",
            dbBrandName: "Finance Automation")
            {
                contactDetails(
                        contactFirstName: "fname",
                        contactLastName: "lname",
                        contactEmail: "email@test.com",
                        contactPhone: "888-888-8888",
                        contactFax: "888-888-8888",
                        contactCompanyName: "anonymous company name",
                        contactAddress1: "address1",
                        contactAddress2: "address2",
                        contactAddress3: "address3",
                        contactCity: "city",
                        contactRegion: "region",
                        contactPostCode: "22201",
                        contactCountry: "USA",
                        contactURL: "http://www.efinancialcareers.com",
                        displayContactFirstName: true,
                        displayContactLastName: true,
                        displayContactEmail: false,
                        displayContactPhone: false,
                        displayContactFax: false,
                        displayContactCompanyName: true,
                        displayContactAddress1: true,
                        displayContactAddress2: true,
                        displayContactAddress3: false,
                        displayContactCity: true,
                        displayContactRegion: false,
                        displayContactPostCode: true,
                        displayContactCountry: false,
                        displayContactURL: true,
                        displayContactBrandImage: false,
                        hideContactDetails: false
                )
                primarySector(
                        sectorCode: "CAPITAL_MARKETS",
                        subSectorCode: "CAPITAL_MARKETS__EXECUTION"
                )
                secondarySector(
                        sectorCode: "COMPLIANCE_LEGAL",
                        subSectorCode: "COMPLIANCE_LEGAL__IN_HOUSE_LEGAL"
                )
                tertiarySector(
                        sectorCode: "DEBT_FIXED_INCOME",
                        subSectorCode: "DEBT_FIXED_INCOME__SALES_TRADING"
                )
                defaultDescription(
                    title: "Job title 10. Automation Job for job alerts. ${random}",
                    description: "Job description - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    summary: "Job summary. Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                    salaryDescription: "Free text field - 45,000 - 65,000",
                    workPermitRequirements: "Free text field - Work permit requirements",
                    languageCode: "EN"
                )
            }

    JobAllocation(uid: "JobAllocation10UID",
            startDate: jobAllocationStartDate2.getTime(),
            expirationDate: jobAllocationExpirationDate2.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job10UID")
    }

    Job(uid: "Job11UID", positionType: "TEMPORARY",
            employmentType: "FULL_TIME",
            currency: "GBP",
            salaryBand: "SECOND_TIER",
            jobReference: "${random}",
            jobApplicationMethod: "BACK_OFFICE",
            autoReply: true,
            screenQuestionary: false,
            locationId: "2643743",
            dbCompanyName: "Demo Finance",
            dbUserEmail: "automation1@mailinator.com",
            dbBrandName: "Finance Automation")
            {
                contactDetails(
                        contactFirstName: "fname",
                        contactLastName: "lname",
                        contactEmail: "email@test.com",
                        contactPhone: "888-888-8888",
                        contactFax: "888-888-8888",
                        contactCompanyName: "2 anonymous company name",
                        contactAddress1: "address1",
                        contactAddress2: "address2",
                        contactAddress3: "address3",
                        contactCity: "city",
                        contactRegion: "region",
                        contactPostCode: "22201",
                        contactCountry: "USA",
                        contactURL: "http://www.efinancialcareers.com",
                        displayContactFirstName: true,
                        displayContactLastName: true,
                        displayContactEmail: false,
                        displayContactPhone: false,
                        displayContactFax: false,
                        displayContactCompanyName: true,
                        displayContactAddress1: true,
                        displayContactAddress2: true,
                        displayContactAddress3: false,
                        displayContactCity: true,
                        displayContactRegion: false,
                        displayContactPostCode: true,
                        displayContactCountry: false,
                        displayContactURL: true,
                        displayContactBrandImage: false,
                        hideContactDetails: false
                )
                primarySector(
                        sectorCode: "CAPITAL_MARKETS",
                        subSectorCode: "CAPITAL_MARKETS__EXECUTION"
                )
                secondarySector(
                        sectorCode: "COMPLIANCE_LEGAL",
                        subSectorCode: "COMPLIANCE_LEGAL__IN_HOUSE_LEGAL"
                )
                tertiarySector(
                        sectorCode: "DEBT_FIXED_INCOME",
                        subSectorCode: "DEBT_FIXED_INCOME__SALES_TRADING"
                )
                defaultDescription(
                    title: "Job title 11. Automation Job for job alerts. ${random}",
                    description: "Job description - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    summary: "Job summary. Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                    salaryDescription: "Free text field - 45,000 - 65,000",
                    workPermitRequirements: "Free text field - Work permit requirements",
                    languageCode: "EN"
                )
            }

    JobAllocation(uid: "JobAllocation11UID",
            startDate: jobAllocationStartDate2.getTime(),
            expirationDate: jobAllocationExpirationDate2.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job11UID")
    }

    Job(uid: "Job12UID", positionType: "TEMPORARY",
            employmentType: "FULL_TIME",
            currency: "GBP",
            salaryBand: "SECOND_TIER",
            jobReference: "${random}",
            jobApplicationMethod: "BACK_OFFICE",
            autoReply: true,
            screenQuestionary: false,
            locationId: "2643743",
            dbCompanyName: "Demo Finance",
            dbUserEmail: "automation1@mailinator.com",
            dbBrandName: "Finance Automation")
            {
                contactDetails(
                        contactFirstName: "fname",
                        contactLastName: "lname",
                        contactEmail: "email@test.com",
                        contactPhone: "",
                        contactFax: "",
                        contactCompanyName: "A company name",
                        contactAddress1: "address1",
                        contactAddress2: "address2",
                        contactAddress3: "address3",
                        contactCity: "city",
                        contactRegion: "region",
                        contactPostCode: "22201",
                        contactCountry: "USA",
                        contactURL: "http://www.efinancialcareers.com",
                        displayContactFirstName: true,
                        displayContactLastName: true,
                        displayContactEmail: false,
                        displayContactPhone: false,
                        displayContactFax: false,
                        displayContactCompanyName: true,
                        displayContactAddress1: true,
                        displayContactAddress2: true,
                        displayContactAddress3: false,
                        displayContactCity: true,
                        displayContactRegion: false,
                        displayContactPostCode: true,
                        displayContactCountry: false,
                        displayContactURL: true,
                        displayContactBrandImage: false,
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
                    title: "Job title 12. Automation Job for job alerts. ${random}",
                    description: "Job description - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    summary: "Job summary. Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                    salaryDescription: "Free text field - 45,000 - 65,000",
                    workPermitRequirements: "Free text field - Work permit requirements",
                    languageCode: "EN"
                )
            }

    JobAllocation(uid: "JobAllocation12UID",
            startDate: jobAllocationStartDate2.getTime(),
            expirationDate: jobAllocationExpirationDate2.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job12UID")
    }

    Job(uid: "Job13UID",
            positionType: "TEMPORARY",
            employmentType: "FULL_TIME",
            currency: "GBP",
            salaryBand: "SECOND_TIER",
            jobReference: "${random}",
            jobApplicationMethod: "BACK_OFFICE",
            autoReply: true,
            screenQuestionary: false,
            locationId: "2643743",
            dbCompanyName: "Demo Finance",
            dbUserEmail: "automation1@mailinator.com",
            dbBrandName: "Finance Automation")
            {
                contactDetails(
                        contactFirstName: "fname",
                        contactLastName: "lname",
                        contactEmail: "email@test.com",
                        contactPhone: "",
                        contactFax: "",
                        contactCompanyName: "",
                        contactAddress1: "address1",
                        contactAddress2: "address2",
                        contactAddress3: "address3",
                        contactCity: "city",
                        contactRegion: "region",
                        contactPostCode: "22201",
                        contactCountry: "USA",
                        contactURL: "http://www.efinancialcareers.com",
                        displayContactFirstName: true,
                        displayContactLastName: true,
                        displayContactEmail: false,
                        displayContactPhone: false,
                        displayContactFax: false,
                        displayContactCompanyName: true,
                        displayContactAddress1: true,
                        displayContactAddress2: true,
                        displayContactAddress3: false,
                        displayContactCity: true,
                        displayContactRegion: false,
                        displayContactPostCode: true,
                        displayContactCountry: false,
                        displayContactURL: true,
                        displayContactBrandImage: false,
                        hideContactDetails: false
                )
                primarySector(
                        sectorCode: "ISLAMIC_FINANCE",
                        subSectorCode: "ISLAMIC_FINANCE__N_A"
                )
                defaultDescription(
                    title: "Job title 13. Automation Job for job alerts. Java developer ${random}",
                    description: "An experienced java developer who works in a hands-on, practical way keen to support others.",
                    summary: "Morgan Stanley is a leading global financial services firm providing a wide range of investment banking, securities, investment management and wealth management services. The Firm's employees serve clients worldwide including corporations, governments and individuals from more than 1,200 offices in 43 countries. ",
                    salaryDescription: "Free text field - 45,000 - 65,000",
                    workPermitRequirements: "Free text field - Work permit requirements",
                    languageCode: "EN"
                )
            }

    JobAllocation(uid: "JobAllocation13UID",
            startDate: jobAllocationStartDate2.getTime(),
            expirationDate: jobAllocationExpirationDate2.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job13UID")
    }



    JobSeeker(
            uid: "JobSeekerUID${it}",
            title: Title.PROF.name(),
            firstName: "Automation",
            lastName: "User",
            displayName: "Test User",
            email: "test${random.toLowerCase()}@" + FoPropertiesLoader.getInstance().getStrProperty("disposable.email.provider").toLowerCase() + ".com",
            isAnonymous: false,
            searchable: true,
            interests: "my favourite interests",
            status: EntityStatus.ACTIVE.name()
    )

    MyEfcUser(
            uid: "MyEfcUserUID${it}",
            password: "testing123",
            salt: "1234567891234567",
            isVerified: true,
            tokenGenDate: Calendar.getInstance().getTime(),
            accountVerificationToken: "accountVerificationToken",
            statusId: EntityStatus.ACTIVE
    ) { uid = it -> jobSeeker(refId: "JobSeekerUID${uid}") }
}
