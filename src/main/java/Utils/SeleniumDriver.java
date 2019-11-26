package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SeleniumDriver {
    public static WebDriver driver;

    @BeforeMethod
    public static void initialiseDriver() {
        String path = System.getProperty("user.dir");
        //System.out.println(path); //use it if unsure of your local path
        System.setProperty("webdriver.chrome.driver",path+"/src/main/resources/chromedriver/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public static void afterMethod() {
        WaitMethods.sleep(2);
        driver.quit();
    }

    public void goToUrl(final String host) {
        driver.get(host);
        driver.manage().window().maximize();
    }
}
