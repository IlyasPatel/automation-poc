package datasets

import com.efinancialcareers.core.domain.bean.enums.EntityStatus
import com.efinancialcareers.core.domain.bean.enums.FileFormat
import com.efinancialcareers.core.domain.bean.enums.Title
import com.efinancialcareers.core.domain.bean.enums.YearsExperience
import com.efinancialcareers.myefc.qa.utils.fo.FoPropertiesLoader
import org.apache.commons.lang.RandomStringUtils


putDataset("MyEfcLiveJobsWithUser") {
    def random = RandomStringUtils.randomAlphanumeric(6);
    def randomNotApplicable = RandomStringUtils.randomAlphanumeric(6);
    def keyword1 = RandomStringUtils.randomAlphabetic(10);
    def keyword2 = RandomStringUtils.randomNumeric(10);

    final Calendar jobAllocationStartDate = Calendar.getInstance();
    final Calendar jobAllocationExpirationDate = Calendar.getInstance();

    jobAllocationStartDate.add(Calendar.HOUR, -4);
    jobAllocationExpirationDate.add(Calendar.DAY_OF_MONTH, 1);


    Job(uid: "Job1UID", positionType: "PERMANENT",
            employmentType: "FULL_TIME",
            currency: "GBP",
            yearsExperience: "THREE_FIVE_YEARS_EXPERIENCE",
            salaryBand: "FIRST_TIER",
            jobReference: "${keyword1}, ${keyword2}",
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
                        title: "Test Job in London 1 EN ${keyword1}",
                        description: "We are looking for a newly qualified ACA candidate with Financial Services audit experience to join Collateral Optimisation Product Control. This person will become a key member of the team, liaising regularly with members of the FO, Finance, Risk and other areas within the bank.",
                        summary: "default summary job",
                        salaryDescription: "45,000 - 65,000",
                        workPermitRequirements: "default perm requirements job",
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
            yearsExperience: "THREE_FIVE_YEARS_EXPERIENCE",
            salaryBand: "THIRD_TIER",
            jobReference: "${keyword1}, ${keyword2}",
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
                        title: "Test Job In London 2 EN",
                        description: "We are looking for a newly qualified ACA candidate with Financial Services audit experience to join Collateral Optimisation Product Control. This person will become a key member of the team, liaising regularly with members of the FO, Finance, Risk and other areas within the bank. ${keyword2}",
                        summary: "default summary job",
                        salaryDescription: "45,000 - 65,000",
                        workPermitRequirements: "default perm requirements job",
                        languageCode: "EN"
                )

            }

    JobAllocation(uid: "JobAllocation2UID",
            startDate: jobAllocationStartDate.getTime(),
            expirationDate: jobAllocationExpirationDate.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job2UID")
    }

    Job(uid: "Job3UID", positionType: "CONTRACT",
            employmentType: "FULL_TIME",
            currency: "GBP",
            yearsExperience: "FIVE_SEVEN_YEARS_EXPERIENCE",
            salaryBand: "SECOND_TIER",
            jobReference: "${keyword1}, ${keyword2}",
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
                        title: "Test Job in London 3 EN ${keyword1} ${keyword2}",
                        description: "We are looking for a newly qualified ACA candidate with Financial Services audit experience to join Collateral Optimisation Product Control. This person will become a key member of the team, liaising regularly with members of the FO, Finance, Risk and other areas within the bank.",
                        summary: "default summary job",
                        salaryDescription: "45,000 - 65,000",
                        workPermitRequirements: "default perm requirements job",
                        languageCode: "EN"
                )

            }

    JobAllocation(uid: "JobAllocation3UID",
            startDate: jobAllocationStartDate.getTime(),
            expirationDate: jobAllocationExpirationDate.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job3UID")
    }

    Job(uid: "Job4UID", positionType: "CONTRACT",
            employmentType: "FULL_TIME",
            currency: "GBP",
            yearsExperience: "FIVE_SEVEN_YEARS_EXPERIENCE",
            salaryBand: "SECOND_TIER",
            jobReference: "${keyword1}, ${keyword2}",
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
                        title: "Test Job in London 4 EN",
                        description: "We are looking for a newly qualified ACA candidate with Financial Services audit experience to join Collateral Optimisation Product Control. This person will become a key member of the team, liaising regularly with members of the FO, Finance, Risk and other areas within the bank.",
                        summary: "default summary job ${keyword2} ${keyword1}",
                        salaryDescription: "45,000 - 65,000",
                        workPermitRequirements: "default perm requirements job",
                        languageCode: "EN"
                )

            }

    JobAllocation(uid: "JobAllocation4UID",
            startDate: jobAllocationStartDate.getTime(),
            expirationDate: jobAllocationExpirationDate.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job4UID")
    }

    Job(uid: "Job5UID", positionType: "CONTRACT",
            employmentType: "FULL_TIME",
            currency: "GBP",
            yearsExperience: "FIVE_SEVEN_YEARS_EXPERIENCE",
            salaryBand: "SECOND_TIER",
            jobReference: "${randomNotApplicable}",
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
                        title: "Test Job in London 5 EN ${randomNotApplicable}",
                        description: "We are looking for a newly qualified ACA candidate with Financial Services audit experience to join Collateral Optimisation Product Control. This person will become a key member of the team, liaising regularly with members of the FO, Finance, Risk and other areas within the bank. ${randomNotApplicable}",
                        summary: "default summary job",
                        salaryDescription: "45,000 - 65,000",
                        workPermitRequirements: "default perm requirements job",
                        languageCode: "EN"
                )

            }

    JobAllocation(uid: "JobAllocation5UID",
            startDate: jobAllocationStartDate.getTime(),
            expirationDate: jobAllocationExpirationDate.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job5UID")
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

    JobSeekerAddress(
            postalCode: "PZ112233",
            locationRefId: "625144"
    ) { uid = it -> jobSeeker(refId: "JobSeekerUID${uid}") }

    JobSeekerExperience(
            jobTitle: "programmer",
            description: "java, junit, tdd",
            companyName: "google",
            startDate: Calendar.getInstance().getTime(),
            endDate: Calendar.getInstance().getTime(),
            toPresent: true,
            locationRefId: "2643743"
    ) { uid = it -> jobSeeker(refId: "JobSeekerUID${uid}") }

    JobSeekerGulfAdditionalInfo(
            arabicFirstLanguage: true,
            genderCode: "FEMALE",
            yearOfBirth: "1995"
    ) { uid = it -> jobSeeker(refId: "JobSeekerUID${uid}") }

    JobSeekerQualification(
            speciality: "java programmer",
            educationLevel: "EDUCATION_LEVEL_10",
            startDate: Calendar.getInstance().getTime(),
            endDate: Calendar.getInstance().getTime(),
            toPresent: true
    ) { uid = it -> jobSeeker(refId: "JobSeekerUID${uid}") }

    JobSeekerWorkSummary(
            profileTitle: "Profile Title",
            yearsExperience: YearsExperience.FIVE_SEVEN_YEARS_EXPERIENCE.name(),
            yearOfGraduation: 2000,
    ) { uid = it -> jobSeeker(refId: "JobSeekerUID${uid}") }

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