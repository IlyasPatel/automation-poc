package com.efinancialcareers.myefc.qa.desktop;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AlreadyAppliedForJobPage extends BasePage {

    @FindBy(tagName = "h1")
    private WebElementFacade alreadyAppliedForThisJobHeader;

    @FindBy(xpath = "//div[@class='error-page container'] //a[contains(@href, '/myefc/application-history')]")
    private WebElementFacade applicationHistoryLink;

    @FindBy(name = "userInfoForm.workPreferences.yearsExperience")
    private WebElementFacade workExperience;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public AlreadyAppliedForJobPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get message in H1
     * @return message
     */
    public String getMessage() {
        return alreadyAppliedForThisJobHeader.getTextValue();
    }

    public WebElementFacade getViewApplicationHistoryLink() {
        return applicationHistoryLink;
    }

    /**
     * Assertion
     */
    public void assertIsNotOnJobApplyPage() {
        this.shouldNotBeVisible(workExperience);
    }
}
