package com.efinancialcareers.myefc.qa.desktop;

import net.thucydides.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

/**
 * User: jon.neville
 * Date: 27/10/14
 * Time: 17:00
 */
public class CompareMePage extends BasePage {

    @FindBy(css = "#content section#main.right h1")
    private WebElementFacade headerText;

    /**
     * Constructor
     *
     * @param driver WebDriver
     */
    public CompareMePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get page header title
     * @return title
     */
    public String getPageHeader() {
        return headerText.getTextValue();
    }
}
