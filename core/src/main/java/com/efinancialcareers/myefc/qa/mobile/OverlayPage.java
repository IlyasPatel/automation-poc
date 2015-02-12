package com.efinancialcareers.myefc.qa.mobile;

import org.openqa.selenium.WebDriver;

/**
 * User: jon.neville
 * Date: 08/08/13
 * Time: 10:10
 */
@Deprecated
public class OverlayPage extends BasePage {

    /** FluentWait polling interval in Microseconds */
    protected static final int POLLING_SRP_UI_BLOCK = 250;

    /**
     * Constructor
     * @param driver WebDriver
     */
    public OverlayPage(WebDriver driver) {
        super(driver);
    }

    /**
      *Wait for overlay to disappear before continuing
      * @param driver webdriver
     */
    /*public static final void waitForOverlay(WebDriver driver) {
        (new WebDriverWait(driver, WaitFor.THREE_SECONDS.getSeconds())).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                JavascriptExecutor js = (JavascriptExecutor) webDriver;
                return (Boolean) js.executeScript(
                    "return document.getElementsByClassName('loadingOverlay')[0].className.split(' ').length == 2");
            }
        });
    }


    public void waitForOverlay() {
        (new WebDriverWait(getDriver(), WaitFor.THREE_SECONDS.getSeconds())).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return (Boolean) evaluateJavascript(
                    "return document.getElementsByClassName('loadingOverlay')[1].className.indexOf('hidden') != -1");
            }
        });
    }*/
}
