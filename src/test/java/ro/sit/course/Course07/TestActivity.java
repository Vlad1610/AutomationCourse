package ro.sit.course.Course07;

import javafx.scene.input.DataFormat;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestActivity {

    @DataProvider(parallel = true)
    public Object[][] displayDataProvider() {
        return new Object[][] {
                {"un text"},
                {"pentru testat"},
                {"in cadrul activitatii"}
        };
    }
    @Test(dataProvider = "displayDataProvider", groups = {"print"}, invocationCount = 5, threadPoolSize = 2)
    public void test1(String param) throws InterruptedException {
        printString(param);
    }
    @Test
    public void test2() throws InterruptedException {
        printString("Text din test 2");
    }

    private void printString(String string) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println(string);
    }
}
