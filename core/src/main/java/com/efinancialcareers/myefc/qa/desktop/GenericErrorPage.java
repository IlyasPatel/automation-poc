package com.efinancialcareers.myefc.qa.desktop;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ilyas.patel on 07/02/14.
 */
public class GenericErrorPage extends BasePage {

    @FindBy(css = "div.error-page p.message")
    private WebElementFacade errorMessage;


    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public GenericErrorPage(WebDriver driver) {
        super(driver);
    }

    public String getErrorMessage() {
        return errorMessage.getTextValue().trim();
    }
}
