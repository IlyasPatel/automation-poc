package datasets

import com.efinancialcareers.core.domain.bean.enums.EntityStatus
import com.efinancialcareers.core.domain.bean.enums.MailingInterval
import com.efinancialcareers.core.domain.bean.enums.Title
import com.efinancialcareers.myefc.qa.utils.fo.FoPropertiesLoader

putDataset("MyEfcLiveJobsWithUser") {

    def random = UUID.randomUUID().toString().substring(0, 18);

    JobSeeker(
            uid: "JobSeekerUID1",
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
            uid: "MyEfcUserUID1",
            password: "testing123",
            salt: "1234567891234567",
            isVerified: true,
            tokenGenDate: Calendar.getInstance().getTime(),
            accountVerificationToken: "accountVerificationToken",
            statusId: EntityStatus.ACTIVE
    ) { uid = it -> jobSeeker(refId: "JobSeekerUID1") }

    JobSavedSearch(
            uid: "JobSavedSearchUID1",
            name: "Search Alert Automation 1",
            query: "{\"keywords\":\"\",\"language\":\"en\",\"localeCountry\":\"GB\",\"requestHandler\":\"FRONT_OFFICE\",\"paging\":{\"rows\":24,\"start\":0},\"strips\":[\"JOB_DESCRIPTION\",\"JOB_SUMMARY\",\"JOB_TITLE\"],\"resultFilters\":[{\"facet\":\"JOB_REFRESH_DT\",\"facetValues\":[\"OTHER\"]}],\"facetConfigs\":[{\"facet\":\"JOB_EMPLOYMENT_TYPE\",\"facetOrder\":{\"order\":\"DESC\",\"orderBy\":\"COUNT\",\"count\":-1,\"minCount\":1},\"include\":true},{\"facet\":\"JOB_POSITION_TYPE\",\"facetOrder\":{\"order\":\"DESC\",\"orderBy\":\"COUNT\",\"count\":-1,\"minCount\":1},\"include\":true},{\"facet\":\"JOB_REFRESH_DT\",\"facetOrder\":{\"order\":\"DESC\",\"orderBy\":\"COUNT\",\"count\":-1,\"minCount\":1},\"include\":true},{\"facet\":\"JOB_SKILLS\",\"facetOrder\":{\"order\":\"ASC\",\"orderBy\":\"NAME\",\"count\":-1,\"minCount\":1},\"include\":true},{\"facet\":\"BRAND_ID\",\"facetOrder\":{\"order\":\"ASC\",\"orderBy\":\"NAME\",\"count\":-1,\"minCount\":1},\"include\":true},{\"facet\":\"IS_ANONYMOUS\",\"facetOrder\":{\"order\":\"DESC\",\"orderBy\":\"COUNT\",\"count\":-1,\"minCount\":1},\"include\":true},{\"facet\":\"JOB_4T_LOCATION_TREE\",\"include\":true},{\"facet\":\"JOB_LOCATION_REGION_IDS\",\"facetOrder\":{\"order\":\"ASC\",\"orderBy\":\"NAME\",\"count\":-1,\"minCount\":1},\"include\":false},{\"facet\":\"JOB_LOCATION_COUNTRY_ID\",\"facetOrder\":{\"order\":\"ASC\",\"orderBy\":\"NAME\",\"count\":-1,\"minCount\":1},\"include\":false},{\"facet\":\"JOB_LOCATION_AD_ID\",\"facetOrder\":{\"order\":\"DESC\",\"orderBy\":\"COUNT\",\"count\":-1,\"minCount\":1},\"include\":false},{\"facet\":\"JOB_LOCATION_CITY_ID\",\"facetOrder\":{\"order\":\"DESC\",\"orderBy\":\"COUNT\",\"count\":-1,\"minCount\":1},\"include\":false},{\"facet\":\"JOB_SECTOR_TREE\",\"include\":true},{\"facet\":\"JOB_SECTORS\",\"facetOrder\":{\"order\":\"ASC\",\"orderBy\":\"NAME\",\"count\":-1,\"minCount\":1},\"include\":false},{\"facet\":\"JOB_SUB_SECTORS\",\"facetOrder\":{\"order\":\"ASC\",\"orderBy\":\"NAME\",\"count\":-1,\"minCount\":1},\"include\":false},{\"facet\":\"JOB_SALARY_TREE\",\"include\":true},{\"facet\":\"JOB_SALARY_CURRENCY\",\"facetOrder\":{\"order\":\"DESC\",\"orderBy\":\"COUNT\",\"count\":-1,\"minCount\":1},\"include\":false},{\"facet\":\"JOB_SALARY_BAND\",\"facetOrder\":{\"order\":\"ASC\",\"orderBy\":\"VALUE\",\"count\":-1,\"minCount\":1},\"include\":false},{\"facet\":\"HAS_SALARY_BAND\",\"facetOrder\":{\"order\":\"DESC\",\"orderBy\":\"COUNT\",\"count\":-1,\"minCount\":1},\"include\":true}],\"returnSections\":[\"PREVIEWS\",\"FACETS\",\"REQUEST\"],\"returnFields\":[\"JOB_ID\",\"JOB_TITLE\",\"JOB_SUMMARY\",\"JOB_DESCRIPTION\",\"JOB_SALARY_DESCRIPTION\",\"BRAND_ID\",\"BRAND_NAME\",\"IS_ANONYMOUS\",\"JOB_CONTACT\",\"JOB_LOCATION_ID\",\"JOB_EMPLOYMENT_TYPE\",\"JOB_POSITION_TYPE\",\"JOB_SALARY_CURRENCY\",\"JOB_SALARY_BAND\",\"JOB_REFRESH_DT\",\"JOB_MODIFIED_DT\",\"JOB_EXPIRATION_DT\",\"JOB_COMPANY_ID\",\"CITY_NAME\",\"COUNTRY_NAME\",\"JOB_SECTORS\",\"JOB_SUB_SECTORS\",\"JOB_APPLICATION_METHOD\",\"JOB_EXTERNAL_APPLICATION_URL\",\"JOB_REF\",\"EA_LICENCE_NUM\",\"SCORE\"],\"textLength\":750}",
            mailingInterval: MailingInterval.NEVER
    ) { uid = it -> myEfcUser(refId: "MyEfcUserUID1") }

    JobSavedSearch(
            uid: "JobSavedSearchUID2",
            name: "Search Alert Automation 2",
            query: "{\"keywords\":\"\",\"language\":\"en\",\"localeCountry\":\"GB\",\"requestHandler\":\"FRONT_OFFICE\",\"paging\":{\"rows\":24,\"start\":0},\"strips\":[\"JOB_DESCRIPTION\",\"JOB_SUMMARY\",\"JOB_TITLE\"],\"resultFilters\":[{\"facet\":\"JOB_REFRESH_DT\",\"facetValues\":[\"OTHER\"]}],\"facetConfigs\":[{\"facet\":\"JOB_EMPLOYMENT_TYPE\",\"facetOrder\":{\"order\":\"DESC\",\"orderBy\":\"COUNT\",\"count\":-1,\"minCount\":1},\"include\":true},{\"facet\":\"JOB_POSITION_TYPE\",\"facetOrder\":{\"order\":\"DESC\",\"orderBy\":\"COUNT\",\"count\":-1,\"minCount\":1},\"include\":true},{\"facet\":\"JOB_REFRESH_DT\",\"facetOrder\":{\"order\":\"DESC\",\"orderBy\":\"COUNT\",\"count\":-1,\"minCount\":1},\"include\":true},{\"facet\":\"JOB_SKILLS\",\"facetOrder\":{\"order\":\"ASC\",\"orderBy\":\"NAME\",\"count\":-1,\"minCount\":1},\"include\":true},{\"facet\":\"BRAND_ID\",\"facetOrder\":{\"order\":\"ASC\",\"orderBy\":\"NAME\",\"count\":-1,\"minCount\":1},\"include\":true},{\"facet\":\"IS_ANONYMOUS\",\"facetOrder\":{\"order\":\"DESC\",\"orderBy\":\"COUNT\",\"count\":-1,\"minCount\":1},\"include\":true},{\"facet\":\"JOB_4T_LOCATION_TREE\",\"include\":true},{\"facet\":\"JOB_LOCATION_REGION_IDS\",\"facetOrder\":{\"order\":\"ASC\",\"orderBy\":\"NAME\",\"count\":-1,\"minCount\":1},\"include\":false},{\"facet\":\"JOB_LOCATION_COUNTRY_ID\",\"facetOrder\":{\"order\":\"ASC\",\"orderBy\":\"NAME\",\"count\":-1,\"minCount\":1},\"include\":false},{\"facet\":\"JOB_LOCATION_AD_ID\",\"facetOrder\":{\"order\":\"DESC\",\"orderBy\":\"COUNT\",\"count\":-1,\"minCount\":1},\"include\":false},{\"facet\":\"JOB_LOCATION_CITY_ID\",\"facetOrder\":{\"order\":\"DESC\",\"orderBy\":\"COUNT\",\"count\":-1,\"minCount\":1},\"include\":false},{\"facet\":\"JOB_SECTOR_TREE\",\"include\":true},{\"facet\":\"JOB_SECTORS\",\"facetOrder\":{\"order\":\"ASC\",\"orderBy\":\"NAME\",\"count\":-1,\"minCount\":1},\"include\":false},{\"facet\":\"JOB_SUB_SECTORS\",\"facetOrder\":{\"order\":\"ASC\",\"orderBy\":\"NAME\",\"count\":-1,\"minCount\":1},\"include\":false},{\"facet\":\"JOB_SALARY_TREE\",\"include\":true},{\"facet\":\"JOB_SALARY_CURRENCY\",\"facetOrder\":{\"order\":\"DESC\",\"orderBy\":\"COUNT\",\"count\":-1,\"minCount\":1},\"include\":false},{\"facet\":\"JOB_SALARY_BAND\",\"facetOrder\":{\"order\":\"ASC\",\"orderBy\":\"VALUE\",\"count\":-1,\"minCount\":1},\"include\":false},{\"facet\":\"HAS_SALARY_BAND\",\"facetOrder\":{\"order\":\"DESC\",\"orderBy\":\"COUNT\",\"count\":-1,\"minCount\":1},\"include\":true}],\"returnSections\":[\"PREVIEWS\",\"FACETS\",\"REQUEST\"],\"returnFields\":[\"JOB_ID\",\"JOB_TITLE\",\"JOB_SUMMARY\",\"JOB_DESCRIPTION\",\"JOB_SALARY_DESCRIPTION\",\"BRAND_ID\",\"BRAND_NAME\",\"IS_ANONYMOUS\",\"JOB_CONTACT\",\"JOB_LOCATION_ID\",\"JOB_EMPLOYMENT_TYPE\",\"JOB_POSITION_TYPE\",\"JOB_SALARY_CURRENCY\",\"JOB_SALARY_BAND\",\"JOB_REFRESH_DT\",\"JOB_MODIFIED_DT\",\"JOB_EXPIRATION_DT\",\"JOB_COMPANY_ID\",\"CITY_NAME\",\"COUNTRY_NAME\",\"JOB_SECTORS\",\"JOB_SUB_SECTORS\",\"JOB_APPLICATION_METHOD\",\"JOB_EXTERNAL_APPLICATION_URL\",\"JOB_REF\",\"EA_LICENCE_NUM\",\"SCORE\"],\"textLength\":750}",
            mailingInterval: MailingInterval.DAILY
    ) { uid = it -> myEfcUser(refId: "MyEfcUserUID1") }
}
