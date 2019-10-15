package Pages;

import Utils.SeleniumDriver;
import Utils.WaitMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Footer {
    SeleniumDriver seleniumDriver = new SeleniumDriver();
    WaitMethods waitMethods = new WaitMethods();

    @FindBy(xpath = "//a[contains(@id, 'ls-footer')]")
    private List<WebElement> footerLinks;

    public enum FooterHyperlinks {
        ABOUT ("https://press.groupon.com/"),
        JOBS ("https://www.grouponcareers.com/en-us/"),
        BLOG ("https://press.groupon.com/"),
        PRESS ("https://press.groupon.com/");

        private final String textH;
        FooterHyperlinks(String text) {this.textH = text;}
        public String getFooterHyperlinkText() {return this.textH;}
    }

    public void clickFooter(String footerLinkId) {
        waitMethods.sleep(5);
        waitMethods.isElementDisplayed(footerLinks.get(0),5);
        for (WebElement footerLink : footerLinks) {
            if (footerLink.getAttribute("id").contains(footerLinkId)) {
                footerLink.click();
                break;
            }
        }
    }

    public String urlValidation (String footerLinkId) {
        clickFooter(footerLinkId);
        String actualLink = seleniumDriver.driver.getCurrentUrl();
        return actualLink;
    }
}
