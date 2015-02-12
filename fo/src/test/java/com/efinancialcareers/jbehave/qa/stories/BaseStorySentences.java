package com.efinancialcareers.jbehave.qa.stories;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseStorySentences {

    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseStorySentences.class);

    @AfterStory
    public void checkErrorCollector() throws Throwable {
    }

    @AfterScenario
    public void afterScenario() {
    }
}
