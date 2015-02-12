package com.efinancialcareers.myefc.qa.desktop;

import org.openqa.selenium.WebDriver;

/**
 * User: ilyas.patel
 * Date: 01/10/13
 * Time: 01:40
 */
public class PSAMailerPage extends BasePage {

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public PSAMailerPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Trigger Mailer
     * @param psaMailerUrl A URL
     */
    public void triggerMailer(String psaMailerUrl) {
        openAt(psaMailerUrl);
    }
}
