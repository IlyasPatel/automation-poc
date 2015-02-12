package com.efinancialcareers.myefc.qa.utils.fo;

import com.efinancialcareers.myefc.qa.utils.ValidationUtils;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.core.io.ClassPathResource;

import static java.lang.String.format;

/**
 * User: ilyas.patel
 * Date: 24/07/13
 * Time: 17:14
 */
public final class FoPropertiesLoader {

    private static final FoPropertiesLoader PROPERTIES_LOADER = new FoPropertiesLoader();
    private static final String DEFAULT_ENV = "qa-app01";
    private final PropertiesConfiguration properties = new PropertiesConfiguration();

    private FoPropertiesLoader() {
        String env = System.getProperty("environment.type");
        if (env == null) {
            env = DEFAULT_ENV;
        }

        try {
            properties.load(new ClassPathResource(format("test-fo-automation-ui-%s.properties", env)).getInputStream());
        } catch (Exception e) {
            throw new RuntimeException(format("Cannot load properties file for ENV = %s", env), e);
        }
    }

    public static FoPropertiesLoader getInstance() {
        return PROPERTIES_LOADER;
    }

    /**
     * Get string property
     *
     * @param name name
     * @return property value
     */
    public String getStrProperty(String name) {

        String overrideProperty = System.getProperty(name);

        if (!ValidationUtils.isEmpty(overrideProperty)) {
            return overrideProperty;
        }

        return (String) properties.getProperty(name);
    }

    public Boolean getBooleanProperty(String name) {

        String overrideProperty = System.getProperty(name);

        if (!ValidationUtils.isEmpty(overrideProperty)) {
            return Boolean.parseBoolean(overrideProperty);
        }

        String property = (String) properties.getProperty(name);

        if (!ValidationUtils.isEmpty(property)) {
            return Boolean.parseBoolean(property);
        }

        return false;
    }
}
