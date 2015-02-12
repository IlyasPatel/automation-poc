package com.efinancialcareers.myefc.qa.desktop;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * User: jon.neville
 * Date: 15/11/13
 * Time: 10:49
 */
public class AccountDeletedPage extends BasePage {

    @FindBy(css = "#content div.header header h1")
    private WebElementFacade accountDeletedText;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public AccountDeletedPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get main heading in account deleted page.
     * @return Page heading
     */
    public String getHeaderText() {
        return accountDeletedText.getText();
    }
}

