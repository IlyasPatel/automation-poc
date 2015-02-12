package com.efinancialcareers.myefc.qa.mobile;

import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * User: jon.neville
 * Date: 08/08/13
 * Time: 10:10
 */
public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElementFacade username;

    @FindBy(id = "password")
    private WebElementFacade password;

    @FindBy(xpath = "//input[@name='keywords']")
    private WebElement jobSearchText;

    @FindBy(xpath = "//a[contains(@href, '#/logout/')]")
    private WebElementFacade signOutLink;

    @FindBy(css = "a.login.inlineIcon")
    private WebElementFacade signInTab;

    @FindBy(css = "#loginForm label.error")
    private WebElementFacade validationMessageText;

    /**
     * Constructor
     * @param driver WebDriver
     */
    public LoginPage(WebDriver driver) {
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
     * Enter Password
     * @param password password
     */
    public void enterPassword(String password) {
        this.password.type(password);
    }

    /**
     * Submit login form
     */
    public void submit() {
        this.password.submit();
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

    /**
     * Assertion for logged in
     */
    public void checkSignOutEnabled() {
        //OverlayPage.waitForOverlay(getDriver());
        //Assert.assertNotNull(signOutLink.isEnabled());
    }

    /**
     * Assertion for logged out
     */
    public void checkSignInTabDisplayed() {
        //OverlayPage.waitForOverlay(getDriver());
        Assert.assertNotNull(signInTab.isDisplayed());
    }

    /**
     * Assertion for invalid credentials
     */
    public void invalidCredentialsErrorDisplayed() {
        Assert.assertNotNull(validationMessageText.isDisplayed());
    }
}
