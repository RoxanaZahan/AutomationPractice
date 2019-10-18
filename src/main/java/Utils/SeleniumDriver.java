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

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    //TODO : find a way to add the set.Property dynamically. If I run your code I get : java.lang.IllegalStateException: The driver executable does not exist: /Users/roxana.zahan/IdeaProjects/AutomationPractice/target/classes/chromedriver/chromedriver
    public static void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver",
                           "/Users/mihai.hosu/IdeaProjects/AutomationPractice/src/main/resources/chromedriver/chromedriver");
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

    public void refreshPage() {
        driver.navigate().refresh();
    }


    //    public void addCookie() {
    //        Cookie header = new Cookie("Cookie.set('LS-5958_NewDesktopHeader_USCA:LS-5958_NewDesktopHeader_USCA:Variant', 'Treatment')");
    //        driver.manage().addCookie(header,);
    //    }


    public List<WebElement> dealsNames() {
        //sleep(0);
        final List<WebElement> deals = driver.findElements(By.xpath("//div[contains(@class,'cui-udc-title')]"));
        return deals;
    }

    public List<WebElement> dealsPrices() {
        //sleep(0);
        final List<WebElement> prices = driver.findElements(By.xpath(
                "//div[contains(@class, 'cui-price-discount c-txt-price')]"));
        return prices;
    }

    //this needs refactoring
    public void sortByFilter(final String filterId) {
        WaitMethods.sleep(2);
        final WebDriverWait wait = new WebDriverWait(driver, 10);
        final WebElement sortBy = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='sort-arrow']")));
        //WebElement sortBy = driver.findElement(By.xpath("//span[@id='sort-arrow']"));
        sortBy.click();
        WaitMethods.sleep(2);
        final List<WebElement> filters = driver.findElements(By.xpath("//div[@class='refinement'][@data-bhc]"));
        for (final WebElement filter : filters) {
            if (filter.getAttribute("data-bhc").contains(filterId)) {
                filter.click();
                break;
            }
        }
    }

    HashMap<String, String> dealsNamesPrices = new HashMap<>();

    public void dealsNamesPricesPrint() {
        WaitMethods.sleep(2);
        int i = 0;
        for (final WebElement deal : dealsNames()) {
            for (WebElement price : dealsPrices()) {
                if (i < dealsPrices().size()) {
                    price = dealsPrices().get(i);
                    this.dealsNamesPrices.put(deal.getText(), price.getText());
                    i++;
                    break;
                }
            }
        }
        for (final String key : this.dealsNamesPrices.keySet()) {
            System.out.println(key + ": " + this.dealsNamesPrices.get(key));
        }
    }

}
