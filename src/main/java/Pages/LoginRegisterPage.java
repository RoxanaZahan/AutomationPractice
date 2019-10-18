package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.SeleniumDriver;
import Utils.WaitMethods;

public class LoginRegisterPage {

    SeleniumDriver seleniumDriver = new SeleniumDriver();
    WaitMethods    waitMethods    = new WaitMethods();
    LandingPage    landingPage    = new LandingPage();

    @FindBy(xpath = "//input[@id='login-email-input']")
    private WebElement signInEmailInput1;
    @FindBy(xpath = "//input[@id='login-password-input']")
    private WebElement signInPasswordInput1;
    @FindBy(xpath = "//button[@id='signin-button']")
    private WebElement signInButton1;
    @FindBy(xpath = "//input[@id='sf-email']")
    private WebElement signInEmailInput2;
    @FindBy(xpath = "//input[@id='sf-pw']")
    private WebElement signInPasswordInput2;
    @FindBy(xpath = "//button[@class = 'btn btn-signin']")
    private WebElement signInButton2;


    public void signInEmailPasswordInput1(final String email, final String password) {
        final WebElement enterEmail = this.waitMethods.waitForElementToBeVisible(this.signInEmailInput1);
        enterEmail.sendKeys(email);
        final WebElement enterPassword = this.waitMethods.waitForElementToBeVisible(this.signInPasswordInput1);
        enterPassword.sendKeys(password);
        //waitMethods.sleep(4);
        this.signInButton2.click();
        //enterPassword.sendKeys(Keys.ENTER);
    }

    public void signInEmailPasswordInput2(final String email, final String password) {
        final WebElement enterEmail = this.waitMethods.waitForElementToBeVisible(this.signInEmailInput2);
        enterEmail.sendKeys(email);
        final WebElement enterPassword = this.waitMethods.waitForElementToBeVisible(this.signInPasswordInput2);
        enterPassword.sendKeys(password);
        //waitMethods.sleep(4);
        this.signInButton2.click();
        //enterPassword.sendKeys(Keys.ENTER);
    }

    //TODO : Refactor this, once you add the cookie you no longer ned to do this.
    public void signIn(final String email, final String password) {
        try {
            if (this.waitMethods.isElementDisplayed(this.signInEmailInput1, 5)) {
                signInEmailPasswordInput1(email, password);
            }
        }
        catch (final Exception e) {}
        try {
            if (this.waitMethods.isElementDisplayed(this.signInEmailInput2, 5)) {
                signInEmailPasswordInput2(email, password);
            }
        }
        catch (final Exception e) {}
    }

    public void signInDefinedCredentials() {
        this.landingPage.clickSignInButton();
        signIn("clo01@groupon.com", "grouponn");
    }
}
