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
}
