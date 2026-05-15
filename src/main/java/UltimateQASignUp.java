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
