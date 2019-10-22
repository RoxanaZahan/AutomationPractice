package Pages;

import Utils.WaitMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutomationFormPage {

    WaitMethods waitMethods = new WaitMethods();

    @FindBy(xpath = "//input[@name = 'firstname']")
    private WebElement firstName;

    public void enterFirstName(String firstName) {
        final WebElement firstNameTab = this.waitMethods.waitForElementToBeVisible(this.firstName);
        firstNameTab.sendKeys(firstName);
    }
     public String validateFirstName() {
        final WebElement enteredFirstName = this.waitMethods.waitForElementToBeVisible(this.firstName);
        return enteredFirstName.getAttribute("value");
     }
}
