package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class SeleniumDriver {
    public static WebDriver driver;

    @BeforeMethod
    public static void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/roxana.zahan/IdeaProjects/Lesson1/src/main/resources/chromedriver/chromedriver");
        driver = new ChromeDriver();
    }

    public void goToUrl(String host) {
        driver.get(host);
    }

}
