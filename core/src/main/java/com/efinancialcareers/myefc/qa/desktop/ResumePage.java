package com.efinancialcareers.myefc.qa.desktop;

import com.efinancialcareers.myefc.qa.utils.Keyboard;
import com.efinancialcareers.myefc.qa.utils.fo.TranslationFacade;
import com.efinancialcareers.myefc.qa.utils.fo.WaitFor;
import org.junit.Assert;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.Robot;
import java.awt.AWTException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * User: ilyas.patel
 * Date: 25/07/13
 * Time: 16:49
 */
public class ResumePage extends BasePage {

    private static final String ENTER = "\n";
    private static final String CV_UPLOAD_CONFIRM = "#popupContent a.exit";

    @FindBy(id = "uploadCVButton")
    private WebElementFacade uploadCVButton;

    @FindBy(css = "#popupContent")
    private WebElementFacade popupContent;

    @FindBy(css = "#popupContent a")
    private WebElementFacade uploadCVFormAnchor;

    @FindBy(css = "#popupContent .filename")
    private WebElementFacade uploadedFilenameText;

    @FindBy(css = "#popupContent #uploadCVForm #submitCvUploadFile")
    private WebElementFacade submitCvUploadFile;

    @FindBy(css = "div.docContainer li.info h2")
    private WebElementFacade resumeNameHeader;

    @FindBy(css = "#popupContent #cvUploadFile")
    private WebElementFacade fileInput;

    @FindBy(css = "#popupContent p")
    private WebElementFacade modalText;

    @FindBy(css = "#popupContent #cvUploadErrors")
    private WebElementFacade cvUploadError;

    @FindBy(css = "#popupContent #uploadCVForm h4.uploadStatus")
    private WebElementFacade uploadStatusTechnicalError;

    @FindBy(css = "#main.right .mainHeader .subtitles .cta .highlightOrange")
    private WebElementFacade noResumesInDocumentLibraryMsg;

    @FindBy(css = "#main.right .mainHeader .subtitles .cta .countDocs")
    private WebElementFacade documentCount;

    @FindBy(css = "#content section article .cvCont ul li h2")
    private List<WebElement> resumeTitles;

    @FindBy(css = SavedJobsPage.DELETE_CONFIRM_BUTTON)
    WebElementFacade confirmationToDeleteBtn;

    @FindBy(css = CV_UPLOAD_CONFIRM)
    private WebElementFacade cvUploadConfirmLink;

    /**
     * Constructor
     * @param driver Webdriver
     */
    public ResumePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Upload resume click
     */
    public void clickUploadResumeButton() {
        clickOn(uploadCVButton);
        waitUntilElementHasStoppedMoving(popupContent);
    }

    private void waitForNativeFileExplorer() {
        naughtyWait();
    }

    /**
     * Uploads resume using Robot class
     * @param filePath File path to document
     */
    public void uploadResumeUsingRobot(String filePath) {
        waitForNativeFileExplorer();
        uploadCVFormAnchor.click();
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            Assert.fail("Resume upload failed using Robot");
        }
        Keyboard keyboard = new Keyboard(robot);
        keyboard.type(filePath);
        keyboard.type(ENTER);

        (new WebDriverWait(getDriver(),
                WaitFor.SLA_RESUME_UPLOAD.getSeconds())).until(ExpectedConditions.visibilityOf(submitCvUploadFile));
    }

    /**
     * Uploads resume using HTML input field
     * @param filePath File path to document
     */
    public void uploadResumeUsingThucydides(String filePath) {
        uploadResumeUsingThucydides(filePath, false);
    }

    /**
     * Uploads resume using HTML input field
     * @param filePath File path to document
     * @param isFileSizeOverLimit isFileSizeOverLimit
     */
    public void uploadResumeUsingThucydides(String filePath, boolean isFileSizeOverLimit) {
        //upload(file.getPath()).to(fileInput);
        fileInput.sendKeys(filePath);

        if (!isFileSizeOverLimit) {
            (new WebDriverWait(getDriver(),
                    WaitFor.SLA_RESUME_UPLOAD.getSeconds())).until(ExpectedConditions.visibilityOf(submitCvUploadFile));
        } else {
            (new WebDriverWait(getDriver(),
                    WaitFor.SLA_RESUME_UPLOAD.getSeconds())).until(ExpectedConditions.visibilityOf(cvUploadError));
        }
    }

    /**
     * Uploads resume using HTML input field
     * @param file document
     */
    public void uploadResumeUsingThucydidesExpectingTechnicalError(File file) {
        upload(file.getPath()).to(fileInput);
        naughtyWait();

        (new WebDriverWait(getDriver(),
                WaitFor.SLA_RESUME_UPLOAD.getSeconds()))
                    .until(ExpectedConditions.visibilityOf(uploadStatusTechnicalError));
    }

    public String getUploadedFileName() {
        return uploadedFilenameText.getTextValue();
    }

    public String getSuccessfulUploadImage() {
        return (String) evaluateJavascript(
            "return $('#popupContent .cvDocNameFormat:visible').css('background-image')"
        );
    }

    /**
     * Upload resume to be processed by Burning Glass, virus scan, etc
     */
    public void uploadResume() {
        clickOn(submitCvUploadFile);

        (new WebDriverWait(getDriver(), WaitFor.SLA_RESUME_UPLOAD.getSeconds()))
                .until(ExpectedConditions.textToBePresentInElementLocated(
                        By.cssSelector("#popupContent #uploadCVForm div h1.uploadStatus"),
                        translationFacade.getTranslation("myefc.cvupload.notifications.processingWithGraphic")));
    }

    /**
     * click submit CV upload file
     */
    public void clickSubmitCvUploadFile() {
        clickOn(submitCvUploadFile);
    }

    /**
     * Collects messages during resume upload process
     * @return List of messages
     */
    public List<String> collectMessages() {

        final List<String> messageList = new ArrayList<String>();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(WaitFor.SLA_RESUME_UPLOAD.getSeconds(), TimeUnit.SECONDS)
                .pollingEvery(WaitFor.ONE_SECOND.getSeconds(), TimeUnit.SECONDS)
                .ignoring(StaleElementReferenceException.class);

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                List<WebElement> messages =
                        getDriver().findElements(By.cssSelector("#popupContent #uploadCVForm div.cvLoadingMsg"));

                if (messages.size() > 0) {
                    String h2 = messages.get(0).findElement(By.tagName("h2")).getText();
                    String p = messages.get(0).findElement(By.tagName("p")).getText();

                    addMessage(h2);
                    addMessage(p);
                }

                return cvUploadConfirmLink.isCurrentlyVisible();
            }

            private void addMessage(String h2) {
                if (!messageList.contains(h2)) {
                    messageList.add(h2);
                }
            }
        });

        return messageList;
    }

    /**
     * Delete resume
     */
    public void deleteResume() {
        naughtyWait();

        (new WebDriverWait(getDriver(), WaitFor.SLA_WEB_ELEMENTS.getSeconds())).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(
                        By.cssSelector("#content #sidebar.left .completeness .profileCompleteText")).isDisplayed();
            }
        });

        evaluateJavascript("$('.docContainer .cvCont ul').addClass('showbuttons');");
        evaluateJavascript("$('#main a.deleteAction').css('visibility','visible');");

        WebDriverWait wait = new WebDriverWait(getDriver(), WaitFor.SLA_WEB_ELEMENTS.getSeconds());
        WebElement deleteButton =
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".docContainer .actions a.deleteAction")));

        clickOn(deleteButton);

        clickOn(confirmationToDeleteBtn);
    }

    /**
     * Display HTML input field so webdriver can upload file.
      */
    public void makeHiddenInputFieldVisible() {
        evaluateJavascript("$('#popupContent #cvUploadFile').css('visibility','visible');");
    }

    /**
     * Assertion
     */
    public void checkThereAreNoResumesInAccount() {
        Assert.assertEquals(TranslationFacade.getInstance().getTranslation("myefc.entities.docs.cvs.noCvs"),
                noResumesInDocumentLibraryMsg.getText());

        Assert.assertEquals("0/5", documentCount.getText());
    }

    /**
     * Get's message from modal box
     * @return string
     */
    public String getMessageFromModal() {
        return modalText.getTextValue();
    }

    /**
     * Get total resumes uploaded
     * @return Number of resumes uploaded
     */
    public String getTotalResumeCount() {
        return documentCount.getText().split("/")[0];
    }

    /**
     * Get file size too large message
     * @return message
     */
    public String getUploadErrorMessage() {
        return cvUploadError.getTextValue();
    }

    /**
     * Get technical error message
     * @return message
     */
    public String getTechnicalErrorMessage() {
        return uploadStatusTechnicalError.getTextValue();
    }

    /**
     * Checks if a resume is in the document library
     * @param documentName Document Name
     * @return true or false
     */
    public boolean checkIfResumeHasUploaded(String documentName) {
        waitForResumePageToRefresh();

        try {
            for (WebElement element: resumeTitles) {
                if (element.getText().trim().equals(documentName)) {
                    return true;
                }
            }
        } catch (NoSuchElementException e) {
            return false;
        }

        return false;
    }

    /**
     * Wait for resume page to refresh before collecting the resumes in the account
     */
    private void waitForResumePageToRefresh() {
        waitForTextToAppear(translationFacade.getTranslation("efc.ticker.footer"));
    }

    /**
     * Close CV upload confirmation modal box
     */
    public void closeCVUploadConfirmationModalBox() {
        clickOn(cvUploadConfirmLink);
        waitForAbsenceOf(CV_UPLOAD_CONFIRM);
    }

    /**
     * Check if upload button is displayed
     * @return upload button present
     */
    public boolean uploadCVIsDisplayed() {
        return this.uploadCVButton.isPresent();
    }
}
