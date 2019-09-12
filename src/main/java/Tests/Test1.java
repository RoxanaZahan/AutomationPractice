package Tests;

import Pages.LandingPage;
import Pages.Login;
import Utils.SeleniumDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 extends SeleniumDriver {
//    random test comment
    //Instance Variable
    LandingPage landingPage;
    Login login;

    String expectedLoginHeaderText = "Sign in to score great deals!";


    @BeforeMethod
    public void beforeTest(){
        landingPage = PageFactory.initElements(driver,LandingPage.class);
        login = PageFactory.initElements(driver, Login.class);

    }

    @Test
    public void TestSearch() {
        //Local Variable
        goToUrl("https://staging.groupon.com/");
        noThanksClick();
        landingPage.waitForLandingPage();
        landingPage.clickSignInButton();
        Assert.assertEquals(login.getTextOfSignInHeader(), expectedLoginHeaderText);
        //landingPage.clickOnCategoriesElseOnNavBar("local-tab-link");
        //landingPage.clickCategories();
        //categoriesClick("local");
        //freeTextSearch("pizza");
        //navBarChannelClick("local-tab");
        //sortByFilter("featured-sort:price:desc");
        //dealsNamesPricesPrint();

    }






}
