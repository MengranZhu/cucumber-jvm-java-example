package com.automationpanda.example.stepdefs;

import com.automationpanda.example.pages.WikiPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class WikiSearchSteps {
    private WebDriver webDriver;
    private WikiPage wikiPage;

    @Before(value = "@web", order = 11)
    public void initWebDriver() throws Throwable {
        webDriver = new ChromeDriver();
    }

    @Before(value = "@wiki", order = 12)
    public void initWikiPage() throws Throwable {
        wikiPage = new WikiPage(webDriver);
    }

    @Given("^a web browser is on the Wikipedia Page$")
    public void aWebBrowserIsOnTheWikipediaPage() throws Throwable {
        wikiPage.navigateToHomePage();
    }


    @When("^the search article \"([^\"]*)\" is entered$")
    public void theSearchArticleIsEntered(String phrase) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        wikiPage.enterSearchPhase(phrase);
    }

    @Then("^some articles for \"([^\"]*)\" are shown$")
    public void someArticlesForAreShown(String phrase) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertThat(wikiPage.pageTitleContains(phrase)).isTrue();
    }

    @After(value = "@web")
    public void disposeWebDriver() throws Throwable {
        webDriver.quit();
    }
}
