package com.efinancialcareers.myefc.qa.domain;

/**
 * User: jon.neville
 * Date: 06/01/15
 * Time: 09:44
 */
public class Resume {

    private String profileTitle;
    private String snippet;
    private String location;
    private String highlightedKeywordsInSnippet;
    private String highlightedKeywordsInProfileTitle;
    private String workExperience;
    private String workSector;
    private String spokenLanguages;
    private String educationLevel;
    private String positionType;
    private String workPermit;
    private String travelRate;

    public String getProfileTitle() {
        return profileTitle;
    }

    public void setProfileTitle(String profileTitle) {
        this.profileTitle = profileTitle;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location.toLowerCase();
    }

    public String getHighlightedKeywordsSnippet() {
        return highlightedKeywordsInSnippet;
    }

    public void setHighlightedKeywordsSnippet(String highlightedKeywordsInSnippet) {
        this.highlightedKeywordsInSnippet = highlightedKeywordsInSnippet.toLowerCase();
    }

    public String getHighlightedKeywordsProfileTitle() {
        return highlightedKeywordsInProfileTitle;
    }

    public void setHighlightedKeywordsProfileTitle(String highlightedKeywordsInProfileTitle) {
        this.highlightedKeywordsInProfileTitle = highlightedKeywordsInProfileTitle.toLowerCase();
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getWorkSector() {
        return workSector;
    }

    public void setWorkSector(String workSector) {
        this.workSector = workSector;
    }

    public String getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(String spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public String getWorkPermit() {
        return workPermit;
    }

    public void setWorkPermit(String workPermit) {
        this.workPermit = workPermit;
    }

    public String getTravelRate() {
        return travelRate;
    }

    public void setTravelRate(String travelRate) {
        this.travelRate = travelRate;
    }
}
