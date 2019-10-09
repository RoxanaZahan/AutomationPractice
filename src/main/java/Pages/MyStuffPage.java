package Pages;

import Utils.SeleniumDriver;
import Utils.WaitMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyStuffPage {
    SeleniumDriver seleniumDriver = new SeleniumDriver();
    WaitMethods waitMethods = new WaitMethods();

    @FindBy(xpath = "//select[@id= 'filter']")
    private WebElement grouponsFilterSelector;
    @FindBy(xpath = "//select[@id= 'filter']/option[@value]")
    private List<WebElement> grouponsFilters;

    public void myGrouponsFilter(String grouponFilter) {
        WebElement selector = waitMethods.waitForElementToBeVisible(grouponsFilterSelector);
        selector.click();
        for (WebElement filter : grouponsFilters) {
            if (filter.getAttribute("value").contains(grouponFilter)) {
                filter.click();
            }
        }
    }
}
