package com.efinancialcareers.myefc.qa.desktop;

import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ilyas.patel on 04/02/14.
 */
public class LocationLandingPage extends JobSearchResultsPage {

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public LocationLandingPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get location Id
     * @return locationId
     */
    public Long getLocationId() {
        String url = super.getCurrentUrl();

        if (url.contains(".cy")) {
            return getLocationIdFromSeoFriendlyURL(url);
        }

        return getLocationIdFromUrl(url);
    }

    public Long getLocationIdForCountry() {
        String url = super.getCurrentUrl();

        return getLocationIdForCountryFromSeoFriendlyURL(url);
    }

    public Long getLocationIdForCity() {
        String url = super.getCurrentUrl();

        return getLocationIdForCityFromSeoFriendlyURL(url);
    }

    private Long getLocationIdFromSeoFriendlyURL(String url) {
        Pattern pattern = Pattern.compile("/.*\\.cy([0-9]+)");

        Matcher matcher = pattern.matcher(url);
        matcher.find();

        return Long.parseLong(matcher.group(1));
    }

    private Long getLocationIdForCountryFromSeoFriendlyURL(String url) {
        Pattern pattern = Pattern.compile("/.*\\.co([0-9]+)");

        Matcher matcher = pattern.matcher(url);
        matcher.find();

        return Long.parseLong(matcher.group(1));
    }

    private Long getLocationIdForCityFromSeoFriendlyURL(String url) {
        Pattern pattern = Pattern.compile("/.*\\.cy([0-9]+)");

        Matcher matcher = pattern.matcher(url);
        matcher.find();

        return Long.parseLong(matcher.group(1));
    }

    private Long getLocationIdFromUrl(String url) {
        Pattern pattern = Pattern.compile("/.*filterGroupForm.locations=([0-9]+)");

        Matcher matcher = pattern.matcher(url);
        matcher.find();

        return Long.parseLong(matcher.group(1));
    }
}
