package com.efinancialcareers.myefc.qa.desktop;

import com.efinancialcareers.myefc.qa.domain.Job;
import com.efinancialcareers.myefc.qa.utils.fo.WaitFor;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: ilyas.patel
 * Date: 05/08/13
 * Time: 02:34
 */
public class JobDetailsPage extends BasePage {

    private static final String tearDropSelector = "article section .job-action-statistics-container";
    private Pattern patternJobId = Pattern.compile("(jobId=|.id00)([0-9]+)");

    @FindBy(css = ".job-overview article aside")
    private WebElementFacade contactInformation;

    @FindBy(css = ".job-overview article .details .company")
    private WebElementFacade brandName;

    @FindBy(css = ".job-overview article .details .salary")
    private WebElementFacade salary;

    @FindBy(css = ".job-overview article .details .location")
    private WebElementFacade location;

    @FindBy(css = ".job-overview article .details .position")
    private WebElementFacade position;

    @FindBy(css = ".job-overview article .details .updated")
    private WebElementFacade updated;

    @FindBy(css = "li.prev")
    private WebElementFacade previousJobLink;

    @FindBy(css = "li.next")
    private WebElementFacade nextJobLink;

    @FindBy(tagName = "h1")
    private WebElementFacade jobTitleText;

    @FindBy(css = "aside a.apply")
    private WebElementFacade applyBtnTopRight;

    @FindBy(css = "aside a.saved")
    private WebElementFacade jobUnsaveBtnTopRight;

    @FindBy(css = "aside div.jobUnSavedPopup")
    private WebElementFacade unsavePopupTopRight;

    @FindBy(css = "aside button.save")
    private WebElementFacade jobSaveBtnTopRightNotLoggedIn;

    @FindBy(css = "article section.actionButtons button.save")
    private WebElementFacade jobSaveBtnBottomNotLoggedIn;

    @FindBy(css = "aside a.save")
    private WebElementFacade jobSaveBtnTopRightLoggedIn;

    @FindBy(css = "article section.actionButtons a.save")
    private WebElementFacade jobSaveBtnBottomLoggedIn;

    @FindBy(css = "article a.apply")
    private WebElementFacade applyBtnBottom;

    @FindBy(css = "article a.saved")
    private WebElementFacade jobUnsaveBtnBottom;

    @FindBy(css = "article div.jobUnSavedPopup")
    private WebElementFacade unsavePopupBottom;

    @FindBy(css = "#contact-info h4")
    private WebElementFacade displayContactInformationLink;

    @FindBy(css = ".job-overview aside a.company-details")
    private WebElementFacade viewMoreJobsByThisCompany;

    @FindBy(css = ".job-overview aside section.brandInfo h2")
    private WebElementFacade companyNameRightHandComponent;

    @FindBy(css = "#contact-info ul li")
    private List<WebElement> contactInfoRightHandSide;

    @FindBy(css = ".job-overview article section.description p")
    private List<WebElement> jobSummaryAndDescription;

    @FindBy(className = "job-overview")
    private WebElementFacade jobOverview;

    @FindBy(css = "a.lftarrow")
    private WebElementFacade backToSearchResultsLink;

    @FindBy(css = "a.share")
    private List<WebElement> shareLinks;

    private WebElementFacade breadcrumbs;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public JobDetailsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Makes browser window Full screen
     */
    @WhenPageOpens
    public void makeBrowserWindowFullScreen() {
        //super.makeBrowserWindowFullScreen();
        super.waitForPagePeel();
        // Some tests go directly to this page and try to interact with elements under page peel
    }

    private String getBrandName() {
        return brandName.getTextValue();
    }

    /**
     * Check if company information is on page
     * @return ExpectedCondition<Boolean>
     */
    public ExpectedCondition<Boolean> checkIfCompanyInformationExists() {
        return ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(".job-overview article aside div.well p"));
    }

    /**
     * Click previous job link
     */
    public void clickPreviousJobLink() {
        clickOnCustom(previousJobLink.findElement(By.tagName("a")));
    }

    /**
     * Click next job link
     */
    public void clickNextJobLink() {
        clickOnCustom(nextJobLink.findElement(By.tagName("a")));
    }

    /**
     * Assert previous job link is inactive when clicking on first job on SRP
     */
    public void assertPreviousLinkIsInactive() {
        Assert.assertEquals(translationFacade.getTranslation("fo.previous.job"), previousJobLink.getText());
        Assert.assertEquals(CLASS_NAME_PREV + " " + CLASS_NAME_DISABLED, previousJobLink.getAttribute("class"));
        Assert.assertTrue(
                previousJobLink.findElement(By.tagName("a")).getAttribute("href").startsWith(super.getCurrentUrl()));
        Assert.assertTrue(previousJobLink.isVisible());
    }

    /**
     * Assert next job link is inactive when clicking on last job on SRP
     */
    public void assertNextLinkIsInactive() {
        Assert.assertEquals(translationFacade.getTranslation("fo.next.job"), nextJobLink.getText());
        Assert.assertEquals(CLASS_NAME_NEXT + " " + CLASS_NAME_DISABLED, nextJobLink.getAttribute("class"));
        Assert.assertTrue(
                nextJobLink.findElement(By.tagName("a")).getAttribute("href").startsWith(super.getCurrentUrl()));
        Assert.assertTrue(nextJobLink.isVisible());
    }

    /**
     * Assert next job link is active
     */
    public void assertNextLinkIsActive() {
        Assert.assertEquals(translationFacade.getTranslation("fo.next.job"), nextJobLink.getText());
        Assert.assertEquals(CLASS_NAME_NEXT, nextJobLink.getAttribute("class"));
        Assert.assertTrue(
                !nextJobLink.findElement(By.tagName("a")).getAttribute("href").startsWith(super.getCurrentUrl()));
        Assert.assertTrue(nextJobLink.isVisible());
    }

    /**
     * Check that job has unsave buttons displayed
     */
    public void assertJobHasUnsaveButtons() {
        Assert.assertTrue(jobUnsaveBtnTopRight.isPresent());
        Assert.assertTrue(jobUnsaveBtnBottom.isPresent());
    }

    /**
     * Check that job has save buttons displayed
     */
    public void assertJobHasSaveButtons() {

            Assert.assertTrue(jobSaveBtnTopRightNotLoggedIn.isPresent());
            Assert.assertTrue(jobSaveBtnBottomNotLoggedIn.isPresent());

    }

    /**
     * Click one of the unsave buttons
     * @return button pressed
     */
    public String clickOneOfTheUnsaveButtons() {

        String buttonPressed;

        if (fiftyFifty()) {
            clickOnCustom(jobUnsaveBtnTopRight);
            buttonPressed = "Clicked Top Right Unsave Button";
        } else {
            clickOnCustom(jobUnsaveBtnBottom);
            buttonPressed = "Clicked Bottom Unsave Button";
        }

        return buttonPressed;
    }

    /**
     * Get job title
     * @return  Job Title
     */
    public String getJobTitle() {
        return jobTitleText.getTextValue();
    }

    /**
     * Click apply button
     * @return MyEfcLoginPage Object
     */
    public MyEfcLoginPage clickApplyButton() {
        if (fiftyFifty()) {
            System.out.println("Clicked Top Right Apply Button");
            clickOnCustom(applyBtnTopRight);
        } else {
            System.out.println("Clicked Bottom Apply Button");
            clickOnCustom(applyBtnBottom);
        }

        return this.switchToPage(MyEfcLoginPage.class);
    }

    /**
     * Click display contact information link
     */
    public void clickDisplayContactInformationLink() {
        clickOnCustom(displayContactInformationLink);
    }

    /**
     * Click on view more jobs by this company link
     */
    public void clickOnViewMoreJobsByThisCompanyLink() {
        clickOn(viewMoreJobsByThisCompany);
    }

    /**
     * Click on back to search results link
     */
    public void clickBackToSearchResults() {
        clickOn(backToSearchResultsLink);
    }

    /**
     * Determines if the contact details are on the page
     * @return true or false
     */
    public boolean isContactInformationAvailable() {
        return getDriver().findElements(By.cssSelector(".job-overview article aside")).size() < 0;
    }

    /**
     * Assert that job is already applied for
     */
    public void assertJobAlreadyApplied() {
        String alreadyAppliedLabel = translationFacade.getTranslation("fo.job.applied.on");

        Assert.assertTrue(applyBtnBottom.getTextValue().startsWith(alreadyAppliedLabel));
        Assert.assertTrue(applyBtnTopRight.getTextValue().startsWith(alreadyAppliedLabel));
    }

    public String getCompanyNameRightHandComponent() {
        return companyNameRightHandComponent.getText();
    }

    public String getTopRightApplyButtonText() {
        return applyBtnTopRight.getTextValue();
    }

    public String getBottomApplyButtonText() {
        return applyBtnBottom.getTextValue();
    }

    public String getCompanyInformationSalary(){
        return salary.getText().split("\\n")[1];
    }

    public String getCompanyInformationLocation(){
        return location.getText().split("\\n")[1];
    }

    public String getCompanyInformationPosition(){
        return position.getText().split("\\n")[1];
    }

    public String getCompanyInformationBrandName(){
        return brandName.getText().split("\\n")[1];
    }

    public String getCompanyInformationUpdatedDate(){
        return updated.getText().split("\\n")[1];
    }

    /**
     * Get company information
     * @return List of company information
     */
    public Job getCompanyInformation() {
        Job job = new Job();

        job.setSalary(getCompanyInformationSalary());
        job.setLocation(getCompanyInformationLocation());
        job.setPositionType(getCompanyInformationPosition());
        job.setBrandName(getCompanyInformationBrandName());
        job.setStartDate(getCompanyInformationUpdatedDate());

        //CHECKSTYLE:OFF
        job.setContactName(contactInfoRightHandSide.get(0).getText());
        job.setContactAddress1(contactInfoRightHandSide.get(1).getText());
        job.setContactPhone(contactInfoRightHandSide.get(2).getText());
        job.setContactFax(contactInfoRightHandSide.get(3).getText());
        job.setContactEmail(contactInfoRightHandSide.get(4).getText());
        job.setContactURL(contactInfoRightHandSide.get(5).getText());
        job.setJobReference(contactInfoRightHandSide.get(6).getText());
        //CHECKSTYLE:ON

        return job;
    }

    /**
     * Get Job Details from current page
     * @return Job Bean
     */
    public Job getJobInformation() {
        String nonDisclosedTrans = translationFacade.getTranslation("OP.company.name.non.disclosed");
        String brandNameTxt = getBrandName();
        String jobSummary = jobSummaryAndDescription.get(0).getText();
        String jobDescription = jobSummaryAndDescription.get(1).getText();
        String positionTrans = position.getTextValue();
        String jobId = String.valueOf(getJobIdFromUrl());

        Job job = new Job();
        job.setJobId(jobId);
        job.setJobTitle(getJobTitle());
        job.setJobSummary(jobSummary);
        job.setJobDescription(jobDescription);
        job.setSalary(salary.getText());
        job.setLocation(location.getText());
        job.setPositionType(positionTrans);
        job.setBrandName(brandNameTxt);
        job.setStartDate(updated.getText());

        if (!job.getBrandName().equals(nonDisclosedTrans)) {
            job.setCompanyNameRightHandSideComponent(getCompanyNameRightHandComponent());
        } else {
            job.setAnonymous(true);
        }

        return job;
    }

    /**
     * Assertion
     */
    public void assertContactInformationIsNotVisibleWhenPageOpens() {
        waitForAJAXToComplete();
        waitForAbsenceOf("#contact-info ul");
    }

    /**
     * Assertion
     */
    public void assertContactInformationIsVisible() {
        for (WebElement element : contactInfoRightHandSide) {
            element.isDisplayed();
        }
    }

    /**
     * Assertion
     */
    public void assertCompanyInformationIsVisible() {
        Assert.assertTrue(jobSummaryAndDescription.get(0).isDisplayed());
        Assert.assertTrue(jobSummaryAndDescription.get(1).isDisplayed());

        Assert.assertTrue(salary.isDisplayed());
        Assert.assertTrue(location.isDisplayed());
        Assert.assertTrue(position.isDisplayed());
        Assert.assertTrue(brandName.isDisplayed());
        Assert.assertTrue(updated.isDisplayed());
    }

    /**
     * Get Job Id from URL
      * @return JobId
     */
    public long getJobIdFromUrl() {
        Matcher matcher = patternJobId.matcher(super.getCurrentUrl());

        matcher.find();
        String jobId = matcher.group(2);
        return Long.valueOf(removeLeadingZeros(jobId));
    }

    private String removeLeadingZeros(String jobId) {
        /**
         * The ^ makes sure the 0+ being matched is at the beginning of the string.
         * The (?!$) negative lookahead ensures NOT the entire string is matched.
         */
        return jobId.replaceFirst("^0+(?!$)", "");
    }

    /**
     * Assertion to make sure company name is not displayed
     * @param companyName Name of parent company
     * @param brandName Brand name
     * @param contactCompanyName Contact company name
     */
    public void assertCompanyNameIsNotInOPPage(String companyName, String brandName, String contactCompanyName) {
        Assert.assertFalse(jobOverview.getTextValue().toLowerCase().contains(companyName.toLowerCase()));
        Assert.assertFalse(jobOverview.getTextValue().toLowerCase().contains(brandName.toLowerCase()));
        Assert.assertFalse(jobOverview.getTextValue().toLowerCase().contains(contactCompanyName.toLowerCase()));
    }

    /**
     * Return breadcrumb's text value
     * @return formatted String
     */
    public String getBreadcrumbText() {
        return breadcrumbs.getTextValue().trim();
    }

    /**
     * Click save job link on OP
     */
    public void clickSaveJob() {
            if (fiftyFifty()) {
                clickOn(jobSaveBtnTopRightNotLoggedIn);
            } else {
                scrollUntilElementIsVisible(jobSaveBtnBottomNotLoggedIn);
                clickOn(jobSaveBtnBottomNotLoggedIn);
            }
    }

    /**
     * Assertion
     */
    public void assertTearDropIsNotVisible() {
        waitForAJAXToComplete();
        waitForAbsenceOf(tearDropSelector);
    }

    /**
     * Get tear drop text
     * @return Text inside tear drop
     */
    public List<String> getAllTearDropText() {
        final List<String> messageList = new ArrayList<String>();

        final long t = System.currentTimeMillis();
        final long end = t + WaitFor.THIRTY_SECONDS.getMilliseconds();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(WaitFor.ONE_MINUTE.getSeconds(), TimeUnit.SECONDS)
                .pollingEvery(WaitFor.TWO_SECONDS.getSeconds(), TimeUnit.SECONDS)
                .ignoring(StaleElementReferenceException.class);

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                WebElementFacade messages = find(By.cssSelector(tearDropSelector));

                addMessage(messages.getTextValue().trim());

                return (System.currentTimeMillis() > end) ? true : false;
            }

            private void addMessage(String tearDropString) {

                // Not ideal but the String split is only done as the css seems to be getting more the one element.
                // It is possibly happening as there is animation when swapping between messages.
                String[] str = tearDropString.split("\n");
                String newTearDropString = str[0] + " " + str[1];

                if (!messageList.contains(newTearDropString)) {
                    messageList.add(newTearDropString);
                }
            }
        });

        return messageList;
    }

    public boolean checkIfSpecificTearDropTextExists(final String str) {
        final List<String> messageList = new ArrayList<String>();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(WaitFor.THIRTY_SECONDS.getSeconds(), TimeUnit.SECONDS)
                .pollingEvery(WaitFor.ONE_SECOND.getSeconds(), TimeUnit.SECONDS)
                .ignoring(StaleElementReferenceException.class);

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                WebElement messages = getDriver().findElement(By.cssSelector(tearDropSelector));

                if (str.equals(messages.getText())) {
                    messageList.add(messages.getText());
                }

                return messageList.size() > 0;
            }
        });

        return messageList.size() > 0 ? true : false;
    }

    public void clickShareLink() {
        if(fiftyFifty()) {
            clickOn(shareLinks.get(0));
        } else {
            clickOn(shareLinks.get(1));
        }

        waitForAnyRenderedElementOf(By.id("at15s"));
    }
}
