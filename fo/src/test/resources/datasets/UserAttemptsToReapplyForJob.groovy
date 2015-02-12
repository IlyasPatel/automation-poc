package datasets

import com.efinancialcareers.core.domain.bean.enums.EntityStatus
import com.efinancialcareers.core.domain.bean.enums.FileFormat
import com.efinancialcareers.core.domain.bean.enums.JobApplicationStatus
import com.efinancialcareers.core.domain.bean.enums.Title
import com.efinancialcareers.core.domain.bean.enums.YearsExperience
import org.apache.commons.lang.RandomStringUtils

putDataset("MyEfcLiveJobsWithUser") {

    def random = RandomStringUtils.randomAlphabetic(10);

    Job(uid: "JobUID1", positionType: "PERMANENT",
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
            job(refId: "JobUID1")
        }
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

    Resume(
            uid: "ResumeUID1",
            status: EntityStatus.ACTIVE.name(),
            originalFileName: "jobSeekerFile.doc",
            filePath: "my-resume-file.txt",
            refno: 123456789,
            fileFormat: FileFormat.TXT
    ) { jobSeeker(refId: "JobSeekerUID1") }

    MyEfcUser(
            uid: "MyEfcUserUID1",
            password: "testing123",
            salt: "1234567891234567",
            isVerified: true,
            tokenGenDate: Calendar.getInstance().getTime(),
            accountVerificationToken: "accountVerificationToken"
    ) { jobSeeker(refId: "JobSeekerUID1") }

    MyEfcJob(
            uid: "myEfcJob1",
            isApplied: true
    ){
        job(refId: "JobUID1")
        user(refId: "MyEfcUserUID1")
    }

    JobApplication(
            uid: "jobApplication27",
            statusId: JobApplicationStatus.NOT_MARKED.getId(),
            locationId: "2643743",
            ipLocationId: "32767"
    ){
        myEfcJob(refId: "myEfcJob1")
        user(refId: "MyEfcUserUID1")
        jobSeeker(refId: "JobSeekerUID1")
        resume(refId: "ResumeUID1")
    }

}