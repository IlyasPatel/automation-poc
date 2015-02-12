package com.efinancialcareers.myefc.qa.email;

import com.efinancialcareers.myefc.qa.domain.Job;

import java.util.List;

public interface PSAEmailPage {

    /**
     * Click edit your alert button
     */
    void clickEditYourAlertButton();

    /**
     * Get jobs list
     * @return List of jobs
     */
    List<Job> getJobs();

    /**
     * Click view all new jobs
     */
    void clickViewAllNewJobs();

    /**
     * Click first job
     */
    void clickFirstJob();

}
