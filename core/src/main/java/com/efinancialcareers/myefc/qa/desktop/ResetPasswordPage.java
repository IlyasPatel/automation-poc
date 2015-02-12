package com.efinancialcareers.myefc.qa.desktop;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * User: ilyas.patel
 * Date: 22/08/13
 * Time: 10:05
 */
public class ResetPasswordPage extends BasePage {

    @FindBy(id = "password")
    private WebElementFacade newPassword;

    @FindBy(id = "confirmpassword")
    private WebElementFacade confirmPassword;

    @FindBy(css = "#resetPassword")
    private WebElementFacade resetPasswordForm;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public ResetPasswordPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Check password reset page is displayed
     * @return if form is displayed
     */
    public boolean isPasswordResetFromDisplayed() {
        return this.resetPasswordForm.isCurrentlyVisible();
    }

    /**
     * New password
     * @param newPassword Password
     */
    public void enterNewPassword(String newPassword) {
        this.newPassword.type(newPassword);
    }

    /**
     * Confirm password
     * @param newPassword Password
     */
    public void confirmPassword(String newPassword) {
        this.confirmPassword.type(newPassword);
    }

    /**
     * Submit form
     */
    public void submit() {
        this.confirmPassword.submit();
    }

}

