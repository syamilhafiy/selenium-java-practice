package com.demoqa.pages;

import com.base.BasePage;
import com.demoqa.pages.forms.FormsPage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.clickJS;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class HomePage extends BasePage {

    private By formsCard = By.xpath("//div[@id='root']//h5[text()='Forms']");

    public FormsPage goToForms(){
        scrollToElementJS(formsCard);
        clickJS(formsCard);
        BasePage.delay(2000);
        return new FormsPage();
    }

}
