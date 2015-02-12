package com.efinancialcareers.myefc.qa.mobile;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * User: jon.neville
 * Date: 14/08/13
 * Time: 08:52
 */
public class SearchResultsPage extends BasePage {

    private JavascriptExecutor javascriptExecutor;

    @FindBy(xpath = "//ul[@id='jobsList']/li/a/div/h2")
    private WebElementFacade firstJob;

    @FindBy(id = "refineSearch")
    private WebElementFacade refineButton;

    /**
     * Constructor
     * @param driver WebDriver
     */
    public SearchResultsPage(WebDriver driver) {
        super(driver);
        javascriptExecutor = (JavascriptExecutor) getDriver();
    }

    /**
     * Select first job
     */
    public void selectFirstJob() {
        this.clickOn(firstJob);
    }

    /**
     * Select refine button
     */
    public void refine() {
        //Remove overlay if present
        javascriptExecutor.executeScript("pMVC.vars.LOADING_OVERLAY.trigger('click');");
        this.clickOn(refineButton);
    }
}
