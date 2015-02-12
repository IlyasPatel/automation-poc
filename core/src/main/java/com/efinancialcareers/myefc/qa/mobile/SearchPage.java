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
public class SearchPage extends BasePage {

    private JavascriptExecutor javascriptExecutor;

    @FindBy(xpath = "//form[@id='quickSearchForm']/div/div/input")
    private WebElementFacade keywords;

    /**
     * Constructor
     * @param driver WebDriver
     */
    public SearchPage(WebDriver driver) {
        super(driver);
        javascriptExecutor = (JavascriptExecutor) getDriver();
    }

    /**
     * Enter username
     * @param keywords keywords
     */
    public void enterKeywords(String keywords) {
        this.keywords.type(keywords);
    }

    /**
     * Submit search form
     */
    public void submit() {
        javascriptExecutor.executeScript("pMVC.vars.LOADING_OVERLAY.trigger('click');");
        this.keywords.submit();
    }
}
