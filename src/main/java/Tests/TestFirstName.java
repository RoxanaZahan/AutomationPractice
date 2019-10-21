package Tests;

import Pages.AutomationFormPage;
import Utils.SeleniumDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestFirstName extends SeleniumDriver {

    //Instance Variables
    AutomationFormPage automationFormPage;
    String firstName = "Potato"; //modify here with the First Name expected to be tested

    @BeforeMethod
    public void beforeTest() {
        automationFormPage = PageFactory.initElements(driver, AutomationFormPage.class);
    }

    @Test
    public void addFirstNameAndValidate() {
        goToUrl("https://www.toolsqa.com/automation-practice-form/");
        automationFormPage.enterFirstName(this.firstName);
        Assert.assertEquals(automationFormPage.validateFirstName(), firstName);
    }
}
