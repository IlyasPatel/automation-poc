import com.efinancialcareers.jbehave.qa.utils.StoryStorage;
import net.serenitybdd.jbehave.SerenityStories;

public class BaseTestSuiteParent extends SerenityStories {

    protected static final StoryStorage STORY_STORAGE = StoryStorage.getInstance();

    public BaseTestSuiteParent() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
    }
}
