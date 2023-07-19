package ro.sit.course.Course07;

import ro.sit.course.course06_07.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Test
public class MyFirstTestNG {
    int count = 0;
    Calculator c;

    @BeforeClass
    public void setUp() {
        c = new Calculator();
        count = 2;
        System.out.println("SetUp before class");
    }

    @BeforeTest
    public void setUpTest() {
        count = 10;
        System.out.println("SetUp before test");
    }

    @BeforeMethod
    public void setUpMethod() {
        System.out.println("SetUp before method");
    }

    @Test(groups = {"smoke", "regression"})
    public void login() {
        System.out.println("I am test 1");
        Assert.assertFalse(1 != 1);
    }

    @Test(description = "I am second test", dependsOnMethods = "login", groups = {"smoke", "regression"})
    public void logout() {
        System.out.println("I am test for logout");
    }

    @Test(dependsOnMethods = {"login"}, alwaysRun = true, groups = {"smoke"})
    public void closeBrowser() {
        System.out.println("Closing the browser");
    }

    protected void test3() {
        System.out.println("I am test 3");
    }

    @Test(invocationCount = 10, threadPoolSize = 6)
    public void testMe() throws InterruptedException {
        count++;
        Thread.sleep(5000);
        System.out.println("Current value for count:" + count);
    }

    @Test(priority = 2, groups = {"regression"})
    public void runAllTime() {
        System.out.println("Test that run all time");
    }

    @DataProvider(parallel = true)
    public Object[][] calculatorDataProvider() {
        return new Object[][]{
                {5, 3, 2, "+", 0},
                {10, -6, -4, "-", 0},
                {24, -6, -4, "*", 0},
                {1.4142, 2, 0, "SQRT", 0.0001},
                {10, 20, 2, "/", 0}
        };
    }

    @Test(dataProvider = "calculatorDataProvider", invocationCount = 7, threadPoolSize = 3)
    public void verifyComputeCalculatorTest(double expectedResult, double fParam, double sParam,
                                            String op, double delta) throws InterruptedException {
        System.out.println("Compute calculator tests with delta:" + delta + " for next:(" + fParam + ")" + op +
                "(" + sParam + ")=" + expectedResult);
        Thread.sleep(5000);
        Assert.assertEquals(expectedResult, c.compute(fParam, sParam, op), delta);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Divide by ZERO")
    public void testExpectedException(){
        c.compute(20,0,"/");
    }

}
