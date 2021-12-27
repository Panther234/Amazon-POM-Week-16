package com.amazon.pages;

import com.amazon.customlisteners.CustomListeners;
import com.amazon.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.List;

public class ResultPage extends Utility {

    public ResultPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
    WebElement resultPage;

//    @CacheLookup
    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    List<WebElement> productOnPage;

    @FindBy(xpath = "//a[text()='Next']")
    WebElement nextPage;

    @FindBy(css = ".s-pagination-item.s-pagination-next.s-pagination-button.s-pagination-separator")
    WebElement nextPageButtonByCss;

    public void confirmNavigateToPage(String text) {
        String actualString = getTextFromElement(resultPage);
        Assert.assertTrue(actualString.contains((text)));
        CustomListeners.test.log(Status.PASS, "Confirming Page Navigate to Laptop: ");
        Reporter.log("Confirming Page Navigate to Laptop: " + text + resultPage.getText() + "<br>");
    }

    public void clickOnProduct(String product) throws InterruptedException {
        boolean isPresent = false;

        int totalPages = 20; //number of pages
        for (int i = 0; i < totalPages; i++) {
            System.out.println("Page: " + (i + 1));
            System.out.println(driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).size());
            for (WebElement name : driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"))) {
                Thread.sleep(500);
                System.out.println(name.getText().equalsIgnoreCase(product));
                if (name.getText().equalsIgnoreCase(product)) {
                    Thread.sleep(1000);
                    name.click();
                    isPresent = true;
                    break;
                }
            }
            if (!isPresent) {
                Thread.sleep(1000);
                clickOnElement(driver.findElement(By.xpath("//a[text()='Next']")));
            } else {
                break;
            }
        }
    }
//    //  @CacheLookup
//    @FindBy(xpath = "//div[@class='s-main-slot s-result-list s-search-results sg-row']//div//div//div//div//div//div//div//div//div//h2//a")
//    List<WebElement> searchResultAllTexts;
//
//    //  @CacheLookup
//    @FindBy(xpath = "//a[normalize-space()='Next']")
//    WebElement nextPageButtonByXpath;
//
//    @FindBy(css = ".s-pagination-item.s-pagination-next.s-pagination-button.s-pagination-separator")
//    WebElement nextPageButtonByCss;
//
//    public void searchItem(String item) {
//        System.out.println("size of items list: " + searchResultAllTexts.size());
//        String actualItem = "";
//        String actual2 = "";
//        int s = 4;
//        boolean mybreak = false;
//        for (int i = 0; i <= s; i++) {
//            for (int j = 1; j < searchResultAllTexts.size(); j++) {
//
//                if (searchResultAllTexts.get(j).getText().contains("\"")) {
//                    actual2 = searchResultAllTexts.get(j).getText().replace("\"", "inch").trim();
//                    if (actual2.equals(item)) {
//                        actualItem = actual2;
//                        System.out.println("item with problem quote="+actualItem);
////                        log.info("finiding item:= " + actual2);
//                        mybreak = true;
//                        break;
//                    }
//                } else if (searchResultAllTexts.get(j).getText().trim().equals(item)) {
//                    actualItem = searchResultAllTexts.get(j).getText();
//                    System.out.println("Item without quote=" + actualItem);
//                    mybreak = true;
//                    break;
//                }
//                if (mybreak) {
//                    break;
//                }
//            }
//            if (!mybreak) {
//                // doWaitUntilVisibilityOfElementLocated(By.xpath("//a[normalize-space()='Next']"), 2);
//                // nextPageButton.click();
//                javaExecutorScriptExecuteScriptToClick(nextPageButtonByCss);
//            }
//        }
//        boolean expected = actualItem.contains(item);
////        log.info("Asserting item by name: " + item);
//        Assert.assertTrue(expected);
//    }
}
