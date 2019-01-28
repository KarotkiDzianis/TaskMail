package com.epam.linkedin.mobile.data;

import com.epam.linkedin.properties.PropertyReader;

import java.util.Map;

public class MobileStorage {

    public static Map<String, String> getDataFromAndroidProperty(String pathToProperties) {
        return PropertyReader.getInstance().getProperties(pathToProperties);
    }
}