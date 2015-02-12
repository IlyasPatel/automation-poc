package com.efinancialcareers.myefc.qa.utils;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Ordering;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by ilyas.patel on 09/05/14.
 */
public final class QAStringUtils {

    private static final int RANDOM_STRING_LENGTH = 10;
    protected static final Random RANDOM = new Random();

    private QAStringUtils() {}

    /**
     * Sorts a delimited string into natural order
     * @param delimitedList delimitedList
     * @param delimiter delimiter
     * @return Sorted string
     */
    public static String sortDelimitedStringToNaturalOrder(String delimitedList, String delimiter) {
        return Joiner.on(",").join(Ordering.natural().onResultOf(new Function<String, String>() {
            @Override
            public String apply(String from) {
                return from;
            }
        }).sortedCopy(Arrays.asList(delimitedList.split(delimiter))));
    }

    public static String getRandomString() {
        return RandomStringUtils.randomAlphanumeric(RANDOM_STRING_LENGTH);
    }

    /**
     * Get any entity from list passed in
     * @param entities entities
     * @param <T> Anything
     * @return Single random object from list
     */
    public static <T extends Object> T getRandomEntity(List<T> entities){
        int value = RANDOM.nextInt(entities.size());
        return entities.get(value);
    }

    public static String makeLocationSafeToEnter(String location) {
        return location.split(",")[0].trim();
    }
}
