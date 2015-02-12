package com.efinancialcareers.myefc.qa.desktop;

import com.efinancialcareers.myefc.qa.domain.Job;
import com.efinancialcareers.myefc.qa.domain.OpenIdProviderInterface;
import net.serenitybdd.core.Serenity;

import java.util.List;
import java.util.Map;

public enum SessionData {

    /**
     * Singleton
     */
    INSTANCE;

    /**
     * Put key, value into Serenity session
     * @param key key
     * @param value value
     */
    protected void putIntoSerenitySession(String key, Object value) {
        Serenity.getCurrentSession().put(key, value);
    }

    /**
     * Get value from Serenity session
     * @param key key
     */
    protected Object getFromSerenitySession(String key) {
        return Serenity.getCurrentSession().get(key);
    }

    public void setJobseekerEmail(String email) {
        putIntoSerenitySession("emailForLaterStep", email);
    }

    public String getJobseekerEmail() {
        return (String) getFromSerenitySession("emailForLaterStep");
    }

    public void setJobseekerNewPassword(String password) {
        putIntoSerenitySession("newPasswordForLaterStep", password);
    }

    public String getJobseekerNewPassword() {
        return (String) getFromSerenitySession("newPasswordForLaterStep");
    }

    public void setCurrentRefinementBrand(Long brandId) {
        putIntoSerenitySession("brandId", brandId);
    }

    public Long getCurrentRefinementBrand() {
        return (Long) getFromSerenitySession("brandId");
    }



    public String getAnalyticsRegistrationDataType() {
        return (String) getFromSerenitySession("analyticsRegistrationDataType");
    }

    public void setAnalyticsRegistrationDataType(String registrationDataType) {
        putIntoSerenitySession("analyticsRegistrationDataType", registrationDataType);
    }

    public void setJobAlertName(String jobAlertName) {
        putIntoSerenitySession("jobAlertName", jobAlertName);
    }

    public String getJobAlertName() {
        return (String) getFromSerenitySession("jobAlertName");
    }

    public String getAnalyticsHitPage() {
        return (String) getFromSerenitySession("analyticsHitPage");
    }

    public void setAnalyticsHitPage(String hitPage) {
        putIntoSerenitySession("analyticsHitPage", hitPage);
    }

    public void setFlashContext(Map<String, String> flash) {
        putIntoSerenitySession("flashContext", flash);
    }

    public Map<String, String> getFlashContext() {
        return (Map<String, String>) getFromSerenitySession("flashContext");
    }

    public boolean containsFlashKey(String key) {
        try {
            return getFlashContext().containsKey(key);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public void setOpenIdProviderName(String provider) {
        putIntoSerenitySession("openIdProviderName", provider);
    }

    public String getOpenIdProviderName() {
        return (String) getFromSerenitySession("openIdProviderName");
    }

    public void setOpenIdProvider(OpenIdProviderInterface provider) {
        putIntoSerenitySession("provider", provider);
    }

    public OpenIdProviderInterface getOpenIdProvider() {
        return (OpenIdProviderInterface) getFromSerenitySession("provider");
    }

    public void setStartedWithBurningGlass() {
        putIntoSerenitySession("isStartedWithBurningGlass", "true");
    }



    public void setIsLoggedIn() {
        putIntoSerenitySession("isLoggedIn", "true");
    }

    public void logout() {
        putIntoSerenitySession("isLoggedIn", "false");
    }

    public String getAnalyticsHitCategory() {
        return (String) getFromSerenitySession("analyticsHitCategory");
    }

    public void setAnalyticsHitCategory(String hitCategory) {
        putIntoSerenitySession("analyticsHitCategory", hitCategory);
    }

    public String getAnalyticsHitAction() {
        return (String) getFromSerenitySession("analyticsHitAction");
    }

    public void setAnalyticsHitAction(String hitAction) {
        putIntoSerenitySession("analyticsHitAction", hitAction);
    }

    public void setCoverLetterTitle(String coverLetterTitle) {
        putIntoSerenitySession("coverLetterTitle", coverLetterTitle);
    }

    public String getCoverLetterTitle() {
        return (String) getFromSerenitySession("coverLetterTitle");
    }

    public void setCoverLetterText(String coverLetterText) {
        putIntoSerenitySession("coverLetterText", coverLetterText);
    }

    public String getCoverLetterText() {
        return (String) getFromSerenitySession("coverLetterText");
    }

    public void setCurrentSiteLanguage(String currentSiteLanguage) {
        putIntoSerenitySession("currentSiteLanguage", currentSiteLanguage);
    }

    public String getCurrentSiteLanguage() {
        return (String) getFromSerenitySession("currentSiteLanguage");
    }

    public void setJobBean(Job job) {
        putIntoSerenitySession("jobForAssertion", job);
    }

    public Job getJobBean() {
        return (Job) getFromSerenitySession("jobForAssertion");
    }

    public void setKeyword(String keyword) {
        putIntoSerenitySession("keywordForLaterStep", keyword);
    }

    public String getKeyword() {
        return (String) getFromSerenitySession("keywordForLaterStep");
    }

    public void setLocation(String location) {
        putIntoSerenitySession("locationForLaterStep", location);
    }

    public String getLocation() {
        return (String) getFromSerenitySession("locationForLaterStep");
    }

    public void setJobFromDataSet(Job job) {
        putIntoSerenitySession("jobFromDataSet", job);
    }

    public Job getJobFromDataSet() {
        return (Job) getFromSerenitySession("jobFromDataSet");
    }

    public void setWaitForLoginToComplete(boolean waitForLoginToComplete) {
        putIntoSerenitySession("waitForLoginToComplete", waitForLoginToComplete);
    }

    public Boolean getWaitForLoginToComplete() {
        return (Boolean) getFromSerenitySession("waitForLoginToComplete");
    }

    public void setTotalNumberOfJobsFromSRP(int numberOfJobsFound) {
        putIntoSerenitySession("totalNumberOfJobsFromSRP", numberOfJobsFound);
    }

    public int getTotalNumberOfJobsFromSRP() {
        return (Integer) getFromSerenitySession("totalNumberOfJobsFromSRP");
    }

    public void setLinkText(String linkText) {
        putIntoSerenitySession("linkText", linkText);
    }

    public String getLinkText() {
        return (String) getFromSerenitySession("linkText");
    }

    public void setNonAnonymousCompanyNames(List<String> companyNames) {
        putIntoSerenitySession("nonAnonymousCompanyNames", companyNames);
    }

    public List<String> getNonAnonymousCompanyNames() {
        return (List<String>) getFromSerenitySession("nonAnonymousCompanyNames");
    }

    public void setAllCompanyNames(List<String> allCompanyNames) {
        putIntoSerenitySession("allCompanyNames", allCompanyNames);
    }

    public List<String> getAllCompanyNames() {
        return (List<String>) getFromSerenitySession("allCompanyNames");
    }

    public void setSectorSelectedLinkText(String sector) {
        putIntoSerenitySession("sectorSelectedLinkText", sector);
    }

    public String getSectorSelectedLinkText() {
        return (String) getFromSerenitySession("sectorSelectedLinkText");
    }

    public void setTotalNumberOfJobsFromHeader(int totalNumberOfJobsFromHeader) {
        putIntoSerenitySession("totalNumberOfJobsFromHeader", totalNumberOfJobsFromHeader);
    }

    public int getTotalNumberOfJobsFromHeader() {
        return (Integer) getFromSerenitySession("totalNumberOfJobsFromHeader");
    }

    public void setRandomSectorName(String randomSectorName) {
        putIntoSerenitySession("randomSectorName", randomSectorName);
    }

    public String getRandomSectorName() {
        return (String) getFromSerenitySession("randomSectorName");
    }

    public void setNoOfJobsTotalExpiredPage(int totalJobCount) {
        putIntoSerenitySession("noOfJobsTotalExpiredPage", totalJobCount);
    }

    public int getNoOfJobsTotalExpiredPage() {
        return (Integer) getFromSerenitySession("noOfJobsTotalExpiredPage");
    }

    public void setNoOfJobsLastThreeDaysExpiredPage(int jobsPostedLastThreeDaysCount) {
        putIntoSerenitySession("noOfJobsLastThreeDaysExpiredPage", jobsPostedLastThreeDaysCount);
    }

    public int getNoOfJobsLastThreeDaysExpiredPage() {
        return (Integer) getFromSerenitySession("noOfJobsLastThreeDaysExpiredPage");
    }

    public void setPsaAlertName(String alertName) {
        putIntoSerenitySession("psaAlertName", alertName);
    }

    public String getPsaAlertName() {
        return (String) getFromSerenitySession("psaAlertName");
    }

    public void setSkillSelectedLinkText(String skillSelectedLinkText) {
        putIntoSerenitySession("skillSelectedLinkText", skillSelectedLinkText);
    }

    public String getSkillSelectedLinkText() {
        return (String) getFromSerenitySession("skillSelectedLinkText");
    }

    public void setLocationSelectedLinkText(String jobCountNotApplicable) {
        putIntoSerenitySession("locationSelectedLinkText", jobCountNotApplicable);
    }

    public String getLocationSelectedLinkText() {
        return (String) getFromSerenitySession("locationSelectedLinkText");
    }

    public void setJobTitleToAssert(String jobTitle) {
        putIntoSerenitySession("jobTitleToAssert", jobTitle);
    }

    public String getJobTitleToAssert() {
        return (String) getFromSerenitySession("jobTitleToAssert");
    }

    public void setDocumentNameToAssert(String document) {
        putIntoSerenitySession("documentNameToAssert", document);
    }

    public String getDocumentNameToAssert() {
        return (String) getFromSerenitySession("documentNameToAssert");
    }

    public void setMyEfcUserBeanNameLaterStep(String myEfcUserBeanName) {
        putIntoSerenitySession("myEfcUserBeanNameLaterStep", myEfcUserBeanName);
    }

    public String getMyEfcUserBeanNameLaterStep() {
        return (String) getFromSerenitySession("myEfcUserBeanNameLaterStep");
    }

    public void setNumberOfSelectedSkills(int skills) {
        putIntoSerenitySession("numberOfSelectedSkills", skills);
    }

    public int getNumberOfSelectedSkills() {
        return (Integer) getFromSerenitySession("numberOfSelectedSkills");
    }

    public void setNumberOfSelectedCompanies(int companies) {
        putIntoSerenitySession("numberOfSelectedCompanies", companies);
    }

    public int getNumberOfSelectedCompanies() {
        return (Integer) getFromSerenitySession("numberOfSelectedSkills");
    }

    public void setJobseekerExternalId(String externalId) {
        putIntoSerenitySession("externalId", externalId);
    }

    public String getJobseekerExternalId() {
        return (String) getFromSerenitySession("externalId");
    }

    public void setJobId(Long jobId) {
        putIntoSerenitySession("jobId", jobId);
    }

    public Long getJobId() {
        return (Long) getFromSerenitySession("jobId");
    }
}
