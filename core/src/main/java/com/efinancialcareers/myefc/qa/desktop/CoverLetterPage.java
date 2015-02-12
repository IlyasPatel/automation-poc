package com.efinancialcareers.myefc.qa.desktop;

import com.efinancialcareers.myefc.qa.utils.fo.WaitFor;
import org.junit.Assert;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * User: jon.neville
 * Date: 02/09/13
 * Time: 15:54
 */
public class CoverLetterPage extends BasePage {

    @FindBy(id = "uploadCoverLetterButton")
    private WebElementFacade createCoverLetterButton;

    @FindBy(id = "coverLetterTitle")
    private WebElementFacade titleText;

    @FindBy(id = "coverLetterText")
    private WebElementFacade coverText;

    @FindBy(css = "#updateCoverLetterForm1 > #coverLetterTitle")
    private WebElementFacade titleEditText;

    @FindBy(css = "#updateCoverLetterForm1 > #coverLetterText")
    private WebElementFacade coverEditText;

    @FindBy(css = "#content section article form#createCoverLetterForm .buttonContainer a.save")
    private WebElementFacade saveButton;

    @FindBy(css = "#content section article form#updateCoverLetterForm1.hidden .buttonContainer a.update")
    private WebElementFacade updateButton;

    @FindBy(css = "#coverLetters article div.docContainer div.elemBoxStyle ul li.info h2")
    private WebElementFacade coverLetter1Details;

    @FindBy(css = "#coverLetters article h4")
    WebElementFacade documentCount;

    @FindBy(css = "#main.right article .docContainer .elemBoxStyle")
    private WebElementFacade coverLetterDisplayedBox;

    @FindBy(css = "#popupContent p")
    WebElementFacade modalText;

    @FindBy(css = SavedJobsPage.DELETE_CONFIRM_BUTTON)
    WebElementFacade confirmationToDeleteBtn;

    /**
     * Constructor
     *
     * @param driver WebDriver
     */
    public CoverLetterPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Click Create Cover Letter
     */
    public void clickCreate() {
        scrollUntilElementIsVisible(createCoverLetterButton);
        clickOnCustom(createCoverLetterButton);
    }

    /**
     * Cover letter title
     * @param text title
     */
    public void enterTitle(String text) {
        typeInto(titleText, text);
    }

    /**
     * Cover letter title body text
     * @param text text
     */
    public void enterText(String text) {
        typeInto(coverText, text);
    }

    /**
     * Edit cover letter title
     * @param text title
     */
    public void editTitle(String text) {
        typeInto(titleEditText, text);
    }

    /**
     * Edit cover letter title body text
     * @param text text
     */
    public void editText(String text) {
        typeInto(coverEditText, text);
    }

    /**
     * Save Cover letter
     */
    public void clickSave() {
        clickOn(saveButton);
        waitForAJAXToComplete();
    }

    /**
     * Update Cover letter
     */
    public void clickUpdate() {
        titleEditText.submit();
    }

    /**
     * Get cover letter details including title
     * @return cover letter details
     */
    public String getCoverLetterDetails() {
        naughtyWait();
        // TODO. i.patel. I think there is the swirly waiting image when updating a cover letter
        // Need to wait for image to dissappear in chrome
        return coverLetter1Details.getText().trim();
    }

    /**
     * Delete cover letter
     */
    public void deleteCoverLetter() {
        makeButtonsVisible();

        WebDriverWait wait = new WebDriverWait(getDriver(), WaitFor.SLA_WEB_ELEMENTS.getSeconds());
        clickOn(wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".docContainer .actions a.deleteAction")
                )
        ));

        waitUntilElementHasStoppedMoving(confirmationToDeleteBtn);
        clickOn(confirmationToDeleteBtn);
    }

    /**
     * Makes buttons visible in MyEfc
     */
    private void makeButtonsVisible() {
        evaluateJavascript("$('.docContainer .coverCont ul').addClass('showbuttons');");
        evaluateJavascript("$('#main a.deleteAction').css('visibility','visible');");
    }

    /**
     * Get text in cover letter section
     * @return Text in cover letter section
     */
    public String getCoverLetterText() {
        waitForTextToAppear("0/5");

        return documentCount.getTextValue().trim();
    }

    /**
     * Click first edit button for a created cover letter
     */
    public void clickEdit() {
        makeButtonsVisible();

        WebDriverWait wait = new WebDriverWait(getDriver(), WaitFor.SLA_WEB_ELEMENTS.getSeconds());
        WebElement editButton =
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".docContainer .actions a.editAction")));

        clickOn(editButton);
    }

    /**
     * Gets message from modal box
     * @return string
     */
    public String getMessageFromModal() {
        return modalText.getTextValue();
    }

}
