package com.efinancialcareers.myefc.qa.email;

import com.efinancialcareers.myefc.qa.desktop.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


/**
 * Created by ilyas.patel on 07/02/14.
 */
public class MailinatorResetPasswordEmailPage extends BasePage implements ResetPasswordEmailPage {

    @FindBy(css = "div.mailview table tbody tr td p font font font")
    protected WebElementFacade emailLink;

    @FindBy(xpath = "//a[contains(@href, 'login/reset-password')]")
    private WebElementFacade resetPasswordButton;

    @FindBy(css = "#mailshowdiv .mail-list")
    private WebElementFacade emailSubjectLineInEmail;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public MailinatorResetPasswordEmailPage(WebDriver driver) {
        super(driver);
    }

    /**
     * click reset password button
     */
    public void clickResetYourPassword() {
        clickOn(resetPasswordButton);
        switchToCurrentWindow();
    }

    /**
     * Assertion
     */
    public void assertBothResetPasswordLinksAreDisplayed() {
        Assert.assertEquals(resetPasswordButton.getAttribute("href"), emailLink.getText());
        Assert.assertTrue(resetPasswordButton.isCurrentlyVisible());
        Assert.assertTrue(emailLink.isCurrentlyVisible());
    }
}
