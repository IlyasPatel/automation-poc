package com.efinancialcareers.myefc.qa.desktop;

import com.efinancialcareers.myefc.qa.utils.fo.TranslationFacade;
import com.efinancialcareers.myefc.qa.utils.fo.WaitFor;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HeaderComponent extends BaseComponent {

    @FindBy(css = "header #navigation-links nav .loggedin")
    private WebElementFacade emailWebElement;

    @FindBy(css = "#navigation-container section#navigation-links nav ul li.static p")
    private WebElementFacade jobseekerMenuItem;

    @FindBy(css = "#candidateSignInMenu.simpleNav ul li a.btn")
    private WebElementFacade signInLink;

    @FindBy(xpath = "//a[contains(@href, '/login/register')]")
    private WebElementFacade registerLink;

    @FindBy(css = "#content #pageMessages div.pageMessage")
    private WebElementFacade pageMessage;

    @FindBy(css = "#navigation-links nav ul li.static")
    private WebElementFacade loggedInClass;

    @FindBy(xpath = "//a[contains(@href, 'myefc/docs/cvs')]")
    private WebElementFacade documentsLink;

    @FindBy(xpath = "//ul[@id='loggedIn'] //a[contains(@href, 'myefc/docs/cover-letters')]")
    private WebElementFacade coverLetterLink;

    @FindBy(xpath = "//ul[@id='loggedIn'] //a[contains(@href, 'myefc/profile/privacy-setting')]")
    private WebElementFacade privacySettingsLink;

    @FindBy(xpath = "(//a[contains(@href, 'myefc/saved-searches')])[2]")
    private WebElementFacade searchAlertLink;

    @FindBy(xpath = "//ul[@id='loggedIn'] //a[contains(@href, 'myefc/jobs')]")
    private WebElementFacade savedJobsLink;

    @FindBy(xpath = "//ul[@id='loggedIn'] //a[contains(@href, 'myefc/application-history')]")
    private WebElementFacade appliedJobsLink;

    @FindBy(xpath = "//ul[@id='loggedIn'] //a[contains(@href, 'myefc/newsletters')]")
    private WebElementFacade newslettersLink;

    @FindBy(xpath = "//ul[@id='loggedIn'] //a[contains(@href, 'myefc/account')]")
    private WebElementFacade accountSettingsLink;

    @FindBy(xpath = "//ul[@id='loggedIn'] //a[contains(@href, '/myefc/compare')]")
    private WebElementFacade compareMeLink;

    @FindBy(xpath = "//ul[@id='loggedIn'] //a[contains(@href, '/logout')]")
    private WebElementFacade logoutLink;

    @FindBy(css = "#navigation-links nav ul li.jobsearch")
    private WebElementFacade jobSearchLink;

    @FindBy(css = "#top-text ul li")
    private WebElementFacade topHeaderText;

    @FindBy(css = "#navigation-links a.logo")
    private WebElementFacade eFCLogoLink;

    @FindBy(css = "#loggedIn .profile-submenu .profile-completeness img")
    private WebElementFacade profileCompletenessIndicator;

    @FindBy(css = "#navigation-container section#top-text ul li a.active")
    private WebElementFacade activeLanguage;

    @FindBy(tagName = "body")
    private WebElementFacade body;

    /**
     * Constructor
     * @param driver Webdriver
     */
    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * Get Salutation text in header after user has logged in
     * @return Text
     */
    public String getLoggedInEmail() {
        return emailWebElement.getText().split("\n")[0];
    }

    /**
     * Get Salutation text in header after user has logged in
     * @return Text
     */
    public String getProfileSearchStatus() {
        return emailWebElement.getText().split("\n")[1];
    }

    /**
     * Check that email address is not displayed in header menu
     * @param email email
     */
    public void assertEmailNotDisplayed(String email) {
        //Assertions.assertThat(body.getText()).doesNotContain(email);
    }

    /**
     * Logout
     */
    public void logout() {
        closeUploadCVForBurningGlassModalBox();

        withAction().moveToElement(jobseekerMenuItem)
                .clickAndHold()
                .perform();

        withAction().release(jobseekerMenuItem).perform();

        clickOn(logoutLink);
    }

    /**
     * select Jobseeker menu so other items within menu can be selected
     */
    public void selectJobseekerMenuNotLoggedIn() {
        super.waitForPagePeel();
        String menuItemTrans = TranslationFacade.getInstance().getTranslation("fo.site.header.menu.jobseekerAcount");

        WebElement jobseekerMenuItemNotLoggedIn =
                getDriver().findElement(By.xpath("//a[contains(text(), '" + menuItemTrans + "')]"));

        withAction().moveToElement(jobseekerMenuItemNotLoggedIn).perform();
    }

    /**
     * Click sign in from the header menu
     */
    public void clickSignInLink() {
        clickOn(signInLink);
    }

    /**
     * Click register from the header menu
     */
    public void clickRegisterLink() {
        clickOn(registerLink);
    }

    /**
     * Wait for Login to complete
     */
    public void waitForLoginToComplete() {
        //waitFor(ExpectedConditions.visibilityOf(loggedInClass));

        By[] locators = {
                By.cssSelector("#navigation-links nav ul li.static"),
                By.id("receivePartnerNewsletter"),
                By.cssSelector("#linkAccountsExisting #password")
        };

        (new WebDriverWait(getDriver(), WaitFor.SLA_WEB_ELEMENTS.getSeconds()))
                .until(somethingIsPresent(locators));
    }

    protected ExpectedCondition<Boolean> somethingIsPresent(By[] locators) {
        final By[] finalLocators = locators;
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                boolean found = false;
                for (By locator : finalLocators) {
                    if (isElementPresent(locator)) {
                        found = true;
                        break;
                    }
                }
                return new Boolean(found);
            }
        };
    }

    /**
     * Similar to does element exist, but also verifies that only one such
     * element exists and that it is displayed and enabled.
     *
     * @param by
     *            By statement locating the element.
     * @return T if one and only one element matching the locator is found, and
     *         if it is displayed and enabled, F otherwise.
     */
    protected boolean isElementPresent(By by) {
        // Temporarily set the implicit timeout to zero
        //getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        // Check to see if there are any elements in the found list
        List<WebElement> elements = getDriver().findElements(by);
        boolean isPresent = (elements.size() == 1)
                && elements.get(0).isDisplayed() && elements.get(0).isEnabled();
        // Return to the original implicit timeout value
        /*getDriver().manage().timeouts()
                .implicitlyWait(30, TimeUnit.SECONDS);*/
        // Properties.TIMEOUT_TEST is from other personal code, replace with your
        // own default timeout setting.
        return isPresent;
    }

    /**
     * Open header menu
     */
    public void openHeaderMenu() {
        waitForPagePeel();

        withAction().moveToElement(jobseekerMenuItem)
                .clickAndHold()
                .perform();

        //evaluateJavascript("$('#loggedIn .account-submenu div ul li:eq(1) h4 a').focus();");
        withAction().release(jobseekerMenuItem).perform();
    }

    /**
     * Return number of search alerts in menu
     * @return int Total
     */
    public int getTotalNumberOfSearchAlerts() {
        return Integer.parseInt(searchAlertLink.getText().replaceAll("\\D+", ""));
    }

    /**
     * Return number of saved jobs in menu
     * @return int Total
     */
    public int getTotalNumberOfSavedJobs() {
        return Integer.parseInt(savedJobsLink.getText().replaceAll("\\D+", ""));
    }

    /**
     * Return number of applied jobs in menu
     * @return int Total
     */
    public int getTotalNumberOfAppliedJobs() {
        return Integer.parseInt(appliedJobsLink.getText().replaceAll("\\D+", ""));
    }

    public String getProfileCompletenessImageName() {
        return FilenameUtils.getName(profileCompletenessIndicator.getAttribute("src"));
    }

    /**
     * Click job search link
     */
    public void clickJobSearchComponent() {
        clickOn(jobSearchLink);
    }

    public String getTopHeaderTextValue(){
        return topHeaderText.getTextValue();
    }

    /**
     * Click Resume Link
     */
    public void clickDocumentsLink() {
        clickOn(documentsLink);
    }

    /**
     * Click Applications Link
     */
    public void clickApplicationsLink() {
        clickOn(appliedJobsLink);
    }

    /**
     * Click Privacy Settings Link
     */
    public void clickPrivacySettingsLink() {
        clickOn(privacySettingsLink);
    }

    /**
     * Click Job Alerts Link
     */
    public void clickJobAlertsLink() {
        clickOn(searchAlertLink);
    }

    /**
     * Click Newsletters Link
     */
    public void clickNewslettersLink() {
        clickOn(newslettersLink);
    }

    /**
     * Click Account Settings Link
     */
    public void clickAccountSettingsLink() {
        clickOn(accountSettingsLink);
    }

    /**
     * Click Account Settings Link
     */
    public void clickCompareMeLink() {
        clickOn(compareMeLink);
    }

    /**
     * Click home to go to Front-Office
     */
    public void clickHome() {
        clickOnCustom(eFCLogoLink);
    }

    /**
     * Click specific locale link
     * @param language language
     */
    public void clickSpecifiedLanguage(String language) {
        waitForPagePeel();
        clickLinkByText(language);
    }

    /**
     * Get active language
     * @return activeLanguage
     */
    public String getActiveLanguage() {
        highlightElement(activeLanguage);
        return activeLanguage.getTextValue();
    }


    /**
     * Click saved jobs link in header
     */
    public void clickSavedJobsLink() {
        openHeaderMenu();
        clickOn(savedJobsLink);
    }
}
