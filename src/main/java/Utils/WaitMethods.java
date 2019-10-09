package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static java.util.concurrent.TimeUnit.SECONDS;

public class WaitMethods {
    SeleniumDriver seleniumDriver = new SeleniumDriver();

    public static void sleep(int sleepSeconds) {
        try {
            Thread.sleep(sleepSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement waitForElementToBeVisible(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(SeleniumDriver.driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeVisible2(By by) {
        Wait<WebDriver> wait = new FluentWait<>(SeleniumDriver.driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
    }

    public boolean isElementDisplayed(final WebElement element, final int timeout) {
        final long startTime = System.currentTimeMillis();
        while ((System.currentTimeMillis() - startTime) < SECONDS.toMillis(timeout)) {
            try {
                return element.isDisplayed();
            }
            catch (final NoSuchElementException ignored) {
                WaitMethods.sleep(1);
            }
        }
        return false;
    }

    public WebElement waitForElement(WebElement WebElement) {
        WebDriverWait wait = new WebDriverWait(seleniumDriver.driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(WebElement));
    }


    public boolean isElementVisible(WebElement webElement){
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(seleniumDriver.driver, 2);
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
        WebDriverWait wait = new WebDriverWait(seleniumDriver.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
