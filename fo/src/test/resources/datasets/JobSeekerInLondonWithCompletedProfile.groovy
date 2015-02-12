package datasets

import com.efinancialcareers.core.domain.bean.enums.EntityStatus
import com.efinancialcareers.core.domain.bean.enums.Title
import com.efinancialcareers.core.domain.bean.enums.YearsExperience
import org.apache.commons.lang.RandomStringUtils

putDataset("JobSeekerInLondon") {

    def random = RandomStringUtils.randomAlphabetic(10);

    JobSeeker(
        uid: "JobSeekerUID",
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
        locationRefId: "2643743"
    ) { jobSeeker(refId: "JobSeekerUID") }

    JobSeekerExperience(
        jobTitle: "programmer",
        description: "java, junit, tdd",
        companyName: "google",
        startDate: Calendar.getInstance().getTime(),
        endDate: Calendar.getInstance().getTime(),
        toPresent: true,
        locationRefId: "2643743"
    ) { jobSeeker(refId: "JobSeekerUID") }

    JobSeekerGulfAdditionalInfo(
        arabicFirstLanguage: true,
        genderCode: "FEMALE",
        yearOfBirth: "1995"
    ) { jobSeeker(refId: "JobSeekerUID") }

    JobSeekerQualification(
        speciality: "java programmer",
        educationLevel: "EDUCATION_LEVEL_10",
        startDate: Calendar.getInstance().getTime(),
        endDate: Calendar.getInstance().getTime(),
        toPresent: true
    ) { jobSeeker(refId: "JobSeekerUID") }

    JobSeekerWorkSummary(
        profileTitle: "Profile Title",
        yearsExperience: YearsExperience.FIVE_SEVEN_YEARS_EXPERIENCE.name(),
        yearOfGraduation: 2000,
    ) { jobSeeker(refId: "JobSeekerUID") }

    MyEfcUser(
        uid: "MyEfcUserUID${it}",
        password: "testing123",
        salt: "1234567891234567",
        isVerified: true,
        tokenGenDate: Calendar.getInstance().getTime(),
        accountVerificationToken: "accountVerificationToken"
    ) { jobSeeker(refId: "JobSeekerUID") }
}
