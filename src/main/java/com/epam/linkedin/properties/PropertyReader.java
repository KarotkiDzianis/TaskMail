package com.epam.linkedin.properties;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Class for getting variables from property file
 */
@Log4j2
public final class PropertyReader {

    private HashMap<String, Properties> propertiesHashMap = new HashMap<>();

    private PropertyReader() {
    }

    public static PropertyReader getInstance() {
        return LazyHolder.propertyReader;
    }

    /**
     * Method allows to read data from property file
     *
     * @param fileName is the key of the data in the property file
     */
    @SneakyThrows(IOException.class)
    private void readPropertyFile(String fileName) {
        if (!propertiesHashMap.containsKey(fileName)) {
            Properties prop = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
            prop.load(inputStream);
            propertiesHashMap.put(fileName, prop);
        }
    }

    /**
     * Method allows to get data from property file
     *
     * @param propKey is the key of the data in the property file
     * @return the data
     */
    public String getProperty(String fileName, String propKey) {
        readPropertyFile(fileName);
        return propertiesHashMap.get(fileName).getProperty(propKey);
    }

    /**
     * Method allows to get data from property file
     *
     * @param fileName is a name of the property file
     * @return the data
     */
    public Map<String, String> getProperties(String fileName) {
        readPropertyFile(fileName);
        return propertiesHashMap.get(fileName).entrySet().stream().collect(
                Collectors.toMap(
                        e -> String.valueOf(e.getKey()),
                        e -> String.valueOf(e.getValue())
                )
        );
    }

    private static class LazyHolder {
        static final PropertyReader propertyReader = new PropertyReader();
    }
}