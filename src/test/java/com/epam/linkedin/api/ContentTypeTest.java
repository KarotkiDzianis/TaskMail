package com.epam.linkedin.api;

import com.epam.linkedin.api.steps.HttpClientSteps;
import com.epam.linkedin.properties.UrlsStorage;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContentTypeTest extends BaseTestApi {

    private final static String KEY = "86y8p41r0ad0gt";
    private final static String SECRET = "qPYPM8oLC5fCnllu";
    private final static String COMPANIES_LIST_URL = "?format=json";
    private final static String CONTENT_TYPE = "application/json;charset=UTF-8";

    @Test
    public void whatIsContentType() {
        HttpClientSteps httpClientSteps = new HttpClientSteps();
        httpClientSteps.authorization(KEY, SECRET, EMAIL, PASSWORD);
        OAuthRequest request = new OAuthRequest(Verb.GET, UrlsStorage.getCompaniesApiUrl() + COMPANIES_LIST_URL);
        httpClientSteps.getService().signRequest(httpClientSteps.getAccessToken(), request);
        Response response = request.send();
        Assert.assertEquals(response.getHeader("Content-Type"), CONTENT_TYPE);
    }
}