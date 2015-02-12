package com.efinancialcareers.jbehave.qa;

import org.junit.runner.RunWith;

import java.util.List;

/**
 * Created by ilyas.patel on 14/05/2014.
 */
@RunWith(RedesignThucydidesReportingRunner.class)
public class FO2TestSuiteFast extends BaseTestSuiteParent {

    @Override
    public List<String> storyPaths() {
        return STORY_STORAGE.getStoriesBySuiteName("suiteFO.xml", "suite2");
    }
}
