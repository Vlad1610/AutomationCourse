package Tests;

import PageObjects.AccountPage;
import PageObjects.LoginPage;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class LoginTest extends BaseTest {

    LoginPage loginPage;
    AccountPage accountPage;
    @DataProvider(name = "loginNDp")
    public Object[][] loginNegativeDataProvider() {
        return new Object[][]{
                {"", "", "chrome", "Please enter your username", "Please enter your password"},
                {"", "somePassword", "edge", "Please enter your username",""},
                {"test", "", "firefox","","Please enter your password" },
                {"zebra", "zebrapassword", "chrome", "", ""},

        };

    }

    @DataProvider(name = "loginPDp")
    public Object[][] loginPositiveDataProvider() {
        return new Object[][]{
                // [zebra/zebrapassword][dingo/dingopassword][camel/camelpassword]
                {"dingo", "dingopassword", "chrome"},
                {"camel", "camelpassword", "chrome"},
                {"zebra", "zebrapassword", "chrome"},

        };

    }



    @Test(dataProvider = "loginNDp")
    public void loginNegative(String username, String password, String browser, String usernameErr, String passErr) {
        System.out.println("Login with username:" + username + "/password:" + password + "=> on browser:" + browser);
        setUpDriver(browser);
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.login(username, password);
        System.out.println("Login finished. Verify error message");
        Assert.assertEquals(loginPage.getUsernameErr(),usernameErr);
        Assert.assertEquals(loginPage.getPassErr(),passErr);


    }

    @Test(dataProvider = "loginPDp")
    public void loginPositive(String username, String password, String browser) {
        // Welcome to web-stubs, dingo!
        System.out.println("Login with username:" + username + "/password:" + password + "=> on browser:" + browser);
        setUpDriver(browser);
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.login(username, password);
        System.out.println("Login finished. Verify error message");
        accountPage = new AccountPage(driver);
        Assert.assertTrue("Login succesfull: "+username,accountPage.getName().contains(username));
        System.out.println("Logout user");
    }


}
