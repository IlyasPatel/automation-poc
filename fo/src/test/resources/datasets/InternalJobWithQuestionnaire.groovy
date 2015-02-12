package datasets

import org.apache.commons.lang.RandomStringUtils

putDataset("MyEfcLiveJobs") {

    def random = RandomStringUtils.randomAlphabetic(10);

    ScreenQuestionnaire(
            uid: "ScreenQuestionnaire1",
            introductoryText: "Some text for introduction here additional questions does not prevent app",
            preventApplication: false,
            template: false
    )

    WorkPermitLocationQuestion(
            uid: "LocationQuestion1UID",
            questionResponseType: "YES_NO",
            desiredResponse: true,
            answerMandatory: true,
            locationId: "630336",
            preventApplication: true
    ) {
        screenQuestionnaire(refId: "ScreenQuestionnaire1")
    }

    LivingPlaceLocationQuestion(
            uid: "LocationQuestion2UID",
            questionResponseType: "YES_NO",
            desiredResponse: true,
            answerMandatory: true,
            locationId: "630336",
            preventApplication: true
    ) {
        screenQuestionnaire(refId: "ScreenQuestionnaire1")
    }



    AdditionalQuestion(
            uid: "AdditionalQuestion1UID",
            questionResponseType: "YES_NO",
            desiredResponse: true,
            answerMandatory: true,
            text: "Additional question ONE yes/no type",
            index: 0
    ) {
        screenQuestionnaire(refId: "ScreenQuestionnaire1")
    }

    AdditionalQuestion(
            uid: "AdditionalQuestion2UID",
            questionResponseType: "YES_NO",
            desiredResponse: true,
            answerMandatory: true,
            text: "Additional question TWO yes/no type",
            index: 1
    ) {
        screenQuestionnaire(refId: "ScreenQuestionnaire1")
    }

    AdditionalQuestion(
            uid: "AdditionalQuestion3UID",
            questionResponseType: "YES_NO",
            desiredResponse: true,
            answerMandatory: true,
            text: "Additional question THREE yes/no type",
            index: 2
    ) {
        screenQuestionnaire(refId: "ScreenQuestionnaire1")
    }

    AdditionalQuestion(
            uid: "AdditionalQuestion4UID",
            questionResponseType: "YES_NO",
            desiredResponse: true,
            answerMandatory: true,
            text: "Additional question FOUR yes/no type",
            index: 3
    ) {
        screenQuestionnaire(refId: "ScreenQuestionnaire1")
    }

    (1..1).each { jobId ->
        Job(uid: "Job${jobId}UID".toString(), positionType: "PERMANENT",
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
                    associatedScreenQuestionnaire(refId: "ScreenQuestionnaire1")
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
            job(refId: "Job${jobAllocId}UID")
        }
    }

}
