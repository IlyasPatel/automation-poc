package com.efinancialcareers.myefc.qa.desktop;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * User: jon.neville
 * Date: 03/04/14
 * Time: 09:23
 */
public class NotFoundPage extends BasePage {

    @FindBy(css = ".message.error")
    private WebElementFacade notFoundMessage;

    @FindBy(css = "article section.description div.well p a.button")
    private WebElementFacade visitOurHomepageLink;

    @FindBy(css = "article section.description div.well p:nth-child(6) a.button")
    private WebElementFacade readOurLatestNewsLink;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public NotFoundPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get Page not found text
     * @return page not found message
     */
    public String getPageNotFoundMessage() {
        return notFoundMessage.getText().replaceAll("\n", " ");
    }

    /**
     * Visit our Homepage link text
     * @return visit our homepage link text
     */
    public String getVisitOurHomepageLinkText() {
        return visitOurHomepageLink.getTextValue();
    }

    /**
     * Visit read our latest news link text
     * @return read our latest news link text
     */
    public String getReadOurLatestNewsLinkText() {
        return readOurLatestNewsLink.getTextValue();
    }
}
