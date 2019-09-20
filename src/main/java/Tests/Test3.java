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

public class Test3 extends SeleniumDriver {

    LandingPage landingPage;
    LoginRegisterPage loginRegisterPage;
    DealDetailsPage dealDetailsPage;
    CheckoutPage checkoutPage;

    String expectedPlaceOrderText = "Place Order";

    @BeforeMethod
    public void beforeTest() {
        landingPage = PageFactory.initElements(driver, LandingPage.class);
        loginRegisterPage = PageFactory.initElements(driver, LoginRegisterPage.class);
        dealDetailsPage = PageFactory.initElements(driver, DealDetailsPage.class);
        checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
    }

    @Test
    public void buySignedIn() {
        goToUrl("https://staging.groupon.com/deals/gl-fantasia-live-in-concert-20");
        landingPage.noThanksClick();
        loginRegisterPage.signIn("clo01@groupon.com", "grouponn");
        dealDetailsPage.selectDate(0);
        dealDetailsPage.selectTime(0);
        dealDetailsPage.selectTicketsNumber(0);
        dealDetailsPage.selectSeatingSection(0);
        dealDetailsPage.clickBuyButton();
        loginRegisterPage.signIn("clo01@groupon.com", "grouponn");
        Assert.assertEquals(checkoutPage.getTextOfPlaceOrder(), expectedPlaceOrderText);
    }
}
