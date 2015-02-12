package com.efinancialcareers.myefc.qa.mobile;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * User: jon.neville
 * Date: 08/08/13
 * Time: 10:10
 */
public class PanelPage extends BasePage {

    //private WebElement openPanel;

    @FindBy(css = "#panel .logout")
    private WebElementFacade logoutLink;

    @FindBy(css = "header a[rel='panel']")
    private WebElementFacade panel;

    @FindBy(css = "#panel ul li")
    private List<WebElement> panelMenuItems;

    /**
     * Constructor
     * @param driver WebDriver
     */
    public PanelPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Open menu
     */
    public void selectPanel() {
        waitForRenderedElements(By.name("keywords"));
        getDriver().findElement(By.cssSelector("html body div#quickSearchPage.page header a.left")).click();
        //waitABit(WaitFor.TEN_SECONDS.getMilliseconds());

        /*javascriptExecutor.executeScript("pMVC.vars.LOADING_OVERLAY.trigger('click');");
        //javascriptExecutor.executeScript("$('div.loadingOverlay').trigger('click');");
        currentPage = (WebElement) javascriptExecutor.executeScript("return CurrentPage[0];");
        WebElement panel = currentPage.findElement(By.cssSelector("a[rel=panel]"));
        panel.click();
        waitABit(WaitFor.ONE_SECOND.getMilliseconds());*/
        //openPanel = getDriver().findElement(By.id("panel"));
        //waitABit(Wait.THREE_SECONDS.getMilliseconds());
    }

    /**
     * Logout of mobile
     */
    public void logout() {
        evaluateJavascript("window.ignoreConfirm=true;");
        logoutLink.click();
    }

    /**
     * Open menu panel
     */
    public void openPanel() {
        panel.click();
    }

    /**
     * Confirms all menu links in panel are enabled post login
     */
    public void checkAllLinksEnabled() {
        /*for (WebElement menuItem : panelMenuItems) {
            System.out.println(menuItem.getTagName());
            System.out.println(menuItem.getText());
        }

        Assert.assertTrue(panelMenuItems.get(0).getText().startsWith(
                TranslationFacade.getInstance().getTranslation("sections.panel.labels.jobSearch")));

        Assert.assertEquals(TranslationFacade.getInstance()
                .getTranslation("sections.myJobs.info.name"), panelMenuItems.get(1).getText());

        Assert.assertEquals(TranslationFacade.getInstance()
                .getTranslation("sections.savedSearches.info.name"), panelMenuItems.get(2).getText());

        Assert.assertEquals(TranslationFacade.getInstance()
                .getTranslation("sections.myAccount.myProfile.info.name"), panelMenuItems.get(3).getText());

        Assert.assertEquals(TranslationFacade.getInstance()
                .getTranslation("sections.myAccount.settings.info.name"), panelMenuItems.get(4).getText());

        Assert.assertEquals(TranslationFacade.getInstance()
                .getTranslation("labels.logout"), panelMenuItems.get(5).getText());

        Assert.assertEquals(TranslationFacade.getInstance()
                .getTranslation("labels.feedback"), panelMenuItems.get(6).getText());

        Assert.assertEquals(TranslationFacade.getInstance()
                .getTranslation("sections.panel.labels.desktop"), panelMenuItems.get(7).getText());*/
    }

    /**
     * Confirms some menu links in panel are disabled when user not logged in
     */
    public void checkMenuLinksAreDisabled() {
        openPanel();

        System.out.println(panelMenuItems.size());

        /*System.out.println(panelMenuItems.get(0).getAttribute("class"));
        System.out.println(panelMenuItems.get(1).getAttribute("class"));
        System.out.println(panelMenuItems.get(2).getAttribute("class"));
        System.out.println(panelMenuItems.get(3).getAttribute("class"));
        System.out.println(panelMenuItems.get(4).getAttribute("class"));
        System.out.println(panelMenuItems.get(5).getAttribute("class"));
        System.out.println(panelMenuItems.get(6).getAttribute("class"));
        System.out.println(panelMenuItems.get(7).getAttribute("class"));*/
    }
}
