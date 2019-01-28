package com.epam.linkedin.steps;

import com.epam.linkedin.pages.CompanyPage;
import com.epam.linkedin.pages.ProfilePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class CompanyPageSteps {

    private ProfilePage profilePage = new ProfilePage();
    private CompanyPage companyPage = new CompanyPage();

    @When("^the user open WorkPage$")
    public void openLinkWork() {
        profilePage.openMenuWork();
    }

    @And("^the user opens link Create page$")
    public void openCreateCompPage() {
        profilePage.openCreateCompanyPage();
    }

    @And("^the user enter company name$")
    public void enterNameCompany(String name) {
        companyPage.enterNameCompany(name);
    }

    @Then("^the user create company page and then delete this page$")
    public void theUserCreateCompanyPageAndThenDeleteThisPage() {
        String firstReadName = createCompanyPage();
        closePopWindow();
        String secondReadName = getNameCompany();
        Assert.assertEquals(firstReadName, secondReadName);
        openAdminTools();
        clickDeleteCompanyPage();
        clickLinkDeactivate();
        Assert.assertTrue(getTextMesAfterDeleteCompanyPage().equals("Your Page was successfully deactivated!"));
        clickButtonGoBack();
    }

    public String createCompanyPage() {
        String name = companyPage.getCompName();
        companyPage.createPage();
        return name;
    }

    public void closePopWindow() {
        companyPage.closePopUpWindow();
    }

    public String getNameCompany() {
        return companyPage.getNameCreateCompany();
    }

    public void openAdminTools() {
        companyPage.adminTools();
    }

    public void clickDeleteCompanyPage() {
        companyPage.deleteCompanyPage();
    }

    public void clickLinkDeactivate() {
        companyPage.deactivatePage();
    }

    public String getTextMesAfterDeleteCompanyPage() {
        return companyPage.getTextAboutDeletePage();
    }

    public void clickButtonGoBack() {
        companyPage.clickLinkGoBack();
    }
}
