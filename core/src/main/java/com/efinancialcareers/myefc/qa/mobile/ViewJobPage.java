package com.efinancialcareers.myefc.qa.mobile;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * User: jon.neville
 * Date: 14/08/13
 * Time: 08:52
 */
public class ViewJobPage extends BasePage {

    @FindBy(css = "a.apply")
    private WebElementFacade applyButton;

    /**
     * Constructor
     * @param driver WebDriver
     */
    public ViewJobPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Click apply button
     */
    public void apply() {
        this.clickOn(applyButton);
    }

}
