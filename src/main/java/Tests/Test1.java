package Tests;

import Utils.SeleniumDriver;
import org.testng.annotations.Test;

public class Test1 extends SeleniumDriver {
    @Test
    public void TestSearch() {
        goToUrl("https://staging.groupon.com/");

    }
}
