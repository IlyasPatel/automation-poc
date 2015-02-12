package com.efinancialcareers.myefc.qa.domain.analytics;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnalyticsDataLayer {

    @Expose
    @SerializedName("LOGGED_IN_USER_ID")
    private String loggedInUserId;

    @Expose
    @SerializedName("SEARCHED_JOBS_IDS")
    private String[] searchedJobIds;

    @Expose
    @SerializedName("APPLIED_JOB_ID")
    private String appliedJobId;

    @Expose
    @SerializedName("JOB_ID")
    private String jobId;

    @Expose
    @SerializedName("hit.type")
    private String hitType;

    @Expose
    @SerializedName("hit.page")
    private String hitPage;

    @Expose
    @SerializedName("hit.category")
    private String hitCategory;

    @Expose
    @SerializedName("hit.action")
    private String hitAction;

    @Expose
    @SerializedName("hit.label")
    private String hitLabel;


    private Type REGISTRATION_DATA;

    public String getLoggedInUserId() {
        return loggedInUserId;
    }

    public void setLoggedInUserId(String loggedInUserId) {
        this.loggedInUserId = loggedInUserId;
    }

    public String[] getSearchedJobIds() {
        return searchedJobIds;
    }

    public void setSearchedJobIds(String[] searchedJobIds) {
        this.searchedJobIds = searchedJobIds;
    }

    public String getAppliedJobId() {
        return appliedJobId;
    }

    public void setAppliedJobId(String appliedJobId) {
        this.appliedJobId = appliedJobId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getHitType() {
        return hitType;
    }

    public void setHitType(String hitType) {
        this.hitType = hitType;
    }

    public String getHitPage() {
        return hitPage;
    }

    public void setHitPage(String hitPage) {
        this.hitPage = hitPage;
    }

    public String getHitCategory() {
        return hitCategory;
    }

    public void setHitCategory(String hitCategory) {
        this.hitCategory = hitCategory;
    }

    public String getHitAction() {
        return hitAction;
    }

    public void setHitAction(String hitAction) {
        this.hitAction = hitAction;
    }

    public String getHitLabel() {
        return hitLabel;
    }

    public void setHitLabel(String hitLabel) {
        this.hitLabel = hitLabel;
    }


    public Type getRegistrationData() {
        if (this.REGISTRATION_DATA == null) {
            this.REGISTRATION_DATA = new Type();
        }

        return REGISTRATION_DATA;
    }

    public void setRegistrationData(Type registrationData) {
        this.REGISTRATION_DATA = registrationData;
    }

    public class Type {
        @SerializedName("TYPE")
        String type;

        public void setType(String type) {
            this.type = type;
        }
    }

    public boolean isDataLayerEmpty() {
        if (getLoggedInUserId() == null
            && getSearchedJobIds() == null
            && getAppliedJobId() == null
            && getJobId() == null
            && getHitPage() == null
            && getHitCategory() == null
            && getHitAction() == null
            && getHitLabel() == null) {
            return true;
        }

        return false;
    }

}
