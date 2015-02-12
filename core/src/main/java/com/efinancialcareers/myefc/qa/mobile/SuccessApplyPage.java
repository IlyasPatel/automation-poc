package com.efinancialcareers.myefc.qa.mobile;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * User: jon.neville
 * Date: 14/08/13
 * Time: 15:42
 */
public class SuccessApplyPage extends BasePage {

    @FindBy(css = "#jobApplyProcessedPage.page")
    private WebElementFacade successApplyPage;

    @FindBy(css = "#jobApplyProcessedPage.page div.mainContent h1")
    private WebElementFacade successApplyMessage;

    /**
     * Constructor
     * @param driver WebDriver
     */
    public SuccessApplyPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Check successfully applied page is shown
     * @return successful message
     */
    public String successfullyApplied() {
        //Assert.assertNotNull(successApplyPage.isDisplayed());
        return successApplyMessage.getText();
    }

}
