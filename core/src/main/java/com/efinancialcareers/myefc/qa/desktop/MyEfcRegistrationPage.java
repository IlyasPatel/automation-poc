package com.efinancialcareers.myefc.qa.desktop;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * User: ilyas.patel
 * Date: 16/07/13
 * Time: 12:04
 */
public class MyEfcRegistrationPage extends BasePage {

    @FindBy(id = "email")
    private WebElementFacade username;

    @FindBy(id = "password")
    private WebElementFacade password;

    @FindBy(id = "passwordConfirm")
    private WebElementFacade passwordConfirmation;

    @FindBy(id = "kaptchaCode")
    private WebElementFacade kaptcha;

    @FindBy(css = "#myEfcUserRegistrationForm button")
    private WebElementFacade submit;

    @FindBy(id = "email.errors")
    private WebElementFacade emailValidationMessage;

    @FindBy(css = "#content form div.fieldMessage[data-field='email']")
    private WebElementFacade emailValidationMessageOpenId;

    @FindBy(id = "password.errors")
    private WebElementFacade passwordValidationMessage;

    @FindBy(id = "passwordConfirm.errors")
    private WebElementFacade passwordConfirmationValidationMessage;

    @FindBy(id = "receivePartnerNewsletters")
    private WebElementFacade receivePartnerNewsletters;

    @FindBy(id = "receiveNewsLetters")
    private WebElementFacade receiveInternalMessages;

    @FindBy(id = "receiveEmails")
    private WebElementFacade receiveThirdPartyNewsletters;

    /**
     * Constructor
     * @param driver WebDriver
     */
    public MyEfcRegistrationPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Enter username
     * @param email email
     */
    public void enterUsername(String email) {
        typeInto(this.username, email);
    }

    /**
     * Enter password
     * @param password password
     */
    public void enterPassword(String password) {
        typeInto(this.password, password);
    }

    /**
     * Enter password confirmation
     * @param password password
     */
    public void enterPasswordConfirmation(String password) {
        typeInto(this.passwordConfirmation, password);
    }

    /**
     * Enter kaptcha
     * @param kaptcha kaptcha
     */
    public void enterKaptcha(String kaptcha) {
        typeInto(this.kaptcha, kaptcha);
    }

    /**
     * Submit registration form
     */
    public void submit() {
        if (fiftyFifty()) {
            kaptcha.submit();
        } else {
            clickOn(submit);
        }
    }

    /**
     * Get email validation message
     * @return Validation message
     */
    public String getEmailValidationMessage() {

        if (getCurrentUrl().contains("link-accounts")) {
            return emailValidationMessageOpenId.getTextValue();
        } else {
            return emailValidationMessage.getTextValue();
        }
    }

    /**
     * Get password validation message
     * @return Validation message
     */
    public String getPasswordValidationMessage() {
        return passwordValidationMessage.getTextValue();
    }

    /**
     * Get password confirmation validation message
     * @return Validation message
     */
    public String getPasswordConfirmationValidationMessage() {
        return passwordConfirmationValidationMessage.getTextValue();
    }

    /**
     * Select site specific newsletters
     */
    public void selectNewsletters() {
        clickOn(receivePartnerNewsletters);
    }

    /**
     * Select internal eFC messages
     */
    public void selectInternalMessages() {
        clickOn(receiveInternalMessages);
    }

    /**
     * Select third party newsletters
     */
    public void selectThirdPartyNewsletters() {
        clickOn(receiveThirdPartyNewsletters);
    }
}
