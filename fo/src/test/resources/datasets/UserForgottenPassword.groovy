package datasets

import com.efinancialcareers.core.domain.bean.enums.EntityStatus
import com.efinancialcareers.core.domain.bean.enums.Title
import com.efinancialcareers.myefc.qa.domain.DisposableEmailProvider
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

    MyEfcUser(
            uid: "MyEfcUserUID${it}",
            password: "testing123",
            salt: "1234567891234567",
            isVerified: true,
            tokenGenDate: Calendar.getInstance().getTime(),
            accountVerificationToken: "accountVerificationToken"
    ) { uid = it -> jobSeeker(refId: "JobSeekerUID${uid}") }

}
