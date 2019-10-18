package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.DealDetailsPage;
import Pages.LandingPage;
import Pages.LoginRegisterPage;
import Utils.Cookies;
import Utils.SeleniumDriver;

public class Test1 extends SeleniumDriver {

    //Instance Variables
    LandingPage       landingPage;
    LoginRegisterPage loginRegisterPage;
    DealDetailsPage   dealDetailsPage;
    Cookies           cookies;

    String expectedDealTitle = "GIA: WillCall Automation Deal";


    @BeforeMethod
    public void beforeTest() {
        this.landingPage = PageFactory.initElements(driver, LandingPage.class);
        this.loginRegisterPage = PageFactory.initElements(driver, LoginRegisterPage.class);
        this.dealDetailsPage = PageFactory.initElements(driver, DealDetailsPage.class);
        this.cookies = PageFactory.initElements(driver, Cookies.class);
    }

    @Test
    public void DealSearch() {
        //Local Variable
        goToUrl("https://staging.groupon.com/");
        this.cookies.addHeaderCookie();
        this.landingPage.noThanksClick();
        this.landingPage.clickSignInButton();
        this.loginRegisterPage.signIn("clo01@groupon.com", "grouponn");
        this.landingPage.clickNavBarCategory("things-to-do-tab");
        this.landingPage.freeTextSearch("willcall");
        this.landingPage.clickOnDeal(0);
        Assert.assertEquals(this.dealDetailsPage.getTextOfDealTitle(),
                            this.expectedDealTitle); //TODO : org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"xpath","selector":"//h1[@id='deal-title']"}
    }

}
