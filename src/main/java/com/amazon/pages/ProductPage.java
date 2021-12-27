package com.amazon.pages;

import com.amazon.customlisteners.CustomListeners;
import com.amazon.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class ProductPage extends Utility {
    public ProductPage() {
        PageFactory.initElements(driver, this); }


    @CacheLookup
    @FindBy(xpath = "//select[@id='quantity']")
    WebElement selectQty;

    @CacheLookup
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
    WebElement mobileAddToCartMessage;

    @CacheLookup
    @FindBy(xpath = "//div[@id='attachDisplayAddBaseAlert']//h4[@class='a-alert-heading'][normalize-space()='Added to Cart']")
    WebElement laptopAddToCartMessage;


    public void selectQtyFromDropDown(String text) {
        selectByValueFromDropDown(selectQty,text);
        CustomListeners.test.log(Status.PASS, "Select Qty: ");
        Reporter.log("Select Qty: " + text + selectQty.getText() + "<br>");
    }
    public void clickAddToCart(){
        clickOnElement(addToCart);
        CustomListeners.test.log(Status.PASS, "Clicking on Add to Cart: ");
//        Reporter.log("Clicking on Add to Cart: " + addToCart.getText() + "<br>");
    }
    public void verifyLaptopAddToCartMessage(String text) throws InterruptedException {
        Thread.sleep(1000);
        String actualString = getTextFromElement(laptopAddToCartMessage);
        System.out.println("text of message: " + actualString);
        Assert.assertTrue(actualString.contains((text)));
        CustomListeners.test.log(Status.PASS, "Verify Add to cart message: ");
        Reporter.log("Verify Add to cart message: " + text + laptopAddToCartMessage.getText() + "<br>");
    }
    public void verifyMobileAddToCartMessage(String text) {
        String actualString = getTextFromElement(mobileAddToCartMessage);
        System.out.println("text of message: " + actualString);
        Assert.assertTrue(actualString.contains((text)));
        CustomListeners.test.log(Status.PASS, "Verify Add to cart message: ");
        Reporter.log("Verify Add to cart message:  " + text + mobileAddToCartMessage.getText() + "<br>");
    }

}
