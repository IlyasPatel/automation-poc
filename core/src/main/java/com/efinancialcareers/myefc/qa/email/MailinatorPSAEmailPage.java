package com.efinancialcareers.myefc.qa.email;

import com.efinancialcareers.myefc.qa.desktop.BasePage;
import com.efinancialcareers.myefc.qa.desktop.SessionData;
import com.efinancialcareers.myefc.qa.domain.Job;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilyas.patel on 06/02/14.
 */
public class MailinatorPSAEmailPage extends BasePage implements PSAEmailPage {

    @FindBy(xpath = "//a[contains(@href, 'secure/view-job-search')]")
    private WebElementFacade editAlertLink;

    @FindBy(xpath = "(//a[contains(@href, 'view-job?')])")
    private List<WebElement> jobLinks;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public MailinatorPSAEmailPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Click edit your alert link in PSA email
     */
    public void clickEditYourAlertButton() {
        clickOn(editAlertLink);
        switchToCurrentWindow();
    }

    /**
     * Get jobs
     * @return List of jobs
     */
    public List<Job> getJobs() {
        List jobList = new ArrayList<Job>();

        for (WebElement jobLink : jobLinks) {
            Job job = new Job();
            job.setJobTitle(jobLink.getText());

            jobList.add(job);
        }

        return jobList;
    }

    /**
     * Click "View All New Jobs" Link
     */
    public void clickViewAllNewJobs() {
        String translation = translationFacade.getTranslation("psa.view.all.new.jobs");

        clickOn(getDriver().findElement(By.partialLinkText(translation)));
        switchToCurrentWindow();
    }

    /**
     * Click first job in PSA email
     */
    public void clickFirstJob() {
        WebElement job = jobLinks.get(0);

        SessionData.INSTANCE.setJobTitleToAssert(job.getText());

        clickOn(job);
        switchToCurrentWindow();
    }
}
