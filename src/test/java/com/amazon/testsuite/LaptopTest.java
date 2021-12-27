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
public class    LaptopTest extends TestBase {

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
    public void verifyThatUserShouldAddLaptopInToCartSuccessfully() throws InterruptedException {
        homePage.textToSearchBar("Laptop");
        homePage.clickSearchButton();
        resultPage.confirmNavigateToPage("Laptop");
        //on page 4
//        resultPage.clickOnProduct("HP Pavilion Gaming 15-Inch Laptop, Intel Core i5-9300H, NVIDIA GeForce GTX 1650, 12GB RAM, 256GB SSD, Windows 10 (15-dk0041nr, Black)");
        //on page 3
//        resultPage.clickOnProduct("Dell Inspiron 15 3000 Business and Student Laptop (2021 Latest Model), 15.6\" HD Display, Intel N4020 Dual-Core Processor, 16GB RAM, 512GB SSD, Webcam, HDMI, Bluetooth, Wi-Fi, Black, Windows 10");
        //on page 2
//        resultPage.clickOnProduct("Dell Inspiron 3000 15” Laptop Intel Celeron – 128GB SSD+500GB HDD – 8GB DDR4 – 1.8GHz - Intel UHD Graphics - Windows 10 Home - Inspiron 15 3000 Series - New");
        //on page 1
        resultPage.clickOnProduct("ASUS ZenBook 13 Ultra-Slim Laptop, 13.3” OLED FHD NanoEdge Bezel Display, Intel Core i7-1165G7, 16GB LPDDR4X RAM, 512GB SSD, NumberPad, Thunderbolt 4, Wi-Fi 6, Windows 10 Pro, Pine Grey, UX325EA-XS74");
        productPage.selectQtyFromDropDown("3");
        productPage.clickAddToCart();
        Thread.sleep(1000);
        productPage.verifyLaptopAddToCartMessage("Added to Cart");
    }
}
