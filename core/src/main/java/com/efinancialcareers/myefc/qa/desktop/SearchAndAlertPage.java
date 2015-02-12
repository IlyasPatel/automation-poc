package com.efinancialcareers.myefc.qa.desktop;

import com.efinancialcareers.myefc.qa.domain.JobAlert;
import com.efinancialcareers.myefc.qa.domain.MailingInterval;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * User: jon.neville
 * Date: 18/09/13
 * Time: 15:42
 */
public class SearchAndAlertPage extends BasePage {

    @FindBy(css = "#savedSearchesContainer h3 a")
    private WebElementFacade searchAlert1Title;

    @FindBy(id = "createSavedSearchButton")
    private WebElementFacade createSavedSearchLink;

    @FindBy(name = "elemBulkAction")
    private List<WebElement> bulkSelectCheckbox;

    @FindBy(css = "#savedSearchesContainer .delete a.elemBulkDelete")
    private WebElementFacade bulkDeleteLink;

    @FindBy(css = SavedJobsPage.DELETE_CONFIRM_BUTTON)
    WebElementFacade confirmationToDeleteBtn;

    @FindBy(css = "#savedSearchesContainer section")
    private WebElementFacade noJobAlertsText;

    @FindBy(css = "#savedSearchesContainer header h1")
    private WebElementFacade headerText;

    @FindBy(css = "#savedSearchesContainer a.deleteElem")
    private WebElementFacade deleteJobAlertButton;

    @FindBy(css = "#sectionContainer a.edit")
    private List<WebElement> editLinks;

    private By bySearchAlertName = By.cssSelector("h3 a.extLink");

    private String keywordsTrans;
    private String salaryTrans;
    private String locationTrans;
    private String skillsTrans;
    private String positionTypeTrans;
    private String employmentTypeTrans;
    private String companyTrans;
    private String sectorsTrans;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public SearchAndAlertPage(WebDriver driver) {
        super(driver);

        keywordsTrans = translationFacade.getTranslation("fo.site.filter.keywords.label");
        salaryTrans = translationFacade.getTranslation("fo.site.filter.salary.label");
        locationTrans = translationFacade.getTranslation("fo.site.filter.locations.label");
        skillsTrans = translationFacade.getTranslation("fo.site.filter.skills.label");
        positionTypeTrans = translationFacade.getTranslation("fo.site.filter.positionType.label");
        employmentTypeTrans = translationFacade.getTranslation("labels.myefc.aboutYou.employmentType");
        companyTrans = translationFacade.getTranslation("fo.site.filter.brands.label");
        sectorsTrans = translationFacade.getTranslation("fo.site.filter.sectors.label");
    }

    /**
     * Assertion to check search Alert exists with correct title
     * @return first job title
     */
    public String checkTheFirstSearchAlertTitleIsCorrect() {
        return searchAlert1Title.getTextValue();
    }

    /**
     * Assertion
     */
    public void assertNoSavedSearchAlerts() {
        this.shouldNotBeVisible(searchAlert1Title);
    }

    /**
     * Click on Create a Saved Search link
     */
    public void clickCreateASavedSearchLink() {
        clickOn(createSavedSearchLink);
    }

    /**
     * Click on alert with specific name
     * @param alertName Alert name
     */
    public void clickOnAlertName(String alertName) {
        List<net.thucydides.core.pages.WebElementFacade> jobAlertList = getSavedSearchAlerts();

        for (WebElementFacade jobAlertElement : jobAlertList) {
            try {
                WebElementFacade element = jobAlertElement.find(bySearchAlertName);

                if (element.getTextValue().equals(alertName)) {
                    clickOn(element);
                    waitForSRPOverlayToComplete();
                    return;
                }
            } catch (NoSuchElementException e) {
                continue;
            }
        }
    }

    /**
     * Get job alert information for a specific job alert
     * @param alertName Alert name
     * @return JobAlert Bean
     */
    public JobAlert getJobAlertInformationFor(String alertName) {
        List<net.thucydides.core.pages.WebElementFacade> jobAlertList = getSavedSearchAlerts();

        for (WebElementFacade jobAlertElement : jobAlertList) {
            try {
                WebElementFacade element = jobAlertElement.find(bySearchAlertName);

                if (element.getTextValue().equals(alertName)) {

                    List<WebElementFacade> searchCriteria =
                            jobAlertElement.thenFindAll(By.cssSelector("ul.searchCriteria li"));
                    JobAlert jobAlert = new JobAlert();

                    jobAlert.setId(Long.parseLong(jobAlertElement.findBy(By.name("id")).getAttribute("value")));

                    for (WebElementFacade criteria : searchCriteria) {

                        String criteriaText = criteria.getTextValue();
                        // TODO. i.patel. Update to switch when we upgrade to Java 7
                        if (criteriaText.startsWith(keywordsTrans)) {
                            jobAlert.setKeywords(criteriaText.split(":")[1].trim());
                        }

                        if (criteriaText.startsWith(salaryTrans)) {
                            jobAlert.setSalaries(criteriaText.split(":")[1].trim());
                        }

                        if (criteriaText.startsWith(locationTrans)) {
                            jobAlert.setLocations(criteriaText.split(":")[1].trim());
                        }

                        if (criteriaText.startsWith(skillsTrans)) {
                            jobAlert.setSkills(criteriaText.split(":")[1].trim());
                        }

                        if (criteriaText.startsWith(positionTypeTrans)) {
                            jobAlert.setPositionTypes(criteriaText.split(":")[1].trim());
                        }

                        if (criteriaText.startsWith(employmentTypeTrans)) {
                            jobAlert.setEmploymentTypes(criteriaText.split(":")[1].trim());
                        }

                        if (criteriaText.startsWith(companyTrans)) {
                            jobAlert.setCompanies(criteriaText.split(":")[1].trim());
                        }

                        if (criteriaText.startsWith(sectorsTrans)) {
                            jobAlert.setSectors(criteriaText.split(":")[1].trim());
                        }
                    }

                    return jobAlert;
                }
            } catch (NoSuchElementException e) {
                continue;
            }
        }

        return null;
    }

    /**
     * Click mailing internal for specific job alert
     * @param alertName Alert name
     * @param mailingInterval Mailing interval
     */
    public void clickMailingInterval(String alertName, MailingInterval mailingInterval) {
        waitForAJAXToComplete();
        JobAlert jobAlertInformationFor = getJobAlertInformationFor(alertName);
        Long jobAlertId = jobAlertInformationFor.getId();

        for (WebElement editLink : editLinks) {
            if (editLink.getAttribute("href").contains(jobAlertId.toString())) {
                clickOn(editLink);
                break;
            }
        }

        String emailAlertSelection = "#jobSearchForm" + jobAlertId + " select";
        String emailAlertSaveBtn = "#jobSearchForm" + jobAlertId + " button";

        selectFromDropdownByHTMLValueAttribute(find(By.cssSelector(emailAlertSelection)), mailingInterval.name());
        clickOn(find(By.cssSelector(emailAlertSaveBtn)));
        waitForAJAXToComplete();
    }

    private List<net.thucydides.core.pages.WebElementFacade> getSavedSearchAlerts() {
        waitForAJAXToComplete();
        return null;
    }

    /**
     * Delete All Alerts
     */
    public void deleteAllJobAlerts() {
        if (fiftyFifty()) {
            scrollUntilElementIsVisible(bulkSelectCheckbox.get(0));
            clickOn(bulkSelectCheckbox.get(0));
        } else {
            scrollUntilElementIsVisible(bulkSelectCheckbox.get(1));
            clickOn(bulkSelectCheckbox.get(1));
        }

        clickOn(bulkDeleteLink);
    }

    /**
     * Confirm delete
     */
    public void deleteJobAlertsConfirm() {
        waitUntilElementHasStoppedMoving(confirmationToDeleteBtn);
        clickOn(confirmationToDeleteBtn);
    }

    /**
     * Gets validation message for no job job alerts saved
     * @return no job alerts message
     */
    public String getNoJobAlertsText() {
        return noJobAlertsText.getTextValue();
    }

    /**
     * Gets page header title
     * @return title
     */
    public String getPageHeader() {
        return headerText.getTextValue();
    }

    /**
     * Click delete button
     */
    public void clickDeleteButton() {
        clickOn(deleteJobAlertButton);
    }
}

