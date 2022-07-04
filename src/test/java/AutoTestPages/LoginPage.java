package AutoTestPages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static AutoTestPages.WebdriverSetUp.driver;

public class LoginPage {

    By emailInput = By.id("exampleInputEmail1");
    By passwordInput = By.id("exampleInputPassword1");
    By submitButton = By.xpath("//button[contains(@class,'btn-primary')]");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500L));


    public void setEmail(String emailText){
        wait.until(ExpectedConditions.presenceOfElementLocated(emailInput));
        driver.findElement(emailInput).sendKeys(emailText);

    }
 /*
    public void setPassword(String passwordText){
        driver.findElement(passwordInput).sendKeys(passwordText);
    }
  */
    public void submit(){
        wait.until(ExpectedConditions.presenceOfElementLocated(submitButton));
        driver.findElement(submitButton).click();
    }

    public void openLoginPage() {
        driver.get("http://online-sh.herokuapp.com/login");
    }

    public void checkOfEmailField(){
        boolean enabledEmail = driver.findElement(emailInput).isEnabled();
        wait.until(ExpectedConditions.presenceOfElementLocated(emailInput));
        Assertions.assertTrue(enabledEmail);

    }
    public void checkOfPasswordField(){

        boolean enabledSubmitButton = driver.findElement(passwordInput).isEnabled();
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordInput));
        Assertions.assertTrue(enabledSubmitButton);

    }
    public void checkOfSubmitButtonField(){

        boolean enabledPassword = driver.findElement(submitButton).isEnabled();
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        Assertions.assertTrue(enabledPassword);

    }

    public void loginProcess(String emailText ,String passwordText){
        driver.get("http://online-sh.herokuapp.com/login");
        driver.findElement(emailInput).sendKeys(emailText);
        driver.findElement(passwordInput).sendKeys(passwordText);
        driver.findElement(submitButton).click();


    }

    public void checkUserIsRedirectToProducts(){
        String curruntUrl = driver.getCurrentUrl();
        wait.until(ExpectedConditions.urlToBe(curruntUrl));
        Assertions.assertEquals("http://online-sh.herokuapp.com/products", curruntUrl);
    }

    public void checkValidationMessage(){
        String validationMessage = driver.findElement(By.id("exampleInputEmail1")).getAttribute("validationMessage");
        //THEN
        Assertions.assertEquals("Адрес электронной почты должен содержать символ \"@\". В адресе \"testtestcom\" отсутствует символ \"@\".",
                validationMessage);
    }

}
