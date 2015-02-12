package com.efinancialcareers.myefc.qa.email;

import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by ilyas.patel on 13/05/2014.
 */
public interface InboxPage {

    /**
     * Wait until email has arrived.
     * @param email email
     */
    void waitUntilEmailHasArrived(String email);

    /**
     * Wait until expected number of emails have arrived.
     * @param email email
     * @param numberOfEmailsToWaitFor numberOfEmailsToWaitFor
     */
    void waitUntilExpectedNumberOfEmailsHaveArrived(String email, final int numberOfEmailsToWaitFor);

    /**
     * Open email with subject.
     * @param subject subject
     */
    void openEmailWithSubject(String subject);

    /**
     * Open email with subject which contains no other eFC content, e.g. a footer.
     * @param subject subject
     */
    void openEmailWithSubjectAndNoEfcContent(String subject);

    /**
     * Get all email subjects.
     * @return List of elements with email subject line
     */
    List<WebElement> getAllEmailSubjects();

    /**
     * Get inbox size.
     * @return inbox size
     */
    int getInboxSize();

    /**
     * Get email based on subject.
     * @param expectedSubject expectedSubject
     * @return Email Element
     */
    WebElement getEmailBasedOnSubject(String expectedSubject);

    /**
     * Inbox URL for provider.
     * @param email email
     * @return URL
     */
    String getInboxUrl(String email);

    /**
     * Open email with subject.
     * @param subject subject
     */
    @Deprecated
    void openCSEmailWithSubject(String subject);
}
