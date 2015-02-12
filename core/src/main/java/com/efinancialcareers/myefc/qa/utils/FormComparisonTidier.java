package com.efinancialcareers.myefc.qa.utils;

import org.apache.commons.collections.MultiMap;

import java.util.Map;

/**
 * Created by ilyas.patel on 25/06/2014.
 */
public interface FormComparisonTidier {

    void removeFieldsFromExpected(MultiMap map);

    void removeFieldsFromActual(MultiMap map);
}
