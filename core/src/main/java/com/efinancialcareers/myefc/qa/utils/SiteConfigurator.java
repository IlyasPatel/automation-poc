package com.efinancialcareers.myefc.qa.utils;

import com.efinancialcareers.myefc.qa.utils.fo.Defaults;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

/**
 * User: ilyas.patel
 * Date: 03/09/13
 * Time: 11:28
 */
public enum SiteConfigurator {

    /**
     * Singleton
     */
    INSTANCE;

    private SiteConfigurationBean[] siteConfigurationBeans;
    private SiteConfigurationBean defaultSiteConfigurationBean;

    private SiteConfigurator() {

        Gson gson = new Gson();
        String output;
        StringBuilder json = new StringBuilder();

        File siteConfiguration = new File(ClassLoader.getSystemResource("siteConfiguration.json").getFile());

        try {
            BufferedReader br = new BufferedReader(new FileReader(siteConfiguration.getAbsolutePath()));

            while ((output = br.readLine()) != null) {
                json.append(output);
            }

            siteConfigurationBeans = gson.fromJson(json.toString(), SiteConfigurationBean[].class);

            /*for (SiteConfigurationBean siteConfigurationBean : siteConfigurationBeans) {
                siteConfigurationBean.setLocale(determineLocale(siteConfigurationBean.getLanguage()));
            }*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        defaultSiteConfigurationBean = new SiteConfigurationBean();
        defaultSiteConfigurationBean.setLanguage(Defaults.LANGUAGE);
        defaultSiteConfigurationBean.setLocaleUri(Defaults.LOCALE_URI);
    }

    /**
     * Get's homepage site url
     * @param siteLabel Site Label in json configuration file (uk-en, fr-fr, UK, etc)
     * @param environment environment
     * @return homepage url
     */
    public String getHomePageSiteUrl(String siteLabel, String environment) {

        String homepageUrl = getSiteConfigurationBean(siteLabel).getHomepageUrl(determineEnvironmentToUse(environment));

        return homepageUrl;
    }

    /**
     * Get's language uri, e.g. uk-en, fr-fr, etc
     * @param siteLabel Site Label in json configuration file (uk-en, fr-fr, UK, etc)
     * @return country uri
     */
    public String getLocaleUri(String siteLabel) {
        return getSiteConfigurationBean(siteLabel).getLocaleUri();
    }

    /**
     * Get's language, e.g. en, fr, etc
     * @param siteLabel Site Label in json configuration file (uk-en, fr-fr, UK, etc)
     * @return language
     */
    public String getLanguage(String siteLabel) {
        return getSiteConfigurationBean(siteLabel).getLanguage();
    }

    /**
     * Get's language, e.g. en, fr, etc
     * @param siteLabel Site Label in json configuration file (uk-en, fr-fr, UK, etc)
     * @return language
     */
    public Locale getLocaleBySiteLabel(String siteLabel) {
        String[] locale = getSiteConfigurationBean(siteLabel).getLocale().split("_");

        return new Locale(locale[0], locale[1]);
    }

    /**
     * Get's language, e.g. en, fr, etc
     * @param siteLabel Site Label in json configuration file (uk-en, fr-fr, UK, etc)
     * @return language
     */
    public Locale getLocaleByLanguage(String siteLabel) {
        return new Locale(siteLabel);
    }

    /**
     * Get Locale by site URL
     * @param url URL
     * @param environment environment
     * @return Locale
     */
    public Locale getLocaleByUrl(String url, String environment) {

        SiteConfigurationBean siteConfigurationBean = getSiteLabel(url, environment);

        String[] locale = siteConfigurationBean.getLocale().split("_");

        return new Locale(locale[0], locale[1]);
    }

    /**
     * Get Network
     * @param siteLabel Site Label in json configuration file (uk-en, fr-fr, UK, etc)
     * @return Network
     */
    public String getNetwork(String siteLabel) {
        return getSiteConfigurationBean(siteLabel).getNetwork();
    }

    /**
     * Get default country id for a site
     * @param siteLabel Site Label in json configuration file (uk-en, fr-fr, UK, etc)
     * @return Country Id
     */
    public long getDefaultCountryId(String siteLabel) {
        return getSiteConfigurationBean(siteLabel).getDefaultCountryId();
    }

    /**
     * Get default country name for a site
     * @param siteLabel Site Label in json configuration file (uk-en, fr-fr, UK, etc)
     * @return Country Name
     */
    public String getDefaultCountryName(String siteLabel) {
        return getSiteConfigurationBean(siteLabel).getDefaultCountryName();
    }

    /**
     * Get default country name for a site
     * @param siteLabel Site Label in json configuration file (uk-en, fr-fr, UK, etc)
     * @return Country Name
     */
    public String getDefaultLanguage(String siteLabel) {
        return getSiteConfigurationBean(siteLabel).getLanguage();
    }

    public String[] getDefaultNewsletterSubscriptions(String siteLabel) {
        return getSiteConfigurationBean(siteLabel).getDefaultNewsletterSubscriptions();
    }

    private SiteConfigurationBean getSiteConfigurationBean(String siteLabel) {
        for (SiteConfigurationBean siteConfigurationBean : siteConfigurationBeans) {
            if (siteConfigurationBean.getLocaleUri().equalsIgnoreCase(siteLabel)) {
                return siteConfigurationBean;
            }

            if (siteConfigurationBean.getLabels() != null) {
                for (String label : siteConfigurationBean.getLabels()) {
                    if (siteLabel.equalsIgnoreCase(label)) {
                        return siteConfigurationBean;
                    }
                }
            }
        }

        return null;
    }

    private SiteConfigurationBean getSiteLabel(String url, String environment) {
        for (SiteConfigurationBean siteConfigurationBean : siteConfigurationBeans) {

            String homepageUrl = siteConfigurationBean.getHomepageUrl(determineEnvironmentToUse(environment));

            if (url.startsWith(homepageUrl)) {
                return siteConfigurationBean;
            }
        }

        return defaultSiteConfigurationBean;
    }

    private String determineEnvironmentToUse(String environment) {
        String environmentToUse = "";

        if(environment == null || environment.length() == 0 || environment.equals("prod")) {
            environmentToUse = "";
        } else if (environment.contains("qa-app01")) {
            environmentToUse = ".qa";
        } else if (environment.contains("qa-app02")) {
            environmentToUse = ".qa2";
        } else if (environment.contains("qa-app03")) {
            environmentToUse = ".qa3";
        } else if (environment.contains("pilot")) {
            environmentToUse = ".pilot";
        } else {
            environmentToUse = "." + environment;
        }

        return environmentToUse;
    }

    private Locale determineLocale(String language) {
        if ("fr".equalsIgnoreCase(language)) {
            return Locale.FRENCH;
        } else if ("de".equalsIgnoreCase(language)) {
            return Locale.GERMAN;
        } else if ("us".equalsIgnoreCase(language)) {
            return Locale.US;
        }

        return Locale.ENGLISH;
    }


}
