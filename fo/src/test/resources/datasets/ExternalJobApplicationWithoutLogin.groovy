package datasets

import com.efinancialcareers.core.domain.bean.enums.EntityStatus
import com.efinancialcareers.core.domain.bean.enums.FileFormat
import com.efinancialcareers.core.domain.bean.enums.Title
import com.efinancialcareers.core.domain.bean.enums.YearsExperience
import com.efinancialcareers.core.testdatautil.core.testobject.JobSeeker
import com.efinancialcareers.core.testdatautil.core.testobject.JobSeekerAddress
import org.apache.commons.lang.RandomStringUtils

putDataset("MyEfcLiveJobsWithUser") {

    def random = RandomStringUtils.randomAlphabetic(10);

    User(uid: "testUser", firstName: "Firstname", lastName: "Lastname", email: "test${random}@test.com", approved: true, internal: false)

    Account(uid: "testAccount", apiKey: "apiKey${random}", apiPassword: "apiPassword1", accountType: "BACK_OFFICE") {
        user(refId: "testUser")
        dbRoleLabels:["Recruiter"]
    }

    Brand(
            uid: "brand_for_jobs",
            name: "brand for jobs"
    )

    Company(
            uid: "CompanyUID",
            name: "Barclays Capital ${random}",
            url: "www.company.com",
            companyType: "DIRECT_EMPLOYER",
            siebelReferenceNumber: "${random}",
            isOfccpCompliant: true,
            status: 1,
            allowExternalAppsWithoutLogin: true,
            parent: null
    ){
        users(refId: "testUser")
        brands(refId: "brand_for_jobs")
    }

    Team(
            uid: "Team1UID",
            name: "Team1"
    ){
        company(refId: "CompanyUID")
        users(refId: "testUser")
        brands(refId: "brand_for_jobs")
    }

    Contract(
            uid: "ContractUID",
            contractRefNum: "${random}"
    ){
        company(refId: "CompanyUID")
    }

    final Calendar inventStartDate = Calendar.getInstance();
    inventStartDate.add(Calendar.DAY_OF_MONTH, 0);

    final Calendar inventExpirationDate = Calendar.getInstance();
    inventExpirationDate.add(Calendar.DAY_OF_MONTH, 30);

    Inventory(
            uid: "InventoryUID",
            inventorySubType: "SLOT",
            amount: 20,
            startDate: inventStartDate.getTime(),
            expirationDate: inventExpirationDate.getTime(),
            allocated: true,
            locationRefId: -1L
    ){
        contract(refId: "ContractUID")
    }

    InventoryAllocation(
            uid: "InventoryAllocation1UID",
            totalAmount: 20
    ){
        inventory(refId: "InventoryUID")
        team(refId: "Team1UID")
    }


    (1..1).each { jobId ->
        Job(uid: "Job${jobId}UID".toString(), positionType: "PERMANENT",
                employmentType: "PART_TIME",
                currency: "USD",
                yearsExperience: "FIVE_SEVEN_YEARS_EXPERIENCE",
                salaryBand: "ONE_HUNDRED_AND_FIFTY_TO_TWO_HUNDRED_AND_FIFTY",
                jobReference: "job reference",
                jobApplicationMethod: "EXTERNAL_APPLICATION",
                externalApplicationURL: "https://www.google.co.uk/",
                autoReply: false,
                screenQuestionary: false,
                locationId: "2643743")
                {
                    user(refId: "testUser")
                    company(refId: "CompanyUID")
                    brand(refId: "brand_for_jobs")
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
                            description: "We are looking for a newly qualified ACA candidate with Financial Services audit experience to join Collateral Optimisation Product Control. ${random}",
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
                expirationDate: allocationExpirationDate1.getTime()
        ){
            job(refId: "Job${jobAllocId}UID")
            inventoryAllocation(refId: "InventoryAllocation1UID")
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

    JobSeekerWorkSummary(
            profileTitle: "Profile Title",
            yearsExperience: YearsExperience.FIVE_SEVEN_YEARS_EXPERIENCE.name(),
            yearOfGraduation: 2000,
    ) { uid = it -> jobSeeker(refId: "JobSeekerUID${uid}") }

    Resume(
            uid: "ResumeUID${it}",
            status: EntityStatus.ACTIVE.name(),
            originalFileName: "jobSeekerFile.doc",
            filePath: "my-resume-file.txt",
            refno: 123456789,
            fileFormat: FileFormat.TXT
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
            accountVerificationToken: "accountVerificationToken"
    ) { uid = it -> jobSeeker(refId: "JobSeekerUID${uid}") }

}
