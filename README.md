# Practice Test 2 - Click Follow On Twitter button and verify username
For this practice I will be using UltimateQA's
[complicated page](https://ultimateqa.com/complicated-page) which offers 
a variety of elements to interact with.  

## Test Case 2
| Field | Details |
|---|---|
| Test URL | `https://ultimateqa.com/complicated-page` |
| Action | Click **Follow on Twitter** button under Social Media Follows section |
| Expected Result | Redirected to `https://x.com/Nikolay_A00` and username `Nikk Advolodkin` is displayed |
| Actual Result | Redirected to `https://x.com/Nikolay_A00` and username `Nikk Advolodkin` is displayed |
| Status | ✅ PASS |

## Test Script
```java
public class SeleniumTestStudy {

@Test
    public void checkFollowTwitter() { //practice element locator, click twitter button, and find username

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless=new");
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        //options.addArguments("--disable-blink-features=AutomationControlled");

        driver = new ChromeDriver(options);

        driver.get("https://ultimateqa.com/complicated-page");

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement tbutton = wait.until(d -> driver.findElement(By.cssSelector("[title='Follow on Twitter']")));
        tbutton.click();

        // Switch to new tab that opened
        String originalTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(originalTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }

        WebElement username = wait.until(d -> driver.findElement(By.xpath("//span[contains(text(),'Nikk Advolodkin')]")));
        String actualText = username.getText();
        String expectedText = "Nikk Advolodkin";

        assertEquals(expectedText, actualText);

        driver.quit();
    }
```

## Learning Outcome
1. Use `WebDriverWait` to ensure elements are loaded before proceeding to the next line.
2. Use `cssSelector` with `title` attribute — `[title='value']` — to locate elements.
3. Store a `WebElement` in a variable to perform actions like `.click()`.
4. Switch driver focus to a new tab using `driver.switchTo().window()`.
5. Locate elements using `By.xpath()` with `contains(text(), 'value')` for partial text match.
