import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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
}
