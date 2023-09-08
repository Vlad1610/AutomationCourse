package Tests;

import PageObjects.HoverPage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsTest extends BaseTest {
    LoginPage loginPage;
    HoverPage hoverPage;

    @Test
    public void hoverTest() {
        loginPage = new LoginPage(driver);
        loginPage.goToHoverPage();
        hoverPage = new HoverPage(driver);
        Assert.assertTrue(hoverPage.hoverMeButtonIsDisplayed(),
                "The Hover Me button is not displayed");
        hoverPage.moveToButton();
        List<String> dropDownOptions = hoverPage.getDropDownOptions();
        for (String dropDownOption : dropDownOptions) {
            System.out.println(dropDownOption);
//            String emptyString = "";
//            String emptyString2 = null;
            Assert.assertNotEquals("", dropDownOption, "The drop down option is empty");
//            Assert.assertFalse(dropDownOption.length() == 0);
        }
    }

    @Test
    public void clickFirstDropDownOption() {
        loginPage = new LoginPage(driver);
        loginPage.goToHoverPage();
        hoverPage = new HoverPage(driver);
        Assert.assertTrue(hoverPage.hoverMeButtonIsDisplayed(),
                "The Hover Me button is not displayed");
        hoverPage.moveToButton();
        hoverPage.clickDropDownOption(0);
        Assert.assertEquals(hoverPage.getDropDownOption(0),
                hoverPage.getSelectedDropDownOption(),
                "Incorrect drop down option selected");
    }
}