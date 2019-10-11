package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.List;

public class SeleniumDriver {
    public static WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    @BeforeMethod
    public static void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver","/Users/roxana.zahan/IdeaProjects/AutomationPractice/target/classes/chromedriver/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public static void afterMethod(){
        WaitMethods.sleep(5);
        driver.quit();
    }

    public void goToUrl(String host) {
        driver.get(host);
        driver.manage().window().maximize();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }


//    public void addCookie() {
//        Cookie header = new Cookie("Cookie.set('LS-5958_NewDesktopHeader_USCA:LS-5958_NewDesktopHeader_USCA:Variant', 'Treatment')");
//        driver.manage().addCookie(header,);
//    }









    public List<WebElement> dealsNames() {
        //sleep(0);
        List<WebElement> deals = driver.findElements(By.xpath("//div[contains(@class,'cui-udc-title')]"));
        return deals;
    }

    public List<WebElement> dealsPrices() {
        //sleep(0);
        List<WebElement> prices = driver.findElements(By.xpath("//div[contains(@class, 'cui-price-discount c-txt-price')]"));
        return prices;
    }

    //this needs refactoring
    public void sortByFilter(String filterId) {
        WaitMethods.sleep(2);
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement sortBy =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='sort-arrow']")));
        //WebElement sortBy = driver.findElement(By.xpath("//span[@id='sort-arrow']"));
        sortBy.click();
        WaitMethods.sleep(2);
        List<WebElement> filters = driver.findElements(By.xpath("//div[@class='refinement'][@data-bhc]"));
        for (WebElement filter : filters) {
            if (filter.getAttribute("data-bhc").contains(filterId)) {
                filter.click();
                break;
            }
        }
    }

    HashMap<String, String> dealsNamesPrices = new HashMap<String, String>();

    public void dealsNamesPricesPrint() {
        WaitMethods.sleep(2);
        int i = 0;
        for (WebElement deal : dealsNames()) {
            for (WebElement price : dealsPrices()) {
                if (i < dealsPrices().size()) {
                    price = dealsPrices().get(i);
                    dealsNamesPrices.put(deal.getText(), price.getText());
                    i++;
                    break;
                }
            }
        }
        for (String key : dealsNamesPrices.keySet()) {
            System.out.println(key + ": " + dealsNamesPrices.get(key));
        }
    }

}
