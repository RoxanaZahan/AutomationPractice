package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Iterator;
import java.util.Set;

public class SeleniumDriver {
    public static WebDriver driver;

    @BeforeMethod
    public static void initialiseDriver() {
        String path = System.getProperty("user.dir");
        //System.out.println(path); //use it if unsure of your local path
        //C:\Program Files\Automation Projects\AutomationPractice\src\main\resources\chromedriver\chromedriver.exe
        System.setProperty("webdriver.chrome.driver",path+"/src/main/resources/chromedriver/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public static void afterMethod() {
        WaitMethods.sleep(2);
        //driver.quit();
    }

    public void goToUrl(final String host) {
        driver.get(host);
        driver.manage().window().maximize();
    }

    public void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
    }

    public void switchToNewTab() {
        openNewTab();
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler);
    }
}
