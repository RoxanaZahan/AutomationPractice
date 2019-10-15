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
    @FindBy(xpath = "//span[@class='flatpickr-day ']")
    private List<WebElement> tableDates;
    @FindBy(xpath = "//div[@data-bhw='GliveBookingDealBookerDates']")
    private WebElement dateSelector;
    @FindBy(xpath = "//div[@data-bhw='GliveBookingDealBookerTimes']")
    private WebElement timeSelector;
    @FindBy(xpath = "//div[@data-bhw='GliveBookingDealBookerQuantities']")
    private WebElement quantitySelector;
    @FindBy(xpath = "//div[@data-bhw='GliveBookingDealBookerSections']")
    private WebElement sectionSelector;
    @FindBy(xpath = "//div/div/ul/li/div[@class=' ch-bg-prim ch-bdr-prim']")
    private List<WebElement> timePills;
    @FindBy(xpath = "//div[contains(@class, 'quantity')]")
    private List<WebElement> ticketsNumber;
    @FindBy(xpath = "//ul[@data-bhw='SectionPicker']/li")
    private List<WebElement> seatingSections;
    @FindBy(xpath = "//button[@id='book-now-button']")
    private WebElement buyButton;
    @FindBy(xpath = "//div[@class='info-price']")
    private WebElement dealPrice;
    @FindBy(xpath = "//div[contains(@class,'collapsed')]")
    private List<WebElement> collapsedArrow;
    @FindBy(xpath = "//div[contains(@class,'expanded')]")
    private List<WebElement> expandedArrow;


    //asserting stuff
    public String getTextOfDealTitle() { return dealTitle.getText(); }
    public Integer getDealPrice() {
        String sPrice = dealPrice.getText().replaceAll("[^0-9]", "");
        Integer iPrice = Integer.parseInt(sPrice);
        return iPrice;
    }
    public Integer numberOfTickets;

//    public void clickNavBarCategory(String channelId) {
//        waitMethods.sleep(2);
//        waitMethods.isElementDisplayed(navBarCategories.get(0), 5);
//        for (WebElement channel : navBarCategories) {
//            if (channel.getAttribute("id").contains(channelId)) {
//                channel.click();
//                break;
//            }
//        }
//    }

    public void isColapsedExpanded (WebElement section) {
        if (section.getAttribute("class").contains("collapsed")) {
            section.click();
        }
    }

    public void selectDate1(int index) {
        isColapsedExpanded(dateSelector);
        WebElement date = waitMethods.waitForElementToBeVisible(dates.get(index));
        date.click();
    }

    public void selectDate2(int index) {
        isColapsedExpanded(dateSelector);
        WebElement date = waitMethods.waitForElementToBeVisible(tableDates.get(index));
        date.click();
    }

    public void selectDate(int index) {
        waitMethods.sleep(5);
        try {
            if(waitMethods.isElementDisplayed(dates.get(index), 5)) {
                selectDate1(index);
            }
        } catch (Exception e) {}
        try {
            if(waitMethods.isElementDisplayed(tableDates.get(index), 5)) {
                selectDate2(index);
            }
        } catch (Exception e) {}
    }

    public void selectTime(int index) {
        isColapsedExpanded(timeSelector);
        WebElement times = waitMethods.waitForElementToBeVisible(timeSelector);
        times.click();
        WebElement time = waitMethods.waitForElementToBeVisible(timePills.get(index));
        time.click();
    }

    //make sure to refactor this in order to function for not visible pills as well
    public void selectTicketsNumber(int numberOfTickets) {
        isColapsedExpanded(quantitySelector);
        this.numberOfTickets = numberOfTickets;
        WebElement number = waitMethods.waitForElementToBeVisible(ticketsNumber.get(numberOfTickets - 1));
        number.click();
    }

    public Integer expectedTotalPriceDD () {
        return this.numberOfTickets * 10;
    }

    public void selectSeatingSection(int index) {
        isColapsedExpanded(sectionSelector);
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
