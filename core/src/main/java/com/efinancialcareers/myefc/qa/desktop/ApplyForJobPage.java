package com.efinancialcareers.myefc.qa.desktop;

import com.efinancialcareers.myefc.qa.utils.fo.WaitFor;
import com.google.common.base.Function;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ApplyForJobPage extends BasePage {

    @FindBy(name = "aboutYouForm.firstName")
    private WebElementFacade firstName;

    @FindBy(name = "aboutYouForm.lastName")
    private WebElementFacade lastName;

    @FindBy(id = "locationText")
    private WebElementFacade locationTypeaHead;

    @FindBy(id = "saveInProfile")
    private WebElementFacade saveDetailsToMyProfileCheckbox;

    @FindBy(id = "userInfoFormMakeSearchable")
    private WebElementFacade contactedByRecruitersCheckbox;

    @FindBy(id = "uploadAction")
    private WebElementFacade uploadAction;

    @FindBy(css = "#popupContent")
    private WebElementFacade popupContent;

    @FindBy(css = "#coverletterAction")
    private WebElementFacade writeACoverLetterLink;

    @FindBy(name = "coverLetterForm.title")
    private WebElementFacade coverLetterTitleText;

    @FindBy(name = "coverLetterForm.text")
    private WebElementFacade coverLetterText;

    @FindBy(css = "#popupContent form#uploadCVForm a[rel='cvUploadFile']")
    private WebElementFacade uploadCVFormAnchor;

    @FindBy(css = "#popupContent form#uploadCVForm #submitCvUploadFile")
    private WebElementFacade submitCvUploadFile;

    @FindBy(css = "#basic.twoColForm button.btn")
    private WebElementFacade applyForThisJobButton;

    @FindBy(css = "#content section#sidebar.left article .applyJobDescriptionList li.jobApplyCompany span")
    private WebElementFacade companyName;

    @FindBy(css = "header .titleCont h4")
    private WebElementFacade applyingForJobText;

    @FindBy(css = "#additional select[name='ofccpForm.ethnic']")
    private WebElementFacade ofccpEthnic;

    @FindBy(css = "#additional select[name='ofccpForm.gender']")
    private WebElementFacade ofccpGender;

    @FindBy(css = "#additional select[name='ofccpForm.veteran']")
    private WebElementFacade ofccpVeteran;

    @FindBy(css = "#sectors span.staticData div.sector-exp")
    private List<WebElement> workSummarySectorsAndSubSectors;

    @FindBy(css = "#jobApplytopdetails #addSector")
    private WebElementFacade additionalInfoAddSector;

    @FindBy(id = "aboutYouForm.profileTitle")
    private WebElementFacade workSummaryProfileTitle;

    @FindBy(id = "aboutYouForm.currentJobTitle")
    private WebElementFacade currentJobTitle;

    @FindBy(id = "workPermitLocations")
    private WebElementFacade workPermit;

    @FindBy(css = "#languageLevels ul")
    private List<WebElement> languages;

    @FindBy(id = "addLanguage")
    private WebElementFacade addLanguage;

    @FindBy(id = "nationality")
    private WebElementFacade nationalityElement;

    @FindBy(id = "addSector")
    private WebElementFacade addSector;

    private By autoComplete = By.cssSelector("body.jobApply ul.ui-autocomplete");

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public ApplyForJobPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Enter first name
     * @param firstName firstName
     */
    public void enterFirstName(String firstName) {
        this.firstName.type(firstName);
    }

    /**
     * Enter last name
     * @param lastName lastName
     */
    public void enterLastName(String lastName) {
        this.lastName.type(lastName);
    }

    /**
     * Enter location name
     * @param locationName location string
     */
    public void enterLocation(String locationName) {
        typeInto(locationTypeaHead, locationName);

        this.waitForTypeAHeadResponse();

        this.locationTypeaHead.sendKeys(Keys.DOWN, Keys.TAB);
    }

    private void waitForTypeAHeadResponse() {
        List<WebElement> autoCompleteList =
                super.explicitlyWaitForElementsBy(WaitFor.SLA_LOCATION_TYPEAHEAD.getSeconds(), autoComplete);

        new FluentWait<List<WebElement>>(autoCompleteList).
                withTimeout(WaitFor.SLA_LOCATION_TYPEAHEAD.getSeconds(), TimeUnit.SECONDS).
                until(new Function<List<WebElement>, WebElement>() {
                    @Override
                    public WebElement apply(List<WebElement> elements) {
                        for (WebElement element : elements) {
                            if (element.getCssValue("display").contains("block")) {
                                return element;
                            }
                        }
                        return null; //TODO i.patel. Throw error if null is returned
                    }
                }
            );
    }

    /**
     * Click on upload a resume link
     */
    public void clickUploadResumeButton() {
        scrollUntilElementIsVisible(uploadAction);
        clickOn(uploadAction);
        waitUntilElementHasStoppedMoving(popupContent);
    }

    /**
     * Click save details checkbox (should be selected by default so needs to be unchecked)
     */
    public void clickSaveDetails() {
        clickOn(saveDetailsToMyProfileCheckbox);
    }

    /**
     * Check if save details is selected or not
     * @return save details value
     */
    public boolean saveDetailsCheckBoxValue() {
        return saveDetailsToMyProfileCheckbox.isSelected();
    }

    /**
     * Check if interest in being contacted is selected or not
     * @return contacted by recruiters
     */
    public boolean contactedByOtherRecruitersCheckBoxValue() {
        return contactedByRecruitersCheckbox.isSelected();
    }

    /**
     * Click contacted by recruiters(should be selected by default so needs to be unchecked)
     */
    public void clickContactedByOtherRecruiters() {
        scrollUntilElementIsVisible(contactedByRecruitersCheckbox);
        clickOn(contactedByRecruitersCheckbox);
    }

    /**
     * Confirm "I’m interested in being contacted about....." checkbox is not displayed
     */
    public void assertContactedByOtherRecruitersIsNotDisplayed() {
        this.shouldNotBeVisible(contactedByRecruitersCheckbox);
    }

    public boolean isContactedByOtherRecruitersDisplayed() {
        return contactedByRecruitersCheckbox.isCurrentlyEnabled();
    }

    public boolean isContactedByOtherRecruitersTicked() {
        if (contactedByRecruitersCheckbox.isCurrentlyEnabled() && contactedByOtherRecruitersCheckBoxValue()) {
            return true;
        }

        return false;
    }

    /**
     * Click on save details checkbox
     */
    public void clickWriteANewCoverLetter() {
        scrollUntilElementIsVisible(writeACoverLetterLink);
        clickOn(writeACoverLetterLink);
    }

    /**
     * Enter cover letter title
     * @param coverLetterTitle coverLetterTitle
     */
    public void enterCoverLetterTitle(String coverLetterTitle) {
        coverLetterTitleText.type(coverLetterTitle);
    }

    /**
     * Enter cover letter text
     * @param coverLetterText coverLetterText
     */
    public void enterCoverLetterText(String coverLetterText) {
        this.coverLetterText.type(coverLetterText);
    }

    public String getCoverLetterText() {
        return coverLetterText.getAttribute("value");
    }

    /**
     * Apply for this job
     */
    public void applyForThisJob() {
        scrollUntilElementIsVisible(applyForThisJobButton);
        clickOn(applyForThisJobButton);
    }

    public boolean isOnJobApplyPage() {
        /*
            TODO. i.patel. When we upgrade to new version of Thucydides, use workExperience.expect("").
            This field is checked to confirm we are on job apply page but it is slightly confusing as we are
            checking workExperience field. We need to document why we are checking this.
         */

        return findAll(By.cssSelector("#basic.twoColForm button.btn")).size() > 0;
    }

    public String getApplyingForJobText() {
        return applyingForJobText.getTextValue();
    }

    public String getCompanyName() {
        return companyName.getTextValue();
    }



    /**
     * Enters profile title
     * @param profileTitle Title of profile
     */
    public void enterProfileTitle(String profileTitle) {
        workSummaryProfileTitle.type(profileTitle);
    }
    /**
     * Enter current job title
     * @param jobTitle Current job title
     */
    public void enterJobTitle(String jobTitle) {
        currentJobTitle.type(jobTitle);
    }

    /**
     * Enter Work Permit
     * @param workPermit location name
     */
    public void enterWorkPermit(String workPermit) {
        this.workPermit.type(workPermit);

        this.waitForTypeAHeadResponse();

        this.workPermit.sendKeys(Keys.DOWN, Keys.TAB);
    }


    /**
     * Click add another language
     */
    public void clickAddLanguage() {
        clickOn(addLanguage);
    }

    /**
     * Enter nationality
     * @param nationality nationality
     */
    public void enterNationality(String nationality) {
        typeInto(nationalityElement, nationality);

        this.waitForTypeAHeadResponse();

        this.nationalityElement.sendKeys(Keys.DOWN, Keys.TAB);
    }

    /**
     * Assert nationality field should not be present
     */
    public void assertNationalityFieldShouldNotBePresent() {
        this.shouldNotBeVisible(nationalityElement);
    }

    /**
     * Click add sector
     */
    public void clickAddSector() {
        clickOn(addSector);
    }
}
