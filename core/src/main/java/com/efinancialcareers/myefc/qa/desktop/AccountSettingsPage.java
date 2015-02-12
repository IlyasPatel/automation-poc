package com.efinancialcareers.myefc.qa.desktop;

import net.thucydides.core.pages.WebElementFacade;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * User: jon.neville
 * Date: 21/09/13
 * Time: 02:34
 */
public class AccountSettingsPage extends BasePage {

    @FindBy(id = "oldPassword")
    private WebElementFacade oldPassword;

    @FindBy(id = "newPassword")
    private WebElementFacade newPassword;

    @FindBy(id = "newPasswordConfirm")
    private WebElementFacade newPasswordConfirm;

    @FindBy(name = "newEmail")
    private WebElementFacade newEmailText;

    @FindBy(name = "newEmailConfirm")
    private WebElementFacade newEmailConfirmText;

    @FindBy(name = "password")
    private WebElementFacade passwordAmendEmailAccordionText;

    @FindBy(css = "div.linkedAccount a.btn")
    private WebElementFacade deleteFirstLinkedAccountBtn;

    @FindBy(id = "newEmail.errors")
    private WebElementFacade amendEmailValidationMessage;

    @FindBy(css = "#subMenu li#sideMenuNavAccount")
    private WebElementFacade accountSettingsSideMenu;

    @FindBy(css = "#accordion div[data-accordionindex='1'] a")
    WebElementFacade newslettersTab;

    @FindBy(css = "#accordion div[data-accordionindex='2'] a")
    WebElementFacade yourEmailAddressTab;

    @FindBy(css = "#accordion div[data-accordionindex='3'] a")
    WebElementFacade passwordTab;

    @FindBy(css = "#accordion div[data-accordionindex='4'] a")
    WebElementFacade emailPreferencesTab;

    @FindBy(css = "#accordion div[data-accordionindex='5'] a")
    WebElementFacade linkedAccountTab;

    @FindBy(css = "#accordion div[data-accordionindex='5'] a")
    WebElementFacade deleteTab;

    @FindBy(css = "#deleteform a.btn")
    private WebElementFacade deleteAccountButton;

    @FindBy(css = "#deleteform .msgBox")
    private WebElementFacade securityNotice;

    @FindBy (css = "#main.right h1")
    private WebElementFacade headerText;

    @FindBy (css = ".linkedAccount img")
    private WebElementFacade firstLinkedAccountImg;

    @FindBy (id = "foundJob1")
    private WebElementFacade foundJobThrougheFCCheckBox;

    @FindBy (id = "dislikeEfc1")
    private WebElementFacade foundJobUsingOtherJobSiteCheckBox;

    @FindBy (id = "otherReason1")
    private WebElementFacade otherReasonCheckBox;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public AccountSettingsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Enter current password
     * @param password password
     */
    public void enterCurrentPassword(String password) {
        typeInto(oldPassword, password);
    }

    /**
     * Enter current password
     * @param newPassword newPassword
     */
    public void enterNewPassword(String newPassword) {
        typeInto(this.newPassword, newPassword);
    }

    /**
     * Enter current password
     * @param confirmPassword confirmPassword
     */
    public void confirmPassword(String confirmPassword) {
        typeInto(this.newPasswordConfirm, confirmPassword);
    }

    /**
     * Submit change password
     */
    public void submitChangePassword() {
        newPasswordConfirm.submit();
    }

    /**
     * Enter new email
     * @param updatedEmail updated email
     */
    public void enterNewEmail(String updatedEmail) {
        typeInto(newEmailText, updatedEmail);
    }

    /**
     * Confirm new email
     * @param updatedEmail updated email
     */
    public void confirmNewEmail(String updatedEmail) {
        typeInto(newEmailConfirmText, updatedEmail);
    }

    /**
     * Enter password on amend email address accordion
     * @param password password
     */
    public void enterPasswordOnAmendEmailAccordion(String password) {
        typeInto(passwordAmendEmailAccordionText, password);
    }

    /**
     * Gets message from email validation field
     * @return string
     */
    public String getMessageFromEmailValidationField() {
        return amendEmailValidationMessage.getTextValue();
    }

    /**
     * Submit update my email address
     */
    public void submitUpdateMyEmail() {
        this.passwordAmendEmailAccordionText.submit();
    }

    /**
     * Submit delete account
     */
    public void submitDeleteAccountForm() {
        scrollUntilElementIsVisible(deleteAccountButton);
        clickOn(deleteAccountButton);
    }

    /**
     * Open change password accordion tab
     */
    public void openChangePasswordAccordionTab() {
        scrollUntilElementIsVisible(passwordTab);
        waitUntilElementHasStoppedMoving(passwordTab);

        clickOn(passwordTab);
        waitUntilElementHasStoppedMoving(passwordTab);
    }

    /**
     * Open newsletters tab
     */
    public void openNewslettersTab() {
        scrollUntilElementIsVisible(newslettersTab);
        waitUntilElementHasStoppedMoving(newslettersTab);

        clickOn(newslettersTab);
        waitUntilElementHasStoppedMoving(newslettersTab);
    }

    /**
     * Open your email address tab
     */
    public void openYourEmailAddressAccordionTab() {
        scrollUntilElementIsVisible(yourEmailAddressTab);
        waitUntilElementHasStoppedMoving(yourEmailAddressTab);

        clickOn(yourEmailAddressTab);
        waitUntilElementHasStoppedMoving(yourEmailAddressTab);
    }

    /**
     * Open delete account accordion tab
     */
    public void openDeleteAccountAccordionTab(){
        scrollUntilElementIsVisible(deleteTab);
        clickOn(deleteTab);

        waitUntilElementHasStoppedMoving(deleteTab);
    }

    public String getSecurityNoticeTextForDeletingAccount() {
        return securityNotice.getText().replaceFirst("\n", " ").trim();
    }

    /**
     * Open linked account accordion tab
     */
    public void openLinkedAccountTab(){
        waitUntilElementHasStoppedMoving(newslettersTab);
        scrollUntilElementIsVisible(linkedAccountTab);
        clickOn(linkedAccountTab);

        waitUntilElementHasStoppedMoving(linkedAccountTab);
    }

    /**
     * Delete first linked account
     */
    public void deleteFirstLinkedAccount(){
        clickOn(deleteFirstLinkedAccountBtn);
        waitForRenderedElementsToDisappear(By.cssSelector(".linkedAccount img"));
    }

    /**
     * Get provider image name
     * @return provider image
     */
    public String getFirstProviderImageName() {
        return FilenameUtils.getName(firstLinkedAccountImg.getAttribute("src"));
    }

    /**
     * Check if there is at least 1 linked account displayed
     * @return linked account present.
     */
    public boolean linkedAccountIsDisplayed() {
        return this.firstLinkedAccountImg.isPresent();
    }

    /**
     * Check linked account is not displayed
    */
    public void assertLinkedAccountIsNotDisplayed() {
        this.shouldNotBeVisible(firstLinkedAccountImg);
    }

    /**
     * Get page header title
     * @return title
     */
    public String getPageHeader() {
        return headerText.getTextValue();
    }

    /**
     * Open email preferences tab
     */
    public void openEmailPreferencesTab(){
        clickOnWhenVisible(emailPreferencesTab);
    }

    public void tickIHaveFoundJobThrougheFinancialCareers() {
        clickOn(foundJobThrougheFCCheckBox);
    }

    public void tickIHaveFoundJobUsingAnotherSource() {
        clickOn(foundJobUsingOtherJobSiteCheckBox);
    }

    public void tickIPreferAnotherJobSite() {
        clickOn(otherReasonCheckBox);
    }
}
