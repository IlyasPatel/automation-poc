package datasets

import com.efinancialcareers.core.domain.bean.enums.EntityStatus
import com.efinancialcareers.core.domain.bean.enums.Title
import org.apache.commons.lang.RandomStringUtils

putDataset("MyEfcLiveJobsWithUserIncompleteProfile") {

    def random = RandomStringUtils.randomAlphabetic(10);

    JobSeeker(
            uid: "JobSeekerUID${it}",
            firstName: "Automation",
            lastName: "User",
            displayName: "Test User",
            email: "testuser${random}@mailinator.com",
            isAnonymous: true,
            searchable: false,
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
