package TestNGExtercisesPackage;

import org.testng.annotations.Test;

public class TestNGPriority {

    @Test(priority = 0)
    public void Test1() {
        System.out.println("test1");
    }

    @Test(priority = 1)
    public void Test2() {
        System.out.println("test2");
    }

    @Test(priority = 2)
    public void Test3() {
        System.out.println("test3");
    }

    @Test(priority = 3)
    public void Test4() {
        System.out.println("test4");
    }
}
