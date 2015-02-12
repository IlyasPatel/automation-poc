package com.efinancialcareers.jbehave.qa;

import com.efinancialcareers.jbehave.qa.utils.StoryStorage;
import com.efinancialcareers.myefc.qa.utils.Story;
import net.thucydides.core.steps.StepEventBus;
import net.serenitybdd.jbehave.runners.SerenityReportingRunner;
import org.jbehave.core.ConfigurableEmbedder;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: ilyas.patel
 * Date: 07/08/13
 * Time: 15:27
 */
public class RedesignThucydidesReportingRunner extends SerenityReportingRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedesignThucydidesReportingRunner.class);
    private static final StoryStorage STORY_STORAGE = StoryStorage.getInstance();
    private static String TEST_SENTENCE = "";

    public RedesignThucydidesReportingRunner(Class<? extends ConfigurableEmbedder> testClass) throws Throwable {
        super(testClass);
    }

    /**
     * Ctor.
     * @param testClass testClass
     * @param embedder embedder
     * @throws Throwable exception
     */
    public RedesignThucydidesReportingRunner(
            Class<? extends ConfigurableEmbedder> testClass, ConfigurableEmbedder embedder
    ) throws Throwable {
        super(testClass, embedder);
    }

    @Override
    public void run(final RunNotifier notifier) {
        notifier.addListener(new RunListener() {
            @Override
            public void testStarted(Description description) throws Exception {
                Story story = STORY_STORAGE.getStoryByName(description.getDisplayName());
                //StepEventBus.getEventBus().registerListener(new FlashStepListener());

                if (story != null) {
                    try {
                        //StoryDataLoaderFactory.getDataLoader(story.getDatasetPaths()).pushDataset(story);
                    } catch (Throwable e) {
                        try {
                            StepEventBus.getEventBus().testFailed(e);
                        } finally {
                            notifier.pleaseStop();
                            notifier.fireTestFailure(new Failure(description, e));
                        }
                    }
                }
            }

            @Override
            public void testFinished(Description description) throws Exception {
                if (!TEST_SENTENCE.equalsIgnoreCase(description.getDisplayName())) {
                    TEST_SENTENCE = description.getDisplayName();
                }
            }
        });

        super.run(notifier);
    }

}
