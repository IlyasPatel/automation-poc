package com.efinancialcareers.jbehave.qa.steps;

import com.efinancialcareers.myefc.qa.desktop.ApplicationSuccessPage;
import com.efinancialcareers.myefc.qa.desktop.ApplyForJobPage;
import com.efinancialcareers.myefc.qa.desktop.HeaderComponent;
import com.efinancialcareers.myefc.qa.desktop.Homepage;
import com.efinancialcareers.myefc.qa.desktop.JobSearchResultsPage;
import com.efinancialcareers.myefc.qa.desktop.KeywordLocationComponent;
import com.efinancialcareers.myefc.qa.desktop.MyEfcLoginPage;
import com.efinancialcareers.myefc.qa.desktop.SessionData;
import com.efinancialcareers.myefc.qa.domain.Job;
import com.efinancialcareers.myefc.qa.domain.analytics.AnalyticsDataLayer;
import com.efinancialcareers.myefc.qa.utils.fo.FoPropertiesLoader;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import org.fest.assertions.Assertions;
import org.junit.Assert;
import org.openqa.selenium.Cookie;

import java.text.MessageFormat;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.equalTo;

public class FoJobSeekerSteps extends ScenarioSteps {

    private Homepage homepage;
    private HeaderComponent headerComponent;
    private MyEfcLoginPage myEfcLoginPage;
    private KeywordLocationComponent keywordLocationComponent;
    private JobSearchResultsPage jobSearchResultsPage;
    private ApplyForJobPage applyForJobPage;
    private ApplicationSuccessPage applicationSuccessPage;

    private Set<Cookie> foCookies;
    private String jobTitleToAssert;


    /*@Autowired
    private DataLayerGenerator dataLayerGenerator;*/

    /**
     * Constructor
     *
     * @param pages Pages
     */
    public FoJobSeekerSteps(Pages pages) {
        super(pages);
    }

    /**
     * Is the homepage
     */
    @Step
    public void isHomePage() {
        homepage.openAt("http://www.efinancialcareers.co.uk/");
        homepage.closeCountryPickerModal();
    }

    /**
     * Click sign on from header menu
     */
    public void clickSignInFromHeaderMenu() {
        headerComponent.selectJobseekerMenuNotLoggedIn();
        headerComponent.clickSignInLink();
    }

    /**
     * Enter email and password
     * @param email email
     * @param password password
     */
    @Step
    public void enterCredentials(String email, String password) {
        myEfcLoginPage.enterUsername(email);
        myEfcLoginPage.enterPassword(password);

        SessionData.INSTANCE.setJobseekerEmail(email);
    }

    /**
     * Click signIn button
     */
    @Step
    public void clickSignIn() {
        myEfcLoginPage.submit();
        headerComponent.waitForLoginToComplete();

        SessionData.INSTANCE.setIsLoggedIn();

        SessionData.INSTANCE.setAnalyticsRegistrationDataType("LOGGED_IN");
        SessionData.INSTANCE.setAnalyticsHitPage("/myefc/login/logged-in.html");
    }

    /**
     * open up job search component so a job search can be performed
     */
    @Step
    public void openJobSearchComponent() {
        headerComponent.clickJobSearchComponent();
    }

    /**
     * Perform a job search with keyword
     * @param keyword keyword
     */
    @Step
    public void iPerformJobSearch(String keyword) {
        keywordLocationComponent.enterKeywords(keyword);

        submitJobSearch();

        SessionData.INSTANCE.setKeyword(keyword);
    }

    /**
     * Submit job search
     * @return JobSearchResultsPage
     */
    public void submitJobSearch() {
        keywordLocationComponent.submitJobSearchForm();
    }

    /**
     * Click on Apply for Job Job Button
     */
    @Step
    public void clickApplyButtonOnSrp() {
        List<Job> informationForAllJobsOnCurrentPage = jobSearchResultsPage.getInformationForAllJobsOnCurrentPage();

        Job jobForAssertion = informationForAllJobsOnCurrentPage.get(0);
        jobSearchResultsPage.selectFirstJobToApply();

        SessionData.INSTANCE.setJobBean(jobForAssertion);
        SessionData.INSTANCE.setJobId(Long.parseLong(jobForAssertion.getJobId()));

    }

    public void assertShouldBeOnApplyForAJobPage() {
        Assertions.assertThat(applyForJobPage.isOnJobApplyPage()).isTrue();
    }

    public void uncheckInterestedInBeingContacted() {
        applyForJobPage.clickContactedByOtherRecruiters();
    }

    /**
     * Submit form to apply for job
     */
    @Step
    public void submitFormToApplyForJob() {
        applyForJobPage.applyForThisJob();
    }

    /**
     * Job successfully applied for
     */
    @Step
    public void assertApplicationSuccessfullySentMessageAppears() {

        Job jobForAssertion = SessionData.INSTANCE.getJobBean();

        String applicationSuccessMessage = MessageFormat.format("Your application for {0} has been sent successfully", jobForAssertion.getJobTitle());

        Assert.assertThat(
                applicationSuccessPage.getMainHeadingInSuccessAppliedPage(),
                equalTo(applicationSuccessMessage)
        );

    }

    /**
     * Assertion
     */
    @Step
    public void assertMyProfileIsNotSearchableAccordingToDescriptionInHeader() {
        Assert.assertThat(
                "Expected profile to be non searchable in header",
                headerComponent.getProfileSearchStatus(),
                equalTo("Your profile is not searchable")
        );
    }
}
