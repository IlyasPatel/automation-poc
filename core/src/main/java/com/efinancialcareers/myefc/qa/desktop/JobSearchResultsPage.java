package com.efinancialcareers.myefc.qa.desktop;

import com.beust.jcommander.internal.Lists;
import com.efinancialcareers.myefc.qa.domain.Job;
import com.efinancialcareers.myefc.qa.domain.JobSearchSortBy;
import com.efinancialcareers.myefc.qa.utils.RegexUtility;
import com.efinancialcareers.myefc.qa.utils.fo.TranslationFacade;
import com.efinancialcareers.myefc.qa.utils.fo.WaitFor;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementFacadeImpl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.validation.DataBinder;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.tagName;

public class JobSearchResultsPage extends BasePage {

    private static final int POSITION_OF_PREVIOUS_PAGINATION_LINK = 0;
    public static final String FACETS_QUERY_STRING = "&keywords=&locationName=&sortBy=&filterGroupForm.datePosted=OTHER"
            + "&searchType=&updateEmitter=EMPTY&filterGroupForm.currency="
            + "&filterGroupForm.locations="
            + "&keywordsSearchForm.locationsId="
            + "&keywordsSearchForm.locationsName=";

    public static final String LOCATION_FILTER_GROUP = "&filterGroupForm.locations=";
    private By locationList = By.cssSelector("#location-facet ul.typeahead li");

    @FindBy(css = "#jobSearchContainer .jobListContainer")
    private WebElementFacade jobListContainer;

    @FindBy(css = "#jobSearchContainer.container div.jobListContainer")
    private WebElementFacade mainJobList;

    @FindBy(css = "#jobSearchContainer .jobListContainer .jobList .jobPreview nav.jobActions a.save")
    private WebElementFacade firstJobSaveBtn;

    @FindBy(css = ".jobPreview nav.jobActions ul li a.saved")
    private WebElementFacade firstJobUnsaveBtn;

    @FindBy(css = ".jobActions ul li.applied")
    private WebElementFacade firstJobAppliedForText;

    @FindBy(xpath = "//a[contains(@href, 'myefc/jobs/apply/')]")
    private WebElementFacade firstJobApplyBtn;

    @FindBy(id = "email1")
    private WebElementFacade username;

    @FindBy(css = "section.sortBy select[name='sortBy']")
    private WebElementFacade sortBy;

    @FindBy(css = "form#saveSearchForm h4.save")
    private WebElementFacade saveSearchButton;

    @FindBy(css = "form#saveSearchForm p.buttons input.saveSearchButton")
    private WebElementFacade saveButton;

    @FindBy(css = "#saveSearchForm.expanded p.buttons a")
    private WebElementFacade manageJobAlertsLink;

    @FindBy(name = "name")
    private WebElementFacade alertName;

    @FindBy(id = "mailingInterval")
    private WebElementFacade mailingIntervalSelect;

    @FindBy(css = "#srpForm #salary-facet legend a")
    private WebElementFacade salaryFacetSection;

    @FindBy(css = "#srpForm #datePosted-facet legend a")
    private WebElementFacade datePostedFacetSection;

    @FindBy(css = "#breadcrumbs")
    private WebElementFacade breadcrumb;

    @FindBy(css = "#srpForm #brands-facet legend a")
    private WebElementFacade brandFacetSection;

    @FindBy(css = "#srpForm #salary-facet select[name='filterGroupForm.currency']")
    private WebElementFacade filterSalaryCurrency;

    @FindBy(css = "#srpForm #datePosted-facet select[name='filterGroupForm.datePosted']")
    private WebElementFacade filterDateRange;

    @FindBy(css = "#srpForm #salary-facet .options label")
    private List<WebElement> filterSalaryBands;

    @FindBy(id = "employmentType-facet")
    private WebElementFacade employmentTypeFacet;

    @FindBy(id = "positionType-facet")
    private WebElementFacade positionTypeFacet;

    @FindBy(id = "brands-facet")
    private WebElementFacade brandFacet;

    @FindBy(id = "sectors-facet")
    private WebElementFacade sectorsFacet;

    @FindBy(css = "#srpForm #employmentType-facet .options label")
    private List<WebElement> filterEmploymentType;

    @FindBy(css = "#srpForm #positionType-facet .options label")
    private List<WebElement> filterPositionType;

    @FindBy(css = "#srpForm #brands-facet .options label")
    private List<WebElement> filterCompanyName;

    @FindBy(css = "#srpForm #sectors-facet #all-sectors .modal-dialog input[name='filterGroupForm.sectors']")
    private List<WebElement> filterSectorsInModal;

    @FindBy(css = "#sectorFilters input[name='filterGroupForm.sectors']")
    private List<WebElement> filterSectors;

    @FindBy(css = "#skills-facet input[name='filterGroupForm.skills']")
    private List<WebElement> filterSkills;

    @FindBy(css = "#yearsExperience-facet input[name='filterGroupForm.yearsExperience']")
    private List<WebElement> yearsExperience;

    @FindBy(css = "#srpForm #contactName-facet .options label")
    private WebElement filterAnonymousCompanies;

    @FindBy(css = "form .save")
    private WebElementFacade updateSaveJobSearchLink;

    @FindBy(xpath = "//a[@name='searchType']")
    private WebElementFacade expandSearchLink;

    @FindBy(css = "#jobSearchContainer .jobListContainer nav.actions ul.pagination li")
    private List<WebElement> pagination;

    @FindBy(css = "#jobSearchContainer .jobListContainer nav.actions ul.pagination li.current")
    private WebElementFacade currentPage;

    @FindBy(css = ".jobList .jobPreview .details li.company")
    private List<WebElement> companyNames;

    @FindBy(css = ".jobListContainer .jobList li.jobPreview")
    private List<WebElement> jobsWebElementList;

    @FindBy(css = "#jobSearchContainer .jobListContainer .toggleLayout .detailed")
    private WebElementFacade detailedViewBtn;

    @FindBy(css = "#jobSearchContainer .jobListContainer article p")
    private WebElementFacade seoBrandDescription;

    @FindBy(css = "#job-search form h3 span")
    private WebElementFacade jobsFound;

    @FindBy (xpath = "//li[contains(@id, 'jobPreview-')][1]")
    private WebElementFacade firstJobPreview;

    @FindBy(xpath = "//article[@data-efctype='embededArticle']/p[1]")
    private WebElementFacade seoLpDescription;

    @FindBy(css = "#location-facet ul li a[href='#all-locations']")
    private WebElementFacade allLocations;

    @FindBy(css = "#sectorFilters li a[href='#all-sectors']")
    private WebElementFacade allSectors;

    @FindBy(css = "#skills-facet ul li a[href='#all-skills']")
    private WebElementFacade allSkills;

    @FindBy(css = "#brands-facet ul li a[href='#all-companies']")
    private WebElementFacade allCompanies;

    @FindBy(css = "#all-sectors .modal-dialog button.close")
    private WebElementFacade sectorModalCloseBtn;

    @FindBy(css = "#all-sectors .modal-dialog a.saveBtn")
    private WebElementFacade sectorModalRefineLink;

    @FindBy(css = "#all-skills .modal-dialog button.close")
    private WebElementFacade skillsModalCloseBtn;

    @FindBy(css = "#all-skills .modal-dialog a.saveBtn")
    private WebElementFacade skillsModalRefineLink;

    @FindBy(css = "#all-companies .modal-dialog button.close")
    private WebElementFacade companiesModalCloseBtn;

    @FindBy(css = "#all-companies .modal-dialog a.saveBtn")
    private WebElementFacade companiesModalRefineLink;

    @FindBy(css = "#all-locations .modal-dialog button.close")
    private WebElementFacade locationModalCloseBtn;

    @FindBy(css = "#all-locations .modal-dialog a.saveBtn")
    private WebElementFacade locationModalRefineLink;

    @FindBy(className = "nextPage")
    private WebElementFacade nextinPagination;

    @FindBy(css = "#datePosted-facet a.clear")
    private WebElementFacade clearDatePostedFacet;

    @FindBy(css = "#salary-facet a.clear")
    private WebElementFacade clearSalaryFacet;

    @FindBy(css = "#location-facet a.clear")
    private WebElementFacade clearLocationFacet;

    @FindBy(css = "#positionType-facet a.clear")
    private WebElementFacade clearPositionTypeFacet;

    @FindBy(css = "#sectors-facet a.clear")
    private WebElementFacade clearSectorsFacet;

    @FindBy(css = "#skills-facet a.clear")
    private WebElementFacade clearSkillsFacet;

    @FindBy(css = "#brands-facet a.clear")
    private WebElementFacade clearBrandFacet;

    @FindBy(css = "#employmentType-facet a.clear")
    private WebElementFacade clearEmploymentTypeFacet;

    @FindBy(css = "#srpForm input[data-efcevent='RESET_FILTERS']")
    private WebElementFacade clearAllFacets;

    @FindBy(css = "[name='filterGroupForm.locations'] + input")
    private WebElementFacade locationWebElement;

    @FindBy(css = "#current-facet ul li")
    private List<WebElement> currentFacets;

    By firstJobTitleSelector = By.cssSelector(".jobList li.jobPreview h3 a");

    private List<Job> jobList;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public JobSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Select apply button
     */
    public void selectFirstJobToApply() {
        clickOn(firstJobApplyBtn);
    }

    /**
     * Check if expand Search link is present
     * @return true false
     */
    public boolean isBroadenYourSearchLinkPresent() {
        return this.expandSearchLink.isPresent();
    }

    /**
     * Check broaden search link is not displayed
     */
    public void assertBroadenYourSearchLinkIsNotDisplayed() {
        this.shouldNotBeVisible(expandSearchLink);
    }

    /**
     * Check assuming that at least 1 job is on the SRP
     * @return jobTitleIsDisplayed on page
     */
    public boolean isOnJobSearchPage() {
        return findAll(firstJobTitleSelector).size() > 0;
    }

    /**
     * Get job title
     * @return Get first job title from SRP so it can be used in assertions
     */
    public String getFirstJobTitle() {
        return findAll(firstJobTitleSelector).get(0).getTextValue();
    }

    /**
     * Select order by
     * @param orderBy orderBy
     */
    public void selectSortBy(JobSearchSortBy orderBy) {
        this.sortBy.selectByValue(orderBy.name());

        waitForSRPOverlayToComplete();
    }

    /**
     * Click save search button
     */
    public void clickSaveSearchAlert() {
        // TODO. i.patel. Add 50/50 here as there are two save buttons on page.
        super.scrollUntilElementIsVisible(saveSearchButton);
        clickOn(saveSearchButton);
    }

    /**
     * Enter saved search alert name
     * @param alertName Search alert name
     */
    public void enterAlertName(String alertName) {
        this.alertName.type(alertName);
    }

    /**
     * Search alert mailing interval
     * @param mailingInterval mailing Interval
     */
    public void selectMailingFrequency(String mailingInterval) {
        super.selectFromDropdownByHTMLValueAttribute(this.mailingIntervalSelect, mailingInterval.toUpperCase());
    }

    public String getMailingFrequency() {
        return mailingIntervalSelect.getValue();
    }

    /**
     * Click save button for alert
     */
    public void clickSave() {
        if (fiftyFifty()) {
            clickOn(saveButton);
        } else {
            alertName.submit();
        }
    }

    private boolean paginationComplete(WebElement nextListElement) {
        return nextListElement.getAttribute("class").contains("disabled");
    }

    private boolean currentPage(WebElement page) {
        return page.getAttribute("class").contains("current");
    }

    private void removePreviousPageLink(List<WebElement> pagination) {
        pagination.remove(0);
    }

    public List<WebElement> getAllValuesFromSortByOptions() {
        return super.getOptionFrom(this.sortBy);
    }

    /**
     * Select Brand by name
     * @param brandName Brand Name
     */
    public void selectBrand(String brandName) {
        super.scrollUntilElementIsVisible(brandFacet);
        openBrandFacet();

        for (WebElement element : filterCompanyName) {
            if (element.getText().contains(brandName)) {
                clickOn(element);
                waitForSRPOverlayToComplete();
                break;
            }
        }
    }

    /**
     * Select Brand by ID
     * @param brandId BrandId
     */
    public void selectBrandById(Long brandId) {
        super.scrollUntilElementIsVisible(brandFacet);
        openBrandFacet();

        for (WebElement element : filterCompanyName) {
            if (element.findElement(By.tagName("input")).getAttribute("value")
                    .equalsIgnoreCase(String.valueOf(brandId))) {
                clickOn(element);
                waitForSRPOverlayToComplete();
                break;
            }
        }
    }

    private void openSalaryFacet() {
        if (this.salaryFacetSection.getAttribute("class").contains("collapsed")) {
            this.salaryFacetSection.click();

            (new WebDriverWait(getDriver(), WaitFor.SLA_WEB_ELEMENTS_QUICK.getSeconds()))
                    .until(new ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver driver) {
                        return driver.findElement(
                            By.cssSelector("#srpForm #salary-facet section")).getAttribute("class").contains("in");
                        }
                    });
        }
    }

    private void openDateRangeFacet() {
        if (this.datePostedFacetSection.getAttribute("class").contains("collapsed")) {
            this.datePostedFacetSection.click();

            (new WebDriverWait(getDriver(), WaitFor.SLA_WEB_ELEMENTS_QUICK.getSeconds()))
                    .until(new ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver driver) {
                        return driver.findElement(
                            By.cssSelector("#srpForm #datePosted-facet section")).getAttribute("class").contains("in");
                        }
                    });
        }
    }

    private void openBrandFacet() {
        if (this.brandFacetSection.getAttribute("class").contains("collapsed")) {
            clickOn(this.brandFacetSection);

            (new WebDriverWait(getDriver(), WaitFor.SLA_WEB_ELEMENTS_QUICK.getSeconds()))
                    .until(new ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver driver) {
                        return driver.findElement(
                            By.cssSelector("#srpForm #brands-facet section")).getAttribute("class").contains("in");
                        }
                    });
        }
    }

    /**
     * Get text in Update Search Alert Button
     * @return text
     */
    public String getUpdateSearchAlertButtonText() {
        Assert.assertTrue(updateSaveJobSearchLink.isDisplayed());
        return updateSaveJobSearchLink.isCurrentlyVisible() ? updateSaveJobSearchLink.getText() : "";
    }


    /**
     * Select non-disclosed salary Band
     */
    public void selectNonDisclosedSalaryBand() {
        for (WebElement element : filterSalaryBands) {
            if (element.findElement(By.tagName("input")).getAttribute("value").equalsIgnoreCase("false")) {
                clickOn(element);
                waitForSRPOverlayToComplete();
                break;
            }
        }
    }

    /**
     * Gets selected Currency
     * @return Selected Currency
     */
    public String getSelectedCurrency() {
        return new Select(filterSalaryCurrency).getFirstSelectedOption().getAttribute("value");
    }
    /**
     * Get all job titles from SRP
     * @return Job titles
     */
    @Deprecated
    public List<String> getAllJobTitles() {
        List<String> jobTitles = new ArrayList<String>();

        List<WebElement> tr = mainJobList.findElements(By.tagName("h3"));

        for (WebElement row : tr) {
            try {
                List<WebElement> anchors = row.findElements(By.tagName("a"));

                for (WebElement anchor : anchors) {
                    jobTitles.add(anchor.getText());
                }
            } catch (NoSuchElementException e) {
                print("Ignore if anchor element not found");
            }
        }
        return jobTitles;
    }

    public String getCurrentlySelectedSortByValue() {
        return sortBy.getSelectedValue();
    }

    public List<Job> getInformationForAllJobsOnCurrentPage() {
        return getInformationForAllJobsUpToPage(1);
    }

    /**
     * Get information for all jobs up to the given page number
     * @param maxPageCount Max pages to paginate
     * @return List of Job Beans
     */
    public List<Job> getInformationForAllJobsUpToPage(int maxPageCount) {
        jobList = new ArrayList<>();
        boolean paginationFinished = false;
        int pageCount = 1;

        while (true) {
            for (WebElement jobWebElement : jobsWebElementList) {
                jobList.add(getJobInformationForThisJob(jobWebElement));
            }

            Serenity.takeScreenshot();
            removePreviousPageLink(pagination);

            for (WebElement page : pagination) {
                if (currentPage(page)) {
                    WebElement nextListElement = pagination.get(pagination.indexOf(page) + 1);

                    if ((paginationComplete(nextListElement)) || (pageCount == maxPageCount)) {
                        paginationFinished = true;
                        break;
                    }
                    WebElementFacade element = WebElementFacadeImpl
                            .wrapWebElement(getDriver(), nextListElement, WaitFor.THIRTY_SECONDS.getSeconds());

                    scrollUntilElementIsVisible(element);
                    clickOn(nextListElement.findElement(By.tagName("a")));

                    waitForSRPOverlayToComplete();
                    pageCount++;

                    break;
                }
            }

            if (paginationFinished) {
                break;
            }
        }

        return jobList;
    }

    private Job getJobInformationForThisJob(WebElement jobWebElement) {
        Job job = new Job();

        String[] summaryAndDesc = jobWebElement.findElement(By.className("description")).getText().split("\n \n");

        job.setJobTitle(jobWebElement.findElement(By.tagName("h3")).getText());
        job.setJobSummary(summaryAndDesc[0]);
        if(summaryAndDesc.length > 1) {
            job.setJobDescription(summaryAndDesc[1]);
        }

        job.setJobId(
            String.valueOf(
                RegexUtility.getJobIdFromUrl(jobWebElement.findElement(By.className("anchor")).getAttribute("id"))
            )
        );

        String brandName =
                jobWebElement.findElement(By.cssSelector(".details .company span")).getText();

        String salaryName =
                jobWebElement.findElement(By.cssSelector(".details .salary span")).getText();

        String location =
                jobWebElement.findElement(By.cssSelector(".details .location span")).getText();

        String positionType =
                jobWebElement.findElement(By.cssSelector(".details .position span")).getText();

        String startDate =
                jobWebElement.findElement(By.cssSelector(".details .updated span")).getText();

        String postedOn = translationFacade.getTranslation("fo.posted.on") + " ";
        String nonDisclosedBrands =
                translationFacade.getTranslation("fo.site.filter.brands.label.nonDisclosedBrands");

        job.setBrandName(brandName);
        job.setCompanyNameRightHandSideComponent(brandName);
        job.setSalary(salaryName);
        job.setLocation(location);
        job.setPositionType(positionType);
        job.setStartDate(startDate.split(":")[1].trim());

        if (brandName.equalsIgnoreCase(nonDisclosedBrands)) {
            job.setAnonymous(true);
        }

        return job;
    }

    /**
     * Select job with a job title
     * @param jobTitle Job title
     */
    public void selectJob(String jobTitle) {
        for (WebElement jobWebElement : jobsWebElementList) {
            WebElement jobTitleLink = jobWebElement.findElement(By.cssSelector("h3 a"));
            String jobTitleText = jobTitleLink.getText().trim();

            if (jobTitleText.equalsIgnoreCase(jobTitle)) {
                super.scrollUntilElementIsVisible(jobTitleLink);
                clickOn(jobTitleLink);
                break;
            }
        }
    }

    /**
     * Select Non-Disclosed companies
     */
    public void selectIncludeNonDisclosedCompanies() {
        selectBrand(TranslationFacade.getInstance().getTranslation("fo.site.filter.brands.label.includeNotDisclosed"));
    }

    /**
     * Select job on SRP starting at position 1
     * @param jobNumber Job number on SRP page
     */
    private void selectJobNumber(int jobNumber) {
        super.scrollTop();
        // TODO i.patel. add fifty fifty
        WebElement element = jobsWebElementList.get(jobNumber - 1).findElement(By.cssSelector("h3 a"));

        super.scrollUntilElementIsVisible(element);

        element.click();
        waitForAJAXToComplete();
    }

    /**
     * Check first job has unsave button
     */
    public void assertFirstJobUnsaveButton() {
        assertTrue(firstJobUnsaveBtn.isPresent());
    }

    /**
     * Check first job has apply button
     */
    public void assertFirstJobApplyButton() {
        assertTrue(firstJobApplyBtn.isPresent());
    }

    /**
     * Get breadcrumb text
     * @return breadcrumb text
     */
    public String getBreadcrumbText() {
        scrollUntilElementIsVisible(breadcrumb);
        return breadcrumb.getTextValue().trim();
    }

    /**
     * Check first job has save button
     */
    public void assertFirstJobSaveButton() {
        assertTrue(firstJobSaveBtn.isPresent());
    }

    /**
     * Check first job applied for text
     */
    public void assertFirstJobAppliedTextExists() {
        assertTrue(firstJobAppliedForText.isPresent());
    }

    /**
     * Get first job applied for button text
     * @return Applied on with date text
     */
    public String getFirstJobAppliedForButtonText() {
        return firstJobAppliedForText.getTextValue();
    }

    /**
     * Get selected posted date
     * @return selected posted date
     */
    public String getCurrentlySelectedPostedDate() {
        return filterDateRange.getSelectedVisibleTextValue().trim();
    }

    /**
     * Switch to detailed view
     */
    public void switchToDetailedView() {
        clickOnCustom(detailedViewBtn);
    }

    /**
     * Assertion to make sure company name is not displayed
     * @param companyName Name of parent company
     * @param brandName Brand name
     * @param contactCompanyName Contact company name
     */
    public void assertCompanyNameIsNotInSRPSection(String companyName, String brandName, String contactCompanyName) {
        Assert.assertFalse(jobListContainer.getText().contains(companyName));
        Assert.assertFalse(jobListContainer.getText().contains(brandName));
        Assert.assertFalse(jobListContainer.getText().contains(contactCompanyName));
    }

    /**
     * Assert previous button on the pagination is disabled
     */
    public void assertPreviousPaginationLinkIsDisabled() {
        Assert.assertTrue(pagination.get(POSITION_OF_PREVIOUS_PAGINATION_LINK)
                .getAttribute("class").equalsIgnoreCase(CLASS_NAME_DISABLED));

        Assert.assertTrue(pagination.get(POSITION_OF_PREVIOUS_PAGINATION_LINK)
                .findElements(By.tagName("a")).size() == 0);
    }

    /**
     * Assert next button on the pagination is disabled
     */
    public void assertNextPaginationLinkIsDisabled() {
        Assert.assertTrue(pagination.get(pagination.size() - 1)
                .getAttribute("class").equalsIgnoreCase(CLASS_NAME_DISABLED));

        Assert.assertTrue(pagination.get(pagination.size() - 1)
                .findElements(By.tagName("a")).size() == 0);
    }

    /**
     * Select the last page using pagination. If there is only one page, then nothing will happen
     */
    public void selectLastPage() {

        int numberOfPages = pagination.size() - 2;

        if (numberOfPages > 2) {
            WebElement page = pagination.get(numberOfPages);
            super.scrollUntilElementIsVisible(page);
            page.findElement(By.tagName("a")).click();
            super.waitForSRPOverlayToComplete();
        }

        assertNextPaginationLinkIsDisabled();
    }

    /**
     * Select the last job on current page
     * @return JobDetailsPage
     */
    public JobDetailsPage selectLastJob() {
        selectJobNumber(jobsWebElementList.size());

        return switchToPage(JobDetailsPage.class);
    }

    /**
     * Select first job on current page
     * @return JobDetailsPage
     */
    public JobDetailsPage selectFirstJob() {
        selectJobNumber(1);

        return switchToPage(JobDetailsPage.class);
    }

    public String getLandingPageSeoDescription() {
        return seoBrandDescription.getTextValue().trim();
    }

    public int getNumberOfJobsFound() {
        return Integer.valueOf(jobsFound.getText().trim());
    }

    private String getSerializedFacets() {
        return (String) evaluateJavascript("return $('.facetsContainer form').serialize();");
    }

    public int getCurrentPageNumber() {
        return Integer.valueOf(currentPage.getText());
    }

    /**
     * Get Location of the first Job on SRP
     * @return Formatted string
     */
    public String getFirstJobLocation() {
        return firstJobPreview.then(className("location"))
                .getTextValue().split("\\n")[1].trim();
    }

    /**
     * Get Company of the first Job on SRP
     * @return Formatted string
     */
    public String getFirstJobCompany() {
        //return firstJobPreview.then(className("company"))
                //.getTextValue().split("\\n")[1].trim();

        //if job has company with EA License number then this is displayed next to company name
        return firstJobPreview.then(className("company")).then(tagName("span")).getAttribute("title");
    }

    /**
     * Get Tooltip of the first Job on SRP
     * @return Formatted string
     */
    public String getFirstJobTooltip() {
        return firstJobPreview.then(tagName("h3"))
                .then(tagName("a")).getAttribute("title");
    }

    /**
     * Get last posted date from SEO
     * @return Formatted string
     */
    public String getSeoLPDescription(){
        return seoLpDescription.getTextValue();
    }

    /**
     * Click "All Sectors" link on refine rail
     */
    public void clickSeeAllSectors() {
        scrollUntilElementIsVisible(allSectors);
        clickOn(allSectors);
        waitForSRPOverlayToComplete();
        waitForAJAXToComplete();
    }

    /**
     * Click "All Skills" link on refine rail
     */
    public void clickSeeAllSkills() {
        scrollUntilElementIsVisible(allSkills);
        clickOn(allSkills);
        waitForSRPOverlayToComplete();
    }

    /**
     * Submit Sectors and SubSectors on modal box
     */
    public void submitSectorAndSubSectorChoices() {
        if (fiftyFifty()) {
            clickOn(sectorModalCloseBtn);
        } else {
            clickOn(sectorModalRefineLink);
        }

        waitForSRPOverlayToComplete();
    }

    /**
     * Submit skills
     */
    public void submitSkillsChoices() {
        if (fiftyFifty()) {
            clickOn(skillsModalCloseBtn);
        } else {
            clickOn(skillsModalRefineLink);
        }

        waitForSRPOverlayToComplete();
    }

    /**
     * Click "Manage Job Alerts" link
     */
    public void clickManageJobAlerts() {
        clickOn(manageJobAlertsLink);
    }

    /**
     *   click on right arrow at the bottom of SRP
     */
    public void clickSecondPageInPaginationIfAvailable() {
        if (nextinPagination.isCurrentlyVisible()){
            scrollUntilElementIsVisible(nextinPagination);
            clickOn(nextinPagination);
            waitForSRPOverlayToComplete();
        }
    }

    /**
     * Click clear date posted facet
     */
    public void clickClearDatePostedFacet() {
        super.scrollUntilElementIsVisible(clearDatePostedFacet);
        clickOn(clearDatePostedFacet);
        waitForSRPOverlayToComplete();
    }

    /**
     * Click clear Date Posted facet
     */
    public void clickClearSalaryFacet() {
        super.scrollUntilElementIsVisible(clearSalaryFacet);
        clickOn(clearSalaryFacet);
        waitForSRPOverlayToComplete();
    }

    /**
     * Click clear Location facet
     */
    public void clickClearLocationFacet() {
        super.scrollUntilElementIsVisible(clearLocationFacet);
        clickOn(clearLocationFacet);
        waitForSRPOverlayToComplete();
    }

    /**
     * Click clear Position Type facet
     */
    public void clickClearPositionTypeFacet() {
        super.scrollUntilElementIsVisible(clearPositionTypeFacet);
        clickOn(clearPositionTypeFacet);
        waitForSRPOverlayToComplete();
    }

    /**
     * Click clear Sectors facet
     */
    public void clickClearSectorsFacet() {
        super.scrollUntilElementIsVisible(clearSectorsFacet);
        clickOn(clearSectorsFacet);
        waitForSRPOverlayToComplete();
    }

    /**
     * Click clear Skills facet
     */
    public void clickClearSkillsFacet() {
        super.scrollUntilElementIsVisible(clearSkillsFacet);
        clickOn(clearSkillsFacet);
        waitForSRPOverlayToComplete();
    }

    /**
     * Click clear Brand facet
     */
    public void clickClearBrandFacet() {
        super.scrollUntilElementIsVisible(clearBrandFacet);
        clickOn(clearBrandFacet);
        waitForSRPOverlayToComplete();
    }

    /**
     * Click clear Employment Type facet
     */
    public void clickClearEmploymentTypeFacet() {
        super.scrollUntilElementIsVisible(clearEmploymentTypeFacet);
        clickOn(clearEmploymentTypeFacet);
        waitForSRPOverlayToComplete();
    }

    /**
     * Clear all facets
     */
    public void clearAllFacets() {
        super.scrollUntilElementIsVisible(clearAllFacets);
        clickOn(clearAllFacets);
        waitForSRPOverlayToComplete();
    }

    /**
     * Get number of jobs on current page
     * @return count
     */
    public int getNumberOfJobsOnCurrentPage() {
        return jobsWebElementList.size();
    }

    /**
     * Select some skills
     * @param numberOfSkillsToSelect Number of skills to select
     */
    public void selectRangeOfSkills(int numberOfSkillsToSelect) {
        int max = numberOfSkillsToSelect - 1;
        List<WebElement> elements =
                getDriver().findElements(By.cssSelector("#skills-facet #all-skills .modal-dialog ul li label"));

        for (int i = 0; i <= max; i++) {
            elements.get(i).click();
        }
    }

    /**
     * Click "See all companies"
     */
    public void clickSeeAllCompanies() {
        scrollUntilElementIsVisible(allCompanies);
        clickOn(allCompanies);
        waitForSRPOverlayToComplete();
    }

    /**
     * Select some companies
     * @param numberOfCompaniesToSelect Number of companies to select
     */
    public void selectRangeOfCompanies(int numberOfCompaniesToSelect) {
        int max = numberOfCompaniesToSelect - 1;
        List<WebElement> elements =
                getDriver().findElements(By.cssSelector("#brands-facet #all-companies.modal ul li label"));

        for (int i = 0; i <= max; i++) {
            elements.get(i).click();
        }
    }

    /**
     * Submit company choices in modal
     */
    public void submitCompanyChoices() {
        if (fiftyFifty()) {
            clickOn(companiesModalCloseBtn);
        } else {
            clickOn(companiesModalRefineLink);
        }

        waitForSRPOverlayToComplete();
    }

    /**
     * Click on the small cross button on a location tag
     */
    public void clickCrossButtonOnLocationTag() {
        find(By.cssSelector("#location-facet ul.tags li button")).click();
        waitForSRPOverlayToComplete();
    }

    /**
     * Click "See All Locations"
     */
    public void clickSeeAllLocations() {
        scrollUntilElementIsVisible(allLocations);
        clickOn(allLocations);
    }

    /**
     * Un-select the first location found in the modal
     */
    public void unselectLocation() {
        waitForSRPOverlayToComplete();
        WebElementFacade element =
                find(By.cssSelector("#location-facet #all-locations .modal-dialog ul li input[checked]"));

        super.scrollUntilElementIsVisible(element);

        clickOn(element);
    }

    /**
     * Submit location choices
     */
    public void submitLocationChoices() {
        if (fiftyFifty()) {
            clickOn(locationModalCloseBtn);
        } else {
            clickOn(locationModalRefineLink);
        }

        waitForSRPOverlayToComplete();
    }

    /**
     * Enter location in the refine rail typeahead
     * @param location location
     * @param locale Locale
     */
    public void enterLocation(String location, Locale locale) {
        triggerLocationDOMInitialisation(locale);
        waitForPagePeel();
        //String newLocation = makeLocationLanguageSiteSafe(location);

        int locationLength = location.length();

        for (int i = 0; i < locationLength; i++) {
            // Required as part of the location gets chopped off if the entire location is entered at once
            locationWebElement.sendKeys(Character.toString(location.charAt(i)));
            waitABit(WaitFor.QUARTER_SECOND.getMilliseconds());
        }

        super.explicitlyWaitForElementsBy(WaitFor.SLA_LOCATION_TYPEAHEAD.getSeconds(), locationList);
        locationWebElement.sendKeys(Keys.TAB);
        waitForSRPOverlayToComplete();
    }

    private String makeLocationLanguageSiteSafe(String location) {
        // TODO. i.patel. Method is duplicated in KeywordLocationComponent
        return location + " ";
    }

    private void triggerLocationDOMInitialisation(Locale locale) {
        // TODO. i.patel. Method is duplicated in KeywordLocationComponent
        clickOn(locationWebElement); // Triggers AJAX call to get locations
        waitABit(2000L);
        /*final String localeStr = locale.getLanguage() + "_" + locale.getCountry();

        WebDriverWait wait = new WebDriverWait(getDriver(), WaitFor.SLA_LOCATION_TYPEAHEAD.getSeconds());
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (Boolean) evaluateJavascript("return (typeof fo.data.location." + localeStr + " === 'string')");
            }
        });*/
    }

    public String getRefineRailText() {
        return (String) evaluateJavascript("return $('#srpForm').text();");
    }

    public List<String> getCurrentRefinements() {
        waitForSRPOverlayToComplete();
        List<String> currentFacetRefinements = Lists.newArrayList();

        for (WebElement currentFacet : currentFacets) {
            currentFacetRefinements.add(currentFacet.getAttribute("id"));
        }

        return currentFacetRefinements;
    }

    public String getSkillWithMostJobs() {
        return find(By.name("filterGroupForm.skills")).getAttribute("value");
    }

    public void selectSkill(String value) {
        for (WebElement element : filterSkills) {
            if (element.getAttribute("value").equalsIgnoreCase(value)) {
                clickOn(element);
                break;
            }
        }
    }

    public Long getBrandWithMostJobs() {
        return Long.valueOf(find(By.name("filterGroupForm.brands")).getAttribute("value"));
    }

    public void saveJob(String jobId) {
        String saveSelector = "#jobPreview-" + jobId + " form button";
        WebElementFacade element = find(By.cssSelector(saveSelector));

        scrollUntilElementIsVisible(element);
        clickOn(element);
    }

    /**
     * Click unsave button for first job
     */
    public void unsaveJob(String jobId) {
        String unsaveSelector = "//a[contains(@href, '/secure/ajax-unsave-job/" + jobId + "')]";

        WebElementFacade element = find(By.xpath(unsaveSelector));

        clickOnCustom(element);
        waitForSRPOverlayToComplete();
    }
}
