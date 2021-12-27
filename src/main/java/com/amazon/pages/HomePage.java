package com.amazon.pages;

import com.amazon.customlisteners.CustomListeners;
import com.amazon.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver, this); }

    @CacheLookup
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement searchBar;

    @CacheLookup
    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    WebElement searchButton;

    public void textToSearchBar(String text) {
        sendTextToElement(searchBar, text);
        CustomListeners.test.log(Status.PASS, "Add text to Search bar ");
        Reporter.log("Add text to Search bar : " + searchBar.getText() + "<br>");
    }

    public void clickSearchButton() {
        clickOnElement(searchButton);
        CustomListeners.test.log(Status.PASS, "Clicking on Search button ");
//        Reporter.log("Clicking on Search button : " + searchButton.getText() + "<br>");
    }
}
