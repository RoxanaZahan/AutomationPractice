package Pages;

import Utils.SeleniumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {
    SeleniumDriver seleniumDriver = new SeleniumDriver();

    @FindBy(xpath = "//button[@class='btn complete-order']")
    private WebElement placeOrderButton;

    //asserting stuff
    public String getTextOfPlaceOrder() { return placeOrderButton.getText(); }
}
