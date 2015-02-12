package com.efinancialcareers.myefc.qa.desktop;

import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ilyas.patel on 11/09/2014.
 */
public class BrandLandingPage extends JobSearchResultsPage {


    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public BrandLandingPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get location Id
     * @return locationId
     */
    public Long getBrandId() {
        String url = super.getCurrentUrl();

        return getBrandIdFromSeoFriendlyURL(url);
    }

    private Long getBrandIdFromSeoFriendlyURL(String url) {
        Pattern pattern = Pattern.compile("/.*\\.br([0-9]+)");

        Matcher matcher = pattern.matcher(url);
        matcher.find();

        return Long.parseLong(matcher.group(1));
    }
}
