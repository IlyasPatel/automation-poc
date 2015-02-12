package com.efinancialcareers.myefc.qa.domain;

/**
 * User: ilyas.patel
 * Date: 04/10/13
 * Time: 12:31
 */
public class Job {

    private String jobId; // TODO. i.patel. Should not be a string data type
    private String jobTitle;
    private long brandId;
    private String brandName;
    private String companyName;
    private String companyNameRightHandSideComponent;
    private String startDate;
    private String location;
    private String positionType;
    private String employmentType;
    private String salary;
    private boolean isAnonymous;
    private String jobSummary;
    private String jobDescription;
    private String contactName;
    private String contactEmail;
    private String contactPhone;
    private String contactFax;
    private String contactCompanyName;
    private String contactAddress1;
    private String contactCity;
    private String contactPostCode;
    private String contactCountry;
    private String contactURL;
    private String jobReference;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = removeCarriageReturn(brandName);
    }

    public long getBrandId() {
        return brandId;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = removeCarriageReturn(startDate);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = removeCarriageReturn(location);
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = removeCarriageReturn(positionType);
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = removeCarriageReturn(employmentType);
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = removeCarriageReturn(salary);
    }

    public String getCompanyNameRightHandSideComponent() {
        return this.companyNameRightHandSideComponent;
    }

    public void setCompanyNameRightHandSideComponent(String companyName) {
        this.companyNameRightHandSideComponent = removeCarriageReturn(companyName);
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
    }

    public String getJobSummary() {
        return jobSummary;
    }

    public void setJobSummary(String jobSummary) {
        this.jobSummary = jobSummary;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = removeCarriageReturn(contactName);
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = removeCarriageReturn(contactEmail);
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = removeCarriageReturn(contactPhone);
    }

    public String getContactFax() {
        return contactFax;
    }

    public void setContactFax(String contactFax) {
        this.contactFax = removeCarriageReturn(contactFax);
    }

    public String getContactCompanyName() {
        return contactCompanyName;
    }

    public void setContactCompanyName(String contactCompanyName) {
        this.contactCompanyName = contactCompanyName;
    }

    public String getContactAddress1() {
        return contactAddress1;
    }

    public void setContactAddress1(String contactAddress1) {
        this.contactAddress1 = removeCarriageReturn(contactAddress1);
    }

    public String getContactCity() {
        return contactCity;
    }

    public void setContactCity(String contactCity) {
        this.contactCity = contactCity;
    }

    public String getContactPostCode() {
        return contactPostCode;
    }

    public void setContactPostCode(String contactPostCode) {
        this.contactPostCode = contactPostCode;
    }

    public String getContactCountry() {
        return contactCountry;
    }

    public void setContactCountry(String contactCountry) {
        this.contactCountry = contactCountry;
    }

    public String getContactURL() {
        return contactURL;
    }

    public void setContactURL(String contactURL) {
        this.contactURL = removeCarriageReturn(contactURL);
    }

    public String getJobReference() {
        return jobReference;
    }

    public void setJobReference(String jobReference) {
        this.jobReference = removeCarriageReturn(jobReference);
    }

    private String removeCarriageReturn(String value) {
        return value.replaceAll("\n", "");
    }
}
