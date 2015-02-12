package com.efinancialcareers.myefc.qa.desktop;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.text.MessageFormat;

/**
 * User: jon.neville
 * Date: 29/08/13
 * Time: 10:47
 */
public class SavedJobsPage extends BasePage {

    // TODO. i.patel. Move to MyEfc Base class as button css is same as AppliedJobsPage
    public static final String DELETE_CONFIRM_BUTTON = "#popupContent button";

    @FindBy(css = "#sectionContainer a.sortTitle")
    private WebElementFacade job1Title;

    @FindBy(css = "#savedJobsContainer a.deleteElem")
    private WebElementFacade deleteJobButton;

    @FindBy(css = SavedJobsPage.DELETE_CONFIRM_BUTTON)
    private WebElementFacade confirmationToDeleteBtn;

    @FindBy(css = "#savedJobsContainer div.elemBoxStyleNoBg")
    private WebElementFacade noSavedJobsText;

    /**
     * Constructor
     *
     * @param driver WebDriver
     */
    public SavedJobsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Assertion to check job title matches what was on the SRP
     * @return first job title
     */
    public String checkTheFirstJobTitleIsCorrect() {
        return job1Title.getTextValue().trim();
    }

    /**
     * Click delete button
     */
    public void clickDeleteButton() {
        clickOn(deleteJobButton);
    }

    /**
     * Click confirmation button Yes
     */
    public void deleteJobConfirm() {
        clickOn(confirmationToDeleteBtn);
    }

    /**
     * Gets validation message for no saved jobs displayed
     * @return no jobs saved message
     */
    public String getNoSavedJobsText() {
        return noSavedJobsText.getText().trim();
    }

    /**
     * Apply for a specific job using id
     * @param jobId Job Id
     */
    public void applyForJobBy(Long jobId) {
        String href = MessageFormat.format("//a[contains(@href, ''/myefc/jobs/apply/{0}'')]", String.valueOf(jobId));

        clickOn(find(By.xpath(href)));
    }
}
