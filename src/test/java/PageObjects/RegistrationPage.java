package PageObjects;

import ro.sit.course.course06_07.MyCustomException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    @FindBy(css = "input#terms+label")
    private WebElement termsCheckboxElement;

    @FindBy(css = "button[class='btn btn-primary']")
    private WebElement submitRegistrationButtonElement;

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    //solution 1
    public void clickTermsCheckboxUsingActionsScroll() throws MyCustomException {
        wait.until(ExpectedConditions.visibilityOf(termsCheckboxElement));
        int currentRetry = 0;
        while (currentRetry < 50) {
            try {
                actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL).build().perform();
                termsCheckboxElement.click();
                break;
            } catch (MoveTargetOutOfBoundsException | ElementClickInterceptedException e) {
                currentRetry++;
            }
        }
        if (currentRetry >= 50) {
            throw new MyCustomException("Max retry reached");
        }
    }

    //solution 2
    public void clickTermsCheckboxUsingJsScroll() throws MyCustomException {
        wait.until(ExpectedConditions.visibilityOf(termsCheckboxElement));
        int currentRetry = 0;
        while (currentRetry < 50) {
            try {
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].scrollIntoView(true);", termsCheckboxElement);
                termsCheckboxElement.click();
                break;
            } catch (ElementClickInterceptedException e) {
                currentRetry++;
            }
        }
        if (currentRetry >= 50) {
            throw new MyCustomException("Max retry reached");
        }
    }
}