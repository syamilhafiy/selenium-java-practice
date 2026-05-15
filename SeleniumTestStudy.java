import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeleniumTestStudy{

    @Test
    public void checkLoginHeading(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless=new");
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        //options.addArguments("--disable-blink-features=AutomationControlled");

        driver = new ChromeDriver(options);
        
        driver.get("https://courses.ultimateqa.com/users/sign_in");

        WebElement heading = driver.findElement(By.tagName("h2"));
//      WebElement heading = driver.findElement(By.className("page__heading")); // alternative selector
        String actualText = heading.getText();
        String expectedText = "Welcome!";

        assertEquals(expectedText,actualText);

        driver.quit();
    }
}
