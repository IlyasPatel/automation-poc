package com.efinancialcareers.myefc.qa.email;

/**
 * Created by ilyas.patel on 14/05/2014.
 */
public interface WelcomeAndVerifyEmailPage {

    /**
     * Verify account
     */
    void verifyAccount();

    /**
     * Assert both verify account links are displayed
     */
    void assertBothVerifyAccountLinksAreDisplayed();

}
