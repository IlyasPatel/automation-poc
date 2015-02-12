package datasets

import com.efinancialcareers.core.domain.bean.enums.EntityStatus
import com.efinancialcareers.core.domain.bean.enums.FileFormat
import com.efinancialcareers.core.domain.bean.enums.Title
import com.efinancialcareers.core.domain.bean.enums.YearsExperience
import org.apache.commons.lang.RandomStringUtils

putDataset("MyEfcLiveJobsWithUser") {

    def random = RandomStringUtils.randomAlphabetic(10);

    final Calendar jobAllocationStartDate1 = Calendar.getInstance();
    final Calendar jobAllocationStartDate2 = Calendar.getInstance();
    final Calendar jobAllocationStartDate3 = Calendar.getInstance();
    final Calendar jobAllocationStartDate4 = Calendar.getInstance();
    final Calendar jobAllocationStartDate5 = Calendar.getInstance();
    final Calendar jobAllocationStartDate6 = Calendar.getInstance();
    final Calendar jobRefreshDate1 = Calendar.getInstance();
    final Calendar jobRefreshDate2 = Calendar.getInstance();
    final Calendar jobRefreshDate3 = Calendar.getInstance();
    final Calendar jobRefreshDate4 = Calendar.getInstance();

    jobAllocationStartDate1.add(Calendar.MINUTE, -130);
    jobAllocationStartDate2.add(Calendar.MINUTE, -120);
    jobAllocationStartDate3.add(Calendar.MINUTE, -110);
    jobAllocationStartDate4.add(Calendar.MINUTE, -100);
    jobAllocationStartDate5.add(Calendar.MINUTE, -90);
    jobAllocationStartDate6.add(Calendar.MINUTE, -80);
    jobRefreshDate1.add(Calendar.MINUTE, -130);
    jobRefreshDate2.add(Calendar.MINUTE, -120);
    jobRefreshDate3.add(Calendar.MINUTE, -110);
    jobRefreshDate4.add(Calendar.MINUTE, -100);


    final Calendar allocationExpirationDate1 = Calendar.getInstance();
    allocationExpirationDate1.add(Calendar.DAY_OF_MONTH, 1);

    Job(uid: "Job1UID", positionType: "PERMANENT",
            employmentType: "PART_TIME",
            currency: "GBP",
            yearsExperience: "THREE_FIVE_YEARS_EXPERIENCE",
            salaryBand: "FIRST_TIER",
            jobReference: "${random}",
            jobApplicationMethod: "BACK_OFFICE",
            externalApplicationURL: "http://smth.com",
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
                    title: "Test Job 1 EN ${random} ${random}",
                    description: "We are looking for a newly qualified ACA candidate with Financial Services audit experience to join Collateral Optimisation Product Control. This person will become a key member of the team, liaising regularly with members of the FO, Finance, Risk and other areas within the bank. ${random}",
                    summary: "default summary job ${random}",
                    salaryDescription: "45,000 - 65,000 ${random}",
                    workPermitRequirements: "default perm requirements job ${random}",
                    languageCode: "EN"
                )

    }

    JobAllocation(uid: "JobAllocation1UID",
            startDate: jobAllocationStartDate1.getTime(),
            expirationDate: allocationExpirationDate1.getTime(),
            dbTeamName: "Finance Automation"
    ){
            job(refId: "Job1UID")
    }

    Job(uid: "Job2UID", positionType: "PERMANENT",
            employmentType: "PART_TIME",
            currency: "GBP",
            yearsExperience: "THREE_FIVE_YEARS_EXPERIENCE",
            salaryBand: "THIRD_TIER",
            jobReference: "job reference",
            jobApplicationMethod: "BACK_OFFICE",
            externalApplicationURL: "http://smth.com",
            autoReply: true,
            screenQuestionary: false,
            locationId: "2988507",
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
                        title: "Test Job 2 FR ${random}",
                        description: "Managers, experts en risques de crédit et contrepartie sur activités de marchés",
                        summary: "Assister nos Clients dans leur processus",
                        salaryDescription: "45,000 - 65,000",
                        workPermitRequirements: "default perm requirements job",
                        languageCode: "FR"
                )

            }

    JobAllocation(uid: "JobAllocation2UID",
            startDate: jobAllocationStartDate2.getTime(),
            expirationDate: allocationExpirationDate1.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job2UID")

    }

    Job(uid: "Job3UID", positionType: "CONTRACT",
            employmentType: "FULL_TIME",
            currency: "GBP",
            yearsExperience: "FIVE_SEVEN_YEARS_EXPERIENCE",
            salaryBand: "SECOND_TIER",
            jobReference: "job reference",
            jobApplicationMethod: "BACK_OFFICE",
            externalApplicationURL: "http://smth.com",
            autoReply: true,
            screenQuestionary: false,
            locationId: "2950159",
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
                        title: "Test Job 3 DE",
                        description: "Die Deutsche Börse AG öffnet ihren Kunden den Weg zu den internationalen Kapitalmärkten. Ihr Produkt- und Dienstleistungsportfolio umfasst die gesamte Prozesskette vom Aktien- und Terminhandel über die Abwicklung der Aufträge und die",
                        summary: "Die Abteilung Treasury ist verantwortlich für das Cash Management der Gruppe Deutsche Börse, für die ${random}",
                        salaryDescription: "45,000 - 65,000 ${random}",
                        workPermitRequirements: "default perm requirements job ${random}",
                        languageCode: "DE"
                )

            }

    JobAllocation(uid: "JobAllocation3UID",
            startDate: jobAllocationStartDate3.getTime(),
            expirationDate: allocationExpirationDate1.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job3UID")
    }

    Job(uid: "Job4UID", positionType: "TEMPORARY",
            employmentType: "FULL_TIME",
            currency: "GBP",
            yearsExperience: "MORE_THAN_FIFTEEN_YEARS_EXPERIENCE",
            salaryBand: "FOURTH_TIER",
            jobReference: "job reference",
            jobApplicationMethod: "BACK_OFFICE",
            externalApplicationURL: "http://smth.com",
            autoReply: true,
            screenQuestionary: false,
            locationId: "2988507",
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
                        title: "Test Job 4 FR",
                        description: "Yet another job. This one must surely interest you. ${random}",
                        summary: "default summary job",
                        salaryDescription: "Great",
                        workPermitRequirements: "default perm requirements job",
                        languageCode: "FR"
                )

            }

    JobAllocation(uid: "JobAllocation4UID",
            startDate: jobAllocationStartDate4.getTime(),
            expirationDate: allocationExpirationDate1.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job4UID")

    }

}
