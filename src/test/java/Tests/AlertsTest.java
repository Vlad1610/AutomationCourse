package Tests;

import PageObjects.AlertsPage;
import PageObjects.LoginPage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {
    LoginPage loginPage;
    AlertsPage alertsPage;


    @Test
    public void openAlert() {
        loginPage = new LoginPage(driver);
        loginPage.goToAlertsPage();
        alertsPage = new AlertsPage(driver);
        Assert.assertTrue(alertsPage.openAlertButtonIsDisplayed());
        alertsPage.openAlert();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
//        alertsPage.openConfirmationAlert();
    }

    @Test
    public void openConfirmationAlert() {
        loginPage = new LoginPage(driver);
        loginPage.goToAlertsPage();
        alertsPage = new AlertsPage(driver);
        Assert.assertTrue(alertsPage.openConfirmationAlertButtonIsDisplayed());
        alertsPage.openConfirmationAlert();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
    }

    @Test
    public void openPromptDialogAlert() {
        loginPage = new LoginPage(driver);
        loginPage.goToAlertsPage();
        alertsPage = new AlertsPage(driver);
        Assert.assertTrue(alertsPage.openPromptDialogAlertButtonIsDisplayed());
        alertsPage.openPromptDialogAlert();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("This is a test message");
        alert.accept();
    }
}