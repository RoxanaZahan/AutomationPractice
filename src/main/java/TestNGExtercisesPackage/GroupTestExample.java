package TestNGExtercisesPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupTestExample {
    String message = ".com";
    MessageUtil4 messageUtil4 = new MessageUtil4(message);

    @Test(groups = { "functest", "checkintest" })

    public void testPrintMessage() {
        System.out.println("Inside testPrintMessage()");
        message = ".com";
        Assert.assertEquals(message, messageUtil4.printMessage());
    }

    @Test(groups = { "checkintest" })

    public void testSalutationMessage() {
        System.out.println("Inside testSalutationMessage()");
        message = "tutorialspoint" + ".com";
        Assert.assertEquals(message, messageUtil4.salutationMessage());
    }

    @Test(groups = { "functest" })

    public void testingExitMessage() {
        System.out.println("Inside testExitMessage()");
        message = "www." + "tutorialspoint"+".com";
        Assert.assertEquals(message, messageUtil4.exitMessage());
    }
}
