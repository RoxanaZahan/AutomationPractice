package Pages;

import Utils.SeleniumDriver;
import Utils.WaitMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginRegisterPage {

    SeleniumDriver seleniumDriver = new SeleniumDriver();
    WaitMethods waitMethods = new WaitMethods();

    @FindBy(xpath = "//input[@id='login-email-input']")
    private WebElement signInEmailInput1;
    @FindBy(xpath = "//input[@id='login-password-input']")
    private WebElement signInPasswordInput1;
    @FindBy(xpath = "//button[@id='signin-button']")
    private WebElement signInButton1;
    @FindBy (xpath = "//input[@id='sf-email']")
    private WebElement signInEmailInput2;
    @FindBy (xpath = "//input[@id='sf-pw']")
    private WebElement signInPasswordInput2;
    @FindBy (xpath = "//button[@class = 'btn btn-signin']")
    private WebElement signInButton2;


    public void signInEmailPasswordInput1 (String email, String password) {
        WebElement enterEmail = waitMethods.waitForElementToBeVisible(signInEmailInput1);
        enterEmail.sendKeys(email);
        WebElement enterPassword = waitMethods.waitForElementToBeVisible(signInPasswordInput1);
        enterPassword.sendKeys(password);
        //waitMethods.sleep(4);
        signInButton2.click();
        //enterPassword.sendKeys(Keys.ENTER);
    }

    public void signInEmailPasswordInput2 (String email, String password) {
        WebElement enterEmail = waitMethods.waitForElementToBeVisible(signInEmailInput2);
        enterEmail.sendKeys(email);
        WebElement enterPassword = waitMethods.waitForElementToBeVisible(signInPasswordInput2);
        enterPassword.sendKeys(password);
        //waitMethods.sleep(4);
        signInButton2.click();
        //enterPassword.sendKeys(Keys.ENTER);
    }

    public void signIn(String email, String password) {
        WaitMethods.sleep(3);
        try{
            if(waitMethods.isElementDisplayed(signInEmailInput1,5)) {
                signInEmailPasswordInput1(email, password);
            }
        } catch (Exception e) {}
        try{
            if(waitMethods.isElementDisplayed(signInEmailInput2,5)) {
                signInEmailPasswordInput2(email, password);
            }
        } catch (Exception e) {}
    }
}
