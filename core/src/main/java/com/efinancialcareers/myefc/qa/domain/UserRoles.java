package com.efinancialcareers.myefc.qa.domain;

/**
 * Created by ilyas.patel on 23/05/2014.
 */
public enum UserRoles {

    ADMINISTRATOR("Administrator"),
    TEAM_ADMINISTRATOR("Team Administrator"),
    RECRUITER("Recruiter"),
    RPO_ADMINISTRATOR("RPO Administrator"),
    RESUME_VIEWER("Resume Viewer"),
    JOBMASTER("Jobmaster"),
    SALES_MASTER("Salesmaster");

    private String name;

    UserRoles(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
