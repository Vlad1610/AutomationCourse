package Registration_homework;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class RegistrationTest {
    private WebDriver chromeDriver;

    @DataProvider(name = "LoginInfoDataProvider")
    public Iterator<Object[]> LoginInfoDataProvider() {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[] {"", "", "", "", "", "", "Please choose a username",
                "Please choose a password", "Passwords do not match", ""});
        dp.add(new String[] {"Vlad123", "", "", "", "", "", "",
                "Please choose a password", "Passwords do not match", ""});
        dp.add(new String[] {"Vlad123", "Vlad1234", "Vlad", "Vlad", "Constantin", "vlad@yahoo.com",
        "", "", "Passwords do not match", ""});
        dp.add(new String[] {"Vlad123", "Vlad3", "Vlad3", "Vlad", "Constantin", "vlad@yahoo.com",
                "", "", "", "Please choose a longer password"});
        return dp.iterator();
    }

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.get("http://86.121.249.151:4999/");
    }
    @AfterMethod
    public void quit() {
        chromeDriver.quit();
    }

    @Test(dataProvider = "LoginInfoDataProvider")
    public void RegisterTest(String username, String password, String confirmPassword, String firstName, String lastName,
                             String email, String userError, String passwordError, String passDoNotMatch, String passTooShort) {

        WebElement loginButtonElement = chromeDriver.findElement(By.tagName("h2"));
        loginButtonElement.click();

        WebElement registerButton = chromeDriver.findElement(By.xpath("//p[2]/div/a"));
        registerButton.click();

        WebElement usernameElement = chromeDriver.findElement(By.id("username"));
        usernameElement.clear();
        usernameElement.sendKeys(username);

        WebElement passwordElement = chromeDriver.findElement(By.id("password"));
        passwordElement.clear();
        passwordElement.sendKeys(password);

        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
        js.executeScript("window.scrollBy(0,300)", "");

        WebElement confirmPasswordElement = chromeDriver.findElement(By.id("password2"));
        confirmPasswordElement.clear();
        confirmPasswordElement.sendKeys(confirmPassword);


        //WebElement titleElement = chromeDriver.findElement(By.id("Mr"));
        //titleElement.click();

        WebElement titleElement = chromeDriver.findElement(By.id("Mr"));
        Actions actions = new Actions(chromeDriver);
        actions.moveToElement(titleElement).click().perform();


        actions.moveToElement(chromeDriver.findElement(By.id("input-first-name")));

        WebElement firstNameElement = chromeDriver.findElement(By.id("input-first-name"));
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);

        WebElement lastNameElement = chromeDriver.findElement(By.id("input-last-name"));
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);


        WebElement emailElement = chromeDriver.findElement(By.id("input-email"));
        emailElement.clear();
        emailElement.sendKeys(email);


        WebDriverWait wait = new WebDriverWait(chromeDriver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[12]/button")));

        WebElement termsElement = chromeDriver.findElement(By.id("terms"));
        actions.moveToElement(termsElement).click().perform();

        WebElement submitElement = chromeDriver.findElement(By.xpath("//div[12]/button"));
        actions.moveToElement(submitElement).click().perform();

        js.executeScript("window.scrollTo(0, 0)");
        js.executeScript("arguments[0].scrollIntoView();", usernameElement);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/small[2]")));

        //WebElement usernameErrorElement = chromeDriver.findElement(By.xpath("//div[1]/small[2]"));
        //String actualUserError = usernameErrorElement.getText();

        //WebElement passErrorElement = chromeDriver.findElement(By.xpath("//div[2]/small[2]"));
        //String actualPassError = passErrorElement.getText();

        //WebElement PasswordDoNotMatchElement = chromeDriver.findElement(By.xpath("//div[3]/small[2]"));
        //String actualRepeatPassError = PasswordDoNotMatchElement.getText();

        if(username.length() == 0 && password.length() == 0) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/small[2]")));

            WebElement usernameErrorElement = chromeDriver.findElement(By.xpath("//div[1]/small[2]"));
            String actualUserError = usernameErrorElement.getText();
            WebElement passErrorElement = chromeDriver.findElement(By.xpath("//div[2]/small[2]"));
            String actualPassError = passErrorElement.getText();

            Assert.assertEquals("Incorrect password error message", userError, actualUserError);
            Assert.assertEquals("Incorrect username error message", passwordError, actualPassError);

        } else if(username.length() == 0) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/small[2]")));

            WebElement usernameErrorElement = chromeDriver.findElement(By.xpath("//div[1]/small[2]"));
            String actualUserError = usernameErrorElement.getText();

            Assert.assertEquals("Incorrect password error message", userError, actualUserError);
        } else if(password.length() == 0) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/small[2]")));

            WebElement passErrorElement = chromeDriver.findElement(By.xpath("//div[2]/small[2]"));
            String actualPassError = passErrorElement.getText();
            Assert.assertEquals("Incorrect username error message", passwordError, actualPassError);
        } else if(password.length() < 8) {
            wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/small[2]"))));

            WebElement needLongerPassErrorElement = chromeDriver.findElement(By.xpath("//div[2]/small[2]"));
            String actualTooShortError = needLongerPassErrorElement.getText();
            Assert.assertEquals("Password need to be at least 8 digits", passTooShort, actualTooShortError);
        } else if(!password.equals(confirmPassword)) {
            wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[3]/small[2]"))));

            WebElement PasswordDoNotMatchElement = chromeDriver.findElement(By.xpath("//div[3]/small[2]"));
            String actualPassDoNotMatchError = PasswordDoNotMatchElement.getText();
            Assert.assertEquals("Passwords do not match error", passDoNotMatch, actualPassDoNotMatchError);
        }

    }
}
