package com.efinancialcareers.myefc.qa.desktop;

import com.efinancialcareers.myefc.qa.domain.Job;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

/**
 * User: jon.neville
 * Date: 12/09/13
 * Time: 15:05
 */
public class ApplicationSuccessPage extends BasePage {

    @FindBy(css = "#japThankYouTop div header.elemBoxStyleNoBg h2")
    private WebElementFacade successAppliedMessage;

    @FindBy(xpath = "(//a[contains(@href, '/myefc/application-history')])[2]")
    private WebElementFacade applicationHistoryLink;

    @FindBy(css = "header #navigation-links nav .loggedin")
    private WebElementFacade loggedInFirstNameInNavigation;

    @FindBy(css = "#japThankYouTop section#main.right div.links a.btn")
    private WebElementFacade goToHomepageBtn;

    @FindBy(xpath = "(//a[contains(@href, '/myefc/account')])[3]")
    private WebElementFacade privacySettingsLink;

    @FindBy(css = ".japThankYou div.mlt:nth-child(2) article")
    private List<WebElement> interestedJobs;

    @FindBy(css = ".japThankYou div.mlt:nth-child(3) article")
    private List<WebElement> profileJobs;

    private List<Job> jobList;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public ApplicationSuccessPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get main heading from successful application page.
     * @return Page heading
     */
    public String getMainHeadingInSuccessAppliedPage() {
        waitFor(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#japThankYouTop section#main.right div.links a.btn")));

        return successAppliedMessage.getTextValue();
    }

    /**
     * Click application history link
     */
    public void clickApplicationHistory() {
        clickOn(applicationHistoryLink);
        waitForAJAXToComplete();
    }

    /**
     * Click privacy settings link
     */
    public void clickPrivacySettings() {
        clickOn(privacySettingsLink);
        waitForAJAXToComplete();
    }

    /**
     * Check if successfully applied message is displayed
     * @return is successfully applied message
     */
    public boolean isSuccessAppliedMessageDisplayed() {
        return this.successAppliedMessage.isPresent();
    }

    /**
     * Get interested jobs
     * @return List of Job Beans
     */
    public List<Job> getInformationForInterestedJobs() {
        jobList = new ArrayList<Job>();

        for (WebElement jobWebElement : interestedJobs) {
            jobList.add(getJobInformationForThisJob(jobWebElement));
        }

        return jobList;
    }

    /**
     * Get profile jobs
     * @return List of Job Beans
     */
    public List<Job> getInformationForJobsMatchingProfile() {
        jobList = new ArrayList<Job>();

        scrollUntilElementIsVisible(profileJobs.get(0));

        for (WebElement jobWebElement : profileJobs) {
            jobList.add(getJobInformationForThisJob(jobWebElement));
        }

        return jobList;
    }

    private Job getJobInformationForThisJob(WebElement jobWebElement) {
        Job job = new Job();

        job.setJobTitle(jobWebElement.findElement(By.tagName("h4")).getText());

        String brandName = jobWebElement.findElement(By.cssSelector("div.mltJobDetails p.mltCompany")).getText();
        String salaryName = jobWebElement.findElement(By.cssSelector("div.mltJobDetails p.mltSalary")).getText();
        String location = jobWebElement.findElement(By.cssSelector("div.mltJobDetails p.mltLocation")).getText();
        String positionType = jobWebElement.findElement(By.cssSelector("div.mltJobDetails p.mltType")).getText();
        String startDate = jobWebElement.findElement(By.cssSelector("div.mltJobDetails p.mltPosted")).getText();

        job.setBrandName(brandName);
        job.setCompanyName(brandName);
        job.setSalary(salaryName);
        job.setLocation(location);
        job.setPositionType(positionType);
        job.setStartDate(startDate);

        return job;
    }

    public void closeCompanyLightBox() {
        waitForCountryLightBoxToAppearAndClose();
    }
}

