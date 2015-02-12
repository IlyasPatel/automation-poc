package com.efinancialcareers.myefc.qa.desktop;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ExternalJobApplicationPage extends BasePage {

    @FindBy(tagName = "h1")
    private WebElement h1;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public ExternalJobApplicationPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get external job application URL
     * @return Redirect URL
     */
    public String getExternalJobApplicationUrl() {
        waitForTextToAppear("Google Search");

        return getCurrentUrl();
    }

    public String getRedirectMessage() {
        try {
            return h1.getText();
        } catch (NoSuchElementException e) {
            return "";
        } catch (StaleElementReferenceException e) {
            return "";
        }
    }
}
