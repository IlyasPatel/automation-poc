package com.efinancialcareers.myefc.qa.domain.analytics;

/**
 * Created by ilyas.patel on 12/11/2014.
 */
public enum JSONFileNames {

    LOGIN("analytics/login.json"),

    LOGIN_OPEN_ID("analytics/loginOpenId.json"),

    REGISTER("analytics/register.json"),

    JOB_SEARCH("analytics/jobSearch.json"),

    RESUME_UPLOADED("analytics/resumeUploaded.json"),

    JOB_APPLY_PAGE("analytics/jobApplyPage.json"),

    APPLIED_JOB_WITH_COVER_LETTER("analytics/appliedJobWithCoverLetter.json");

    private String filename;

    JSONFileNames(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
}
