package com.efinancialcareers.myefc.qa.mailinator;

import com.efinancialcareers.myefc.qa.desktop.BasePage;
import com.efinancialcareers.myefc.qa.utils.fo.TranslationFacade;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * User: jon.neville
 * Date: 13/09/13
 * Time: 15:30
 */
@Deprecated
public class MailinatorPage extends BasePage {

    @FindBy(id = "InboxCtrl")
    private WebElementFacade inbox;

    @FindBy(css = "#InboxCtrl li")
    private List<WebElement> inboxList;

    @FindBy(xpath = "//table[@class='header']")
    private WebElement tableHeader;

    @FindBy(xpath = "//table[@class='mainTable']")
    private WebElement mainTable;



    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public MailinatorPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get PSA Email
     * @param alertName Name of alert
     */
    public void getPSAEmail(String alertName) {
        WebElement alert = inbox.findElement(By.partialLinkText(alertName));
        alert.click();

        waitForAnyTextToAppear(TranslationFacade.getInstance().getTranslation("psa.unsubscribe.link"));
    }

    /**
     * Get all links and data in email alert
     * @return key/value pair of data
     */
    public Map<String, String> getAllLinksInAlert() {
        Map<String, String> emailDetails = new LinkedHashMap<String, String>();

        WebElement td = tableHeader.findElement(By.tagName("td"));
        String psaName = td.getText();

        emailDetails.put("PSA NAME", psaName);

        List<WebElement> tr = mainTable.findElements(By.tagName("tr"));

        for (WebElement row : tr) {
            try {
                List<WebElement> anchors = row.findElements(By.tagName("a"));

                for (WebElement anchor : anchors) {
                    emailDetails.put(anchor.getText(), anchor.getAttribute("href"));
                }
            } catch (NoSuchElementException e) {
                print("Ignore if anchor element not found");
            }
        }

        return emailDetails;
    }




}
