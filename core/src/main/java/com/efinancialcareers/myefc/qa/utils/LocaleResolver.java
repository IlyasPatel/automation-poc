package com.efinancialcareers.myefc.qa.utils;

import java.util.Locale;

/**
 * Created by ilyas.patel on 17/02/14.
 */
public final class LocaleResolver {

    private  LocaleResolver() {}

    /**
     * Resolve locale by URL and environment
     * @param url url
     * @param environment environment
     * @return Locale
     */
    public static Locale resolveLocale(String url, String environment) {
        return SiteConfigurator.INSTANCE.getLocaleByUrl(url, environment);
    }


}
