package ro.sit.course.course06;
import org.junit.*;
public class TestClass {
    @Test
    public void myTestMethod() {
        System.out.println("Hello world");
    }

    @Test
    @Ignore
    public void myTestMethod2() {
        System.out.println("Hello world again");
    }

    @Before
    public void beforeMethod() {
        System.out.println("This method runs before each test");
    }

    @After
    public void afterMethod() {
        System.out.println("This method runs after each test");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("This method runs before each test class, but runs only once");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("This method runs before each test class, but runs only once");
    }
}
