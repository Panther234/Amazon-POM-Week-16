package com.amazon.testsuite;

import com.amazon.customlisteners.CustomListeners;
import com.amazon.pages.HomePage;
import com.amazon.pages.ProductPage;
import com.amazon.pages.ResultPage;
import com.amazon.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


    @Listeners(CustomListeners.class)
    public class MobileTest extends TestBase {

        HomePage homePage;
        ResultPage resultPage;
        ProductPage productPage;

        @BeforeMethod(alwaysRun = true)
        public void inIt() {
            homePage = new HomePage();
            resultPage = new ResultPage();
            productPage = new ProductPage();
        }

        @Test(groups = {"regression"})
        public void verifyThatUserShouldAddMobileInToCartSuccessfully() throws InterruptedException {
            homePage.textToSearchBar("Mobile Phone");
            homePage.clickSearchButton();
            resultPage.confirmNavigateToPage("Mobile Phone");
            //page 1
            resultPage.clickOnProduct("Nokia G10 | Android 11 | Unlocked Smartphone | 3-Day Battery | Dual SIM | US Version | 3/32GB | 6.52-Inch Screen | 13MP Triple Camera | Polar Night");
            //page 2
//            resultPage.clickOnProduct("Samsung Galaxy A12 (128GB, 4GB) 6.5\" HD+, 48MP Quad Camera, All Day Battery, Dual SIM GSM Unlocked Global 4G Volte (T-Mobile, AT&T, Metro) International Model A127M/DS (w/Fast Car Charger, Blue)");
            // Page 3
//            resultPage.clickOnProduct("Samsung Galaxy S10 Factory Unlocked Android Cell Phone | US Version | 128GB of Storage | Fingerprint ID and Facial Recognition | Long-Lasting Battery | Prism Black (SM-G973U1ZKAX)");
            // Page 4
//            resultPage.clickOnProduct("Samsung Galaxy Note 9, 128GB, Midnight Black - Verizon (Renewed)");
            productPage.selectQtyFromDropDown("2");
            productPage.clickAddToCart();
            productPage.verifyMobileAddToCartMessage("Added to Cart");
        }
    }

