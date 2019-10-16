package Pages;

import Utils.SeleniumDriver;
import Utils.WaitMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReceiptPage {
    SeleniumDriver seleniumDriver = new SeleniumDriver();
    WaitMethods waitMethods = new WaitMethods();

    @FindBy(xpath = "//div[@class='processing-text']")
    private WebElement processingFirstLine;
    @FindBy(xpath = "//div[contains(@class, 'reason-text')]")
    private WebElement processingSecondLine;
    @FindBy(xpath = "//a[@id= 'user-name']")
    private WebElement myStuff;


    public void printReceiptError() {
        waitMethods.sleep(35);
        //try {
            if (waitMethods.isElementDisplayed(processingFirstLine, 20)) {
                System.out.println(processingFirstLine.getText());
            }
        //} catch (Exception e) {}

        //waitMethods.isElementDisplayed(processingFirstLine, 20);

        //WebElement firstLine = waitMethods.waitForElementToBeVisible2(By.xpath("//div[@class='processing-text']"));
        WebElement secondLine = waitMethods.waitForElementToBeVisible(processingSecondLine);
        //System.out.println(firstLine.getText());
        System.out.println(secondLine.getText());
    }

    public void clickMyStuff() {
        WebElement myStuffButton = waitMethods.waitForElementToBeVisible(myStuff);
        myStuffButton.click();
    }

    public void printReceiptAndGoToMyStuff() {
        printReceiptError();
        clickMyStuff();
    }

}
