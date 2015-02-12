package com.efinancialcareers.myefc.qa.desktop;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * User: jon.neville
 * Date: 24/02/14
 * Time: 10:05
 */
public class ProfilePrivacySettingsSection extends AccountSettingsPage {

    private static final String MAKE_SEARCHABLE_CONFIRM = "#popupContent nav.wizardButtons a.btn:nth-child(1)";

    @FindBy(css = "input[name=\"profilePrivacySettings\"]")
    private WebElementFacade searchableRadio;

    @FindBy(xpath = "(//input[@name='profilePrivacySettings'])[2]")
    private WebElementFacade searchableAnonRadio;

    @FindBy(xpath = "(//input[@name='profilePrivacySettings'])[3]")
    private WebElementFacade nonSearchableRadio;

    @FindBy(css = "#makeSearchableAttachCvPrivacyPolicy.save")
    private WebElementFacade submitBtn;

    @FindBy(css = "#main.right article p.msgBox")
    private List<WebElement> alertMessages;

    @FindBy(css = "header #navigation-links nav .loggedin")
    private WebElementFacade loggedInFirstNameInNavigation;

    @FindBy(css = "div.searchableInfo")
    private WebElementFacade profileStatusSidebar;

    @FindBy(css = "#main.right article header")
    private WebElementFacade headerText;

    @FindBy(css = MAKE_SEARCHABLE_CONFIRM)
    private WebElementFacade makeSearchableConfirmLink;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public ProfilePrivacySettingsSection(WebDriver driver) {
        super(driver);
    }

    /**
     * Click searchable
     */
    public void clickSearchable() {
        clickOn(searchableRadio);
    }

    /**
     * Click searchable but anonymous
     */
    public void clickSearchableButAnonymous() {
        clickOn(searchableAnonRadio);
    }

    /**
     * Click Non-searchable
     */
    public void clickNonSearchable() {
        scrollUntilElementIsVisible(nonSearchableRadio);
        clickOn(nonSearchableRadio);
    }

    /**
     * Click submit
     */
    public void clickSubmit() {
        clickOn(submitBtn);
        waitForAJAXToComplete();
    }

    /**
     * Click submit
     */
    public void clickMakeSearchable() {
        waitUntilElementHasStoppedMoving(makeSearchableConfirmLink);
        makeSearchableConfirmLink.click();
        waitForAbsenceOf(MAKE_SEARCHABLE_CONFIRM);
    }

    public Boolean isSearchableSelected() {
        return searchableRadio.isSelected();
    }

    public Boolean isSearchableButAnonymousSelected(){
        return searchableAnonRadio.isSelected();
    }

    public Boolean isNonSearchableSelected() {
        return nonSearchableRadio.isSelected();
    }

    public Boolean isSearchableEnabled() {
        return searchableRadio.isEnabled();
    }

    public Boolean isSearchableButAnonymousEnabled() {
        return searchableAnonRadio.isEnabled();
    }

    public Boolean isNonSearchableEnabled() {
        return nonSearchableRadio.isEnabled();
    }

    /**
     * Get profile status from sidebar
     * @return status
     */
    public String getProfileStatusFromSidebar() {
        return profileStatusSidebar.getTextValue().split("\n")[1];
    }

    /**
     * Get page header title
     * @return title
     */
    public String getPageHeader() {
        return headerText.getTextValue();
    }

    /**
     * Close company light box
     */
    public void closeCompanyLightBox() {
        waitForCountryLightBoxToAppearAndClose();
    }
}

