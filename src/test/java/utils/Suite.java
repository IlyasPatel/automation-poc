package utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * Created by ilyas.patel on 16/05/2014.
 */
public class Suite {

    private Map<String, Story> suiteMap;
    private List<String> shareDataSets;

    /**
     * Constructor
     */
    public Suite() {
        this.suiteMap = Maps.newLinkedHashMap();
        this.shareDataSets = Lists.newArrayList();
    }

    public Map<String, Story> getSuiteMap() {
        return suiteMap;
    }

    public void setSuiteMap(Map<String, Story> suiteMap) {
        this.suiteMap = suiteMap;
    }

    public List<String> getShareDataSets() {
        return shareDataSets;
    }

    public void setShareDataSets(List<String> shareDataSets) {
        this.shareDataSets = shareDataSets;
    }
}
