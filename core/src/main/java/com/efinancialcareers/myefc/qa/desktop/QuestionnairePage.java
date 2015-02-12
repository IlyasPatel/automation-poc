package com.efinancialcareers.myefc.qa.desktop;

import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class QuestionnairePage extends BasePage {

    @FindBy(id = "jobScreenQuestionnaireAnswerForm")
    private List<WebElement> questionnaireForm;

    @FindBy(name = "workPermitQuestionAnswer.answer")
    private WebElementFacade questionEligibleToWorkInYes;

    @FindBy(name = "workPermitQuestionAnswer.answerNo")
    private WebElementFacade questionEligibleToWorkInNo;

    @FindBy(name = "livingPlaceQuestionAnswer.answer")
    private WebElementFacade questionResideInYes;

    @FindBy(id = "additionalYesNoAnswers0.answer1")
    private WebElementFacade question1Yes;

    @FindBy(id = "additionalYesNoAnswers1.answer1")
    private WebElementFacade question2Yes;

    @FindBy(id = "additionalYesNoAnswers2.answer1")
    private WebElementFacade question3Yes;

    @FindBy(id = "additionalYesNoAnswers3.answer1")
    private WebElementFacade question4Yes;

    @FindBy(css = "a.btn.continue")
    private WebElementFacade continueButton;

    /**
     * Constructor
     *
     * @param driver WebDriver
     */
    public QuestionnairePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Check that user is on questionnaire page
     * @return questionnaireForm
     */
    public boolean isOnQuestionnairePage() {
        return questionnaireForm.size() > 0;
    }

    /**
     * Enter questionnaire answers
     */
    public void enterAnswers() {
        clickOn(questionEligibleToWorkInYes);
        clickOn(questionResideInYes);
        clickOn(question1Yes);
        clickOn(question2Yes);
        clickOn(question3Yes);
        clickOn(question4Yes);
    }

    /**
     * Submit questionnaire form
     */
    public void submit() {
        clickOn(continueButton);
    }

}
