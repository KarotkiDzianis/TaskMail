package com.epam.linkedin.api;

import com.epam.linkedin.api.steps.HttpClientSteps;
import com.epam.linkedin.properties.UrlsStorage;
import com.epam.linkedin.utils.RandomUtils;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTestApi {

    private final static int BAD_REQUEST_CODE = 400;
    private final static String FIRST_NAME = "Linked";
    private final static String LAST_NAME = "Grach";
    private final static String SUCCESS = "Created";
    private final static String SPAM_MESSAGE = "Hello!";
    private final static String PROFILE_URL = "?format=json";
    private final static String SHARE_URL = "/shares?format=json";
    private final static String COMPANIES_LIST_URL = ":(id,num-connections,picture-url)?format=json";

    @Test
    public void profileDataCheckTest() {
        HttpClientSteps httpClientSteps = new HttpClientSteps();
        httpClientSteps.authorization(KEY, SECRET, EMAIL, PASSWORD);
        OAuthRequest request = new OAuthRequest(Verb.GET, UrlsStorage.getPeopleApiUrl() + PROFILE_URL);
        httpClientSteps.getService().signRequest(httpClientSteps.getAccessToken(), request);
        Response response = request.send();
        httpClientSteps.checkIfUserNamesAreCorrect(FIRST_NAME, LAST_NAME, response.getBody());
    }

    @Test
    public void listTest() {
        HttpClientSteps httpClientSteps = new HttpClientSteps();
        httpClientSteps.authorization(KEY, SECRET, EMAIL, PASSWORD);
        OAuthRequest request = new OAuthRequest(Verb.GET, UrlsStorage.getPeopleApiUrl() + COMPANIES_LIST_URL);
        httpClientSteps.getService().signRequest(httpClientSteps.getAccessToken(), request);
        Response response = request.send();
        httpClientSteps.viewConnections(response.getBody());
    }

    @Test
    public void correctContentShareTest() {
        HttpClientSteps httpClientSteps = new HttpClientSteps();
        httpClientSteps.authorization(KEY, SECRET, EMAIL, PASSWORD);
        OAuthRequest request = new OAuthRequest(Verb.POST, UrlsStorage.getPeopleApiUrl() + SHARE_URL);
        request.addHeader("Content-Type", "text/xml");
        request.addPayload(httpClientSteps.addUserShare(RandomUtils.getRandomString(7)).asXML());
        httpClientSteps.getService().signRequest(httpClientSteps.getAccessToken(), request);
        Response response = request.send();
        httpClientSteps.checkIfCommentPosted(SUCCESS, response.getMessage());
    }

    @Test
    public void duplicateContentSharesTest() {
        HttpClientSteps httpClientSteps = new HttpClientSteps();
        httpClientSteps.authorization(KEY, SECRET, EMAIL, PASSWORD);
        httpClientSteps.createARequest(UrlsStorage.getPeopleApiUrl() + SHARE_URL, SPAM_MESSAGE).send();
        Response response = httpClientSteps.createARequest(SHARE_URL, SPAM_MESSAGE).send();
        httpClientSteps.checkIfCommentIsntPosted(BAD_REQUEST_CODE, response.getCode());
    }
}
