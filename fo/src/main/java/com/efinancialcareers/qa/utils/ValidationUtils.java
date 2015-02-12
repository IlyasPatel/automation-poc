package com.efinancialcareers.qa.utils;

public class ValidationUtils {

    /**
     * Checks is string is null or empty.
     *
     * @param text text
     * @return empty
     */
    public static boolean isEmpty(CharSequence text) {
        return length(text) == 0;
    }

    /**
     * Returns text lenght.
     *
     * @param text text
     * @return length.
     */
    public static int length(CharSequence text) {
        return text == null ? 0 : text.length();
    }

}
