package com.efinancialcareers.myefc.qa.email;

import com.efinancialcareers.myefc.qa.desktop.BasePage;
import com.efinancialcareers.myefc.qa.utils.fo.WaitFor;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.MessageFormat;
import java.util.List;

/**
 * Created by ilyas.patel on 06/02/14.
 */
public class MailinatorInboxPage extends BasePage implements InboxPage {

    public static final String MAILINATOR_TOKEN = "token=2c5361364a5b4393a924d1fc0ac2ce82";

    @FindBy(css = "#mailcontainer li")
    private List<WebElement> inboxList;

    @FindBy(css = "#mailcontainer li div.subject")
    private List<WebElement> allEmailSubjects;

    @FindBy(css = "#mailshowdivbody iframe")
    private WebElementFacade emailBody;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public MailinatorInboxPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitUntilEmailHasArrived(String email) {
        super.setDefaultBaseUrl(getInboxUrl(email));
        super.open();

        WebDriverWait wait = new WebDriverWait(getDriver(), WaitFor.THREE_MINUTES.getSeconds());

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return inboxList.size() > 0 && inboxList.get(0).isDisplayed();
            }
        });
    }

    @Override
    public void waitUntilExpectedNumberOfEmailsHaveArrived(String email, final int numberOfEmailsToWaitFor) {
        super.setDefaultBaseUrl(getInboxUrl(email));
        super.open();

        WebDriverWait wait = new WebDriverWait(getDriver(), WaitFor.THREE_MINUTES.getSeconds());

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return inboxList.size() >= numberOfEmailsToWaitFor && inboxList.get(0).isDisplayed();
            }
        });
    }

    @Override
    public void openEmailWithSubject(String subject) {
        clickOn(getEmailBasedOnSubject(subject).findElement(By.tagName("a")));
        super.switchToFrame(emailBody);
        assertFooterAppears();
    }

    @Override
    public void openEmailWithSubjectAndNoEfcContent(String subject) {
        clickOn(getEmailBasedOnSubject(subject).findElement(By.tagName("a")));
        super.switchToFrame(emailBody);
    }

    @Override
    public List<WebElement> getAllEmailSubjects() {
        return allEmailSubjects;
    }

    @Override
    public int getInboxSize() {
        return inboxList.size();
    }

    private void shouldOnlyBeOneEmailForNewRegisteredUser() {
        Assert.assertEquals(1, inboxList.size());
    }

    private void assertFooterAppears() {
        waitABit(WaitFor.TEN_SECONDS.getSeconds());
        //waitForTextToAppear(translationFacade.getTranslation("efc.ltd.footer"));
    }

    @Override
    public WebElement getEmailBasedOnSubject(String expectedSubject) {
        for (WebElement element : inboxList) {
            if (element.findElement(By.className("subject")).getText().equals(expectedSubject)) {
                return element;
            }
        }

        return null;
    }

    @Override
    public String getInboxUrl(String email) {
        String name = StringUtils.substringBefore(email, "@");
        String mailinatorAccountUrl = "https://www.mailinator.com/inbox.jsp?to={0}";

        mailinatorAccountUrl = MessageFormat.format(mailinatorAccountUrl, name);

        return mailinatorAccountUrl;
    }

    @Override
    public void openCSEmailWithSubject(String subject) {
        clickOn(getEmailBasedOnSubject(subject).findElement(By.tagName("a")));
        super.switchToFrame(emailBody);
    }
}
