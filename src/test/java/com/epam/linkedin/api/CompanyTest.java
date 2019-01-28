package com.epam.linkedin.api;

import com.epam.linkedin.api.steps.HttpClientSteps;
import com.epam.linkedin.properties.UrlsStorage;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;
import org.testng.annotations.Test;

import java.util.List;

public class CompanyTest extends BaseTestApi {

    private final static int SUCCESS_CODE = 200;
    private final static String COMPANIES_LIST_URL = "?format=json&is-company-admin=true";
    private final static String FOLLOWERS_STATISTIC_URL = "/12634317/is-company-share-enabled?format=json";
    private final static String COMPANY_URL = "/12635258/relation-to-viewer/is-company-share-enabled?format=json";
    private final static List<String> COMPANY_NAMES = List.of("Hello World Company", "How Are You Doing Company", "I Am Fine Company");

    @Test
    public void isUserIsAdminOfTheseCompaniesTest() {
        HttpClientSteps httpClientSteps = new HttpClientSteps();
        httpClientSteps.authorization(KEY, SECRET, EMAIL, PASSWORD);
        OAuthRequest request = new OAuthRequest(Verb.GET, UrlsStorage.getCompaniesApiUrl() + COMPANIES_LIST_URL);
        httpClientSteps.getService().signRequest(httpClientSteps.getAccessToken(), request);
        Response response = request.send();
        httpClientSteps.checkIfUserIsAdminOfCompanies(COMPANY_NAMES, response.getBody());
    }

    @Test
    public void ifUserIsAdminOfTheCompanyTest() {
        HttpClientSteps httpClientSteps = new HttpClientSteps();
        httpClientSteps.authorization(KEY, SECRET, EMAIL, PASSWORD);
        OAuthRequest request = new OAuthRequest(Verb.GET, UrlsStorage.getCompaniesApiUrl() + COMPANY_URL);
        httpClientSteps.getService().signRequest(httpClientSteps.getAccessToken(), request);
        Response response = request.send();
        httpClientSteps.checkIfUserIsAdminOfCompany(SUCCESS_CODE, response.getCode());
    }

    @Test
    public void companySharingIsEnabledTest() {
        HttpClientSteps httpClientSteps = new HttpClientSteps();
        httpClientSteps.authorization(KEY, SECRET, EMAIL, PASSWORD);
        OAuthRequest request = new OAuthRequest(Verb.GET, UrlsStorage.getCompaniesApiUrl() + FOLLOWERS_STATISTIC_URL);
        httpClientSteps.getService().signRequest(httpClientSteps.getAccessToken(), request);
        Response response = request.send();
        httpClientSteps.checkIfCompanySharingIsEnabled(response.getBody());
    }
}
