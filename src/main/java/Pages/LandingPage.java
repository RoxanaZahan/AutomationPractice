package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import Utils.SeleniumDriver;
import Utils.WaitMethods;


public class LandingPage {

    SeleniumDriver seleniumDriver = new SeleniumDriver();
    WaitMethods    waitMethods    = new WaitMethods();

    @FindBy(xpath = "//div[@id='btn-categories']")
    private WebElement       categories;
    @FindBy(xpath = "//li[@id]/a[@id]")
    private List<WebElement> navBarCategories;
    @FindBy(xpath = "//header[@id='ls-header']")
    private WebElement       header;
    @FindBy(xpath = "//a[@id='home-tab-link']")
    private WebElement       featured;
    @FindBy(xpath = "//div[@class='categories-column']/div[@id]")
    private List<WebElement> categoriesChannels;
    @FindBy(xpath = "//a[@class='shop-all-link']")
    private WebElement       shopAllButton; //this probably works for local only
    @FindBy(xpath = "//a[@class='user-menu-item user-menu-action']")
    private WebElement       signInButton1;
    @FindBy(xpath = "//div[contains(@id,'signin-container')]")
    private WebElement       signInButton2;
    @FindBy(xpath = "//*[@id='nothx']")
    private WebElement       noThanks;
    @FindBy(xpath = "//*[@id='ls-search']")
    private WebElement       textSearch;
    @FindBy(xpath = "//div[contains(@class,'cui-udc-title')]")
    private List<WebElement> dealsNames;

    public void openStagingGrouponAndLogin() {
        this.seleniumDriver.goToUrl("https://staging.groupon.com/");
        noThanksClick();
        clickSignInButton();
    }

    public void noThanksClick() {
        this.waitMethods.waitForElementToBeVisible(this.noThanks);
        this.noThanks.click();
    }

    public void waitForLandingPage() {
        this.waitMethods.waitForElement(this.header);
    }

    public void searchAndChoose() {
        freeTextSearch("willcall");
        clickOnDeal(0);
    }

    //TODO : Refactor this, once you add the cookie you no longer ned to do this.
    public void clickSignInButton() {
        try {
            if (this.waitMethods.isElementDisplayed(this.signInButton1, 5)) {
                this.signInButton1.click();
            }
        }
        catch (final Exception e) {}
        try {
            if (this.waitMethods.isElementDisplayed(this.signInButton2, 5)) {
                this.signInButton2.click();
            }
        }
        catch (final Exception e) {}

    }

    public void clickNavBarCategory(final String channelId) {
        //     this.waitMethods.sleep(2);
        this.waitMethods.isElementDisplayed(this.navBarCategories.get(0), 5);
        for (final WebElement channel : this.navBarCategories) {
            if (channel.getAttribute("id").contains(channelId)) {
                channel.click();
                break;
            }
        }
    }

    public void clickCategoriesChannel(final String channelId) {
        WaitMethods.sleep(2);
        for (final WebElement channel : this.categoriesChannels) {
            if (channel.getAttribute("id").contains(channelId)) {
                channel.click();
                this.shopAllButton.click();
            }
        }
    }

    public void clickOnCategoriesElseOnNavBar(final String channelId) {
        WaitMethods.sleep(2);
        try {
            if (this.categories.isDisplayed()) {
                this.categories.click();
                WaitMethods.sleep(3);
                clickCategoriesChannel("local");
            }
            else {
                clickNavBarCategory(channelId);
            }
        }
        catch (final Exception e) {}
    }

    public void freeTextSearch(final String textInput) {
        //  WaitMethods.sleep(2);
        this.waitMethods.isElementDisplayed(this.textSearch, 100);
        //  final WebElement enterText = this.waitMethods.waitForElementToBeVisible(this.textSearch);
        this.textSearch.sendKeys(textInput);
        this.textSearch.sendKeys(Keys.ENTER);
    }

    public void clickOnDeal(final int index) {
        final WebElement deal = this.waitMethods.waitForElementToBeVisible(this.dealsNames.get(index));
        deal.click();
    }

}
