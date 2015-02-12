package com.efinancialcareers.myefc.qa.utils;

import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

/**
 * Created by ilyas.patel on 19/05/2014.
 */
public final class BrowserUtils {

    private BrowserUtils() {
    }

    /**
     * Get name of currently running browser name.
     * PLEASE DO NOT USE THIS METHOD LIGHTLY.
     * @param webDriver WebDriver
     * @return Browser name. Values from BrowserType class used which is from the Selenium project.
     */
    public static String getBrowserName(WebDriver webDriver) {
        WebDriver proxiedDriver = ((WebDriverFacade) webDriver).getProxiedDriver();

        if (proxiedDriver instanceof FirefoxDriver) {
            return BrowserType.FIREFOX;
        } else if (proxiedDriver instanceof InternetExplorerDriver) {
            return BrowserType.IE;
        }

        return BrowserType.CHROME;
    }

}
