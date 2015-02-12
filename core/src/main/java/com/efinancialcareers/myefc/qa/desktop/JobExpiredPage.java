package com.efinancialcareers.myefc.qa.desktop;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * User: jon.neville
 * Date: 28/11/13
 * Time: 10:03
 */
public class JobExpiredPage extends BasePage {

    @FindBy(css = ".expired article section.details div.well p a:nth-of-type(1)")
    private WebElementFacade totalJobsLink;

    @FindBy(css = ".expired article section.details div.well p a:nth-of-type(2)")
    private WebElementFacade jobsLastThreeDaysLink;

    @FindBy(css = ".message.error")
    private WebElementFacade expiredMessage;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public JobExpiredPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get total job count
     * @return total job count
     */
    public int getTotalJobCount() {
        return Integer.parseInt(totalJobsLink.getText().replaceAll("\\D+", ""));
    }

    /**
     * Get jobs posted in last 3 days count
     * @return total job count last three days
     */
    public int getJobsPostedLastThreeDaysCount() {
        return Integer.parseInt(jobsLastThreeDaysLink.getText().replaceAll("\\D+", ""));
    }

    /**
     * Click total jobs link
     */
    public void clickTotalJobsLink() {
        this.clickOn(totalJobsLink);
    }

    /**
     * Click jobs posted in last 3 days link
     */
    public void clickJobsPostedInLastThreeDaysLink() {
        this.clickOn(jobsLastThreeDaysLink);
    }

    /**
     * Get expired message text
     * @return expired message
     */
    public String getJobExpiredMessage() {
        return expiredMessage.getText().replaceAll("\n", " ");
    }

}

