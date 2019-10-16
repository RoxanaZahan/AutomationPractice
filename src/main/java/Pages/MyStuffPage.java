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
    @FindBy(xpath = "//span[contains(@class,'status')]")
    private List<WebElement> grouponsSatusesList;
    @FindBy(xpath = "//a[@data-bhc-path='Web2AppModal|close-modal:icon']")
    private WebElement closeModal;

    public void myGrouponsFilter(String grouponFilter) {
        WebElement selector = waitMethods.waitForElementToBeVisible(grouponsFilterSelector);
        selector.click();
        for (WebElement filter : grouponsFilters) {
            if (filter.getAttribute("value").contains(grouponFilter)) {
                filter.click();
            }
        }
    }

//            for (WebElement channel : navBarCategories) {
//        if (channel.getAttribute("id").contains(channelId)) {

    public String grouponStatus(Integer index) {
        WebElement groupon = grouponsSatusesList.get(index);
        String status = groupon.getText();
        return status;
    }

    public void closeModal(){
        waitMethods.waitForElementToBeVisible(closeModal);
        closeModal.click();
    }

    public void filterGroupons(String grouponFilter) {
        closeModal();
        myGrouponsFilter(grouponFilter);
    }
}
