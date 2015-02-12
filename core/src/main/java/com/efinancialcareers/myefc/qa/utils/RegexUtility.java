package com.efinancialcareers.myefc.qa.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ilyas.patel on 25/02/14.
 */
public final class RegexUtility {

    private static final String REMOVE_HTML_ENT = "[^a-zA-Z0-9%]";
    private static final Pattern PATTERN_JOB_ID = Pattern.compile("([0-9]+)");
    private static final Pattern GET_INVENTORY = Pattern.compile("[0-9]+/[0-9]+");

    private RegexUtility() {
    }

    /**
     * Get bin count from facet value string, e.g. Asset Management (20)
     * @param facetValue Facet value
     * @return Bin count
     */
    public static int getBinCountFrom(String facetValue) {
        Pattern p = Pattern.compile("\\((\\d+)\\)");
        Matcher m = p.matcher(facetValue);
        m.find();

        return Integer.valueOf(m.group(1));
    }

    /**
     * Remove whitespace and bad characters from a string.
     * @param str String
     * @return Cleaned string
     */
    public static String removeWhiteSpaceFrom(String str) {
        return str.replaceAll(REMOVE_HTML_ENT, "");
    }

    /**
     * Remove value from a query string using the attibute name pre-pended with ampersand if required
     * @param queryString Query String
     * @param key Attribute name
     * @return cleaned query string
     */
    public static String removeValueFromQueryString(String queryString, String key) {
        String pattern = "(" + key + "=)[^&]*";

        return queryString.replaceAll(pattern, "$1");
    }

    /**
     * Remove value from a query string using the attibute name pre-pended with ampersand if required
     * @param queryString Query String
     * @param key Attribute name
     * @return cleaned query string
     */
    public static String removeFirstValueFromQueryString(String queryString, String key) {
        String pattern = "(" + key + "=)[^&]*";

        return queryString.replaceFirst(pattern, "$1");
    }

    public static String replaceFirstValueFromQueryString(String queryString, String key, String replacement) {
        String pattern = "(" + key + "=)([^&]*)";

        return queryString.replaceFirst(pattern, "$1" + replacement);
    }

    /**
     * Get job id from URL
     * @param url URL
     * @return Job Id
     */
    public static long getJobIdFromUrl(String url) {
        Matcher matcher = PATTERN_JOB_ID.matcher(url);
        matcher.find();

        return Long.parseLong(matcher.group(1));
    }

    /**
     * Completely remove all keys and values from a query
     * @param queryString Query String
     * @param key Attribute name
     * @return cleaned query string
     */
    public static String removeAllPairsFromQueryString(String queryString, String key) {
        String pattern = String.format("%s=\\d+&", key);

        return queryString.replaceAll(pattern, "");
    }

    /**
     * Gets inventory values from a string on BO UI, e.g. 79/100 Slot Global
     * @param inventory String from UI
     * @return Inventory values
     */
    public static String getInventory(String inventory) {
        Matcher matcher = GET_INVENTORY.matcher(inventory);
        matcher.find();

        return matcher.group(0);
    }

}
