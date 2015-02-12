package com.efinancialcareers.myefc.qa.desktop;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by ilyas.patel on 15/09/2014.
 */
public class ProfileWorkingInTheGulfSectionPage extends BasePage {

    private final String editLinkSelector = "#WORKING_IN_THE_GULF a.edit";

    @FindBy(id = "GENDER")
    private WebElementFacade gender;

    @FindBy(id = "YEAR_OF_BIRTH")
    private WebElementFacade birth;

    @FindBy(xpath = "//select[contains(@name, 'isArabicFirstLanguage')]")
    private WebElementFacade isArabicFirstLanguage;

    @FindBy(css = "#WORKING_IN_THE_GULF span[data-tile='isArabicFirstLanguagePreviewValue']")
    private WebElementFacade isArabicFirstLanguagePreviewText;

    @FindBy(css = editLinkSelector)
    private WebElementFacade editLink;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public ProfileWorkingInTheGulfSectionPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get Arabic language text from preview
     * @return Is Arabic first language
     */
    public String getArabicFirstLanguageTextFromPreview() {
        scrollUntilElementIsVisible(isArabicFirstLanguagePreviewText);
        return isArabicFirstLanguagePreviewText.getTextValue();
    }

    public void edit() {
        if (findAll(editLinkSelector).size() != 0) {
            scrollUntilElementIsVisible(editLink);
            clickOn(editLink);
        }
    }
}
