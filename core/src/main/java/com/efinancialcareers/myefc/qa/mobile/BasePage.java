package com.efinancialcareers.myefc.qa.mobile;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by ilyas.patel on 10/01/14.
 */
public class BasePage extends PageObject {

    /**
     * Constructor
     * @param driver WebDriver
     */
    public BasePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Wait for login to finish after a user has signed in
     */
    public void waitForLoginToFinish() {
        waitForRenderedElements(By.cssSelector("#quickSearchPage header a[rel='panel']"));
    }

    /**
     * Wait for overlay to finish
     */
    public void waitForOverlayToFinish() {
        /*(new WebDriverWait(getDriver(), 20)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return (Boolean) evaluateJavascript(
                    "return document.getElementsByClassName('loadingOverlay')[0].className.indexOf('hidden') != -1");
            }
        });*/
    }
}
