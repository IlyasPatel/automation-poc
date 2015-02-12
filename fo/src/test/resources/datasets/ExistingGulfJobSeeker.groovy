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
            status: EntityStatus.ACTIVE.name(),
            partnerId: 48
    )

    JobSeekerAddress(
            postalCode: "PZ112233",
            locationRefId: "292223"
    ) { uid = it -> jobSeeker(refId: "JobSeekerUID${uid}") }

    JobSeekerExperience(
            jobTitle: "programmer",
            description: "java, junit, tdd",
            companyName: "google",
            startDate: Calendar.getInstance().getTime(),
            endDate: Calendar.getInstance().getTime(),
            toPresent: true,
            locationRefId: "292223"
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
