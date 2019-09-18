package Utils;

public class WaitMethods extends SeleniumDriver {
    //SeleniumDriver seleniumDriver = new SeleniumDriver();

    public static void sleep(int sleepSeconds) {
        try {
            Thread.sleep(sleepSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public WebElement waitForElementToBeVisible(WebElement element) {
//        Wait<WebDriver> wait = new FluentWait<>(SeleniumDriver.driver)
//                .withTimeout(Duration.ofSeconds(5))
//                .pollingEvery(Duration.ofMillis(500))
//                .ignoring(NoSuchElementException.class);
//        return wait.until(ExpectedConditions.visibilityOf(element));
//    }
}
