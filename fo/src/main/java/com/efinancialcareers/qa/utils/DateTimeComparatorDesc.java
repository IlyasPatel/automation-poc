package com.efinancialcareers.qa.utils;

import org.joda.time.DateTime;

import java.util.Comparator;

/**
 * User: ilyas.patel
 * Date: 06/10/13
 * Time: 03:00
 */
public class DateTimeComparatorDesc implements Comparator<DateTime> {

    /**
     * Compares dates to sort in descending order
     * @param dateTime1 dateTime1
     * @param dateTime2 dateTime2
     * @return comparison
     */
    public int compare(DateTime dateTime1, DateTime dateTime2) {
        return dateTime2.compareTo(dateTime1);
    }

}
