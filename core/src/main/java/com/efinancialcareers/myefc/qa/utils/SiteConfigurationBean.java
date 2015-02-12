package com.efinancialcareers.myefc.qa.utils;

import java.text.MessageFormat;

/**
 * User: ilyas.patel
 * Date: 03/09/13
 * Time: 11:14
 */
public class SiteConfigurationBean {

    private String homepageUrl;
    private String[] labels;
    private String language;
    private String localeUri;
    private String network;
    private String locale;
    private Long defaultCountryId;
    private String defaultCountryName;
    private String[] defaultNewsletterSubscriptions;

    /**
     * Gets homepage url
     * @param environment environment
     * @return homepage uri
     */
    public String getHomepageUrl(String environment) {
        return MessageFormat.format(homepageUrl, environment);
    }

    public String[] getLabels() {
        return labels;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLocaleUri() {
        return localeUri;
    }

    public void setHomepageUrl(String homepageUrl) {
        this.homepageUrl = homepageUrl;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public void setLocaleUri(String localeUri) {
        this.localeUri = localeUri;
    }

    public String getNetwork() {
        return network;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getDefaultCountryName() {
        return defaultCountryName;
    }

    public void setDefaultCountryName(String defaultCountryName) {
        this.defaultCountryName = defaultCountryName;
    }

    public String getHomepageUrl() {
        return homepageUrl;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public Long getDefaultCountryId() {
        return defaultCountryId;
    }

    public void setDefaultCountryId(Long defaultCountryId) {
        this.defaultCountryId = defaultCountryId;
    }

    public String[] getDefaultNewsletterSubscriptions() {
        return defaultNewsletterSubscriptions;
    }

    public void setDefaultNewsletterSubscriptions(String[] defaultNewsletterSubscriptions) {
        this.defaultNewsletterSubscriptions = defaultNewsletterSubscriptions;
    }
}
