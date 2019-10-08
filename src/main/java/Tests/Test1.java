package Tests;

import Pages.DealDetailsPage;
import Pages.LandingPage;
import Pages.LoginRegisterPage;
import Utils.SeleniumDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 extends SeleniumDriver {

    //Instance Variables
    LandingPage landingPage;
    LoginRegisterPage loginRegisterPage;
    DealDetailsPage dealDetailsPage;

    String expectedDealTitle = "GIA: WillCall Automation Deal";


    @BeforeMethod
    public void beforeTest(){
        landingPage = PageFactory.initElements(driver,LandingPage.class);
        loginRegisterPage = PageFactory.initElements(driver, LoginRegisterPage.class);
        dealDetailsPage = PageFactory.initElements(driver, DealDetailsPage.class);

    }

    @Test
    public void DealSearch() {
        //Local Variable
        goToUrl("https://staging.groupon.com/");
        landingPage.noThanksClick();
        landingPage.clickSignInButton();
        loginRegisterPage.signIn("clo01@groupon.com", "grouponn");
        landingPage.clickNavBarCategory("things-to-do-tab");
        landingPage.freeTextSearch("willcall");
        landingPage.clickOnDeal(0);
        Assert.assertEquals(dealDetailsPage.getTextOfDealTitle(), expectedDealTitle);

    }

}
