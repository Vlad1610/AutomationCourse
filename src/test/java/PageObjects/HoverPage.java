package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HoverPage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @FindBy(css = "p#result+div > button")
    private WebElement hoverMeButtonElement;

    @FindBy(css = "span.clicked")
    private WebElement selectedDropDownOptionElement;

    @FindBy(css = "p#result+div div[id]")
    private List<WebElement> dropDownElements;

    public HoverPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public boolean hoverMeButtonIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(hoverMeButtonElement));
        return hoverMeButtonElement.isDisplayed();
    }

    public List<String> getDropDownOptions() {
        List<String> dropDownOptions = new ArrayList<>();
        for (WebElement dropDownOptionElement : dropDownElements) {
            dropDownOptions.add(dropDownOptionElement.getText());
        }
        return dropDownOptions;
    }

    public void moveToButton() {
        actions.moveToElement(hoverMeButtonElement).perform();
    }

    public void clickDropDownOption(int dropDownOptionIndex) {
        actions.moveToElement(dropDownElements.get(dropDownOptionIndex)).click()
                .build().perform();
//        dropDownElements.get(dropDownOptionIndex).click();
    }

    public String getDropDownOption(int dropDownOptionIndex) {
        return dropDownElements.get(dropDownOptionIndex).getText();
    }

    public String getSelectedDropDownOption() {
        return selectedDropDownOptionElement.getText();
    }
}
