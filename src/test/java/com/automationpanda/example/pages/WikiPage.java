package com.automationpanda.example.pages;

import com.automationpanda.example.framework.AbstractPandaPage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WikiPage extends AbstractPandaPage {
    private static final String WIKI_HOME_URL = "https://www.wikipedia.org/";
    private static final By BY_SEARCH_FIELD = By.name("search");

    public WikiPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        getDriver().navigate().to(WIKI_HOME_URL);
    }

    public void enterSearchPhase(String phrase) {
        WebElement searchField = driverWait(10).until(ExpectedConditions.elementToBeClickable(BY_SEARCH_FIELD));
        searchField.sendKeys(phrase);
        searchField.submit();
    }

    public boolean pageTitleContains(String phrase) {
        try {
            return driverWait(5).until(ExpectedConditions.titleContains(phrase));
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public boolean pageUrlContain(String phrase) {
        try {
            return driverWait(5).until(ExpectedConditions.urlContains(phrase));
        } catch (TimeoutException ex) {
            return false;
        }
    }

}
