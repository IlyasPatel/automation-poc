package datasets

import com.efinancialcareers.core.domain.bean.enums.EntityStatus
import com.efinancialcareers.core.domain.bean.enums.Title
import com.efinancialcareers.core.domain.bean.enums.YearsExperience
import com.efinancialcareers.myefc.qa.utils.fo.FoPropertiesLoader
import org.apache.commons.lang.RandomStringUtils

putDataset("MyEfcLiveJobsWithUser") {

    def random = RandomStringUtils.randomAlphabetic(10);

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
