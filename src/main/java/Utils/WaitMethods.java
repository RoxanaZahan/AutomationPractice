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

    public static void sleep(final int sleepSeconds) {
        try {
            Thread.sleep(sleepSeconds * 1000);
        }
        catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement waitForElementToBeVisible(final WebElement element) {
        final Wait<WebDriver> wait = new FluentWait<>(SeleniumDriver.driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeVisible2(final By by) {
        final Wait<WebDriver> wait = new FluentWait<>(SeleniumDriver.driver)
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
            catch (final Exception ignored) {
                WaitMethods.sleep(1);
            }
        }
        return false;
    }

    public WebElement waitForElement(final WebElement WebElement) {
        final WebDriverWait wait = new WebDriverWait(this.seleniumDriver.driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(WebElement));
    }


    public boolean isElementVisible(final WebElement webElement) {
        WebElement element = null;
        final WebDriverWait wait = new WebDriverWait(this.seleniumDriver.driver, 2);
        try {
            element = wait.until(ExpectedConditions.visibilityOf(webElement));
        }
        catch (final Exception e) { }
        try {
            if (element.isDisplayed()) {
                return true;
            }
        }
        catch (final Exception e) {}
        return false;
    }

    public void waitForElement(final By by) {
        final WebDriverWait wait = new WebDriverWait(this.seleniumDriver.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
