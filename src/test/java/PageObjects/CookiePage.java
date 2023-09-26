package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CookiePage {

    @FindBy(id = "set-cookie")
    private WebElement setCookieButtonElement;

    @FindBy(id = "cookie-value")
    private WebElement cookieValueElement;

    @FindBy(id = "delete-cookie")
    private WebElement removeCookieButtonElement;

    @FindBy(tagName = "h1")
    private WebElement pageTitleElement;

    WebDriver driver;
    WebDriverWait wait;

    public CookiePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean setCookieButtonIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(setCookieButtonElement));
        return setCookieButtonElement.isDisplayed();
    }

    public void clickSetCookieButton() {
        setCookieButtonElement.click();
    }

    public String getDisplayedCookie() {
        return cookieValueElement.getText();
    }

    public void removeCookie() {
        removeCookieButtonElement.click();
    }

    public boolean cookieValueIsDisplayed() {
        return cookieValueElement.isDisplayed();
    }

    public String getPageTitle() {
        return pageTitleElement.getText();
    }
}