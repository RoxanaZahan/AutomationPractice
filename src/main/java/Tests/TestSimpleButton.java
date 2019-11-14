package Tests;

import Pages.AutomationFormPage;
import Utils.SeleniumDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSimpleButton extends SeleniumDriver {
    //Instance Variables
    AutomationFormPage automationFormPage;

    @BeforeMethod
    public void beforeTest() {
        automationFormPage = PageFactory.initElements(driver, AutomationFormPage.class);
    }

    @Test
    public void addLastNameAndValidate() {
        goToUrl("https://www.toolsqa.com/automation-practice-form/");
        automationFormPage.clickSimpleButton();
    }
}
