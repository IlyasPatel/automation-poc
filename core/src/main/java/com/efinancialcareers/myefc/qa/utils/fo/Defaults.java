package com.efinancialcareers.myefc.qa.utils.fo;

public final class Defaults {
    private static final Defaults DEFAULTS = new Defaults();

    /** Solr Url */
    public static final String SOLR_URL = FoPropertiesLoader.getInstance().getStrProperty("solr-url");

    /** SMF Url */
    public static final String SMF_URL = FoPropertiesLoader.getInstance().getStrProperty("smf-url");

    /** Number of seconds to wait for Solr partial to run. Normally every 3 minutes on all environments */
    public static final Long TIME_TO_WAIT_SOLR_INDEX_UPDATE =
            Long.parseLong(
                    FoPropertiesLoader.getInstance().getStrProperty("time.to.wait.for.solr.index.update.in.seconds"));
    /** Default Locale */
    public static final String LANGUAGE = FoPropertiesLoader.getInstance().getStrProperty("default.language");

    /** Default Locale URI */
    public static final String LOCALE_URI = "uk-en";

    /** Default Locale */
    public static final String PSA_MAILER_URL = FoPropertiesLoader.getInstance().getStrProperty("psa.mailer.url");

    /** Default Locale */
    public static final int MAX_PAGES_TO_PAGINATE = 2;

    /** Website to determine IP address and display which country the tests are running in */
    public static final String WHATS_MY_IP_ADDRESS_URL = "http://www.whatismyip.com";

    /** Magic keyword used when creating random users */
    public static final String MAGIC_KEYWORD_FOR_EMAIL = "(dataset)";

    /** Default password for all users */
    public static final String PASSWORD = "testing123";

    public static Defaults getInstance() {
        return DEFAULTS;
    }

    private Defaults() {
    }
}
