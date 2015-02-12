package com.efinancialcareers.myefc.qa.email;

import com.efinancialcareers.myefc.qa.desktop.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by jon.neville on 09/06/14.
 */
public class MailinatorBOResetPasswordEmailPage extends BasePage implements ResetPasswordBOEmailPage {

    @FindBy(css = "div.row-fluid div.span12 div.mailview a")
    protected WebElementFacade emailLink;

    @FindBy(xpath = "//a[contains(@href, 'login/reset-password')]")
    private WebElementFacade resetPasswordButton;

    @FindBy(css = "#mailshowdiv .mail-list")
    private WebElementFacade emailSubjectLineInEmail;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public MailinatorBOResetPasswordEmailPage(WebDriver driver) {
        super(driver);
    }

    /**
     * click reset password button
     */
    public void clickResetYourPassword() {
        clickOn(emailLink);
        switchToCurrentWindow();
    }

}
