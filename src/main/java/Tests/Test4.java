package Tests;

import Pages.*;
import Utils.Cookies;
import Utils.SeleniumDriver;
import Utils.WaitMethods;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test4 extends SeleniumDriver {

    //Instance Variables
    LandingPage landingPage;
    LoginRegisterPage loginRegisterPage;
    DealDetailsPage dealDetailsPage;
    CheckoutPage checkoutPage;
    ReceiptPage receiptPage;
    WaitMethods waitMethods;
    Cookies cookies;
    Footer footer;
    MyStuffPage myStuffPage;

    Integer expectedDealPrice = 10;
    Integer expectedItemPrice = 1102;
    Integer expectedTotalPrice = 2204;
    String expectedStatus = "Processing";
    Footer.FooterHyperlinks aboutLink = Footer.FooterHyperlinks.ABOUT;

    @BeforeMethod
    public void beforeTest() {
        landingPage = PageFactory.initElements(driver, LandingPage.class);
        loginRegisterPage = PageFactory.initElements(driver, LoginRegisterPage.class);
        dealDetailsPage = PageFactory.initElements(driver, DealDetailsPage.class);
        checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
        receiptPage = PageFactory.initElements(driver, ReceiptPage.class);
        waitMethods = PageFactory.initElements(driver, WaitMethods.class);
        cookies = PageFactory.initElements(driver, Cookies.class);
        footer = PageFactory.initElements(driver, Footer.class);
        myStuffPage = PageFactory.initElements(driver, MyStuffPage.class);

    }

    @Test
    public void BuyDealEndToEnd() {
        landingPage.openStagingGrouponAndLogin();
        loginRegisterPage.signIn("clo01@groupon.com", "grouponn");
        //Assert.assertEquals(footer.urlValidation("about"), aboutLink.getFooterHyperlinkText());
        landingPage.searchAndChoose();
        Assert.assertEquals(dealDetailsPage.getDealPrice(), expectedDealPrice);
        dealDetailsPage.preselectOptions();
        Assert.assertEquals(dealDetailsPage.getDealPrice(), expectedTotalPrice);
        dealDetailsPage.clickBuyButton();
        Assert.assertEquals(checkoutPage.getItemPrice(), expectedItemPrice);
        Assert.assertEquals(checkoutPage.getItemPriceForQuantity(), checkoutPage.getFinalPrice());
        checkoutPage.clickPlaceOrder();
        receiptPage.printReceiptAndGoToMyStuff();
        myStuffPage.filterGroupons("all");
        Assert.assertEquals(expectedStatus, myStuffPage.grouponStatus(0));
    }
}
