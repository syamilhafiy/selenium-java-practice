import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseStructure {

    protected WebDriver driver;

    @BeforeEach
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless=new");
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        //options.addArguments("--disable-blink-features=AutomationControlled");

        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void tearDown(){

        driver.quit();
    }
}
