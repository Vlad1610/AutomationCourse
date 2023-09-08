package Tests;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class CookiesGoogleTest extends BaseTest {

    @Test
    public void googleCookies() {
        Set<Cookie> googleCookies = driver.manage().getCookies();
        for (Cookie cookie : googleCookies) {
            System.out.println(cookie.getName() + ":" + cookie.getValue());
        }
    }

    @Test
    public void printConsentCookie() {
        Cookie consentCookie = driver.manage().getCookieNamed("CONSENT");
        Assert.assertNotNull(consentCookie, "Checking that the cookie is not null");
        System.out.println("Consent cookie value: " + consentCookie.getValue());
    }
}