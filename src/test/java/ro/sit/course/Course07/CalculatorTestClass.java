package ro.sit.course.Course07;
import ro.sit.course.course06_07.Calculator;
import org.junit.*;
public class CalculatorTestClass {
    static double totalSum = 0;
    double result = 1;
    Calculator calculator = new Calculator();

    @Before
    public void resetResult() {
        result = 0;
    }

    @After
    public void calculateTotalSum() {
        totalSum += result;
    }

    @AfterClass()
    public static void printTotalSum() {
        System.out.println("Total sum is: " + totalSum);
    }

    @Test()
    public void testMultiplyForZero() {
        System.out.println("Initial result: " + result);
        result = calculator.compute(0, 1, "*");
        System.out.println("Result after compute: " + result);
        Assert.assertEquals(0, result, 0);
    }

    @Test()
    public void testAddition() {
        System.out.println("Initial result: " + result);
        result = calculator.compute(100, 25, "+");
        System.out.println("Result after compute: " + result);
        Assert.assertEquals(125, result, 0);
    }

    @Test()
    public void testSubtraction() {
        System.out.println("Initial result: " + result);
        result = calculator.compute(20, 1, "-");
        System.out.println("Result after compute: " + result);
        Assert.assertEquals(19, result, 0);
    }

    @Test()
    public void testMultiply() {
        System.out.println("Initial result: " + result);
        result = calculator.compute(11, 12, "*");
        System.out.println("Result after compute: " + result);
        Assert.assertEquals(132, result, 0);
    }

    @Test()
    public void testDivide() {
        System.out.println("Initial result: " + result);
        result = calculator.compute(33, 3, "/");
        System.out.println("Result after compute: " + result);
        Assert.assertEquals(11, result, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZeroWithoutFail() {
        System.out.println("Initial result: " + result);
        System.out.println("It will not work because we cannot divide by 0");
        result = calculator.compute(50, 0, "/");
        System.out.println("Result after compute: " + result);
        Assert.assertEquals(10, result, 0);
    }

    @Test()
    public void testDivideByZeroWithFail() {
        System.out.println("Initial result: " + result);
        System.out.println("It will not work because we cannot divide by 0");
        result = calculator.compute(50, 0, "/");
        System.out.println("Result after compute: " + result);
        Assert.assertEquals(10, result, 0);
    }

    // Homeowork Junits - 2 tests for each operation
    @Test()
    public void testAddingTwoNegativeNumbers() {
        result = calculator.compute(-5, -127, "+");
        Assert.assertEquals(-132, result, 0);
    }

    @Test()
    public void testAddingOnePositiveOneNegative() {
        result = calculator.compute(-32, 27, "+");
        Assert.assertEquals(-5, result, 0);
    }

    @Test()
    public void testSubstractNeagativeSecondParam() {
        result = calculator.compute(14, -21, "-");
        Assert.assertEquals(35, result, 0);
    }

    @Test()
    public void testSubstractBothNegativeNumbers() {
        result = calculator.compute(-15, -2, "-");
        Assert.assertEquals(-13, result, 0);
    }

    @Test()
    public void testMultiplyWithZero() {
        result = calculator.compute(25, 0, "*");
        Assert.assertEquals(0, result, 0);
    }

    @Test()
    public void testMultiplyWithTwoNegativeNumbers() {
        result = calculator.compute(-12, -6, "*");
        Assert.assertEquals(72, result, 0);
    }

    @Test()
    public void testDivideFromZero() {
        result = calculator.compute(0, 3, "/");
        Assert.assertEquals(0, result, 0);
    }

    @Test()
    public void testDivideWithTwoNegatives() {
        result = calculator.compute(-4, -2, "/");
        Assert.assertEquals(2, result, 0);
    }

    @Test()
    public void testSqrtOfZero() {
        result = calculator.compute(0, 0, "SQRT");
        Assert.assertEquals(0, result, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeSQRT() {
        result = calculator.compute(-4, 0, "SQRT");
        Assert.assertEquals(2, result, 0);
    }
}
