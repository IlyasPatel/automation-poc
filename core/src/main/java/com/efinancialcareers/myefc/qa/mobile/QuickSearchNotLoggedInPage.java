package com.efinancialcareers.myefc.qa.mobile;

import org.junit.Assert;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ilyas.patel on 19/01/14.
 */
public class QuickSearchNotLoggedInPage extends BasePage {

    @FindBy(css = "#quickSearchPage .mainContent ul.three li .login")
    private WebElementFacade loginTab;

    @FindBy(css = "#quickSearchPage form#quickSearchForm a.submit")
    private WebElementFacade jobSearchSubmit;

    /**
     * Constructor
     *
     * @param driver WebDriver
     */
    public QuickSearchNotLoggedInPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Select sign in tab
     */
    public void selectSignInTab() {
        loginTab.click();

        waitForOverlayToFinish();
    }

    /**
     * Assertion
     */
    public void checkSignInTabDisplayed() {
        Assert.assertTrue(loginTab.isDisplayed());
    }

    /**
     * Submit job search form
     */
    public void submitJobSearch() {
        jobSearchSubmit.click();
    }
}
