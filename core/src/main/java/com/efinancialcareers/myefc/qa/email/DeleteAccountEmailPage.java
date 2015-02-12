package com.efinancialcareers.myefc.qa.email;

/**
 * Created by ilyas.patel on 14/05/2014.
 */
public interface DeleteAccountEmailPage {


    /**
     * Assert both confirm deletion links are displayed
     */
    void assertBothConfirmDeletionLinksAreDisplayed();

    /**
     * Click confirm deletion button
     */
    void clickConfirmDeletionButton();
}
