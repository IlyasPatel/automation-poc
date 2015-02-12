package datasets

import com.efinancialcareers.core.domain.bean.enums.CurrencyType
import com.efinancialcareers.core.domain.bean.enums.EmploymentType
import com.efinancialcareers.core.domain.bean.enums.EntityStatus
import com.efinancialcareers.core.domain.bean.enums.FileFormat
import com.efinancialcareers.core.domain.bean.enums.JobApplicationStatus
import com.efinancialcareers.core.domain.bean.enums.PositionType
import com.efinancialcareers.core.domain.bean.enums.Sector
import com.efinancialcareers.core.domain.bean.enums.SubSector
import com.efinancialcareers.core.domain.bean.enums.Title
import com.efinancialcareers.core.domain.bean.enums.TravelRate
import com.efinancialcareers.core.domain.bean.enums.YearsExperience
import com.efinancialcareers.core.domain.bean.enums.LanguageCodes
import com.efinancialcareers.core.domain.bean.enums.LanguageFluency
import org.apache.commons.lang.RandomStringUtils

putDataset("MyEfcLiveJobsWithUser") {

    def random = RandomStringUtils.randomAlphabetic(10);

    final Calendar jobAllocationStartDate1 = Calendar.getInstance();
    jobAllocationStartDate1.add(Calendar.DAY_OF_MONTH, -3);

    final Calendar jobAllocationStartDate2 = Calendar.getInstance();
    jobAllocationStartDate2.add(Calendar.DAY_OF_MONTH, -5);


    final Calendar allocationExpirationDate1 = Calendar.getInstance();
    allocationExpirationDate1.add(Calendar.DAY_OF_MONTH, 1);

    Job(uid: "Job1UID", positionType: "PERMANENT",
            employmentType: "PART_TIME",
            currency: "GBP",
            yearsExperience: "THREE_FIVE_YEARS_EXPERIENCE",
            salaryBand: "FIRST_TIER",
            jobReference: "job reference",
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
                    title: "Test Job 1 EN",
                    description: "We are looking for a newly qualified ACA candidate with Financial Services audit experience to join Collateral Optimisation Product Control. This person will become a key member of the team, liaising regularly with members of the FO, Finance, Risk and other areas within the bank. ${random}",
                    summary: "default summary job ${random}",
                    salaryDescription: "45,000 - 65,000 ${random}",
                    workPermitRequirements: "default perm requirements job ${random}",
                    languageCode: "EN"
                )

    }

    JobAllocation(uid: "JobAllocation1UID",
            startDate: jobAllocationStartDate2.getTime(),
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
                        title: "Test Job 2 FR",
                        description: "Managers, experts en risques de crédit et contrepartie sur activités de marchés ${random}",
                        summary: "Assister nos Clients dans leur processus ${random}",
                        salaryDescription: "45,000 - 65,000 ${random}",
                        workPermitRequirements: "default perm requirements job ${random}",
                        languageCode: "FR"
                )

            }

    JobAllocation(uid: "JobAllocation2UID",
            startDate: jobAllocationStartDate1.getTime(),
            expirationDate: allocationExpirationDate1.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job2UID")

    }

    Job(uid: "Job3UID", positionType: "CONTRACT",
            employmentType: "FULL_TIME",
            currency: "USD",
            yearsExperience: "FIVE_SEVEN_YEARS_EXPERIENCE",
            salaryBand: "SECOND_TIER",
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
                        description: "Die Deutsche Börse AG öffnet ihren Kunden den Weg zu den internationalen Kapitalmärkten. Ihr Produkt- und Dienstleistungsportfolio umfasst die gesamte Prozesskette vom Aktien- und Terminhandel über die Abwicklung der Aufträge und die  ${random}",
                        summary: "Die Abteilung Treasury ist verantwortlich für das Cash Management der Gruppe Deutsche Börse, für die ${random}",
                        salaryDescription: "45,000 - 65,000 ${random}",
                        workPermitRequirements: "default perm requirements job ${random}",
                        languageCode: "DE"
                )

            }

    JobAllocation(uid: "JobAllocation3UID",
            startDate: jobAllocationStartDate1.getTime(),
            expirationDate: allocationExpirationDate1.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job3UID")
    }

    Job(uid: "Job4UID", positionType: "TEMPORARY",
            employmentType: "FULL_TIME",
            currency: "GBP",
            yearsExperience: "MORE_THAN_FIFTEEN_YEARS_EXPERIENCE",
            salaryBand: "SECOND_TIER",
            jobReference: "job reference",
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
                        title: "Test Job 4 EN",
                        description: "Yet another job. This one must surely interest you. ${random}",
                        summary: "default summary job ${random}",
                        salaryDescription: "Great",
                        workPermitRequirements: "default perm requirements job ${random}",
                        languageCode: "EN"
                )

            }

    JobAllocation(uid: "JobAllocation4UID",
            startDate: jobAllocationStartDate1.getTime(),
            expirationDate: allocationExpirationDate1.getTime(),
            dbTeamName: "Finance Automation"
    ){
        job(refId: "Job4UID")

    }

    Job(uid: "Job5UID", positionType: "TEMPORARY",
            employmentType: "FULL_TIME",
            currency: "GBP",
            yearsExperience: "MORE_THAN_FIFTEEN_YEARS_EXPERIENCE",
            salaryBand: "SECOND_TIER",
            jobReference: "job reference",
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
                        title: "Test Job 5 US",
                        description: "Great opportunity in the USA. ${random}",
                        summary: "default summary job ${random}",
                        salaryDescription: "Great",
                        workPermitRequirements: "default perm requirements job ${random}",
                        languageCode: "US"
                )

            }

    JobAllocation(uid: "JobAllocation5UID",
            startDate: jobAllocationStartDate1.getTime(),
            expirationDate: allocationExpirationDate1.getTime(),
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
            email: "testuser${random}@mailinator.com",
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

    LanguageLevel(
            language:LanguageCodes.EN,
            levelSpoken: LanguageFluency.BASIC.getId(),
            levelWritten: LanguageFluency.BASIC.getId()
    ) { uid = it -> jobSeeker(refId: "JobSeekerUID${uid}") }

    JobSeekerWorkSummary(
            profileTitle: "Profile Title",
            yearsExperience: YearsExperience.FIVE_SEVEN_YEARS_EXPERIENCE.name(),
            yearOfGraduation: 2000,
    ){ it2 = it ->
        jobSeeker(refId: "JobSeekerUID${it2}")
        sectors(
                sectorCode: Sector.ACCOUNTING_FINANCE,
                subSectorCode: SubSector.ACCOUNTING_FINANCE__AUDIT
        )

        workPermits(
                countryLocationRefId: 3017382   //  france
        )
    }

    WorkPreferences(
            uid: "WorkPreferences${it}",
            availabilityDate: new Date(),
            positionTypes: [PositionType.CONTRACT],
            employmentTypes: [EmploymentType.FULL_TIME],
            desiredTravel: TravelRate.TWENTY_FIVE_PERCENTS,
            currency: CurrencyType.EUR,
            salary: "40000",
            objective: "To find a new job",
            willingToRelocate: true,
            willingToRelocateLocationsIds: ["2988507", "2950157", "3169070", "3451190"] //париж берлин рим рио-де-жанейро
    ){ it2 = it ->
        jobSeeker(refId: "JobSeekerUID${it2}")
        sectors(
                sectorCode: Sector.ACCOUNTING_FINANCE,
                subSectorCode: SubSector.ACCOUNTING_FINANCE__AUDIT
        )
    }

    Resume(
            uid: "ResumeUID1",
            status: EntityStatus.ACTIVE.name(),
            originalFileName: "jobSeekerFile.doc",
            filePath: "my-resume-file.doc",
            fileContent: "QADefaultResumeText",
            refno: 123456789,
            fileFormat: FileFormat.DOC
    ) { uid = it -> jobSeeker(refId: "JobSeekerUID${uid}") }

    Resume(
            uid: "ResumeUID2",
            status: EntityStatus.INACTIVE.name(),
            originalFileName: "jobSeekerFile2.doc",
            filePath: "my-resume-file.txt",
            refno: 123456789,
            fileFormat: FileFormat.DOC
    ) { uid = it -> jobSeeker(refId: "JobSeekerUID${uid}") }

    Resume(
            uid: "ResumeUID3",
            status: EntityStatus.INACTIVE.name(),
            originalFileName: "jobSeekerFile3.doc",
            filePath: "my-resume-file.txt",
            refno: 123456789,
            fileFormat: FileFormat.DOC
    ) { uid = it -> jobSeeker(refId: "JobSeekerUID${uid}") }

    Resume(
            uid: "ResumeUID4",
            status: EntityStatus.INACTIVE.name(),
            originalFileName: "jobSeekerFile4.doc",
            filePath: "my-resume-file.txt",
            refno: 123456789,
            fileFormat: FileFormat.DOC
    ) { uid = it -> jobSeeker(refId: "JobSeekerUID${uid}") }

    CoverLetter(
            uid: "CoverLetterUID1",
            status: EntityStatus.ACTIVE.name(),
            title: "JobSeeker Cover Letter 1",
            text: "JobSeeker Cover Letter TEXT"
    ) { uid = it -> jobSeeker(refId: "JobSeekerUID${uid}") }

    CoverLetter(
            uid: "CoverLetterUID2",
            status: EntityStatus.ACTIVE.name(),
            title: "JobSeeker Cover Letter 2",
            text: "JobSeeker Cover Letter TEXT"
    ) { uid = it -> jobSeeker(refId: "JobSeekerUID${uid}") }

    CoverLetter(
            uid: "CoverLetterUID3",
            status: EntityStatus.ACTIVE.name(),
            title: "JobSeeker Cover Letter 3",
            text: "JobSeeker Cover Letter TEXT"
    ) { uid = it -> jobSeeker(refId: "JobSeekerUID${uid}") }

    CoverLetter(
            uid: "CoverLetterUID4",
            status: EntityStatus.ACTIVE.name(),
            title: "JobSeeker Cover Letter 4",
            text: "JobSeeker Cover Letter TEXT"
    ) { uid = it -> jobSeeker(refId: "JobSeekerUID${uid}") }

    CoverLetter(
            uid: "CoverLetterUID5",
            status: EntityStatus.ACTIVE.name(),
            title: "JobSeeker Cover Letter 5",
            text: "JobSeeker Cover Letter TEXT"
    ) { uid = it -> jobSeeker(refId: "JobSeekerUID${uid}") }

    MyEfcUser(
            uid: "MyEfcUserUID",
            password: "testing123",
            salt: "1234567891234567",
            isVerified: true,
            tokenGenDate: Calendar.getInstance().getTime(),
            accountVerificationToken: "accountVerificationToken",
            statusId: EntityStatus.ACTIVE

    ) { uid = it -> jobSeeker(refId: "JobSeekerUID${uid}") }

    MyEfcJob(
            uid: "SavedJob1UID",
    ) {
        user(refId: "MyEfcUserUID")
        job(refId: "Job1UID")
    }

    MyEfcJob(
            uid: "SavedJob2UID",
    ) {
        user(refId: "MyEfcUserUID")
        job(refId: "Job2UID")
    }

    MyEfcJob(
            uid: "SavedJob3UID",
    ) {
        user(refId: "MyEfcUserUID")
        job(refId: "Job3UID")
    }

    MyEfcJob(
            uid: "myEfcJob1",
            isApplied: true
    ){
        job(refId: "Job4UID")
        user(refId: "MyEfcUserUID")
    }

    JobApplication(
            uid: "jobApplication1",
            statusId: JobApplicationStatus.NOT_MARKED.getId(),
            locationId: "2643743",
            ipLocationId: "32767"
    ){  it2 = it ->
        jobSeeker(refId: "JobSeekerUID${it2}")
        myEfcJob(refId: "myEfcJob1")
        user(refId: "MyEfcUserUID")
        resume(refId: "ResumeUID1")
    }

}
