package UI;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Page page;

    Duration seconds = Duration.ofSeconds(20);

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, seconds);
        driver.manage().window().maximize();
        page = new Page(driver, wait);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
