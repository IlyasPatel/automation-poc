package com.efinancialcareers.myefc.qa.desktop;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * User: jon.neville
 * Date: 03/04/14
 * Time: 14:26
 */
public class TechnicalErrorPage extends BasePage {

    @FindBy(css = "div h1")
    private WebElementFacade siteUnavailableENText;

    @FindBy(css = "div h1:nth-of-type(2)")
    private WebElementFacade siteUnavailableFRText;

    @FindBy(css = "div h1:nth-of-type(3)")
    private WebElementFacade siteUnavailableDEText;

    @FindBy(css = "div h1")
    private List<WebElement> siteUnavailableTitleText;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public TechnicalErrorPage(WebDriver driver) {
        super(driver);
    }

    /**
     * 500 Text EN
     * @return site unavailable EN text
     */
    public String getSiteUnavailableENText() {
        return siteUnavailableENText.getTextValue();
    }

    /**
     * 500 Text FR
     * @return site unavailable FR text
     */
    public String getSiteUnavailableFRText() {
        return siteUnavailableFRText.getTextValue();
    }

    /**
     * 500 Text DE
     * @return site unavailable DE text
     */
    public String getSiteUnavailableDEText() {
        return siteUnavailableDEText.getTextValue();
    }
}
