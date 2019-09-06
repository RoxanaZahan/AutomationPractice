package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class SeleniumDriver {
    public static WebDriver driver;


    @BeforeMethod
    public static void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver","/Users/roxana.zahan/IdeaProjects/AutomationPractice/target/classes/chromedriver/chromedriver");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;
    }

    @AfterMethod
    public static void afterMethod(){
        sleep(5000);
        driver.quit();
    }

    public static void sleep(int sleepMillis) {
        try {
            Thread.sleep(sleepMillis);
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

    //DO NOT lists below!! - I have to learn about dictionaries
    public List<WebElement> dealsNames() {
        //sleep(0);
        List<WebElement> deals = driver.findElements(By.xpath("//div[@class='cui-udc-title ']"));
        return deals;
    }

    public List<WebElement> dealsPrices() {
        //sleep(0);
        List<WebElement> prices = driver.findElements(By.xpath("//div[contains(@class, 'cui-price-discount c-txt-price')]"));
        return prices;
    }

    //this needs refactoring
    public void dealsNamesPricesPrint() {
        sleep(3000);
        dealsNames();
        dealsPrices();

        int i = 0;
        for (WebElement deal : dealsNames()) {
            System.out.printf(deal.getText() + ": ");
            for (WebElement price : dealsPrices()) {
                if (i < dealsPrices().size()) {
                    price = dealsPrices().get(i);
                    System.out.println(price.getText());
                    i++;
                    break;
                }
            }
        }
        //for (int i = 0; i < deals.size(); i++) {
        //    System.out.printf(deals.get(i).getText(), "%n");
        //}
    }

    //this probably work for local only
    public void categoriesClick(String categoryId) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement categories = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='btn-categories']")));
        categories.click();
        List<WebElement> categoriesL = driver.findElements(By.xpath("//div[contains(@class, 'l1-cat')]"));
        for (WebElement category : categoriesL) {
            if (category.getAttribute("id").contains(categoryId));
            category.click();
            WebElement shopAll = driver.findElement(By.xpath("//a[@class='shop-all-link']"));
            shopAll.click();
            break;
        }
    }

    public WebElement waitForElement(WebElement WebElement) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(WebElement));
    }

    public void waitForElement(By by){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //need a method for categories/local as well - as we seem to have 2 browsing variants
    public void navBarChannelClick(String channelId) {
        sleep(3000);
        List<WebElement> channels = driver.findElements(By.xpath("//li[@id]"));
        for (WebElement channel : channels) {
            if (channel.getAttribute("id").contains(channelId)) {
                channel.click();
                break;
            }
        }
    }

    //this needs refactoring
    public void sortByFilter(String filterId) {
        //sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement sortBy =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='sort-arrow']")));
        //WebElement sortBy = driver.findElement(By.xpath("//span[@id='sort-arrow']"));
        sortBy.click();
        sleep(3000);
        List<WebElement> filters = driver.findElements(By.xpath("//div[@class='refinement'][@data-bhc]"));
        for (WebElement filter : filters) {
            if (filter.getAttribute("data-bhc").contains(filterId)) {
                filter.click();
                break;
            }
        }
    }
}
