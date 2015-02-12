package com.efinancialcareers.myefc.qa.desktop;

import com.beust.jcommander.internal.Lists;
import com.efinancialcareers.myefc.qa.utils.fo.WaitFor;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Locale;

/**
 * User: ilyas.patel
 * Date: 30/09/13
 * Time: 22:57
 */
public class KeywordLocationComponent extends BasePage {

    private By locationList = By.cssSelector("#job-search form ul.typeahead li");
    private By keywordList = By.cssSelector("#job-search form div.multi-select ul.typeahead li");

    @FindBy(css = "#job-search form input.form-control")
    private WebElementFacade keywordWebElement;

    @FindBy(css = "#job-search form div div:nth-child(2) input")
    private WebElementFacade locationWebElement;

    @FindBy(css = ".job-search-container form h3 span")
    private WebElementFacade jobCount;

    @FindBy(xpath = "//*[@id='job-search']//button[@class='btn btn-default']")
    private WebElementFacade searchJobsBtn;

    @FindBy(xpath = "//*[starts-with(@class,\"selected-keyword selected\")]")
    private List<WebElement> currentLocations;


    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public KeywordLocationComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * Enter keywords for job search
     * @param keyword keyword
     */
    public void enterKeywords(String keyword) {
        int keywordLength = keyword.length();

        for (int i = 0; i < keywordLength; i++) {
            // Required as part of the location gets chopped off if the entire location is entered at once
            keywordWebElement.sendKeys(Character.toString(keyword.charAt(i)));
            waitABit(WaitFor.QUARTER_SECOND.getMilliseconds());
        }

        waitABit(WaitFor.QUARTER_SECOND.getMilliseconds());
        super.explicitlyWaitForElementsBy(WaitFor.SLA_LOCATION_TYPEAHEAD.getSeconds(), keywordList);
        //keywordWebElement.sendKeys(Keys.TAB);
    }

    /**
     * Enter location for job search
     * @param location location
     * @param locale locale
     */
    public void enterLocation(String location, final Locale locale) {
        triggerLocationDOMInitialisation(locale);
        enterLocation(location);
    }

    /**
     * Enter location for job search without Locale specified
     * @param location location
     */
    public void enterLocation(String location) {
        waitForPagePeel();
        String newLocation = makeLocationLanguageSiteSafe(location);

        int locationLength = newLocation.length();

        for (int i = 0; i < locationLength; i++) {
            // Required as part of the location gets chopped off if the entire location is entered at once
            locationWebElement.sendKeys(Character.toString(newLocation.charAt(i)));
            waitABit(WaitFor.QUARTER_SECOND.getMilliseconds());
        }

        waitABit(3000); // TODO i.patel Need to review this once location typeahead is finalised in 2.27

        super.explicitlyWaitForElementsBy(WaitFor.SLA_LOCATION_TYPEAHEAD.getSeconds(), locationList);
        locationWebElement.sendKeys(Keys.TAB);
    }

    /**
     * Clear fields
     */
    public void clear(){
        evaluateJavascript("$('.selected-keyword').remove()");
    }

    private String makeLocationLanguageSiteSafe(String location) {
        return location;
    }

    private void triggerLocationDOMInitialisation(Locale locale) {
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

    /**
     * Submit Job Search Form
     * @return JobSearchResultsPage
     */
    public JobSearchResultsPage submitJobSearchForm() {
        submitSearchForm();

        JobSearchResultsPage jobSearchResultsPage = this.switchToPage(JobSearchResultsPage.class);

        jobSearchResultsPage.switchToDetailedView();

        return jobSearchResultsPage;
    }

    /**
     * Simple Search Form Submit
     */
    public void submitSearchForm() {
        clickOn(searchJobsBtn);
    }

    /**
     * Get keyword
     * @return keyword
    */
    public String getKeyword() {
        return find(By.id("keyword")).getAttribute("value").toLowerCase();
    }

    /**
     * Get locationIds once locations have been entered on the typeahead
     * @return LocationIds
     */
    public List<String> getEnteredLocationIds() {
        List<String> currentEnteredLocations = Lists.newArrayList();
        for (WebElement location : currentLocations) {
            currentEnteredLocations.add(location.getAttribute("data-id"));
        }

        return currentEnteredLocations;
    }

    /**
     * Return number of jobs in count
     * @return int
     */
    @Deprecated
    public int keywordSearchCount() {
        return Integer.parseInt(jobCount.getTextValue());
    }

}
