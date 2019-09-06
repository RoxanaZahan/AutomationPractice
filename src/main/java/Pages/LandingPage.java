package Pages;

import Utils.SeleniumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class LandingPage {

    SeleniumDriver seleniumDriver = new SeleniumDriver();

    @FindBy(xpath = "//div[@id='btn-categories']")
    private WebElement categories;
    @FindBy(xpath = "//li[@id]")
    private List<WebElement> navBarCategories;
    @FindBy(xpath = "//header[@id='ls-header']")
    private WebElement header;


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

    public void clickOnCategoriesElseOnNavBar(String channelId) {
        if (categories.isDisplayed()) {
            clickCategories();
        } else {
            navBarCategoryClick(channelId);
        }
    }

    public void waitForLandingPage() {
        seleniumDriver.waitForElement(header);
    }

}
