package OldTests;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MyFirstTest {

    @Test
    public void htmlUnitDriverTest() {
        WebDriver htmlUnitDriver = new HtmlUnitDriver();
        htmlUnitDriver.get("https://www.google.com/");
        System.out.println("Page title: " + htmlUnitDriver.getTitle());
        htmlUnitDriver.navigate().to("https://www.facebook.com/");
        System.out.println("Page title after navigate to facebook page: "
                + htmlUnitDriver.getTitle());
        htmlUnitDriver.navigate().back();
        System.out.println("Page title after back method: " + htmlUnitDriver.getTitle());
        htmlUnitDriver.navigate().forward();
        System.out.println("Page title after forward method: " + htmlUnitDriver.getTitle());
        htmlUnitDriver.navigate().refresh();
        htmlUnitDriver.quit();
    }

    @Test
    public void chromeDriverTest() {
        //path catre chromedriver.exe al fiecaruia dintre voi
        System.setProperty("webdriver.chrome.driver",
                "C:\\Radu\\scoala_informala_IT\\automation\\src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.google.com/");
        System.out.println("Page title: " + chromeDriver.getTitle());
        chromeDriver.navigate().to("https://www.facebook.com/");
        System.out.println("Page title after navigate to facebook page: "
                + chromeDriver.getTitle());
        chromeDriver.navigate().back();
        System.out.println("Page title after back method: " + chromeDriver.getTitle());
        chromeDriver.navigate().forward();
        System.out.println("Page title after forward method: " + chromeDriver.getTitle());
        chromeDriver.navigate().refresh();
        chromeDriver.quit();
    }

    @Test
    public void switchWindowHandles() {
        //path catre chromedriver.exe al fiecaruia dintre voi
        System.setProperty("webdriver.chrome.driver",
                "C:\\Radu\\scoala_informala_IT\\automation\\src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://www.google.com/");
        for (String currentBrowserTab : chromeDriver.getWindowHandles()) {
            chromeDriver.switchTo().window(currentBrowserTab);
            System.out.println("Current tab title: " + chromeDriver.getTitle());
        }
        //close inchide browser tab-ul curent
        //quit inchide browserul cu totul, indiferent de nr de tab-uri deschise
//        chromeDriver.close();
        chromeDriver.quit();
    }

    @Test
    public void edgeDriverTest() {
        System.setProperty("webdriver.edge.driver",
                "C:\\Radu\\scoala_informala_IT\\automation\\src\\test\\resources\\drivers\\msedgedriver.exe");
        WebDriver edgeDriver = new EdgeDriver();
//        edgeDriver.get("https://www.google.com/");
        edgeDriver.navigate().to("https://www.google.com/");
        System.out.println("Page title: " + edgeDriver.getTitle());
        edgeDriver.quit();
    }

    @Test
    public void webElementTestGetText() {
        //path catre chromedriver.exe al fiecaruia dintre voi
        System.setProperty("webdriver.chrome.driver",
                "C:\\Radu\\scoala_informala_IT\\automation\\src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("http://86.121.249.151:4999/");
        WebElement titleElement = chromeDriver.findElement(By.tagName("h1"));
        System.out.println(titleElement.getText());
        chromeDriver.quit();
    }

    @Test
    public void webElementTestSendTextToField() {
        //path catre chromedriver.exe al fiecaruia dintre voi
        System.setProperty("webdriver.chrome.driver",
                "C:\\Radu\\scoala_informala_IT\\automation\\src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("http://86.121.249.151:4999/");
        WebElement loginElement = chromeDriver.findElement(By.tagName("h2"));
        loginElement.click();
        WebElement usernameElement = chromeDriver.findElement(By.id("user"));
        usernameElement.sendKeys("zebra");
        System.out.println("username field content: " + usernameElement.getAttribute("value"));
        Assert.assertEquals("Incorrect username", "zebra",
                usernameElement.getAttribute("value"));
        usernameElement.clear();
        Assert.assertEquals("Username was not deleted", "", usernameElement.getAttribute("value"));
        chromeDriver.quit();
    }

    @Test
    public void printSideButton() throws InterruptedException {
        //path catre chromedriver.exe al fiecaruia dintre voi
        System.setProperty("webdriver.chrome.driver",
                "C:\\Radu\\scoala_informala_IT\\automation\\src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
//        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        chromeDriver.get("http://86.121.249.151:4999/");
        List<WebElement> sidebarButtonsElements =
                chromeDriver.findElements(By.xpath("//div[@class='sidebar']/a[not(@target)]"));
        for (WebElement currentButtonElement : sidebarButtonsElements) {
            System.out.println("Button text: " + currentButtonElement.getText());
        }
        WebElement waitButtonElement = sidebarButtonsElements.get(sidebarButtonsElements.size() - 1);
        waitButtonElement.click();
        WebElement answerElement = chromeDriver.findElement(By.cssSelector("p.answer"));
        System.out.println("Calculating answer element: " + answerElement.getText());
        WebElement giveAnswerButtonElement = chromeDriver.findElement(By.id("answer-trigger"));
        WebElement answerBeforeCalculateElement = chromeDriver.findElement(By.cssSelector(".answer"));
        System.out.println("Is answer displayed: " + answerBeforeCalculateElement.isDisplayed());
        giveAnswerButtonElement.click();
        System.out.println("Calculating answer element: " + answerElement.getText());
//        System.out.println("Before Thread sleep");
        //nu folositi niciodata Thread.sleep
//        Thread.sleep(30000);
//        System.out.println("After Thread sleep");
//        WebElement responseElement = chromeDriver.findElement(By.xpath("//p[text()='42']"));
        WebElement responseElement =
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//p[text()='42']")));
        System.out.println("Response element text: " + responseElement.getText());
        chromeDriver.quit();
    }

    @Test
    public void isCheckboxSelected() {
        //path catre chromedriver.exe al fiecaruia dintre voi
        System.setProperty("webdriver.chrome.driver",
                "C:\\Radu\\scoala_informala_IT\\automation\\src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://86.121.249.151:4999/");
        List<WebElement> sidebarButtonsElements =
                chromeDriver.findElements(By.xpath("//div[@class='sidebar']/a[not(@target)]"));
        for (WebElement currentButtonElement : sidebarButtonsElements) {
            System.out.println("Button text: " + currentButtonElement.getText());
        }
        WebElement clickInterceptedElement = sidebarButtonsElements.get(3);
        clickInterceptedElement.click();
        WebElement checkboxElement = chromeDriver.findElement(By.id("the_checkbox"));
        System.out.println("Checkbox is selected: " + checkboxElement.isSelected());
        WebElement checkboxTextElement = chromeDriver.findElement(By.cssSelector(".off"));
        checkboxTextElement.click();
        Assert.assertTrue("Checkbox is not selected", checkboxElement.isSelected());
        chromeDriver.quit();
    }
}
