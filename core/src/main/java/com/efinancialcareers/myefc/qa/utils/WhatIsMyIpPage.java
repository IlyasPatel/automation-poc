package com.efinancialcareers.myefc.qa.utils;

import com.efinancialcareers.myefc.qa.desktop.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: ilyas.patel
 * Date: 27/11/13
 * Time: 15:16
 */
public class WhatIsMyIpPage extends BasePage {

    private static final Pattern GET_COUNTRY_CODE = Pattern.compile("([a-zA-Z]{2})");

    @FindBy(css = "#ip-box .the-country")
    private WebElementFacade countryElement;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public WhatIsMyIpPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get country
     * @return Country found
     */
    public String getCountry() {
        return getCountryCodeFrom(countryElement.getTextValue()).toUpperCase();
    }

    private String getCountryCodeFrom(String str) {
        Matcher matcher = GET_COUNTRY_CODE.matcher(str);
        matcher.find();

        return matcher.group(0);
    }
}
