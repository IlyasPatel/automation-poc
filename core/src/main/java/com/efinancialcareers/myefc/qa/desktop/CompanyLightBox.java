package com.efinancialcareers.myefc.qa.desktop;

import com.beust.jcommander.internal.Lists;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * User: jon.neville
 * Date: 14/11/14
 * Time: 09:14
 */
public class CompanyLightBox extends BasePage {

    @FindBy(className = "modal-title")
    private WebElementFacade headerText;

    @FindBy(css = "div.modal-header button.close")
    private WebElementFacade closeWindow;

    /**
     * Constructor
     *
     * @param driver WebDriver
     */
    public CompanyLightBox(WebDriver driver) {
        super(driver);
    }

    /**
     * Get page header title
     * @return title
     */
    public String getHeader() {
        return headerText.getTextValue().replaceAll("\\n", " ");
    }
}