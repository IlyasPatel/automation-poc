package datasets


import com.efinancialcareers.core.domain.bean.enums.CurrencyType
import com.efinancialcareers.core.domain.bean.enums.EmploymentType
import com.efinancialcareers.core.domain.bean.enums.JobApplicationMethodType
import com.efinancialcareers.core.domain.bean.enums.PositionType
import com.efinancialcareers.core.domain.bean.enums.SalaryBand
import com.efinancialcareers.core.domain.bean.enums.YearsExperience
import com.efinancialcareers.myefc.qa.dataBase.DBManager
import com.efinancialcareers.myefc.qa.dataBase.beans.SkillBean
import com.efinancialcareers.qa.utils.DataExtractor
import org.apache.commons.lang.RandomStringUtils

putDataset("LangSpecific_FR") {

    String LANG = "FR"
    String random = RandomStringUtils.randomAlphanumeric(6);
    Calendar startDate = Calendar.getInstance();
    startDate.add(Calendar.DATE, -1);
    Calendar endDate = Calendar.getInstance();
    endDate.add(Calendar.DATE, 2);
    Calendar jobRefreshDate = Calendar.getInstance();
    jobRefreshDate.add(Calendar.MINUTE, -10);
    String description = "";
    for (String iterator : DataExtractor.getWordsWithLangSymbols(LANG)){
        description = description +" "+ iterator;
    }
    Job(uid: "JobUID", positionType: PositionType.PERMANENT.name(),
            employmentType: EmploymentType.PART_TIME.name(),
            currency: CurrencyType.EUR.name(),
            yearsExperience: YearsExperience.FIVE_SEVEN_YEARS_EXPERIENCE.name(),
            salaryBand: SalaryBand.FIRST_TIER.name(),
            jobReference: "${random}",
            jobApplicationMethod: JobApplicationMethodType.BACK_OFFICE.name(),
            externalApplicationURL: "http://www.google.co.uk",
            autoReply: false,
            screenQuestionary: false,
            refresh: jobRefreshDate.getTime(),
            locationId: "2643743",
            dbCompanyName: "Demo Finance",
            dbUserEmail: "automation1@mailinator.com",
            dbBrandName: "Finance Automation")
            {
                contactDetails(
                        contactCompanyName: "Demo Finance",
                        displayContactCompanyName: true

                )
                primarySector(
                        sectorCode: "ACCOUNTING_FINANCE",
                        subSectorCode: "ACCOUNTING_FINANCE__AUDIT"
                )
                secondarySector(
                        sectorCode: "ACCOUNTING_FINANCE",
                        subSectorCode: "ACCOUNTING_FINANCE__FD_CFO"
                )
                defaultDescription(
                        title: "Language Specific Symbols${random}_"+LANG,
                        description: "Job ${description}",
                        summary: "default summary job ${random}",
                        salaryDescription: "45,000 - 65,000 ${random}",
                        workPermitRequirements: "default perm requirements job ${random}",
                        languageCode: LANG
                )

            }

            JobAllocation(uid: "JobAllocationUID",
                    startDate: startDate.getTime(),
                    expirationDate: endDate.getTime(),
                    dbTeamName: "Finance Automation"
            ){
                job(refId: "JobUID")

            }
}
