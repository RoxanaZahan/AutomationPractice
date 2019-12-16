package AutomationPracticeWithToolsQASite.Pages.Tests;

import AutomationPracticeWithToolsQASite.Pages.AutomationFormPage;
import Utils.SeleniumDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLastName extends SeleniumDriver {

    //still have to do some changes here - currently the test fails

    //Instance Variables
    AutomationFormPage automationFormPage;
    String lastName = "Rotten"; //modify here with the Last Name expected to be tested

    @BeforeMethod
    public void beforeTest() {
        automationFormPage = PageFactory.initElements(driver, AutomationFormPage.class);
    }

    @Test
    public void addLastNameAndValidate() {
        goToUrl("https://www.toolsqa.com/automation-practice-form/");
        automationFormPage.enterLastName(this.lastName);
        Assert.assertEquals(automationFormPage.getLastName(), this.lastName);
    }
}
