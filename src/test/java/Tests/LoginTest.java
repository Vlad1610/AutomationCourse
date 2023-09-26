package Tests;

import PageObjects.LoginPage;
import TestListenersExtendReports.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @DataProvider(name = "loginDp")
    public Object[][] loginDataProvider() {
        return new Object[][]{
                {"", "", "chrome", "Please enter your username", "Please enter your password"},
                {"", "somePassword", "edge", "Please enter your username", ""},
                {"test", "", "firefox", "", "Please enter your password"},
                {"zebra", "zebrapassword", "chrome", "", ""}
        };
    }

    @Test(dataProvider = "loginDp")
    public void login(String username, String password, String browser, String usernameErr, String passErr, Method method) {
        ExtentTestManager.startTest(method.getName() + "(user:'" + username + "',pass:'" + password + "')", "");

        System.out.println("Login with username:" + username + "/password:" + password + "=> on browser:" + browser);
        ExtentTestManager.getTest().log(Status.INFO, "Login with username:" + username + "/password:" + password + "=> on browser:" + browser);

        setUpDriver(browser);
        driver.get(baseUrl);

        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.login(username, password);

        System.out.println("Login Finished, verify error message");
        ExtentTestManager.getTest().log(Status.INFO, "Login Finished, verify error message");
//                          actual results ,         expected results
        ExtentTestManager.getTest().log(Status.INFO, "Verify username message are same: actual results:" + loginPage.getUsernameErr() +
                " VS expected results:" + usernameErr);
        Assert.assertEquals(loginPage.getUsernameErr(), usernameErr);

        ExtentTestManager.getTest().log(Status.INFO, "Verify password message are same: actual results:" + loginPage.getPassErr() +
                " VS expected results:" + passErr);
        Assert.assertEquals(loginPage.getPassErr(), passErr);
    }
}