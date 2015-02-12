package com.efinancialcareers.myefc.qa.desktop;

import com.efinancialcareers.myefc.qa.domain.HomepageItem;
import com.efinancialcareers.myefc.qa.utils.QAStringUtils;
import com.efinancialcareers.myefc.qa.utils.fo.WaitFor;
import com.google.common.base.Function;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Homepage extends BasePage {

    private static final String TOP_SECTOR_SECTION_SELECTOR = "#sectors-facet.topFacet ul li";
    private static final String ALL_SECTORS_SELECTOR = "#all-sectors.modal div.modal-body ul div li";

    @FindBy(css = "button.close")
    private WebElementFacade modelBoxCloseButton;

    @FindBy(css = "#sectors-facet h4 a")
    private WebElementFacade sectorsHeaderLink;

    @FindBy(css = "#skills-facet h4 a")
    private WebElementFacade skillsHeaderLink;

    @FindBy(css = "#locations-facet h4 a")
    private WebElementFacade locationsHeaderLink;

    @FindBy(css = TOP_SECTOR_SECTION_SELECTOR)
    private List<WebElement> topSectors;

    @FindBy(css = "#sectors-facet.topFacet h4 a.viewall")
    private WebElementFacade sectorsViewAllLink;

    @FindBy(css = ALL_SECTORS_SELECTOR)
    private List<WebElement> allSectors;

    @FindBy(css = "#skills-facet.topFacet ul li")
    private List<WebElement> topSkills;

    @FindBy(css = "#skills-facet.topFacet h4 a.viewall")
    private WebElementFacade skillsViewAllLink;

    @FindBy(css = "#all-skills.modal div.modal-body ul div li")
    private List<WebElement> allSkills;

    @FindBy(css = "#locations-facet.topFacet ul li")
    private List<WebElement> topLocations;

    @FindBy(css = "#locations-facet.topFacet h4 a.viewall")
    private WebElementFacade locationsViewAllLink;

    @FindBy(css = "#all-locations.modal div.modal-body ul div li")
    private List<WebElement> allLocations;

    @FindBy(css = "#countrySelectorModal #continueCountrySelection")
    private WebElementFacade modelBoxContinueButton;

    @FindBy(id = "countrySelectorModal")
    private WebElementFacade countrySelectorModal;

    @FindBy(id = "rememberCountrySelection")
    private WebElementFacade rememberCountrySelection;

    @FindBy(css = "div.rowContainer div.home_col div.home_item")
    private List<WebElement> homeItem;

    @FindBy(css = ".welcomeAddDart")
    private WebElementFacade dartBoxContinueButton;

    private By countrySelectorModalBy = By.id("countrySelectorModal");
    private By dartModalBy = By.className("welcomeBanner");

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public Homepage(WebDriver driver) {
        super(driver);
    }

    /**
     * Close country selection modal
     */
    public void closeCountryPickerModal() {
        naughtyWait();
        naughtyWait();
        naughtyWait();
        if (super.isElementVisible(countrySelectorModalBy)) {
            waitUntilElementHasStoppedMoving(modelBoxContinueButton);
            clickOnCustom(modelBoxContinueButton);
        }

        waitForCountryPickerModalToFade();

        closeDartModalBox();
    }

    private void closeDartModalBox() {
        naughtyWait();
        evaluateJavascript("$('.welcomeAdDart').remove();");
        evaluateJavascript("$('.modal-backdrop').remove();");
    }

    /**
     * Assert country picker is displayed
     */
    public void assertCountryPickerIsDisplayed() {
        countrySelectorModal.waitUntilPresent();
        countrySelectorModal.shouldBeCurrentlyVisible();
    }

    /**
     * Assert country picker is not displayed
     */
    public void assertCountryPickerIsNotDisplayed() {
        countrySelectorModal.shouldNotBeCurrentlyVisible();
    }

    /**
     * Select remember country selection checkbox
     * @return Home page
     */
    public Homepage selectRememberCountrySelectionCheckbox() {
        setCheckbox(rememberCountrySelection, true);
        return this;
    }

    /**
     * De-select remember country selection checkbox
     * @return Home page
     */
    public Homepage deSelectRememberCountrySelectionCheckbox() {
        setCheckbox(rememberCountrySelection, false);
        return this;
    }

    /**
     * Submit
     */
    public void submit() {
        clickOnCustom(modelBoxContinueButton);
        closeDartModalBox();
    }

    /**
     * Select country site
     * @param url URL
     */
    public void selectCountrySite(String url) {
        find(By.xpath(
                "//*[contains(@id, 'countrySelectorModal')] //a[contains(@href,'" + url + "')]")).click();
    }

    /**
     * Randomly click one of the sector links from view all modal. Return sector text selected.
     * @return Sector selected with count
     */
    public String clickRandomSectorFromViewAll() {
        clickOnCustom(sectorsViewAllLink);
        waitForAJAXToComplete();

        return clickRandomLinkFrom(allSectors);
    }

    /**
     * Randomly click one of the skill links from view all modal. Return skill text selected.
     * @return Skill selected with count
     */
    public String clickRandomSkillFromViewAll() {
        clickOnCustom(skillsViewAllLink);
        waitForAJAXToComplete();

        /*
        TODO. i.patel.
        An attempt to speed this test up. will need to revisit as it is taking a long time to click a link.
        String js = "var allSkills = document.querySelectorAll('#skills-facet.topFacet ul li a'); " +
                    "var random = Math.floor(Math.random() * allSkills.length); " +
                    "allSkills[random];";*/
        return clickRandomLinkFrom(allSkills);
    }

    /**
     * Randomly click one of the location links from view all modal. Return location text selected.
     * @return Location selected with count
     */
    public String clickRandomLocationFromViewAll() {
        clickOnCustom(locationsViewAllLink);
        waitForAJAXToComplete();

        return clickRandomLinkFrom(allLocations);
    }

    /**
     * Randomly click one of the top sector links. Return sector text selected.
     * @return Sector selected with count
     */
    public String clickRandomTopSectorLink() {
        return clickRandomLinkFrom(topSectors);
    }

    /**
     * Randomly click one of the top skill links. Return skill text selected.
     * @return Skill selected with count
     */
    public String clickRandomTopSkillLink() {
        return clickRandomLinkFrom(topSkills);
    }

    /**
     * Randomly click one of the top location links. Return location text selected.
     * @return Location selected with count
     */
    public String clickRandomTopLocationLink() {
        return clickRandomLinkFrom(topLocations);
    }

    private String clickRandomLinkFrom(List<WebElement> randomLinks) {
        WebElement specificLink = QAStringUtils.getRandomEntity(randomLinks).findElement(By.cssSelector("a"));
        String topSelectedText = specificLink.getText();

        clickOn(specificLink);

        return topSelectedText;
    }

    /**
     * Get sector header Url
     * @return Sectors link URL
     */
    public String getSectorsHeaderUrl() {
        return sectorsHeaderLink.getAttribute("href");
    }

    /**
     * Get skills header Url
     * @return Skills link URL
     */
    public String getSkillsHeaderUrl() {
        return skillsHeaderLink.getAttribute("href");
    }

    /**
     * Get locations header Url
     * @return Locations link URL
     */
    public String getLocationsHeaderUrl() {
        return locationsHeaderLink.getAttribute("href");
    }

    /**
     * Click sector header url
     */
    public void clickSectorHeader() {
        clickOn(sectorsHeaderLink);
    }

    /**
     * Click location header url
     */
    public void clickSkillsHeader() {
        clickOn(skillsHeaderLink);
    }

    /**
     * Click location header url
     */
    public void clickLocationsHeader() {
        clickOn(locationsHeaderLink);
    }

    /**
     * Click All Sectors link
     */
    public void clickAllSectorsLink(){
        waitForAJAXToComplete();
        sectorsViewAllLink.click();
    }

    /**
     * Click "Create your Profile" button
     */
    public void clickCreateYourProfile(){
        WebElementFacade button =
                find(By.linkText((translationFacade.getTranslation("fo.site.404.browse.cv"))));
        clickOn(button);
    }

    /**
     * Click "Make My Profile Searchable" button
     */
    public void clickMakeMyProfileSearchableButton() {
        WebElementFacade button =
                find(By.linkText((
                        translationFacade.getTranslation("labels.myefc.profile.viewProfile.makeProfileSearchable"))));
        clickOn(button);
    }

    /**
     * Get Homepage item information
     * @return List of homepage items
     */
    public HomepageItem getHomepageItems() {
        HomepageItem homepageItems = new HomepageItem();

        homepageItems.setNewsAndAdviceText(homeItem.get(1).findElement(By.cssSelector("h4")).getText());
        homepageItems.setStudentsText(homeItem.get(2).findElement(By.cssSelector("strong")).getText());
        homepageItems.setITFinanceText(homeItem.get(3).findElement(By.cssSelector("strong")).getText());
        homepageItems.setLetRecruitersFindYouText(homeItem.get(4).findElement(By.cssSelector("h4")).getText());
        homepageItems.setFeaturedCompaniesText(homeItem.get(5).findElement(By.cssSelector("h4")).getText());
        homepageItems.setPollText(homeItem.get(6).findElement(By.cssSelector("h4")).getText());
        homepageItems.setEditorsPicksText(homeItem.get(7).findElement(By.cssSelector("h4")).getText());

        return homepageItems;
    }

    /**
     * Retrieves List of Sector names and Randomly select one of them
     * @return A randomly selected sector name
     */
    public String getRandomSectorNameFromAllSectors() {
        String result = "";
        waitForAJAXToComplete();
        result = $(getRandomWebElementFromList(explicitlyWaitForElementsBy(WaitFor.SLA_WEB_ELEMENTS.getSeconds(),
                By.cssSelector(ALL_SECTORS_SELECTOR)))).getTextValue();
        return result.replaceAll(REGEX_REMOVE_NUMBER_OF_JOBS, "").trim();
    }

    /**
     * Return Tooltip of the hyperlink by partially matched name
     * @param linkText Name to match
     * @return A Tooltip Value
     */
    public String getTooltipByPartialLinkText(String linkText) {
        return find(By.partialLinkText(linkText)).getAttribute("title").trim();
    }

    /**
     * Retrieves one random Sector from Top Section
     * @return A Sector name
     */
    public String getRandomSectorNameFromTopSection() {
        String result = "";
        waitForAJAXToComplete();
        result = $(getRandomWebElementFromList(explicitlyWaitForElementsBy(WaitFor.SLA_WEB_ELEMENTS.getSeconds(),
                By.cssSelector(TOP_SECTOR_SECTION_SELECTOR)))).getTextValue();
        return result.replaceAll(REGEX_REMOVE_NUMBER_OF_JOBS, "").trim();
    }

    private void waitForCountryPickerModalToFade() {
        try {
            Wait<WebDriver> wait = new FluentWait<>(getDriver())
                    .withTimeout(WaitFor.SLA_WEB_ELEMENTS.getSeconds(), TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);

            final WebElement overlay = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(countrySelectorModalBy);
                }
            });

            Wait<WebDriver> wait2 = new FluentWait<>(getDriver())
                    .withTimeout(WaitFor.SLA_WEB_ELEMENTS.getSeconds(), TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);

            wait2.until(new Function<WebDriver, Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return overlay.getAttribute("style").contains("none");
                }
            });

        } catch (TimeoutException e) {
            System.out.println("Country picker modal error - do nothing. TimeoutException cannot be suppressed");
        }
    }
}

