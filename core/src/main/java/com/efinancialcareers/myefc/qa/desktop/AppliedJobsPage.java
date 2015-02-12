package com.efinancialcareers.myefc.qa.desktop;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * User: jon.neville
 * Date: 12/09/13
 * Time: 16:47
 */
public class AppliedJobsPage extends BasePage {

    @FindBy(css = "a.sortTitle")
    private WebElementFacade job1Title;

    @FindBy(css = "#applicationHistoryContainer header h1")
    private WebElementFacade headerText;

    @FindBy(css = "#applicationHistoryContainer header div.elemBoxStyleNoBg")
    private WebElementFacade noJobApplicationsText;

    @FindBy(css = "#sectionContainer a.deleteElem")
    private WebElementFacade job1deleteBtn;

    @FindBy(css = "div.expand p.info a.loop")
    private WebElementFacade viewCoverLetterButton;

    @FindBy(css = "div.jobDescCriteria p:nth-child(4)")
    private WebElementFacade job1CompanyName;

    @FindBy(css = "div.jobDescCriteria p:nth-child(6)")
    private WebElementFacade coverLetterTitle;

    @FindBy(css = "li.status span.viewed")
    private WebElementFacade job1ApplicationStatus;

    @FindBy(css = SavedJobsPage.DELETE_CONFIRM_BUTTON)
    private WebElementFacade deleteJobConfirmLink;

    /**
     * Constructor
     *
     * @param driver WebDriver
     */
    public AppliedJobsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Assertion to check job title matches what was on the SRP
     * @return first job title
     */
    public String getJobTitleFromFirstRecord() {
        return job1Title.getTextValue();
    }

    /**
     * Assertion
     */
    public void assertNoJobApplications() {
        this.shouldNotBeVisible(job1Title);
    }

    /**
     * Get application view status for first job
     * @return first job application status
     */
    public String getApplicationViewStatusFirstRecord() {
        return job1ApplicationStatus.getAttribute("data-tooltip-content");
    }

    public String getCompanyNameFromFirstRecord() {
        return job1CompanyName.getTextValue().split("\n")[0];
    }

    /**
     * Click first job delete button
     */
    public void clickFirstJobDeleteBtn() {
        waitForAJAXToComplete();
        clickOn(job1deleteBtn);
    }

    /**
     * Confirm delete job action
     */
    public void confirmJobDeletion() {
        waitUntilElementHasStoppedMoving(deleteJobConfirmLink);
        clickOn(deleteJobConfirmLink);
        waitForAbsenceOf(SavedJobsPage.DELETE_CONFIRM_BUTTON);
    }

    /**
     * Get no jobs applied for text
     * @return number of jobs
     */
    public String getNoJobApplicationsText() {
        return noJobApplicationsText.getTextValue();
    }

    /**
     * Cover letter title
     * @return cover letter title
     */
    public String getCoverLetterTitle() {
        // Get 2nd element used cover letter title
        return coverLetterTitle.getTextValue().split(":")[1].trim();
    }

    /**
     * Get page header title
     * @return title
     */
    public String getPageHeader() {
        return headerText.getTextValue();
    }

    public void viewCoverLetter() {
        clickOn(find(By.cssSelector("a[rel='popup']")));

        waitUntilElementHasStoppedMoving(find(By.id("popupContent")));
    }

    public String getCoverLetterTitleFromPopup() {
        return find(By.cssSelector("#popupContent h3")).getText();
    }

    public String getCoverLetterTextFromPopup() {
        return (String) evaluateJavascript("return $('#popupContent').first().contents().filter(function() {"
                + "    return this.nodeType == 3; "
                + "}).text().trim();");
    }
}
