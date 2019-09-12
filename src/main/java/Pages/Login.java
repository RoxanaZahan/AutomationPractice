package Pages;

import Utils.SeleniumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

    SeleniumDriver seleniumDriver = new SeleniumDriver();

    @FindBy(xpath = "//main[@data-bhw='TabbedLoginPage']/div/h1")
    private WebElement signInTextHeader;

    public String getTextOfSignInHeader(){
        return signInTextHeader.getText();
    }

}
