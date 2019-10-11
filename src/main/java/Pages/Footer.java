package Pages;

import Utils.SeleniumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Footer {
    SeleniumDriver seleniumDriver = new SeleniumDriver();

    @FindBy(xpath = "//a[contains(@id, 'ls-footer')]")
    private List<WebElement> footerLinks;

    public void clickFooter() {
        for (WebElement footer : footerLinks) {
            footer.click();
        }
    }
}
