package com.efinancialcareers.myefc.qa.desktop;

import com.efinancialcareers.myefc.qa.utils.fo.TranslationFacade;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * User: ilyas.patel
 * Date: 22/08/13
 * Time: 10:05
 */
public class ProfileViewPage extends BasePage {

    @FindBy(css = "#accordion div[data-id='youdetails'] span")
    private List<WebElement> aboutYouEmail;

    @FindBy(css = "header #navigation-links nav .loggedin")
    private WebElementFacade loggedInFirstNameInNavigation;

    @FindBy(css = "#main.right div.profileBlock div div.profileViewBlock div.profileBlockLeft h3")
    private WebElementFacade name;

    @FindBy(css = "#content section#main.right h1")
    private WebElementFacade headerText;

    @FindBy(css = "#accordion.twoColForm div.elemBoxStyle")
    private List<WebElement> allDetails;

    @FindBy(css = "#accordion.twoColForm div.elemBoxStyle div div:nth-child(5)")
    private WebElementFacade availability;

    @FindBy(css = "#accordion.twoColForm div.elemBoxStyle div div:nth-child(6)")
    private WebElementFacade minimumAnnualSalary;

    @FindBy(css = "#accordion.twoColForm div.elemBoxStyle div div:nth-child(7)")
    private WebElementFacade employmentType;

    @FindBy(css = "#accordion.twoColForm div.elemBoxStyle div div:nth-child(8)")
    private WebElementFacade targetWorkSector;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public ProfileViewPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get main heading in profile view page.
     * @return Page heading
     */
    public String getProfileAnonymousText() {
        waitForTextToAppear(TranslationFacade.getInstance().getTranslation("labels.myefc.profile.viewMyProfile"));
        return aboutYouEmail.get(1).getText();
    }

    /**
     * Get email from profile page
     * @return email
     */
    public String getEmailFromProfile() {
        waitForTextToAppear(TranslationFacade.getInstance().getTranslation("labels.myefc.profile.viewMyProfile"));
        return aboutYouEmail.get(0).getText();
    }

    /**
     * Get name
     * @return candidate name
     */
    public String getJobSeekerName() {
        return name.getTextValue().split("\n")[0];
    }

    /**
     * Get availability
     * @return availability
     */
    public String getAvailability() {
        return availability.getTextValue().trim();
    }

    /**
     * Get salary
     * @return salary
     */
    public String getSalary() {
        return minimumAnnualSalary.getTextValue().trim();
    }

    /**
     * Get employment type
     * @return employment type
     */
    public String getEmploymentType() {
        return employmentType.getTextValue().trim();
    }

    /**
     * Get target work sector
     * @return target work sector
     */
    public String getTargetWorkSector() {
        return targetWorkSector.getTextValue().trim();
    }

    /**
     * Get page header title
     * @return title
     */
    public String getPageHeader() {
        return headerText.getTextValue();
    }
}

