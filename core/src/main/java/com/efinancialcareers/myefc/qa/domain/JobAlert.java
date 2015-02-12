package com.efinancialcareers.myefc.qa.domain;


import com.efinancialcareers.myefc.qa.utils.QAStringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Created by ilyas.patel on 20/02/14.
 */
public class JobAlert {

    private Long id;
    private String keywords = "";
    private String salaries = "";
    private String locations = "";
    private String skills = "";
    private String positionTypes = "";
    private String employmentTypes = "";
    private String companies = "";
    private String sectors = "";
    private String subSectors = "";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getSalaries() {
        return salaries;
    }

    public void setSalaries(String salaries) {
        this.salaries = salaries;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getPositionTypes() {
        return positionTypes;
    }

    public void setPositionTypes(String positionTypes) {
        this.positionTypes = QAStringUtils.sortDelimitedStringToNaturalOrder(positionTypes, ", ");
    }

    public String getEmploymentTypes() {
        return employmentTypes;
    }

    public void setEmploymentTypes(String employmentTypes) {
        this.employmentTypes = employmentTypes;
    }

    public String getCompanies() {
        return companies;
    }

    public void setCompanies(String companies) {
        this.companies = companies;
    }

    public String getSectors() {
        return sectors;
    }

    public void setSectors(String sectors) {
        this.sectors = QAStringUtils.sortDelimitedStringToNaturalOrder(sectors, ", ");
    }

    public String getSubSectors() {
        return subSectors;
    }

    public void setSubSectors(String subSectors) {
        this.subSectors = subSectors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JobAlert that = (JobAlert) o;

        return new EqualsBuilder()
                .append(this.companies, that.companies)
                .append(this.employmentTypes, that.employmentTypes)
                .append(this.keywords, that.keywords)
                .append(this.locations, that.locations)
                .append(this.positionTypes, that.positionTypes)
                .append(this.salaries, that.salaries)
                .append(this.sectors, that.sectors)
                .append(this.subSectors, that.subSectors)
                .append(this.skills, that.skills)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(companies)
                .append(employmentTypes)
                .append(keywords)
                .append(locations)
                .append(positionTypes)
                .append(salaries)
                .append(sectors)
                .append(subSectors)
                .append(skills)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("companies", companies)
                .append("employmentTypes", employmentTypes)
                .append("keywords", keywords)
                .append("locations", locations)
                .append("positionTypes", positionTypes)
                .append("salaries", salaries)
                .append("sectors", sectors)
                .append("subSectors", subSectors)
                .append("skills", skills)
                .toString();
    }
}
