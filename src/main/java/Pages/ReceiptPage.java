package Pages;

import Utils.SeleniumDriver;
import Utils.WaitMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ReceiptPage {
    SeleniumDriver seleniumDriver = new SeleniumDriver();
    WaitMethods waitMethods = new WaitMethods();

    @FindBy(xpath = "//div[@class='processing-text']")
    private WebElement processingFirstLine;
    @FindBy(xpath = "//div[contains(@class, 'reason-text')]")
    private WebElement processingSecondLine;
    @FindBy(xpath = "//a[@id= 'user-name']")
    private WebElement myStuff;
    @FindBy(xpath = "//select[@id= 'filter']")
    private WebElement grouponsFilterSelector;
    @FindBy(xpath = "//select[@id= 'filter']/option")
    private List<WebElement> grouponsFilters;


    public void getTextProcessingFirstLine() { System.out.println(processingFirstLine.getText()); }
    public void getTextProcessingSecondLine() { System.out.println(processingSecondLine.getText()); }

    public void clickMyStuff() {
        WebElement myStuffButton = waitMethods.waitForElementToBeVisible(myStuff);
        myStuffButton.click();
    }

    public void myGrouponsFilter() {
        WebElement selector = waitMethods.waitForElementToBeVisible(grouponsFilterSelector);
        selector.click();

    }

}
