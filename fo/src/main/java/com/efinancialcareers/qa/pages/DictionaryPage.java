package com.efinancialcareers.qa.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static ch.lambdaj.Lambda.extract;
import static ch.lambdaj.Lambda.on;

/**
 * DictionaryPage
 */
@DefaultUrl("http://en.wiktionary.org/wiki/Wiktionary:Main_Page")
public class DictionaryPage extends PageObject {

    @FindBy(name = "search")
    private WebElement searchTerms;

    @FindBy(name = "go")
    private WebElement lookupButton;

    @FindBy(css = "ol li")
    private List<WebElement> definitionList;

    /**
     * Ctor.
     * @param driver driver
     */
    public DictionaryPage(WebDriver driver) {
        super(driver);
    }

    /**
     * enterKeywords
     * @param keyword keyword
     */
    public void enterKeywords(String keyword) {
        $(searchTerms).type(keyword);
    }

    /**
     * lookupTerms
     */
    public void lookupTerms() {
        $(lookupButton).click();
    }

    public Iterable<String> getDefinitions() {
        return extract(definitionList, on(WebElement.class).getText());
    }
}
