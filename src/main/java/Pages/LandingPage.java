package Pages;

import Utils.SeleniumDriver;
import Utils.WaitMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class LandingPage {

    SeleniumDriver seleniumDriver = new SeleniumDriver();
    WaitMethods waitMethods = new WaitMethods();

    @FindBy(xpath = "//div[@id='btn-categories']")
    private WebElement categories;
    @FindBy(xpath = "//li[@id]/a[@id]")
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
    @FindBy (xpath = "//*[@id='nothx']")
    private WebElement noThanks;
    @FindBy (xpath = "//*[@id='ls-search']")
    private WebElement textSearch;
    @FindBy (xpath = "//div[contains(@class,'cui-udc-title')]")
    private List<WebElement> dealsNames;


    public void noThanksClick() {
        waitMethods.waitForElementToBeVisible(noThanks);
        noThanks.click();
    }
    public void waitForLandingPage() {
        waitMethods.waitForElement(header);
    }

    public void clickSignInButton() {
        WaitMethods.sleep(3);
        try{
            if(waitMethods.isElementDisplayed(signInButton1,5)) {
                signInButton1.click();
            }
        } catch (Exception e) {}
        try{
            if(waitMethods.isElementDisplayed(signInButton2,5)) {
                signInButton2.click();
            }
        } catch (Exception e) {}

    }

    public void clickNavBarCategory(String channelId) {
        waitMethods.isElementDisplayed(navBarCategories.get(0), 5);
        for (WebElement channel : navBarCategories) {
            if (channel.getAttribute("id").contains(channelId)) {
                channel.click();
                break;
            }
        }
    }

    public void clickCategoriesChannel(String channelId) {
        WaitMethods.sleep(2);
        for (WebElement channel : categoriesChannels) {
            if (channel.getAttribute("id").contains(channelId)) {
                channel.click();
                shopAllButton.click();
            }
        }
    }

    public void clickOnCategoriesElseOnNavBar(String channelId) {
        WaitMethods.sleep(2);
        try{
            if(categories.isDisplayed()){
                categories.click();
                WaitMethods.sleep(3);
                clickCategoriesChannel("local");
            } else {
                clickNavBarCategory(channelId);
            }
        }catch (Exception e){}
    }

    public void freeTextSearch(String textInput) {
        WaitMethods.sleep(5);
        WebElement enterText = waitMethods.waitForElementToBeVisible(textSearch);
        enterText.sendKeys(textInput);
        enterText.sendKeys(Keys.ENTER);
    }

    public void clickOnDeal(int index) {
        WaitMethods.sleep(3);
        WebElement deal = waitMethods.waitForElementToBeVisible(dealsNames.get(index));
        deal.click();
        WaitMethods.sleep(3);
    }

}
