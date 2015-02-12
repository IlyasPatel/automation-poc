package com.efinancialcareers.qa.utils;

import org.joda.time.DateTime;

import java.util.Comparator;

/**
 * User: ilyas.patel
 * Date: 06/10/13
 * Time: 17:41
 */
public class DateTimeComparatorAsc implements Comparator<DateTime> {

    /**
     * Compares dates to sort in ascending order
     * @param dateTime1 dateTime1
     * @param dateTime2 dateTime2
     * @return comparison
     */
    public int compare(DateTime dateTime1, DateTime dateTime2) {
        return dateTime1.compareTo(dateTime2);
    }

}
