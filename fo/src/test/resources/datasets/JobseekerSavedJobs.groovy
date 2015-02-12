package datasets

import com.efinancialcareers.core.domain.bean.enums.EntityStatus
import com.efinancialcareers.core.domain.bean.enums.FileFormat
import com.efinancialcareers.core.domain.bean.enums.JobApplicationStatus
import com.efinancialcareers.core.domain.bean.enums.Title
import com.efinancialcareers.core.domain.bean.enums.YearsExperience
import org.apache.commons.lang.RandomStringUtils

putDataset("JobseekerSavedJobs") {

    MyEfcJob (
        uid: "SavedJob1UID",
    ) {
        user(refId: "JobseekerInLondonWithCompletedProfile.MyEfcUserUID1")
        job(refId: "SingleExternalLiveJob.ExternalJob1UID")
    }

    MyEfcJob (
        uid: "SavedJob2UID",
    ) {
        user(refId: "JobseekerInLondonWithCompletedProfile.MyEfcUserUID1")
        job(refId: "SingleInternalLiveJob.InternalJob1UID")
    }
}
