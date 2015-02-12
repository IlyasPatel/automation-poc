package com.efinancialcareers.myefc.qa.domain;

/**
 * User: ilyas.patel
 * Date: 08/10/13
 * Time: 11:40
 */
public enum MailingInterval {

    /**
     * Never.
     */
    NEVER("n"),
    /**
     * Once a day.
     */
    DAILY("d"),

    /**
     * Once a week.
     */
    WEEKLY("w");

    private String scheduledTaskValue;

    MailingInterval(String scheduledTaskValue) {
        this.scheduledTaskValue = scheduledTaskValue;
    }

    public String getScheduledTaskValue() {
        return scheduledTaskValue;
    }
}
