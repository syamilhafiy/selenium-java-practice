# Practice Test 1 - Check Login Heading

For this practice I will be using UltimateQA's automation [website](https://ultimateqa.com/automation) as it offers a variety of elements to be tested.

## Test Case 1
| Field | Details |
|---|---|
| Test URL | `https://courses.ultimateqa.com/users/sign_in` |
| Expected Result | Page heading displays `Welcome!` |
| Actual Result | Page heading displays `Welcome!` |
| Status | PASS |

## Test Script
```java
public class SeleniumTestStudy {

// Test method
@Test
public void checkLoginHeading() {

    // BaseTest setup
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    // options.addArguments("--headless=new");                   // run without browser window
    options.addArguments("--incognito");                         // open in incognito mode
    options.addArguments("--start-maximized");                   // open maximized
    // options.addArguments("--disable-blink-features=AutomationControlled"); // hide automation flag
    driver = new ChromeDriver(options);

    driver.get("https://courses.ultimateqa.com/users/sign_in");

    WebElement heading = driver.findElement(By.tagName("h2"));
    // WebElement heading = driver.findElement(By.className("page__heading")); // alternative locator

    String actualText   = heading.getText();
    String expectedText = "Welcome!";

    assertEquals(expectedText, actualText);

    driver.quit(); //closes the browser after test is completed
}
```

## Learning Outcome
1. Use `ChromeOptions` to configure browser behaviour
   — `--incognito`, `--start-maximized`, `--headless`
2. Write a `@Test` method following JUnit 5 structure.
3. Locate web elements using `By.tagName()` and `By.className()`.
4. Use `assertEquals(expected, actual)` to verify page content.
5. Understand that multiple locators can target the same element.
