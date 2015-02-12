package com.efinancialcareers.myefc.qa.mobile;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * User: jon.neville
 * Date: 14/08/13
 * Time: 14:40
 */
public class ApplyPage extends BasePage {

    @FindBy(css = "#jobApplyForm a.submit")
    private WebElementFacade sendMyApplicationButton;

    /**
     * Constructor
     * @param driver WebDriver
     */
    public ApplyPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Click apply button
     */
    public void sendApplication() {
        this.clickOn(sendMyApplicationButton);
    }

}
