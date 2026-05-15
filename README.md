# Practice Test 3
Before I begin, I am creating a new Java class under test/java named `BaseStructure` to consolidate duplicate global steps such as browser open and close behaviour. This way my actual test class `SeleniumTestStudy` can be simplified to only show test scripts.

```java
public class BaseStructure {

    protected WebDriver driver;

    @BeforeEach
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();       //opens browser in selected mode
        //options.addArguments("--headless=new");
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        //options.addArguments("--disable-blink-features=AutomationControlled");

        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void tearDown(){

        driver.quit();     // closes browser after test complete
    }
}
```
In this practice test, I will be dealing with multiple elements such as input fields `Name`, `Email`, `Message`, `Captcha`, and button `Submit`.  
As these input fields are constant, it is a good practice to consolidate them in a Page Object Model (POM). I call this class `UltimateQASignUp`

```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UltimateQASignUp {

    private WebDriver driver;

    public UltimateQASignUp (WebDriver driver) {
        this.driver = driver;
    }

    By nameLoc = By.id("et_pb_contact_name_0");
    By emailLoc = By.id("et_pb_contact_email_0");
    By messageLoc = By.id("et_pb_contact_message_0");
    By captchaLoc = By.name("et_pb_contact_captcha_0");
    By submitLoc = By.name("et_builder_submit_button");
    By responseLoc = By.cssSelector(".et-pb-contact-message");

    public void fillForm(String name, String email, String message, int captchaOffset){
        //Fill Form
        driver.findElement(nameLoc).sendKeys(name);
        driver.findElement(emailLoc).sendKeys(email);
        driver.findElement(messageLoc).sendKeys(message);

        //Dynamic solving of captcha
        WebElement captcha = driver.findElement(captchaLoc);
        int firstDigit  = Integer.parseInt(captcha.getAttribute("data-first_digit"));
        int secondDigit = Integer.parseInt(captcha.getAttribute("data-second_digit"));
        int answer      = firstDigit + secondDigit + captchaOffset;
        captcha.sendKeys(String.valueOf(answer));
    }

    public void checkWrongCaptcha(String name, String email, String message, int captchaOffset){
        //Fill Form
        driver.findElement(nameLoc).sendKeys(name);
        driver.findElement(emailLoc).sendKeys(email);
        driver.findElement(messageLoc).sendKeys(message);

        //Dynamic solving of captcha
        WebElement captcha = driver.findElement(captchaLoc);
        int firstDigit  = Integer.parseInt(captcha.getAttribute("data-first_digit"));
        int secondDigit = Integer.parseInt(captcha.getAttribute("data-second_digit"));
        int answer      = firstDigit + secondDigit + captchaOffset;
        captcha.sendKeys(String.valueOf(answer));
    }

    public void checkInvalidEmail(String name, String email, String message, int captchaOffset){
        //Fill Form
        driver.findElement(nameLoc).sendKeys(name);
        driver.findElement(emailLoc).sendKeys(email); // Invalid email
        driver.findElement(messageLoc).sendKeys(message);

        //Dynamic solving of captcha
        WebElement captcha = driver.findElement(captchaLoc);
        int firstDigit  = Integer.parseInt(captcha.getAttribute("data-first_digit"));
        int secondDigit = Integer.parseInt(captcha.getAttribute("data-second_digit"));
        int answer      = firstDigit + secondDigit + captchaOffset;
        captcha.sendKeys(String.valueOf(answer));
    }

    public void submitButton(){
        //Submit Form
        driver.findElement(submitLoc).click();
    }
}
```
## Test Case 3a - Valid Input
| Field | Details |
|-------|---------|
| Test URL | `https://ultimateqa.com/complicated-page` |
| Action | Fill form with valid inputs and click Submit |
| Name | `Syamil Hafiy` |
| Email | `syamilhca@gmail.com` |
| Message | `Hello World!` |
| Captcha | Sum of two displayed numbers |
| Expected Result | `Thanks for contacting us` is displayed |
| Actual Result | `Thanks for contacting us` is displayed |
| Status | ✅ PASS |

### Test Script
 ```java
 public class SeleniumTestStudy extends BaseStructure{

    @Test
    public void fillSignUpForm() { //Fill sign up form

        driver.get("https://ultimateqa.com/complicated-page");

        UltimateQASignUp ultimateQASignUpPom = new UltimateQASignUp(driver); //Naming POM variable

        //Fill Form
        ultimateQASignUpPom.fillForm(
          "Syamil Hafiy",
          "syamilhca@gmail.com",
          "Hello World!",
          0
          );

        //Submit Form
        ultimateQASignUpPom.submitButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement response = wait.until (
                ExpectedConditions.visibilityOfElementLocated(ultimateQASignUpPom.responseLoc)
        );
        String responseText = response.getText().trim();

        assertEquals("Thanks for contacting us", responseText);
    }
}
```
## Test Case 3b — Wrong Captcha

| Field | Details |
|-------|---------|
| Test URL | `https://ultimateqa.com/complicated-page` |
| Action | Fill form with incorrect captcha answer |
| Captcha | Sum of two numbers + 1 (intentionally wrong) |
| Expected Result | `You entered the wrong number in captcha.` is displayed |
| Actual Result | `You entered the wrong number in captcha.` is displayed |
| Status | ✅ PASS |

### Test Script

```java
@Test
    public void testWrongCaptcha() { //Fill sign up form with wrong Captcha

        driver.get("https://ultimateqa.com/complicated-page");

        UltimateQASignUp ultimateQASignUpPom = new UltimateQASignUp(driver); //Naming POM variable

        //Fill Form
        ultimateQASignUpPom.fillForm(
          "Syamil Hafiy",
          "syamilhca@gmail.com",
          "Hello World!",
          1
          );

        //Submit Form
        ultimateQASignUpPom.submitButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement response = wait.until (
                ExpectedConditions.visibilityOfElementLocated(ultimateQASignUpPom.responseLoc)
        );
        String responseText = response.getText().trim();

        assertEquals("You entered the wrong number in captcha.", responseText);
    }
```

## Test Case 3c — Invalid Email

| Field | Details |
|-------|---------|
| Test URL | `https://ultimateqa.com/complicated-page` |
| Action | Fill form with invalid email format |
| Email | `s` |
| Expected Result | `Invalid email` error is displayed |
| Actual Result | `Invalid email` error is displayed |
| Status | ✅ PASS |

### Test Script

```java
@Test
    public void testInvalidEmail() { //Fill sign up form with invalid email

        driver.get("https://ultimateqa.com/complicated-page");

        UltimateQASignUp ultimateQASignUpPom = new UltimateQASignUp(driver); //Naming POM variable

        //Fill Form
        ultimateQASignUpPom.fillForm(
          "Syamil Hafiy",
          "s",
          "Hello World!",
          0
          );

        //Submit Form
        ultimateQASignUpPom.submitButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement response = wait.until (
                ExpectedConditions.visibilityOfElementLocated(ultimateQASignUpPom.responseLoc)
        );
        String responseText = response.getText().trim();

        assertEquals("Invalid email", responseText);
    }
```

## Learning Outcome
1. Create a `BaseStructure` class with `@BeforeEach` and `@AfterEach` to eliminate 
   repeated browser setup code across test classes.
2. Create a **Page Object Model (POM)** class to consolidate locators and actions, 
   keeping test scripts clean and reusable.
3. Pass test data as **parameters** into POM methods instead of hardcoding values.
4. Dynamically solve captcha using `getAttribute()` to read `data-first_digit` 
   and `data-second_digit` HTML attributes.
5. Use `ExpectedConditions.visibilityOfElementLocated()` to wait for response 
   message before asserting.
6. Use `response.getText().trim()` to clean whitespace before comparison.
