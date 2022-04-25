package systemTests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


import java.time.Duration;
import java.util.List;
import java.util.Random;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class SeleniumTests {
    String URL = "http://localhost:8080/";
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        final String chromeDriverPath = "C:\\Users\\viole\\Desktop\\web\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();

        driver.manage().window().setSize(new Dimension(1000, 1000));
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void testFindSpecimens() {
        driver.get(URL);
        HomePage homePage = new HomePage(driver);
        WebElement idField = homePage.getIdField();
        idField.sendKeys("3");
        WebElement findBtn = homePage.getFindBtn();
        findBtn.click();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        Assert.assertEquals(driver.findElement(By.cssSelector("h5")).getText(), "Образец №3");

        WebElement sourceField = homePage.getSourceField();
        sourceField.sendKeys("экспедиция");
        findBtn = homePage.getFindBtn();
        findBtn.click();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        Assert.assertEquals(driver.findElement(By.id("source")).getText(), "экспедиция");
    }
}