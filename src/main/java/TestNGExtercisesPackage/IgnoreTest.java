package TestNGExtercisesPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IgnoreTest {
    String message = "Manisha";
    MessageUtil3 messageUtil3 = new MessageUtil3(message);

    //This type of annotation ignores your test..
    @Test(enabled = false)
    public void testPrintMessage() {
        System.out.println("Inside testPrintMessage()");
        message = "Manisha";
        Assert.assertEquals(message, messageUtil3.printMessage());
    }

    @Test
    public void testSalutationMessage() {
        System.out.println("Inside testSalutationMessage()");
        message = "Hi!" + "Manisha";
        Assert.assertEquals(message, messageUtil3.salutationMessage());
    }
}
