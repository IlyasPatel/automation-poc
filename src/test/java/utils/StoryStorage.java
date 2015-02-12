package utils;

import com.efinancialcareers.core.domain.validation.ValidationUtils;
import com.efinancialcareers.myefc.qa.testDataUtils.factory.StoryDataLoaderFactory;
import com.efinancialcareers.myefc.qa.utils.Story;
import com.efinancialcareers.myefc.qa.utils.Suite;
import com.efinancialcareers.myefc.qa.utils.bo.PropertiesLoader;
import com.efinancialcareers.myefc.qa.utils.fo.FoPropertiesLoader;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.jbehave.core.io.StoryFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

/**
 * Created by ilyas.patel on 14/05/2014.
 */
public final class StoryStorage {

    private static final Logger LOGGER = LoggerFactory.getLogger(StoryStorage.class);
    private static final String FOLDER = FoPropertiesLoader.getInstance().getStrProperty("suiteFolder");
    private Suite completeSuite;

    private static final StoryStorage INSTANCE = new StoryStorage();

    public static StoryStorage getInstance() {
        return INSTANCE;
    }

    public List<String> getStoriesBySuiteName(String xmlFileName, String suiteName) {
        try {
            completeSuite = loadStories(xmlFileName, suiteName);
            loadStoryDatasets();

            return getStoriesPaths(completeSuite);
        } catch (Exception e) {
            LOGGER.error("\n\n* Most likely cause, story file does not exist or dataset failed to be injected. *\n\n");
            e.printStackTrace();
        }

        return Lists.newArrayList();
    }

    public List<String> getStoriesPaths(Suite suite) {
        return Lists.transform(Lists.newArrayList(getStoriesIncluded(suite)),
                new Function<Story, String>() {
                    @Nullable
                    @Override
                    public String apply(@Nullable Story input) {
                        return input != null ? input.getStoryFilePath() : null;
                    }
                });
    }

    private Collection<Story> getStoriesIncluded(Suite suite) {
        return Maps.filterValues(suite.getSuiteMap(), new Predicate<Story>() {
            @Override
            public boolean apply(@Nullable Story input) {
                return input != null && input.isInclude();
            }
        }).values();
    }

    private void loadStoryDatasets() {
        Map<String, Story> allStories = completeSuite.getSuiteMap();

        if (completeSuite.getShareDataSets() != null && completeSuite.getShareDataSets().size() > 0) {
            StoryDataLoaderFactory.getDataUtilsLoader().insertSharedDataSet(completeSuite.getShareDataSets());
        }

        for(Map.Entry<String, Story> entry: allStories.entrySet()) {
            Story story = entry.getValue();
            if (story.isInclude()) {
                StoryDataLoaderFactory.getDataUtilsLoader().insertDataset(story);
            }
        }
    }

    private Suite loadStories(String xmlFileName, String suiteName) throws Exception {
        Suite suite = new Suite();

        fillMapFromSuite(suite, getSuiteFilesInFolder(FOLDER, xmlFileName), suiteName);

        return suite;
    }

    private File getSuiteFilesInFolder(String folderName, String suiteFile) {
        return FileUtils.getFile(new File(folderName), suiteFile);
    }

    private void fillMapFromSuite(@Nonnull Suite suite, @Nonnull File xmlSuiteFile, String suiteName) throws Exception {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlSuiteFile);
            doc.getDocumentElement().normalize();

            NodeList suiteList = doc.getElementsByTagName("suite");
            addSharedDatasetToSuite(suite, doc);

            for (int i = 0; i < suiteList.getLength(); i++) {
                Node suiteNode = suiteList.item(i);

                if (suiteNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element suiteElement = (Element) suiteNode;
                    String suiteNameInFile = suiteElement.getAttribute("name");

                    if (suiteNameInFile.equalsIgnoreCase(suiteName)) {
                        NodeList storyList = ((Element) suiteNode).getElementsByTagName("story");

                        for (int j = 0; j < storyList.getLength(); j++) {
                            Node storyNode = storyList.item(j);

                            if (storyNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element storyElement = (Element) storyNode;
                                String storyName = storyElement.getAttribute("name");

                                Story story = new Story(storyName,
                                        isStoryIncluded(storyElement.getAttribute("include")),
                                        getPath(storyName),
                                        getDatasets(storyElement.getAttribute("datasets")),
                                        getDatasets(storyElement.getAttribute("data")));

                                suite.getSuiteMap().put(storyName, story);
                            }
                        }
                    }
                }
            }


        } catch (ParserConfigurationException e) {
            propagateException(format("Exception while reading file %s", xmlSuiteFile.getAbsolutePath()), e);
        } catch (SAXException e) {
            propagateException(format("Exception while reading file %s", xmlSuiteFile.getAbsolutePath()), e);
        } catch (IOException e) {
            propagateException(format("Exception while reading file %s", xmlSuiteFile.getAbsolutePath()), e);
        }
    }

    private void addSharedDatasetToSuite(Suite suite, Document doc) {
        List<String> nodes = getAllStoriesDataSet(doc.getElementsByTagName("dataSets").item(0));

        if (nodes != null) {
            suite.getShareDataSets().addAll(nodes);
        }
    }

    private List<String> getAllStoriesDataSet(Node dataSetNode){
        String nodeValue = dataSetNode.getFirstChild().getNodeValue().replaceAll("\\s", "");

        if (!ValidationUtils.isEmpty(nodeValue)) {
            return Arrays.asList(nodeValue.split(";"));
        }

        return null;
    }

    private boolean isStoryIncluded(String num) {
        return getBool(num);
    }

    private String getPath(String name) {
        String path = getFullPath(name);
        return path.substring(0, path.lastIndexOf(name));
    }

    private String getFullPath(String name) {
        return getFirstNotNull(new StoryFinder()
                .findPaths(codeLocationFromClass(this.getClass()),
                        Lists.newArrayList("**/" + name),
                        Lists.<String>newArrayList()));
    }

    private List<String> getDatasets(String value) {
        List<String> list = Lists.newArrayList();
        if (StringUtils.isNotBlank(value)) {
            list.addAll(Arrays.asList(value.split(";")));
        }
        return list;
    }

    private String getFirstNotNull(List<String> col) {
        return col != null && !col.isEmpty() ? col.get(0) : null;
    }

    private boolean getBool(String num) {
        return !"0".equals(num);
    }

    private void propagateException(String message, Exception t) throws Exception {
        LOGGER.error(message, t);
        throw t;
    }

    /**
     * Get story by name
     *
     * @param name name
     * @return story
     */
    public Story getStoryByName(@Nonnull String name) {
        return completeSuite.getSuiteMap().get(name);
    }
}
