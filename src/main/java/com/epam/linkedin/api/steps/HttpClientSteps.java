package com.epam.linkedin.api.steps;

import com.epam.linkedin.api.pages.LoginPage;
import com.epam.linkedin.webdriver.DriverManager;
import lombok.extern.log4j.Log4j2;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.json.JSONObject;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.LinkedInApi;
import org.scribe.model.Verb;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Request;
import org.scribe.model.Verifier;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

@Log4j2
public class HttpClientSteps {

    private static final int VERIFIER_CODE_LENGTH = 5;
    private Token accessToken = null;
    private OAuthService service = null;

    public OAuthService getService() {
        return service;
    }

    public Token getAccessToken() {
        return accessToken;
    }

    public void authorization(String key, String secret, String login, String password) {
        log.info("Trying to allow access to the account");
        service = new ServiceBuilder()
                .provider(LinkedInApi.class)
                .apiKey(key)
                .apiSecret(secret)
                .callback("https://www.linkedin.com/oauth/v2/authorization")
                .build();
        Token requestToken = service.getRequestToken();
        String authUrl = service.getAuthorizationUrl(requestToken);
        LoginPage loginPage = new LoginPage();
        String verifierLink = loginPage.deliverVerifierCode(authUrl, login, password);
        DriverManager.quitDriver();
        String verifierCode = verifierLink.substring(verifierLink.length() - VERIFIER_CODE_LENGTH);
        log.info("Verifier code received: " + verifierCode);
        Verifier verifier = new Verifier(verifierCode);
        accessToken = service.getAccessToken(requestToken, verifier);
        log.info("Access token received: " + accessToken);
    }

    public void checkIfUserIsAdminOfCompanies(List<String> companies, String json) {
        List<String> receivedCompanies = new ArrayList<>();
        JSONObject object = new JSONObject(json);
        for (Object o : object.getJSONArray("values")) {
            JSONObject companiesObject = (JSONObject) o;
            receivedCompanies.add(companiesObject.getString("name"));
        }
        assertTrue(receivedCompanies.containsAll(companies));
    }

    public void checkIfUserIsAdminOfCompany(int expectedCode, int actualCode) {
        assertEquals(expectedCode, actualCode);
    }

    public void viewConnections(String json) {
        JSONObject object = new JSONObject(json);
        log.info("Numbers of Connections is : " + object.getInt("numConnections"));
        assertTrue(object.getInt("numConnections") > 0);
    }

    public Document addUserShare(String comment) {
        Document doc = DocumentHelper.createDocument();
        Element share = doc.addElement("share");
        share.addElement("comment").addText(comment);
        Element content = share.addElement("content");
        content.addElement("title").addText("A title for your share");
        content.addElement("submitted-url").addText("http://developer.linkedin.com");
        share.addElement("visibility").addElement("code").addText("anyone");
        log.info("Document is being sent");
        return doc;
    }

    public void checkIfUserNamesAreCorrect(String firstName, String lastName, String json) {
        JSONObject object = new JSONObject(json);
        assertEquals("Sign in process was incorrect", object.getString("firstName") + object.getString("lastName"),
                firstName + lastName);
    }

    public void checkIfCommentPosted(String word, String response) {
        assertEquals("Posting comment process was incorrect", word, response);
        log.info("Comment is posted");
    }

    public Request createARequest(String url, String message) {
        OAuthRequest request = new OAuthRequest(Verb.POST, url);
        request.addHeader("Content-Type", "text/xml");
        request.addPayload(addUserShare(message).asXML());
        getService().signRequest(getAccessToken(), request);
        return request;
    }

    public void checkIfCommentIsntPosted(int expectedCode, int actualCode) {
        assertEquals("Posting comment process was incorrect", expectedCode, actualCode);
        log.info("Comment isn't posted");
    }

    public void checkIfCompanySharingIsEnabled(String response) {
        assertTrue(response.contains("true"), "Sharing is not enabled for a company");
        log.info("Sharing is enabled for a company ");
    }
}


