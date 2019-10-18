package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import Utils.SeleniumDriver;
import Utils.WaitMethods;

public class DealDetailsPage {
    SeleniumDriver seleniumDriver = new SeleniumDriver();
    WaitMethods    waitMethods    = new WaitMethods();

    @FindBy(xpath = "//h1[@id='deal-title']")
    private WebElement       dealTitle;
    @FindBy(xpath = "//div[@class='description']")
    private List<WebElement> dates;
    @FindBy(xpath = "//span[@class='flatpickr-day ']")
    private List<WebElement> tableDates;
    @FindBy(xpath = "//div[@data-bhw='GliveBookingDealBookerDates']")
    private WebElement       dateSelector;
    @FindBy(xpath = "//div[@data-bhw='GliveBookingDealBookerTimes']")
    private WebElement       timeSelector;
    @FindBy(xpath = "//div[@data-bhw='GliveBookingDealBookerQuantities']")
    private WebElement       quantitySelector;
    @FindBy(xpath = "//div[@data-bhw='GliveBookingDealBookerSections']")
    private WebElement       sectionSelector;
    @FindBy(xpath = "//div/div/ul/li/div[@class=' ch-bg-prim ch-bdr-prim']")
    private List<WebElement> timePills;
    @FindBy(xpath = "//div[contains(@class, 'quantity')]")
    private List<WebElement> ticketsNumber;
    @FindBy(xpath = "//ul[@data-bhw='SectionPicker']/li")
    private List<WebElement> seatingSections;
    @FindBy(xpath = "//button[@id='book-now-button']")
    private WebElement       buyButton;
    @FindBy(xpath = "//div[@class='info-price']")
    private WebElement       dealPrice;
    @FindBy(xpath = "//div[contains(@class,'collapsed')]")
    private List<WebElement> collapsedArrow;
    @FindBy(xpath = "//div[contains(@class,'expanded')]")
    private List<WebElement> expandedArrow;


    //used for asserting stuff
    public String getTextOfDealTitle() {
        this.waitMethods.isElementDisplayed(this.dealTitle, 10);
        return this.dealTitle.getText();
    }

    public Integer getDealPrice() { //this returns deal price as integer
        this.waitMethods.isElementDisplayed(this.dealPrice, 10);
        final String sPrice = this.dealPrice.getText().replaceAll("[^0-9]", "");
        final Integer iPrice = Integer.parseInt(sPrice);
        return iPrice;
    }

    public Integer numberOfTickets;

    public Integer totalPrice() {
        return this.numberOfTickets * getDealPrice();
    }

    public void preselectOptions() {
        selectDate(0);
        selectTime(0);
        selectTicketsNumber(2);
        selectSeatingSection(0);
    }

    public void isColapsedExpanded(final WebElement section) {
        if (section.getAttribute("class").contains("collapsed")) {
            section.click();
        }
    }

    public void selectDate1(final int index) {
        isColapsedExpanded(this.dateSelector);
        final WebElement date = this.waitMethods.waitForElementToBeVisible(this.dates.get(index));
        date.click();
    }

    public void selectDate2(final int index) {
        isColapsedExpanded(this.dateSelector);
        final WebElement date = this.waitMethods.waitForElementToBeVisible(this.tableDates.get(index));
        date.click();
    }

    public void selectDate(final int index) {
        this.waitMethods.sleep(2);
        try {
            if (this.waitMethods.isElementDisplayed(this.dates.get(index), 5)) {
                selectDate1(index);
            }
        }
        catch (final Exception e) {}
        try {
            if (this.waitMethods.isElementDisplayed(this.tableDates.get(index), 5)) {
                selectDate2(index);
            }
        }
        catch (final Exception e) {}
    }

    public void selectTime(final int index) {
        this.waitMethods.sleep(2);
        isColapsedExpanded(this.timeSelector);
        //WebElement times = waitMethods.waitForElementToBeVisible(timeSelector);
        //times.click();
        final WebElement time = this.waitMethods.waitForElementToBeVisible(this.timePills.get(index));
        time.click();
    }

    //make sure to refactor this in order to function for not visible pills as well
    public void selectTicketsNumber(final int numberOfTickets) {
        this.waitMethods.sleep(2);
        isColapsedExpanded(this.quantitySelector);
        this.numberOfTickets = numberOfTickets;
        final WebElement number = this.waitMethods.waitForElementToBeVisible(this.ticketsNumber.get(numberOfTickets - 1));
        number.click();
    }

    public void selectSeatingSection(final int index) {
        isColapsedExpanded(this.sectionSelector);
        WaitMethods.sleep(2);
        final WebElement seatingSection = this.waitMethods.waitForElementToBeVisible(this.seatingSections.get(index));
        seatingSection.click();
    }

    //check what happens if buy button is grey (not active)
    public void clickBuyButton() {
        WaitMethods.sleep(2);
        this.buyButton.click();
        WaitMethods.sleep(3);
    }
}
