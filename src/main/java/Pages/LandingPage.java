package Pages;

import Utils.SeleniumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class LandingPage {

    SeleniumDriver seleniumDriver = new SeleniumDriver();

    @FindBy(xpath = "//div[@id='btn-categories']")
    private WebElement categories;
    @FindBy(xpath = "//li[@id]/a")
    private List<WebElement> navBarCategories;
    @FindBy(xpath = "//header[@id='ls-header']")
    private WebElement header;
    @FindBy (xpath = "//a[@id='home-tab-link']")
    private WebElement featured;
    @FindBy (xpath = "//div[@class='categories-column']/div[@id]")
    private List<WebElement> categoriesChannels;
    @FindBy (xpath = "//a[@class='shop-all-link']")
    private WebElement shopAllButton; //this probably works for local only
    @FindBy (xpath = "//a[@class='user-menu-item user-menu-action']")
    private WebElement signInButton1;
    @FindBy (xpath = "//div[contains(@id,'signin-container')]")
    private WebElement signInButton2;


    public void clickCategories() {
        seleniumDriver.waitForElement(categories);
        categories.click();
    }

    public void navBarCategoryClick(String channelId) {
        seleniumDriver.waitForElement(navBarCategories.get(0));
        for (WebElement channel : navBarCategories) {
            if (channel.getAttribute("id").contains(channelId)) {
                channel.click();
                break;
            }
        }
    }

    public void waitForLandingPage() {
        seleniumDriver.waitForElement(header);
    }

    public void clickSignInButton1() {
        signInButton1.click();
    }

    public void clickSignInButton2() {
        signInButton2.click();
    }

    public void clickSignInButton() {
        seleniumDriver.sleep(3);
        try{
            if(seleniumDriver.isElementDisplayed(signInButton1,5)) {
                clickSignInButton1();
            }
        } catch (Exception e) {}
        try{
            if(seleniumDriver.isElementDisplayed(signInButton2,5)) {
                clickSignInButton2();
            }
        } catch (Exception e) {}

    }



    public void clickOnCategoriesElseOnNavBar(String channelId) {
        seleniumDriver.sleep(2);
        try{
            if(categories.isDisplayed()){
                categories.click();
                seleniumDriver.sleep(3);
                clickCategoriesChannel("local");
            } else {
                navBarCategoryClick(channelId);
            }
        }catch (Exception e){}

    }

        public void clickCategoriesChannel(String channelId) {
            seleniumDriver.sleep(2);
            for (WebElement channel : categoriesChannels) {
                if (channel.getAttribute("id").contains(channelId)) {
                    channel.click();
                    shopAllButton.click();
                }
            }
        }

}
