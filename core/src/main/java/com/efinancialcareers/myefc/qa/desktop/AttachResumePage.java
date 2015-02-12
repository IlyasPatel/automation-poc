package com.efinancialcareers.myefc.qa.desktop;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ilyas.patel on 19/03/14.
 */
public class AttachResumePage extends BasePage {

    @FindBy(css = "#main .attachcv a")
    private WebElementFacade attachCV;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public AttachResumePage(WebDriver driver) {
        super(driver);
    }

    public String getAttachResumeHref() {
        return attachCV.getAttribute("href");
    }
}
