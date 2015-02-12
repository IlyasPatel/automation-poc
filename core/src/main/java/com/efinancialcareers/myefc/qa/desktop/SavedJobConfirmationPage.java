package com.efinancialcareers.myefc.qa.desktop;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * User: ilyas.patel
 * Date: 15/08/13
 * Time: 19:37
 */
public class SavedJobConfirmationPage extends BasePage {

    @FindBy(css = "#applyJobWizTopTitles h3")
    private WebElementFacade savedJobConfirmationMessage;

    @FindBy(css = "#sidebar #sidebarCont h3")
    private WebElementFacade jobTitleOfSavedJob;

    @FindBy(css = "#sidebar #sidebarCont a.continue")
    private WebElementFacade continueToSavedJobsPage;



    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public SavedJobConfirmationPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Go to saved jobs
     */
    public void goToSavedJobsPage() {
        this.continueToSavedJobsPage.click();
    }
}
