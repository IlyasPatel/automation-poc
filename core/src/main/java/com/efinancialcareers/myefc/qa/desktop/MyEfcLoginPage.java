package com.efinancialcareers.myefc.qa.desktop;

import com.efinancialcareers.myefc.qa.utils.fo.WaitFor;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * User: ilyas.patel
 * Date: 12/07/13
 * Time: 13:55
 */
public class MyEfcLoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElementFacade username;

    @FindBy(id = "password")
    private WebElementFacade password;

    @FindBy(id = "txtLoginDetailsName")
    private WebElement loginLabel;

    @FindBy(css = "li#loggedIn a")
    private WebElementFacade logoutLink;

    @FindBy(id = "rememberMe1")
    private WebElementFacade rememberMeCheckbox;

    @FindBy(css = "#content .loginsections form label a")
    private WebElementFacade createAccountLink;

    @FindBy(css = "#myEfcUserCredentialsForm button")
    private WebElementFacade submit;

    @FindBy(css = "#pageMessages div.pageMessage")
    private WebElementFacade errorMessage;

    @FindBy(xpath = "//*[@id='myEfcUserCredentialsForm.errors']")
    private WebElementFacade errorMessageOpenId;

    @FindBy(css = "ul.forogtremember li a")
    private WebElementFacade forgottenPasswordLink;

    @FindBy(id = "email")
    private WebElementFacade forgottenPasswordEmail;

    @FindBy(css = "#popupContent #legacyUserPassReset p:nth-child(3)")
    private WebElementFacade verifyAccount;

    @FindBy(css = "#popupContent #modalFrame")
    private WebElementFacade modal;

    @FindBy(css = "body .forgottenPassword div")
    private WebElementFacade forgottenPasswordEmailSentMessage;

    /**
     * Constructor
     * @param driver WebDriver
     */
    public MyEfcLoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Enter username
     * @param email email
     */
    public void enterUsername(String email) {
        this.username.type(email);
    }

    /**
     * Return email address displayed in email field.
     * @return username displayed
     */
    public String getEnteredEmail() {
        return username.getAttribute("value");
    }

    /**
     * Enter Password
     * @param password password
     */
    public void enterPassword(String password) {
        this.password.type(password);
    }

    /**
     * Check if remember me checkbox is selected or not
     * @return remember me value
     */
    public boolean rememberMeValueIsSelected() {
        return rememberMeCheckbox.isSelected();
    }

    /**
     * Click keep me signed in checkbox
     */
    public void clickKeepMeSignedIn() {
        rememberMeCheckbox.click();
    }

    /**
     * Submit login form
     */
    public void submit() {
        if(fiftyFifty()) {
            System.out.println("Submitting login form by pressing enter key from password field.");
            password.submit();
        } else {
            System.out.println("Submitting login form by clicking on submit button.");
            clickOn(submit);
        }
    }

    /**
     * Enter username and password
     * @param email email
     * @param password password
     */
    public void enterMyCredentialsAndSubmit(String email, String password) {
        enterUsername(email);
        enterPassword(password);
        submit();
    }

    public String getLoginLabel() {
        return loginLabel.getText();
    }

    /**
     * Clicks on Create Account Link on the login page
     * @return MyEfcRegistrationPage Object
     */
    public MyEfcRegistrationPage clickOnCreateAccountLink() {
        clickOn(createAccountLink);

        return super.switchToPage(MyEfcRegistrationPage.class);
    }

    /**
     * Checks if username field is on the page to determine if user is logged in or out
     * @return true or false
     */
    public boolean isUsernameFieldOnPage() {
        return this.username.isPresent();
    }

    /**
     * Gets error message on login page
     * @return error message
     */
    public String getErrorMessage() {
        // TODO i.patel. Check if this is common for all error messages to move to base page.
        // TODO i.patel. Try to remove the if statement
        if (getDriver().getCurrentUrl().contains("openid")) {
            return errorMessageOpenId.getText().trim();
        } else {
            return errorMessage.getText().trim();
        }
    }

    /**
     * Click forgotten password link
     */
    public void clickForgottenPassword() {
        clickOn(forgottenPasswordLink);

        waitUntilElementHasStoppedMoving(modal, WaitFor.TWO_SECONDS.getMilliseconds());
        waitForRenderedElements(By.id("modalFrame"));
        switchToFrame("modalFrame");
    }

    /**
     * Forgotten password email
     * @param email email
     */
    public void enterForgottenPasswordEmail(String email) {
        forgottenPasswordEmail.type(email);
    }

    /**
     * Submit forgotten password modal
     */
    public void submitForgottenPassword() {
        forgottenPasswordEmail.submit();
    }

    public String getVerifyYourAccountMessage() {
        return verifyAccount.getText().trim();
    }

    public String getEmailSentMessage() {
        return forgottenPasswordEmailSentMessage.getText().trim();
    }
}

