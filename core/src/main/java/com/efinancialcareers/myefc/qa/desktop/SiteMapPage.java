package com.efinancialcareers.myefc.qa.desktop;

import com.efinancialcareers.myefc.qa.domain.LinkType;
import com.efinancialcareers.myefc.qa.utils.QAStringUtils;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * User: jon.neville
 * Date: 03/12/13
 * Time: 09:57
 */
public class SiteMapPage extends BasePage {

    @FindBy(css = "#siteMapContainer")
    private WebElementFacade siteMapContainer;

    @FindBy(xpath = "//a[contains(@href, '.br0')]")
    private List<WebElement> brandLinks;

    @FindBy(xpath = "//a[contains(@href, '.co0')]")
    private List<WebElement> countryLinks;

    @FindBy(xpath = "//a[contains(@href, '.cy0')]")
    private List<WebElement> cityLinks;

    @FindBy(xpath = "//a[contains(@href, '.os0')]")
    private List<WebElement> sectorLinks;

    @FindBy(xpath = "//a[contains(@href, '.ob0')]")
    private List<WebElement> subSectorLinks;

    /**
     * Constructor
     * @param driver Webdriver
     */
    public SiteMapPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Check that user is on site map page
     * @return siteMapPage
     */
    public boolean isOnSiteMapPage() {
        return this.siteMapContainer.isPresent();
    }

    /**
     * Select sector from SiteMap by name
     * @param sectorName Sector name
     */
    public void selectSectorFromSiteMapByName(String sectorName) {
        clickLinkByPartialText(sectorName);
    }

    /**
     * Get link of specified type
     * @param linkType LinkType
     * @return link text
     */
    public String getLinkOfType(LinkType linkType) {
        List<WebElement> links = null;

        switch (linkType) {
            case SINGLE_BRAND:
                links = brandLinks;
                break;
            case SECTOR:
                links = sectorLinks;
                break;
            case SUBSECTOR:
                links = subSectorLinks;
                break;
            case COUNTRY:
                links = countryLinks;
                break;
            case CITY:
                links = cityLinks;
                break;
        }

        return QAStringUtils.getRandomEntity(links).getText();
    }
}
