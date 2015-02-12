package com.efinancialcareers.myefc.qa.domain;

/**
 * User: ilyas.patel
 * Date: 11/09/13
 * Time: 12:33
 */
public interface OpenIdProviderInterface {
    /**
     * Click on Open ID rovider on login page
     */
    void click();

    /**
     * Enter email
     * @param email email
     */
    void enterEmail(String email);

    /**
     * Enter Password
     * @param password pasword
     */
    void enterPassword(String password);

    /**
     * Submit form on Open ID page (3rd party site)
     */
    void submit();

    /**
     * Return provider Name
     *
     * @return provider Name
     */
    String getProviderName();

    /**
     * Does password required for linkage with MyEfc for particular provider
     * @return isLinkedPasswordRequired
     */
    Boolean isLinkedPasswordRequired();

    /**
     * Does Email required for for linkage with MyEfc for particular provider
     * @return isLinkedEmailRequired
     */
    Boolean isLinkedEmailRequired();

    /**
     * Wait for login form to be displayed
     */
    void waitForLoginModalDialogToAppear();
}
