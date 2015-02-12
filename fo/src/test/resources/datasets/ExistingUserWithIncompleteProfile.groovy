package datasets

import com.efinancialcareers.core.domain.bean.enums.CurrencyType
import com.efinancialcareers.core.domain.bean.enums.EmploymentType
import com.efinancialcareers.core.domain.bean.enums.EntityStatus
import com.efinancialcareers.core.domain.bean.enums.FileFormat
import com.efinancialcareers.core.domain.bean.enums.PositionType
import com.efinancialcareers.core.domain.bean.enums.Sector
import com.efinancialcareers.core.domain.bean.enums.SubSector
import com.efinancialcareers.core.domain.bean.enums.Title
import com.efinancialcareers.core.domain.bean.enums.TravelRate
import com.efinancialcareers.core.domain.bean.enums.YearsExperience
import org.apache.commons.lang.RandomStringUtils

putDataset("MyEfcLiveJobsWithUserIncompleteProfile") {

    def random = RandomStringUtils.randomAlphabetic(10);
    resumeText = [
            "I am a banker located in Moscow who would like to work in banks, I have no experience working in banking sector, I have more than one work permit in EU, Belgium, and Germany. I am willing to relocate to Paris, Berlin, Rome, Minsk. I am proficient in various languages, English is my first language, Fluent in French, I speak basic Japanese. I am working in Accounting & Finance in Audit subsector. I am a fresh graduate with No experience. I don't want to specify my education level. I am looking for a PERMANENT and Full Time position. I have a little desire to travel with 25% out of 100%. I expect a minimum salary of GBP 100000 with my resume searchable from potential employer.",
            "I am an economist staying in London with strong interest in Economists. UK. I am holding multiple work permits in Malaysia, France, Italy. I am willing to relocate to Malaysia, Berlin, Rome, Minsk. I can speak English because this is my first language, I can speak Fluent French, can speak and write Malay in Competent level. I am working in Asset Management sector in CIO. I finished my High School education and have 1-3 years working experience. I would like to get into FULL Time with TEMPORARY position. I am expecting to earn at least GBP 50000. I am not willing to relocate to anywhere. I have set my resume to searchable.",
            "Candidate staying in Paris, France, with work permit of UK, Singapore, Australia. I was a developer proficient in C#, C++, .net, and Java. I am willing to relocate to Edinburgh, Singapore, Canberra, Minsk. English is my First Language, I do speak Fluent Tamil and Basic German. I have 5 years experience in Capital Markets in Documentation Structuring. I have finished my Diploma course as my highest education. I am currently looking for Part Time Contract work expecting a minimum salary of EUR 20000. I am willing to travel with a rate of 75%. I have made this resume searchable to everybody from the job sites."
    ];

    JobSeeker(
            uid: "JobSeekerUID${it}",
            title: Title.PROF.name(),
            firstName: "Automation",
            lastName: "User",
            displayName: "Test User",
            email: "testuser${random}@mailinator.com",
            isAnonymous: true,
            searchable: false,
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
