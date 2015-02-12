package com.efinancialcareers.jbehave.qa;

import org.junit.runner.RunWith;

import java.util.List;

@RunWith(RedesignThucydidesReportingRunner.class)
public class TestSuiteLocalDevelopment extends BaseTestSuiteParent {

    @Override
    public List<String> storyPaths() {
        return STORY_STORAGE.getStoriesBySuiteName("suiteFOLocal.xml", "local");
    }
}
