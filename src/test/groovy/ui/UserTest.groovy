package ui

import cz.upce.nnpia_cv5.NnpiaCviceni5Application
import cz.upce.nnpia_cv5.datafactory.Creator
import cz.upce.nnpia_cv5.entity.TrainingUnit
import cz.upce.nnpia_cv5.entity.User
import cz.upce.nnpia_cv5.repository.TrainingUnitRepository
import cz.upce.nnpia_cv5.repository.UserRepository
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import
import org.springframework.test.context.ContextConfiguration

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = NnpiaCviceni5Application.class)
@Import(Creator.class)
public class UserTest {

    private WebDriver driver;


    @Autowired
    Creator creator;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TrainingUnitRepository trainingUnitRepository;


    @BeforeAll
    public static void setupWebdriverChromeDriver() {
        String chromedriverPath =  UserTest.class.getResource("/chromedriver.exe").getFile();
        System.setProperty("webdriver.chrome.driver", chromedriverPath);
    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        TrainingUnit unit = creator.saveEntity(new TrainingUnit()) as TrainingUnit
        unit.setReservation(null)
        trainingUnitRepository.save(unit)
    }

    @AfterEach
    public void teardown() {
        userRepository.deleteAll()
        trainingUnitRepository.deleteAll()
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void createUserTest() {
        driver.get("http://localhost:8080/sign-up");
        driver.findElement(By.id("username")).sendKeys("testUser");
        driver.findElement(By.id("firstName")).sendKeys("Test");
        driver.findElement(By.id("surname")).sendKeys("User");
        driver.findElement(By.id("password")).sendKeys("pass");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assert.assertEquals(1, driver.findElements(By.xpath("//a[@href='/logout']")).size());
        Assert.assertEquals(1, driver.findElements(By.xpath("//a[contains(text(), 'rezervovat')]")).size());
    }

    @Test
    public void LoginUserTest() {
        creator.saveEntity(new User(username: "test", password: "pass"))

        driver.get("http://localhost:8080/login");
        driver.findElement(By.id("username")).sendKeys("test");
        driver.findElement(By.id("password")).sendKeys("pass");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assert.assertEquals(1, driver.findElements(By.xpath("//a[@href='/logout']")).size());
        Assert.assertEquals(1, driver.findElements(By.xpath("//a[contains(text(), 'rezervovat')]")).size());
    }

}
