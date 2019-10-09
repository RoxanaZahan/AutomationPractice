package Pages;

import Utils.SeleniumDriver;
import Utils.WaitMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {
    SeleniumDriver seleniumDriver = new SeleniumDriver();
    WaitMethods waitMethods = new WaitMethods();

    @FindBy(xpath = "//button[@class='btn complete-order']")
    private WebElement placeOrderButton;
    @FindBy(xpath = "//span[contains(@class, 'subtotal-formatted-amount')]")
    private WebElement itemPrice;
    @FindBy(xpath = "//span[contains(@class, 'final-amount')]")
    private WebElement finalPrice;
    @FindBy(xpath = "//label[@class='quantity']")
    private WebElement quantity;

    //asserting stuff
    public String getTextOfPlaceOrder() { return placeOrderButton.getText(); }
    public Integer getItemPrice() {
        String sPrice = itemPrice.getText().replaceAll("[^0-9]", "");
        Integer iPrice = Integer.parseInt(sPrice);
        return iPrice;
    }
    public Integer getFinalPrice() {
        String sPrice = finalPrice.getText().replaceAll("[^0-9]", "");
        Integer iPrice = Integer.parseInt(sPrice);
        return iPrice;
    }
    public Integer getQuantity() {
        Integer iQuantity = Integer.parseInt(quantity.getText());
        return iQuantity;
    }
    public Integer getItemPriceForQuantity() {
        Integer total = getItemPrice() * getQuantity();
        return total;
    }

    public void clickPlaceOrder() {
        WebElement placeOrder = waitMethods.waitForElementToBeVisible(placeOrderButton);
        placeOrder.click();
    }



}
