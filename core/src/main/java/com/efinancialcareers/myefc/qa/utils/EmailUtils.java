package com.efinancialcareers.myefc.qa.utils;

import com.efinancialcareers.myefc.qa.email.MailinatorInboxPage;
import com.efinancialcareers.myefc.qa.utils.fo.Defaults;
import org.openqa.selenium.WebElement;

import java.text.MessageFormat;

/**
 * User: ilyas.patel
 * Date: 01/10/13
 * Time: 00:20
 */
public final class EmailUtils {

    private EmailUtils() {}

    private static final String PSA_MAILER_URL = Defaults.PSA_MAILER_URL
            + "&frequency={0}&createLog=1&testUser={2}&testUserEmailAddress={3}";

    /**
     * Create PSA Mailer Url to trigger scheduled task
     * @param jobseekerId jobseekerId
     * @param testEmail testEmail
     * @param frequency frequency
     * @param countryNetwork countryNetwork
     * @return URL
     */
    public static String generatePSAMailerUrl(
            long jobseekerId, String testEmail, String frequency, String countryNetwork) {

        return MessageFormat.format(PSA_MAILER_URL, frequency, countryNetwork, String.valueOf(jobseekerId), testEmail);
    }

    public static String updateMailinatorUrlLink(String oldUrl) {
        return MessageFormat.format(
                "return arguments[0].href = ''{0}&{1}''",
                oldUrl, MailinatorInboxPage.MAILINATOR_TOKEN
        );
    }

}
