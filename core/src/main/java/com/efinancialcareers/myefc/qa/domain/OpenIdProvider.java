package com.efinancialcareers.myefc.qa.domain;

import com.efinancialcareers.myefc.qa.desktop.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * User: ilyas.patel
 * Date: 11/09/13
 * Time: 11:25
 */
public abstract class OpenIdProvider extends BasePage {

    /**
     * Constructor
     * @param driver Webdriver
     */
    public OpenIdProvider(WebDriver driver) {
        super(driver);
    }

    /**
     * Wait Login form is displayed
     * @param submitOnOpenIDModal
     */
    protected void waitForLoginModalDialogToAppear(By submitOnOpenIDModal) {
        waitFor(ExpectedConditions.visibilityOfElementLocated(submitOnOpenIDModal));
    }

}
