package utilities;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility extends Utility {

    public static void scrollToElementJS(By locator) {
        WebElement element = BasePage.driver.findElement(locator);
        String jsScript = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(jsScript, element);
    }

    public static void clickJS(By locator) {
        WebElement element = BasePage.driver.findElement(locator);
        ((JavascriptExecutor) BasePage.driver).executeScript("arguments[0].click();", element);
    }
}
