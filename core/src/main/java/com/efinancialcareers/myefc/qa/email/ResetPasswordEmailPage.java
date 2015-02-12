package com.efinancialcareers.myefc.qa.email;

/**
 * Created by ilyas.patel on 14/05/2014.
 */
public interface ResetPasswordEmailPage {

    /**
     * Assert both reset password links are displayed.
     */
    void assertBothResetPasswordLinksAreDisplayed();

    /**
     * Click reset your password.
     */
    void clickResetYourPassword();

}
