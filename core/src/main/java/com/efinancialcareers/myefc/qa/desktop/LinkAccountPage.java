package com.efinancialcareers.myefc.qa.desktop;

import com.efinancialcareers.myefc.qa.domain.FoURLs;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;


/**
 * User: jon.neville
 * Date: 17/02/13
 * Time: 11:11
 */
public class LinkAccountPage extends BasePage {

    @FindBy(id = "password")
    private WebElementFacade password;

    @FindBy(xpath = "//a[@class='btn submit']")
    private WebElementFacade signUpButton;

    @FindBy(id = "email")
    private WebElementFacade email;

    @FindBy(id = "kaptchaCode")
    private WebElementFacade kaptcha;

    @FindBy(id = "receivePartnerNewsletter")
    private WebElementFacade receivePartnerNewsletter;

    @FindBy(id = "receiveNewsLetters")
    private WebElementFacade receiveInternalMessages;

    @FindBy(id = "receiveEmails")
    private WebElementFacade receiveThirdPartyNewsletters;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public LinkAccountPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Enter Password
     * @param password password
     */
    public void enterPassword(String password) {
        waitABit(3000L);
        typeInto(this.password, password);
    }

    /**
     * Click sign up
     */
    public void clickSignUp() {
        clickOn(signUpButton);
    }

    public boolean isOnLinkAccountPage() {
        return this.password.isPresent();
    }

    /**
     * Enter Email
     * @param email Email to enter
     */
    public void enterEmail(String email) {
        this.email.type(email);
    }

    /**
     * Enter Kaptcha
     */
    public void enterKaptcha() {
        waitForPageToChangeToLinkAccounts();

        typeInto(kaptcha, "qwerty");
    }

    public void waitForPageToChangeToLinkAccounts() {
        waitFor(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {
                return input.getCurrentUrl().contains(FoURLs.LINK_ACCOUNTS_REGISTRATION.getPath());
            }
        });
    }

    /**
     * Select site specific newsletters
     */
    public void selectNewsletters() {
        waitABit(4000);
        waitForPageToChangeToLinkAccounts();
        clickOn(receivePartnerNewsletter);
    }

    /**
     * Select internal eFC messages
     */
    public void selectInternalMessages() {
        waitForPageToChangeToLinkAccounts();
        clickOn(receiveInternalMessages);
    }

    /**
     * Select third party newsletters
     */
    public void selectThirdPartyNewsletters() {
        waitForPageToChangeToLinkAccounts();
        clickOn(receiveThirdPartyNewsletters);
    }
}

