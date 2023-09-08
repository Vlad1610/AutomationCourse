package Tests;

import PageObjects.CookiePage;
import PageObjects.LoginPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class CookieTest extends BaseTest {
    LoginPage loginPage;
    CookiePage cookiePage;

    @Test
    public void printCookie() {
        loginPage = new LoginPage(driver);
//        cookiePage = loginPage.goToCookiePage();
        loginPage.goToCookiePage();
        cookiePage = new CookiePage(driver);
        Assert.assertTrue(cookiePage.setCookieButtonIsDisplayed(),
                "Cookie button is not displayed");
        Cookie pageTitleCookie = driver.manage().getCookieNamed("cookiePageTitle");
        Assert.assertEquals(cookiePage.getPageTitle(), pageTitleCookie.getValue(),
                "Incorrect page title");
//        driver.manage().deleteCookie(pageTitleCookie);
//        driver.manage().deleteCookieNamed("cookiePageTitle");
//        pageTitleCookie = driver.manage().getCookieNamed("cookiePageTitle");
//        Assert.assertEquals(cookiePage.getPageTitle(), pageTitleCookie.getValue(),
//                "Incorrect page title");
        driver.navigate().refresh();
        cookiePage.clickSetCookieButton();
        Cookie consentCookie = driver.manage().getCookieNamed("gibberish");
        Assert.assertNotNull(consentCookie, "Checking that the cookie is not null");
        System.out.println("Consent cookie value: " + consentCookie.getValue());
        Assert.assertEquals(consentCookie.getValue(),
                cookiePage.getDisplayedCookie(),
                "Incorrect cookie values");
        cookiePage.removeCookie();
        //is displayed returneaza true chiar daca elementul nu mai este vizibil in pagina, dar exista in DOM
//        Assert.assertFalse(cookiePage.cookieValueIsDisplayed(),
//                "Cookie value is still displayed");
        Assert.assertEquals("",
                cookiePage.getDisplayedCookie(),
                "Incorrect cookie values");
        consentCookie = driver.manage().getCookieNamed("gibberish");
        Assert.assertNull(consentCookie, "Cookie is still present");
    }

    @Test
    public void deleteAllCookies() throws IOException {
        loginPage = new LoginPage(driver);
        loginPage.goToCookiePage();
        cookiePage = new CookiePage(driver);
        Assert.assertTrue(cookiePage.setCookieButtonIsDisplayed(),
                "Cookie button is not displayed");
        Cookie pageTitleCookie = driver.manage().getCookieNamed("cookiePageTitle");
        Assert.assertEquals(cookiePage.getPageTitle(), pageTitleCookie.getValue(),
                "Incorrect page title");
        driver.navigate().refresh();
        cookiePage.clickSetCookieButton();
        Set<Cookie> allCookies = driver.manage().getCookies();
        for (Cookie cookie : allCookies) {
            System.out.println(cookie.getName() + ":" + cookie.getValue());
        }
        System.out.println("-----------------------");
        driver.manage().deleteAllCookies();
        allCookies = driver.manage().getCookies();
        for (Cookie cookie : allCookies) {
            System.out.println(cookie.getName() + ":" + cookie.getValue());
        }

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File finalFile = new File("screenshots/image.png");
        FileUtils.copyFile(screenshotFile, finalFile);
    }
}