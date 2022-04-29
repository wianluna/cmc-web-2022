package systemTests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

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
        driver.manage().timeouts().pageLoadTimeout(10, SECONDS);
        wait = new WebDriverWait(driver,10);
    }

    @Test(priority = 1)
    public void testFindSpecimens() {
        driver.get(URL);
        driver.findElement(By.xpath("//*[@name = 'specimens_id']")).sendKeys("3");
        driver.findElement(By.xpath("//*[contains(text(), 'Поиск')]")).click();
        Assert.assertEquals(driver.findElement(By.id("obj_title")).getText(), "Образец №3");

        driver.findElement(By.xpath("//*[@name = 'specimens_id']")).sendKeys("0");
        driver.findElement(By.xpath("//*[contains(text(), 'Поиск')]")).click();
        Assert.assertEquals(driver.findElement(By.id("no_obj")).getText(), "Образцы не найдены");

        driver.findElement(By.xpath("//*[@name = 'source']")).sendKeys("экспедиция");
        driver.findElement(By.xpath("//*[contains(text(), 'Поиск')]")).click();
        Assert.assertEquals(driver.findElement(By.id("source")).getText(), "экспедиция");

        driver.findElement(By.xpath("//*[@name = 'source']")).sendKeys("тест");
        driver.findElement(By.xpath("//*[contains(text(), 'Поиск')]")).click();
        Assert.assertEquals(driver.findElement(By.id("no_obj")).getText(), "Образцы не найдены");

        driver.findElement(By.xpath("//*[@name = 'possible_origin']")).sendKeys("кристаллизация магмы");
        driver.findElement(By.xpath("//*[contains(text(), 'Поиск')]")).click();
        Assert.assertEquals(driver.findElement(By.id("possible_origin")).getText(), "кристаллизация магмы");

        driver.findElement(By.xpath("//*[@name = 'possible_origin']")).sendKeys("тест");
        driver.findElement(By.xpath("//*[contains(text(), 'Поиск')]")).click();
        Assert.assertEquals(driver.findElement(By.id("no_obj")).getText(), "Образцы не найдены");

        driver.findElement(By.xpath("//*[@name = 'source']")).sendKeys("экспедиция");
        driver.findElement(By.xpath("//*[@name = 'possible_origin']")).sendKeys("кристаллизация магмы");
        driver.findElement(By.xpath("//*[contains(text(), 'Поиск')]")).click();
        Assert.assertEquals(driver.findElement(By.id("source")).getText(), "экспедиция");
        Assert.assertEquals(driver.findElement(By.id("possible_origin")).getText(), "кристаллизация магмы");
    }

    @Test(priority = 2)
    public void testFindExpedition() {
        driver.get(URL);
        driver.findElement(By.xpath("//*[contains(text(), 'Экспедиции')]")).click();
        driver.findElement(By.xpath("//*[@name = 'date_start']")).sendKeys("2009-07-20");
        driver.findElement(By.xpath("//*[@name = 'date_end']")).sendKeys("2009-08-21");
        driver.findElement(By.xpath("//*[contains(text(), 'Поиск')]")).click();
        Assert.assertEquals(driver.findElement(By.id("obj_title")).getText(), "Экспедиция №3");

        driver.findElement(By.xpath("//*[@name = 'date_start']")).sendKeys("2009-07-20");
        driver.findElement(By.xpath("//*[@name = 'date_end']")).sendKeys("2009-07-20");
        driver.findElement(By.xpath("//*[contains(text(), 'Поиск')]")).click();
        Assert.assertEquals(driver.findElement(By.id("no_obj")).getText(), "Экспедиции не найдены");
    }

    @Test(priority = 3)
    public void testFindMineral() {
        driver.get(URL);
        driver.findElement(By.xpath("//*[contains(text(), 'Минералы')]")).click();
        driver.findElement(By.xpath("//*[@name = 'species_name']")).sendKeys("апатит");
        driver.findElement(By.xpath("//*[contains(text(), 'Поиск')]")).click();
        Assert.assertEquals(driver.findElement(By.id("obj_title")).getText(), "апатит");

        driver.findElement(By.xpath("//*[@name = 'species_name']")).sendKeys("минерал");
        driver.findElement(By.xpath("//*[contains(text(), 'Поиск')]")).click();
        Assert.assertEquals(driver.findElement(By.id("no_obj")).getText(), "Минералы не найдены");
    }

    @Test(priority = 4)
    public void testAddExpedition() {
        driver.get(URL);
        driver.findElement(By.xpath("//*[contains(text(), 'Экспедиции')]")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Добавить экспедицию')]")).click();

        driver.findElement(By.xpath("//*[@name = 'date_start']")).sendKeys("2022-04-01");
        driver.findElement(By.xpath("//*[@name = 'date_end']")).sendKeys("2022-04-26");
        driver.findElement(By.xpath("//*[@name = 'members']")).sendKeys("Морковкин");
        driver.findElement(By.xpath("//*[@name = 'description']")).sendKeys("Тестовая экспедиция");
        driver.findElement(By.xpath("//*[contains(text(), 'Сохранить')]")).click();

        driver.findElement(By.xpath("//*[@name = 'date_start']")).sendKeys("2022-04-01");
        driver.findElement(By.xpath("//*[@name = 'date_end']")).sendKeys("2022-04-26");
        driver.findElement(By.xpath("//*[contains(text(), 'Поиск')]")).click();

        Assert.assertEquals(driver.findElement(By.id("date_start")).getText(), "2022-04-01");
        Assert.assertEquals(driver.findElement(By.id("date_end")).getText(), "2022-04-26");
    }

    @Test(priority = 5)
    public void testEditExpedition() {
        driver.get(URL);
        driver.findElement(By.xpath("//*[contains(text(), 'Экспедиции')]")).click();

        driver.findElement(By.xpath("//*[@name = 'date_start']")).sendKeys("2022-04-01");
        driver.findElement(By.xpath("//*[@name = 'date_end']")).sendKeys("2022-04-26");
        driver.findElement(By.xpath("//*[contains(text(), 'Поиск')]")).click();
        WebElement ele = driver.findElement(By.xpath("//*[contains(text(), 'Детальнее')]"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", ele);
        Assert.assertEquals(driver.findElement(By.id("description")).getText(), "Тестовая экспедиция");
        driver.findElement(By.xpath("//*[contains(text(), 'Редактировать')]")).click();

        driver.findElement(By.xpath("//*[@name = 'members']")).sendKeys(", Помидоркин");
        driver.findElement(By.xpath("//*[contains(text(), 'Сохранить')]")).click();

        driver.findElement(By.xpath("//*[@name = 'date_start']")).sendKeys("2022-04-01");
        driver.findElement(By.xpath("//*[@name = 'date_end']")).sendKeys("2022-04-26");
        driver.findElement(By.xpath("//*[contains(text(), 'Поиск')]")).click();

        ele = driver.findElement(By.xpath("//*[contains(text(), 'Детальнее')]"));
        jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", ele);

        Assert.assertEquals(driver.findElement(By.id("members")).getText(), "Морковкин, Помидоркин");
    }

    @Test(priority = 6)
    public void testDeleteExpedition() {
        driver.get(URL);
        driver.findElement(By.xpath("//*[contains(text(), 'Экспедиции')]")).click();

        driver.findElement(By.xpath("//*[@name = 'date_start']")).sendKeys("2022-04-01");
        driver.findElement(By.xpath("//*[@name = 'date_end']")).sendKeys("2022-04-26");
        driver.findElement(By.xpath("//*[contains(text(), 'Поиск')]")).click();
        WebElement ele = driver.findElement(By.xpath("//*[contains(text(), 'Детальнее')]"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", ele);
        Assert.assertEquals(driver.findElement(By.id("description")).getText(), "Тестовая экспедиция");
        driver.findElement(By.xpath("//*[contains(text(), 'Удалить')]")).click();

        driver.findElement(By.xpath("//*[@name = 'date_start']")).sendKeys("2022-04-01");
        driver.findElement(By.xpath("//*[@name = 'date_end']")).sendKeys("2022-04-26");
        driver.findElement(By.xpath("//*[contains(text(), 'Поиск')]")).click();
        wait.until(visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Экспедиции не найдены')]")));
    }

    @Test(priority = 7)
    public void testAddSpecimen() {
        driver.get(URL);
        driver.findElement(By.xpath("//*[contains(text(), 'Добавить образец')]")).click();
        wait.until(visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Новый образец')]")));

        driver.findElement(By.xpath("//*[@name = 'possible_origin']")).sendKeys("происхождение тестового образца");
        driver.findElement(By.xpath("//*[@name = 'source']")).sendKeys("источник тестового образца");
        driver.findElement(By.xpath("//*[@name = 'location']")).sendKeys("Сызрань");
        driver.findElement(By.xpath("//*[@name = 'coordinates']")).sendKeys("(10.00, 10.00)");
        driver.findElement(By.xpath("//*[@name = 'expedition_id']")).sendKeys("4");
        driver.findElement(By.xpath("//*[contains(text(), 'Сохранить')]")).click();

        driver.findElement(By.xpath("//*[contains(text(), 'Экспедиции')]")).click();
        driver.findElement(By.xpath("//*[@name = 'date_start']")).sendKeys("2010-06-25");
        driver.findElement(By.xpath("//*[@name = 'date_end']")).sendKeys("2010-07-22");
        driver.findElement(By.xpath("//*[contains(text(), 'Поиск')]")).click();
        WebElement ele = driver.findElement(By.xpath("//*[contains(text(), 'Детальнее')]"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", ele);

        driver.findElement(By.id("btn_specimens")).click();
        wait.until(visibilityOfElementLocated(By.xpath("//*[contains(text(), 'происхождение тестового образца')]")));
        wait.until(visibilityOfElementLocated(By.xpath("//*[contains(text(), 'источник тестового образца')]")));
    }

    @Test(priority = 8)
    public void testEditSpecimen() {
        driver.get(URL);
        driver.findElement(By.xpath("//*[contains(text(), 'Экспедиции')]")).click();
        driver.findElement(By.xpath("//*[@name = 'date_start']")).sendKeys("2010-06-25");
        driver.findElement(By.xpath("//*[@name = 'date_end']")).sendKeys("2010-07-22");
        driver.findElement(By.xpath("//*[contains(text(), 'Поиск')]")).click();
        WebElement ele = driver.findElement(By.xpath("//*[contains(text(), 'Детальнее')]"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", ele);

        driver.findElement(By.id("btn_specimens")).click();
        ele = driver.findElement(By.xpath("//*[contains(text(), 'Детальнее')]"));
        jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", ele);
    }
}