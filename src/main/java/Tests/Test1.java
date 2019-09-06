package Tests;

import Pages.LandingPage;
import Utils.SeleniumDriver;
import org.testng.annotations.Test;

public class Test1 extends SeleniumDriver {
    LandingPage landingPage = new LandingPage();
//    random test comment
    @Test
    public void TestSearch() {
        goToUrl("https://staging.groupon.com/");
        noThanksClick();
        landingPage.waitForLandingPage();
        landingPage.clickOnCategoriesElseOnNavBar("local-tab-link");
        //landingPage.clickCategories();
        //categoriesClick("local");
        //freeTextSearch("pizza");
        //navBarChannelClick("local-tab");
        //sortByFilter("featured-sort:price:desc");
        //dealsNamesPricesPrint();
    }
}
