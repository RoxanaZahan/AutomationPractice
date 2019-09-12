package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import static java.util.concurrent.TimeUnit.SECONDS;

public class SeleniumDriver {
    public static WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    @BeforeMethod
    public static void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver","/Users/roxana.zahan/IdeaProjects/AutomationPractice/target/classes/chromedriver/chromedriver");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;
    }

//    @AfterMethod
//    public static void afterMethod(){
//        sleep(2);
//        driver.quit();
//    }

    public static void sleep(int sleepSeconds) {
        try {
            Thread.sleep(sleepSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void goToUrl(String host) {
        driver.get(host);
    }

    public void noThanksClick() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement nTclick =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='nothx']")));
        nTclick.click();
        //driver.findElement(By.xpath("//*[@id='nothx']")).click();
    }

    public void freeTextSearch(String freeText) {
        //sleep(3000);
        //WebElement textSearch =  driver.findElement(By.xpath("//*[@id='ls-search']"));
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement textSearch =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ls-search']")));
        textSearch.sendKeys(freeText);
        textSearch.sendKeys(Keys.ENTER);
    }

    public void categoriesSearch(String dataId) {
        //sleep(5000);
        WebElement categories = driver.findElement(By.xpath("//*[@id='featured-category-box']"));
        categories.click();
        List<WebElement> categoriesItems = driver.findElements(By.xpath("//li[@data-id]"));
        for (WebElement cItem : categoriesItems) {
            if (cItem.getAttribute("data-id").contains(dataId)) {
                cItem.click();
                break;
            }
        }
    }

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

    public WebElement waitForElement(WebElement WebElement) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(WebElement));
    }


    public boolean isElementVisible(WebElement webElement){
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, 2);
        try{
            element = wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception e){ }
        try{
            if(element.isDisplayed()){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    public void waitForElement(By by){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    //this needs refactoring
    public void sortByFilter(String filterId) {
        sleep(2);
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement sortBy =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='sort-arrow']")));
        //WebElement sortBy = driver.findElement(By.xpath("//span[@id='sort-arrow']"));
        sortBy.click();
        sleep(2);
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
        sleep(2);
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

    public boolean isElementDisplayed(final WebElement element, final int timeout) {
        final long startTime = System.currentTimeMillis();
        while ((System.currentTimeMillis() - startTime) < SECONDS.toMillis(timeout)) {
            try {
                return element.isDisplayed();
            }
            catch (final NoSuchElementException ignored) {
                sleep(1);
            }
        }
        return false;
    }

    public WebElement waitForElementToBeVisible(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }



}
