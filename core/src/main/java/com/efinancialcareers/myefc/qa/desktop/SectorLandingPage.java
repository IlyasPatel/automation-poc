package com.efinancialcareers.myefc.qa.desktop;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ilyas.patel on 04/02/14.
 */
public class SectorLandingPage extends JobSearchResultsPage {

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public SectorLandingPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get Sector Id
     * @return sector id
     */
    public int getSectorId() {
        Pattern pattern = Pattern.compile("/.*\\.o?s([0-9]{3})([0-9]*)");
        String url = super.getCurrentUrl();

        Matcher matcher = pattern.matcher(url);
        matcher.find();

        return Integer.parseInt(matcher.group(1));
    }

    public long getLocationIdForCountry() {
        Pattern pattern = Pattern.compile("/.*\\.o?s([0-9]{3})([0-9]*)");
        String url = super.getCurrentUrl();

        Matcher matcher = pattern.matcher(url);
        matcher.find();

        return Long.parseLong(matcher.group(2));
    }
}
