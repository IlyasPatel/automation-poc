package com.efinancialcareers.myefc.qa.domain;

import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

/**
 * User: ilyas.patel
 * Date: 09/10/13
 * Time: 14:01
 */
public final class ClientServiceContactNumber {

    /**
     * Temporary Map to use to populate supported locales
     */
    private static final Map<String, String> CLIENT_SERVICE_TEMP_MAP = new HashMap<String, String>();

    static {
        CLIENT_SERVICE_TEMP_MAP.put("uk-en", "help@efinancialcareers.com");
        CLIENT_SERVICE_TEMP_MAP.put("au-en", "help@efinancialcareers.com.au");
        CLIENT_SERVICE_TEMP_MAP.put("be-nl", "help@efinancialcareers.com");
        CLIENT_SERVICE_TEMP_MAP.put("be-en", "help@efinancialcareers.com");
        CLIENT_SERVICE_TEMP_MAP.put("be-fr", "help@efinancialcareers.com");
        CLIENT_SERVICE_TEMP_MAP.put("za-en", "help@efinancialcareers.com");
        CLIENT_SERVICE_TEMP_MAP.put("ca-en", "help-ca@efinancialcareers.com");
        CLIENT_SERVICE_TEMP_MAP.put("fr-fr", "service-clients@efinancialcareers.fr");
        CLIENT_SERVICE_TEMP_MAP.put("fr-en", "service-clients@efinancialcareers.fr");
        CLIENT_SERVICE_TEMP_MAP.put("cn-en", "help@efinancialcareers.com");
        CLIENT_SERVICE_TEMP_MAP.put("cn-cn", "help@efinancialcareers.com");
        CLIENT_SERVICE_TEMP_MAP.put("dk-en", "help@efinancialcareers.com");
        CLIENT_SERVICE_TEMP_MAP.put("fi-en", "help@efinancialcareers.com");
        CLIENT_SERVICE_TEMP_MAP.put("hk-en", "help@efinancialcareers.hk");
        CLIENT_SERVICE_TEMP_MAP.put("de-de", "kundenservice@efinancialcareers.de");
        CLIENT_SERVICE_TEMP_MAP.put("de-en", "kundenservice@efinancialcareers.de");
        CLIENT_SERVICE_TEMP_MAP.put("ie-en", "help@efinancialcareers.com");
        CLIENT_SERVICE_TEMP_MAP.put("it-it", "info@efinancialcareers.it");
        CLIENT_SERVICE_TEMP_MAP.put("lu-fr", "help@efinancialcareers.com");
        CLIENT_SERVICE_TEMP_MAP.put("lu-en", "help@efinancialcareers.com");
        CLIENT_SERVICE_TEMP_MAP.put("lu-de", "help@efinancialcareers.com");
        CLIENT_SERVICE_TEMP_MAP.put("jp-en", "help@efinancialcareers.jp");
        CLIENT_SERVICE_TEMP_MAP.put("sg-en", "help@efinancialcareers.sg");
        CLIENT_SERVICE_TEMP_MAP.put("ch-fr", "kundendienst@efinancialcareers.ch");
        CLIENT_SERVICE_TEMP_MAP.put("ch-de", "kundendienst@efinancialcareers.ch");
        CLIENT_SERVICE_TEMP_MAP.put("ch-it", "kundendienst@efinancialcareers.ch");
        CLIENT_SERVICE_TEMP_MAP.put("us-en", "help-usa@efinancialcareers.com");
        CLIENT_SERVICE_TEMP_MAP.put("gulf-en", "help@efinancialcareers.com");
        CLIENT_SERVICE_TEMP_MAP.put("nl-nl", "help@efinancialcareers.com");
        CLIENT_SERVICE_TEMP_MAP.put("nl-en", "help@efinancialcareers.com");
        CLIENT_SERVICE_TEMP_MAP.put("no-en", "help@efinancialcareers.com");
        CLIENT_SERVICE_TEMP_MAP.put("ru-en", "help@efinancialcareers.com");
        CLIENT_SERVICE_TEMP_MAP.put("sc-en", "help@efinancialcareers.com");
        CLIENT_SERVICE_TEMP_MAP.put("se-en", "help@efinancialcareers.com");
        CLIENT_SERVICE_TEMP_MAP.put("my-en", "help@efinancialcareers.com");
    }

    private ClientServiceContactNumber() {}


    /**
     * Supported country with language in url.
     */
    public static final ImmutableMap<String, String> MYEFC_CLIENT_SERVICE_CONTACT_NUMBER =
            ImmutableMap.copyOf(CLIENT_SERVICE_TEMP_MAP);

    /**
     * Gets Locale using country and language in url
     * @param path path
     * @return locale
     */
    public static String getClientServiceContactNumber(String path) {

        if (path != null && path.length() > 0) {
            return MYEFC_CLIENT_SERVICE_CONTACT_NUMBER.get(path.toLowerCase());
        }

        return MYEFC_CLIENT_SERVICE_CONTACT_NUMBER.get("uk-en");
    }
}
