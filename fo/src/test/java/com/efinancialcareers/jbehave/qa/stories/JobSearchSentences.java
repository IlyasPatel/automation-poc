package com.efinancialcareers.jbehave.qa.stories;

import com.efinancialcareers.jbehave.qa.steps.FoJobSeekerSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.spring.SpringIntegration;
import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(SerenityRunner.class)
@ContextConfiguration(locations = "/spring-config.xml")
public class JobSearchSentences extends BaseStorySentences {

    @Rule
    public SpringIntegration springIntegration = new SpringIntegration();

    @Steps
    private FoJobSeekerSteps foEndUser;

    /*@Autowired
    private Dataload dataload;
    */

    @Given("I am a jobseeker on the FO home page and I login with my normal account")
    public void givenIAmAJobseekerOnTheFOHomePageAndILoginWithMyNormalAccount(
            @Named("email") String email, @Named("password") String password) {

        foEndUser.isHomePage();
        foEndUser.clickSignInFromHeaderMenu();
        foEndUser.enterCredentials(email, password);
        foEndUser.clickSignIn();
    }

    @When("I search for this job using the job search component and click on the apply button")
    public void whenIPerformAJobSearchUsingJobSearchComponent() {
        Long jobId = 642410L;
        String jobTitle = "Test Job";

        foEndUser.openJobSearchComponent();
        foEndUser.iPerformJobSearch(jobTitle);
        foEndUser.clickApplyButtonOnSrp();
    }

    @Then("I am taken to the \"Apply for a Job\" page")
    public void iAmTakenToApplyForAJobPage() {
        foEndUser.assertShouldBeOnApplyForAJobPage();
    }

    @Then("I untick \"I'm interested in being contacted\" checkbox")
    public void uncheckInterestedInBeingContacted() {
        foEndUser.uncheckInterestedInBeingContacted();
    }

    @Then("then apply for the job")
    @Aliases(values = {
            "I submit my application without entering details",
            "I submit my application without entering nationality",
            "apply for the job"}
    )
    public void applyForThisJob() {
        foEndUser.submitFormToApplyForJob();
    }
}
