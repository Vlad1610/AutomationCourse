package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "alert-trigger")
    private WebElement openAlertButtonElement;

    @FindBy(id = "confirm-trigger")
    private WebElement openConfirmationAlertButtonElement;

    @FindBy(id = "prompt-trigger")
    private WebElement openPromptDialogAlertButtonElement;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public boolean openAlertButtonIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(openAlertButtonElement));
        return openAlertButtonElement.isDisplayed();
    }

    public boolean openConfirmationAlertButtonIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(openConfirmationAlertButtonElement));
        return openConfirmationAlertButtonElement.isDisplayed();
    }

    public boolean openPromptDialogAlertButtonIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(openPromptDialogAlertButtonElement));
        return openPromptDialogAlertButtonElement.isDisplayed();
    }

    public void openAlert() {
        openAlertButtonElement.click();
    }

    public void openConfirmationAlert() {
        openConfirmationAlertButtonElement.click();
    }

    public void openPromptDialogAlert() {
        openPromptDialogAlertButtonElement.click();
    }
}