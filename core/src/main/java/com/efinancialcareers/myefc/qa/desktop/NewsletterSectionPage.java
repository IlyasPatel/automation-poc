package com.efinancialcareers.myefc.qa.desktop;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * User: jon.neville
 * Date: 06/09/13
 * Time: 10:00
 */
public class NewsletterSectionPage extends AccountSettingsPage {

    @FindBy(css = "#unsubscribe.unsubscribe")
    private WebElementFacade unsubscribeCheckbox;

    @FindBy(css = "#newsletter a.btn")
    private WebElementFacade subscribeButton;

    @FindBy(css = "article header .subtitles .savedItems")
    private WebElementFacade subscribedNewsLettersText;

    @FindBy(css = "#accordion div[data-accordionindex='1']")
    WebElementFacade newsletterSection;

    @FindBy(css = "#accordion div[data-id='AMERICAS'] li label")
    private List<WebElement> sectionAmericaLabels;

    @FindBy(css = "#accordion div[data-id='AMERICAS']")
    private WebElement sectionAmericas;

    @FindBy(css = "#accordion div[data-id='EMEA'] li label")
    private List<WebElement> sectionEMEALabels;

    @FindBy(css = "#accordion div[data-id='EMEA']")
    private WebElement sectionEMEA;

    @FindBy(css = "#accordion div[data-id='APAC'] li label")
    private List<WebElement> sectionAPACLabels;

    @FindBy(css = "#main.right article header div.mainHeader ul.titles")
    WebElementFacade headerText;

    @FindBy(css = "#accordion div[data-id='APAC']")
    private WebElement sectionAPAC;

    private By newsletterCheckboxes = By.cssSelector("input[checked]");

    /**
     * Constructor
     *
     * @param driver WebDriver
     */
    public NewsletterSectionPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Select Americas Newsletters
     */
    public void selectAllAmericasNewsletters() {
        waitUntilElementHasStoppedMoving(sectionAmericas);
        scrollUntilElementIsVisible(sectionAmericas);
        for (WebElement li : sectionAmericaLabels) {
            clickOn(li);
        }
    }

    /**
     * Select Europe Newsletters
     */
    public void selectAllEurope() {
        scrollUntilElementIsVisible(sectionEMEA);

        for (WebElement li : sectionEMEALabels) {
            clickOn(li);
        }
    }

    /**
     * Select Asia-Pacific Newsletters
     */
    public void selectAllAsiaPacific() {
        scrollUntilElementIsVisible(sectionAPAC);

        for (WebElement li : sectionAPACLabels) {
            clickOn(li);
        }
    }

    /**
     * Click subscribe button
     */
    public void clickSubscribe() {
        clickOn(subscribeButton);

        waitForAJAXToComplete();
        super.refreshPage();
    }

    /**
     * Capture the newsletter subscribed to text
     * @return subscribedNewsLettersText
     */
    public String savedNewslettersValidationMessage() {
        return subscribedNewsLettersText.getText().trim();
    }

    /**
     * Unsubscribe from newsletters
     */
    public void unsubscribeFromAllNewsletters() {
        scrollUntilElementIsVisible(unsubscribeCheckbox);
        clickOn(unsubscribeCheckbox);
        clickOn(subscribeButton);
    }

    /**
     * Get selected/ticked American newsletters
     * @return List of selected american newsletters
     */
    public List<WebElement> getSelectedAmericanNewsletters() {
        scrollUntilElementIsVisible(sectionAmericas);
        return sectionAmericas.findElements(newsletterCheckboxes);
    }

    /**
     * Get selected/ticked EMEA newsletters
     * @return List of selected EMEA newsletters
     */
    public List<WebElement> getSelectedEMEANewsletters() {
        scrollUntilElementIsVisible(sectionEMEA);
        return sectionEMEA.findElements(newsletterCheckboxes);
    }

    /**
     * Get selected/ticked APAC newsletters
     * @return List of selected APAC newsletters
     */
    public List<WebElement> getSelectedAPACNewsletters() {
        scrollUntilElementIsVisible(sectionAPAC);
        return sectionAPAC.findElements(newsletterCheckboxes);
    }

    /**
     * Get page header title
     * @return title
     */
    public String getPageHeader() {
        return headerText.getTextValue();
    }

    /**
     * Get list of selected newsletters on page
     * @return List of checkboxes
     */
    public List<WebElementFacade> getSelectedNewsletters() {
        return newsletterSection.thenFindAll(newsletterCheckboxes);
    }
}
