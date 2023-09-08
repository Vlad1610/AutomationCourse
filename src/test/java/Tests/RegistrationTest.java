package Tests;

import PageObjects.LoginPage;
import PageObjects.RegistrationPage;
import course.course06_07.MyCustomException;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
    LoginPage loginPage;
    RegistrationPage registrationPage;

    @Test
    public void registerTest() throws MyCustomException {
        loginPage = new LoginPage(driver);
        loginPage.goToRegistrationPage();
        registrationPage = new RegistrationPage(driver);
//        registrationPage.clickTermsCheckboxUsingActionsScroll();
        registrationPage.clickTermsCheckboxUsingJsScroll();
    }
}