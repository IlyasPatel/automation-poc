package com.efinancialcareers.myefc.qa.email;

import com.efinancialcareers.myefc.qa.desktop.BasePage;
import com.efinancialcareers.myefc.qa.utils.EmailUtils;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.text.MessageFormat;

/**
 * Created by ilyas.patel on 07/02/14.
 */
public class MailinatorDeleteAccountEmailPage extends BasePage implements DeleteAccountEmailPage {

    @FindBy(css = "div.mailview table tbody tr td p font font font")
    protected WebElementFacade emailLink;

    @FindBy(xpath = "//a[contains(@href, 'login/confirm-delete-account')]")
    private WebElementFacade deleteAccountButton;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public MailinatorDeleteAccountEmailPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Click confirm deletion button
     */
    @Override
    public void clickConfirmDeletionButton() {
        clickOn(deleteAccountButton);
        switchToCurrentWindow();
    }

    /**
     * Assertion
     */
    @Override
    public void assertBothConfirmDeletionLinksAreDisplayed() {
        Assert.assertEquals(deleteAccountButton.getAttribute("href"), emailLink.getText());
        Assert.assertTrue(deleteAccountButton.isCurrentlyVisible());
        Assert.assertTrue(emailLink.isCurrentlyVisible());
    }
}
