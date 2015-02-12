package com.efinancialcareers.myefc.qa.desktop;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * User: jon.neville
 * Date: 02/12/13
 * Time: 15:02
 */
public class FooterComponent extends BaseComponent {

    @FindBy(xpath = "//section[@id='meta']//a[contains(@href, 'sitemap/html')]")
    private WebElementFacade siteMapLink;

    @FindBy(xpath = "//section[@id='meta']//a[contains(@href, '/search')]")
    private WebElementFacade jobSearchLink;

    @FindBy(xpath = "//section[@id='meta']//a[contains(@href, '.s019')]")
    private WebElementFacade itFinanceLink;

    @FindBy(xpath = "//section[@id='meta']//a[contains(@href, '/myefc/profile')]")
    private WebElementFacade candidateSignInLink;

    @FindBy(css = "#network-sites .network-container a")
    private WebElementFacade networkSites;

    @FindBy(css = "#meta.container div ul li ul li a")
    List<WebElement> footerLinks;

    /**
     * Constructor
     * @param driver Webdriver
     */
    public FooterComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * Click site map link
     */
    public void clickSiteMap() {
        scrollBottom();
        clickOn(siteMapLink);
    }

    /**
     * Click site map link
     */
    public void clickJobSearch() {
        scrollBottom();

        clickOn(jobSearchLink);
    }

    /**
     * Click candidate sign in link
     */
    public void clickCandidateSignIn() {
        scrollBottom();

        clickOn(candidateSignInLink);
    }

    /**
     * Click IT Finance link
     */
    public void clickITFinance() {
        scrollBottom();

        clickOn(itFinanceLink);
    }

    /**
     * Open Country picker in the footer
     */
    public void openCountryPicker() {
        scrollBottom();

        withAction().moveToElement(networkSites)
                .clickAndHold()
                .perform();
    }

    /**
     * Click country site
     * @param url url
     */
    public void clickCountrySite(String url) {
        clickOn(find(By.xpath("//footer //a[contains(@href,'" + url + "')]")));

        withAction().release(networkSites)
                .perform();
    }

    /**
     * Get number of footer link
     * @return count
     */
    public int getNumberOfFooterLinks() {
        return footerLinks.size();
    }
}
