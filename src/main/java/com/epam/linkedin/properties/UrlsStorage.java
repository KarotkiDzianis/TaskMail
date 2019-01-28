package com.epam.linkedin.properties;

public class UrlsStorage {

    private static final String MAIN_PAGE_URL = "MAIN_PAGE_URL";
    private static final String HUB_ADDRESS = "HUB_ADDRESS";
    private static final String ANDROID_HUB_ADDRESS = "ANDROID_HUB_ADDRESS";
    private static final String COMPANIES_API_URL = "COMPANIES_API_URL";
    private static final String PEOPLE_API_URL = "PEOPLE_API_URL";
    private static final String FILE_NAME = "config.properties";

    public static String getMainPageUrl() {
        return PropertyReader.getInstance().getProperty(FILE_NAME, MAIN_PAGE_URL);
    }

    public static String getHubAddress() {
        return PropertyReader.getInstance().getProperty(FILE_NAME, HUB_ADDRESS);
    }

    public static String getAndroidHubAddress() {
        return PropertyReader.getInstance().getProperty(FILE_NAME, ANDROID_HUB_ADDRESS);
    }

    public static String getCompaniesApiUrl() {
        return PropertyReader.getInstance().getProperty(FILE_NAME, COMPANIES_API_URL);
    }

    public static String getPeopleApiUrl() {
        return PropertyReader.getInstance().getProperty(FILE_NAME, PEOPLE_API_URL);
    }
}