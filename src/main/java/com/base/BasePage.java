package com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    public static WebDriver driver;

    public void setDriver(WebDriver driver) { // setting the driver
       BasePage.driver = driver;
    }

    protected WebElement find(By locator) { // finding the WebElement
        return driver.findElement(locator);
    }

    protected void set(By locator,String text) { // setting the values
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void click(By locator) { // clicking the element
        find(locator).click();
    }

    public static void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException exc) {
            exc.printStackTrace();
        }
    }
}
