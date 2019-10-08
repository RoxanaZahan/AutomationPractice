package Tests;

import Pages.CheckoutPage;
import Pages.DealDetailsPage;
import Pages.LandingPage;
import Pages.LoginRegisterPage;
import Utils.SeleniumDriver;
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

    Integer expectedDealPrice = 10;
    Integer expectedItemPrice = 1000;

    @BeforeMethod
    public void beforeTest() {
        landingPage = PageFactory.initElements(driver, LandingPage.class);
        loginRegisterPage = PageFactory.initElements(driver, LoginRegisterPage.class);
        dealDetailsPage = PageFactory.initElements(driver, DealDetailsPage.class);
        checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);

    }

    @Test
    public void BuyDealEndToEnd() {
        //Local Variable
        goToUrl("https://staging.groupon.com/");
        landingPage.noThanksClick();
        landingPage.clickSignInButton();
        loginRegisterPage.signIn("clo01@groupon.com", "grouponn");
        landingPage.clickNavBarCategory("things-to-do-tab");
        landingPage.freeTextSearch("willcall");
        landingPage.clickOnDeal(0);
        Assert.assertEquals(dealDetailsPage.getDealPrice(), expectedDealPrice);
        dealDetailsPage.selectDate(0);
        dealDetailsPage.selectTime(0);
        dealDetailsPage.selectTicketsNumber(2);
        dealDetailsPage.selectSeatingSection(0);
        Assert.assertEquals(dealDetailsPage.getDealPrice(), dealDetailsPage.expectedTotalPriceDD());
        dealDetailsPage.clickBuyButton();
        Assert.assertEquals(checkoutPage.getItemPrice(), expectedItemPrice);
        Assert.assertEquals(checkoutPage.getItemPriceForQuantity(), checkoutPage.getFinalPrice());

    }
}
