package Pages;

import Utils.SeleniumDriver;
import Utils.WaitMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DealDetailsPage {
    SeleniumDriver seleniumDriver = new SeleniumDriver();
    WaitMethods waitMethods = new WaitMethods();

    @FindBy(xpath = "//h1[@id='deal-title']")
    private WebElement dealTitle;
    @FindBy(xpath = "//div[@class='description']")
    private List<WebElement> dates;
    @FindBy(xpath = "//div[@data-bhw='GliveBookingDealBookerTimes']")
    private WebElement timeSelector;
    @FindBy(xpath = "//div/div/ul/li/div[@class=' ch-bg-prim ch-bdr-prim']")
    private List<WebElement> timePills;
    @FindBy(xpath = "//div[contains(@class, 'quantity')]")
    private List<WebElement> ticketsNumber;
    @FindBy(xpath = "//ul[@data-bhw='SectionPicker']/li")
    private List<WebElement> seatingSections;
    @FindBy(xpath = "//button[@id='book-now-button']")
    private WebElement buyButton;

    //asserting stuff
    public String getTextOfDealTitle() { return dealTitle.getText(); }

    public void selectDate(int index) {
        WaitMethods.sleep(5);
        WebElement date = waitMethods.waitForElementToBeVisible(dates.get(index));
        date.click();
    }

    public void selectTime(int index) {
        WebElement times = waitMethods.waitForElementToBeVisible(timeSelector);
        times.click();
        WebElement time = waitMethods.waitForElementToBeVisible(timePills.get(index));
        time.click();
    }

    //make sure to refactor this in order to function for not visible pills as well
    public void selectTicketsNumber(int index) {
        WebElement number = waitMethods.waitForElementToBeVisible(ticketsNumber.get(index));
        number.click();
    }

    public void selectSeatingSection(int index) {
        WaitMethods.sleep(3);
        WebElement seatingSection = waitMethods.waitForElementToBeVisible(seatingSections.get(index));
        seatingSection.click();
    }

    //check what happens if buy button is grey (not active)
    public void clickBuyButton() {
        WaitMethods.sleep(3);
        buyButton.click();
        WaitMethods.sleep(3);
    }
}
