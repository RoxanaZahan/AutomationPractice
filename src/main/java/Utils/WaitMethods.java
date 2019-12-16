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

    public WebElement waitForElementToBeClickable(final WebElement element) {
        final Wait<WebDriver> wait = new FluentWait<>(SeleniumDriver.driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeClickableByPath() {
        final WebElement ha = seleniumDriver.driver.findElement(By.xpath("//button[@id='buttonwithclass']"));
        ha.click();
    }


    public WebElement waitForElementToBeVisible(final WebElement element) {
        final Wait<WebDriver> wait = new FluentWait<>(SeleniumDriver.driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.visibilityOf(element));
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
}
