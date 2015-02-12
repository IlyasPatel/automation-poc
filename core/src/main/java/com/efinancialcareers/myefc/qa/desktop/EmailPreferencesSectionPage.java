package com.efinancialcareers.myefc.qa.desktop;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by ilyas.patel on 08/09/2014.
 */
public class EmailPreferencesSectionPage extends BasePage {

    @FindBy(id = "receiveNewsLetters")
    private WebElementFacade receiveInternalMessages;

    @FindBy(id = "receiveEmails")
    private WebElementFacade receiveThirdPartyMessages;

    @FindBy(name = "emailFormat")
    private List<WebElement> emailFormats;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public EmailPreferencesSectionPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get internal messages value
     * @return Is checked
     */
    public String getInternalMessagesValue() {
        return receiveInternalMessages.getAttribute("checked");
    }

    /**
     * Get internal messages value
     * @return Is checked
     */
    public String getThirdPartyMessagesValue() {
        return receiveThirdPartyMessages.getAttribute("checked");
    }

    /**
     * Get selected email format value
     * @return value
     */
    public String getEmailFormat() {
        for (WebElement emailFormat : emailFormats) {
            if (emailFormat.isSelected()) {
                return emailFormat.getAttribute("value");
            }
        }

        return "";
    }
}
