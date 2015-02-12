package datasets

import com.efinancialcareers.core.domain.bean.enums.CurrencyType
import com.efinancialcareers.core.domain.bean.enums.EmploymentType
import com.efinancialcareers.core.domain.bean.enums.EntityStatus
import com.efinancialcareers.core.domain.bean.enums.FileFormat
import com.efinancialcareers.core.domain.bean.enums.LanguageCodes
import com.efinancialcareers.core.domain.bean.enums.LanguageFluency
import com.efinancialcareers.core.domain.bean.enums.PositionType
import com.efinancialcareers.core.domain.bean.enums.Sector
import com.efinancialcareers.core.domain.bean.enums.SubSector
import com.efinancialcareers.core.domain.bean.enums.Title
import com.efinancialcareers.core.domain.bean.enums.TravelRate
import com.efinancialcareers.core.domain.bean.enums.YearsExperience
import org.apache.commons.lang.RandomStringUtils

putDataset("MyEfcLiveJobsWithUser") {

    def random = RandomStringUtils.randomAlphabetic(10);

    (1..1).each { jobId ->
        Job(uid: "Job${jobId}UID".toString(), positionType: "PERMANENT",
                employmentType: "PART_TIME",
                currency: "USD",
                yearsExperience: "FIVE_SEVEN_YEARS_EXPERIENCE",
                salaryBand: "ONE_HUNDRED_AND_FIFTY_TO_TWO_HUNDRED_AND_FIFTY",
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
                            contactCompanyName: "company name",
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
                            title: "${random}",
                            description: "We are looking for a newly qualified ACA candidate with Financial Services audit experience to join Collateral Optimisation Product Control. This person will become a key member of the team, liaising regularly with members of the FO, Finance, Risk and other areas within the bank. ${random}",
                            summary: "default summary job ${random}",
                            salaryDescription: "45,000 - 65,000 ${random}",
                            workPermitRequirements: "default perm requirements job ${random}",
                            languageCode: "EN"
                    )

                }
    }

    final Calendar jobAllocationStartDate1 = Calendar.getInstance();
    jobAllocationStartDate1.add(Calendar.DAY_OF_MONTH, -3);

    (1..1).each { jobAllocId ->
        final Calendar allocationExpirationDate1 = Calendar.getInstance();
        allocationExpirationDate1.add(Calendar.DAY_OF_MONTH, 1);

        JobAllocation(uid: "JobAllocation${jobAllocId}UID",
                startDate: jobAllocationStartDate1.getTime(),
                expirationDate: allocationExpirationDate1.getTime(),
                dbTeamName: "Finance Automation"
        ){
            job(refId: "Job${jobAllocId}UID")
        }
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
            uid: "ResumeUID${it}",
            status: EntityStatus.ACTIVE.name(),
            originalFileName: "jobSeekerFile.doc",
            filePath: "my-resume-file.doc",
            fileContent: "QADefaultResumeText",
            refno: 123456789,
            fileFormat: FileFormat.DOC
    ) { uid = it -> jobSeeker(refId: "JobSeekerUID${uid}") }

    CoverLetter(
            uid: "CoverLetterUID${it}",
            title: "JobSeeker Cover Letter",
            text: "JobSeeker Cover Letter TEXT"
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
