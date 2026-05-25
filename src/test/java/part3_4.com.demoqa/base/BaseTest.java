package part3_4.com.demoqa.base;

import com.demoqa.pages.HomePage;
import com.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.base.BasePage.delay;
import static utilities.Utility.setUtilityDriver;

public class BaseTest {

    private WebDriver driver;
    protected BasePage basePage; //from POM
    protected HomePage homepage; //from POM
    private String DEMOQA_URL = "https://demoqa.com/";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void loadApplication(){
        driver.get(DEMOQA_URL);
        basePage = new BasePage(); // create new instance of basePage
        basePage.setDriver(driver); // set the driver
        setUtilityDriver();
        homepage = new HomePage(); // create new instance of homePage
    }

    @AfterClass
    public void tearDown() {
        delay(3000);
        driver.quit();
    }
}
