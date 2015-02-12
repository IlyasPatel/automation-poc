package datasets

import com.efinancialcareers.core.domain.bean.enums.EntityStatus
import com.efinancialcareers.core.domain.bean.enums.FileFormat
import com.efinancialcareers.core.domain.bean.enums.JobApplicationStatus
import com.efinancialcareers.core.domain.bean.enums.Title
import com.efinancialcareers.core.domain.bean.enums.YearsExperience
import org.apache.commons.lang.RandomStringUtils

putDataset("MyEfcLiveJobsWithUser") {

    def random = RandomStringUtils.randomAlphabetic(10);

    final Calendar jobAllocationStartDate1 = Calendar.getInstance();
    jobAllocationStartDate1.add(Calendar.DAY_OF_MONTH, -3);

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
            locationId: "1796236",
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
                    title: "物质转移师 投资经理 ${random}",
                    description: "职位职能:  搬运工  普工/操作工 职位描述: 一、岗位职责： 1、负责物品装卸、搬运、摆放及防损工作； 2、上级领导交办的其他工作。 二、任职资格 1、有1年以上同等职位工作经验者优先考虑； 2、懂得消防知识，有物流经验者更佳； 3、能吃苦耐劳，有责任心。 三、态度 1、体格强壮，有责任心； 2、吃苦耐劳，有敬业精神。 四、备注： 1、有意向者看直接来面试招募处面试； ${random}",
                    summary: "搬运工人 搬砖工 ${random}",
                    salaryDescription: "45,000 - 65,000 ${random}",
                    workPermitRequirements: "default perm requirements job ${random}",
                    languageCode: "EN"
                )

    }

    JobAllocation(uid: "JobAllocation1UID",
            startDate: jobAllocationStartDate1.getTime(),
            expirationDate: allocationExpirationDate1.getTime(),
            dbTeamName: "Finance Automation"
    ){
            job(refId: "Job1UID")
    }

    JobSeeker(
            uid: "JobSeekerUID1",
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

    MyEfcUser(
            uid: "MyEfcUserUID",
            password: "testing123",
            salt: "1234567891234567",
            isVerified: true,
            tokenGenDate: Calendar.getInstance().getTime(),
            accountVerificationToken: "accountVerificationToken",
            statusId: EntityStatus.ACTIVE

    ) {jobSeeker(refId: "JobSeekerUID1") }

    MyEfcJob(
            uid: "SavedJob1UID",
    ) {
        user(refId: "MyEfcUserUID")
        job(refId: "Job1UID")
    }

}
