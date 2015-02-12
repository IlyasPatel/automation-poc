package com.efinancialcareers.myefc.qa.email;

import com.efinancialcareers.myefc.qa.desktop.BasePage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.text.MessageFormat;

/**
 * Created by ilyas.patel on 06/02/14.
 */
public class MailinatorWelcomeAndVerifyEmailPage extends BasePage implements WelcomeAndVerifyEmailPage {

    @FindBy(css = "div.mailview table tbody tr td p font font font")
    protected WebElementFacade emailLink;

    @FindBy(xpath = "//a[contains(@href, 'login/verify-account')]")
    private WebElementFacade verifyAccountButton;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public MailinatorWelcomeAndVerifyEmailPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Verify account
     */
    @Override
    public void verifyAccount() {
        Serenity.takeScreenshot();
        clickOn(verifyAccountButton);
        switchToCurrentWindow();
    }

    /**
     * Assertion
     */
    @Override
    public void assertBothVerifyAccountLinksAreDisplayed() {
        Assert.assertEquals(verifyAccountButton.getAttribute("href"), emailLink.getTextValue());
        Assert.assertTrue(verifyAccountButton.isCurrentlyVisible());
        Assert.assertTrue(emailLink.isCurrentlyVisible());
    }
}
