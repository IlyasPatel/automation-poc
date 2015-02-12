package datasets


import com.efinancialcareers.core.domain.bean.enums.CurrencyType
import com.efinancialcareers.core.domain.bean.enums.EmploymentType
import com.efinancialcareers.core.domain.bean.enums.JobApplicationMethodType
import com.efinancialcareers.core.domain.bean.enums.PositionType
import com.efinancialcareers.core.domain.bean.enums.SalaryBand
import com.efinancialcareers.core.domain.bean.enums.YearsExperience
import com.efinancialcareers.myefc.qa.dataBase.DBManager
import com.efinancialcareers.myefc.qa.dataBase.beans.SkillBean
import org.apache.commons.lang.RandomStringUtils

putDataset("JobWithSkillsSynonyms_DE") {
    language = "DE";
    def List <SkillBean> skillAndSynonyms = DBManager.getSynonymsAndSkillsForLanguage(language);
    String random = RandomStringUtils.randomAlphanumeric(6);
    Calendar startDate = Calendar.getInstance();
    startDate.add(Calendar.DATE, -1);
    Calendar endDate = Calendar.getInstance();
    endDate.add(Calendar.DATE, 2);
    Calendar jobRefreshDate = Calendar.getInstance();
    jobRefreshDate.add(Calendar.MINUTE, -10);
    SkillBean lastSkill = skillAndSynonyms.get(skillAndSynonyms.size()-1);
    for (int i = 0; i< lastSkill.getSynonyms().length; i++){
        String description = "";
        for (e in skillAndSynonyms ){
            try {
                description = description +" "+ e.getSynonyms()[i];
            } catch (IndexOutOfBoundsException e1) {
                description = description +" "+ e.getSynonyms()[0];
            }
        }
        Job(uid: "JobUID${i}", positionType: PositionType.PERMANENT.name(),
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
                            title: "Test Job ${random}_${i}_"+language,
                            description: "Job number_${i} ${description}",
                            summary: "default summary job ${random}",
                            salaryDescription: "45,000 - 65,000 ${random}",
                            workPermitRequirements: "default perm requirements job ${random}",
                            languageCode: language
                    )

                }

        JobAllocation(uid: "JobAllocationUID${i}",
                startDate: startDate.getTime(),
                expirationDate: endDate.getTime(),
                dbTeamName: "Finance Automation"
        ){
            job(refId: "JobUID${i}")

        }
    }
}
