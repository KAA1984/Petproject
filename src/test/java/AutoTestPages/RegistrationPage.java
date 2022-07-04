package AutoTestPages;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
public class RegistrationPage {

    By nameInput = By.xpath("//input[@name='name']");
    By lastNameInput = By.xpath("//input[@name='last_Name']");
    By emailInput = By.id("exampleInputEmail1");
    By passwordInput = By.id("exampleInputPassword1");
    By submitButton = By.xpath("//button[contains(@class,'btn-primary')]");

/*
    public void setName(String nameText){
        WebdriverSetUp.driver.findElement(nameInput).sendKeys(nameText);
    }

    public void setLastName(String lastNameText) {
        WebdriverSetUp.driver.findElement(lastNameInput).sendKeys(lastNameText);

    }
    public void setEmailRegistration(String emailText){
        WebdriverSetUp.driver.findElement(emailInput).sendKeys(emailText);
    }

    public void setPasswordRegistration(String passwordText){
        WebdriverSetUp.driver.findElement(passwordInput).sendKeys(passwordText);
    }
    public void submitRegistration(){
        WebdriverSetUp.driver.findElement(submitButton).click();
    }
*/
    public void openRegistrationPage() {
        WebdriverSetUp.driver.get("http://online-sh.herokuapp.com/registration");
    }
    public void checkUserIsRedirectToLogin(){
        String curruntUrl = WebdriverSetUp.driver.getCurrentUrl();
        Assertions.assertEquals("http://online-sh.herokuapp.com/login", curruntUrl);
    }
    public void checkOfNameFieldOfRegistrationForm(){

        boolean displayedNameField = WebdriverSetUp.driver.findElement(nameInput).isDisplayed();
        Assertions.assertTrue(displayedNameField);
    }

    public void checkOfLastNameFieldOfRegistrationForm(){

        boolean displayedLastNameField = WebdriverSetUp.driver.findElement(lastNameInput).isDisplayed();
        Assertions.assertTrue(displayedLastNameField);
    }

    public void checkOfEmailFieldOfRegistrationForm(){

        boolean displayedEmailField = WebdriverSetUp.driver.findElement(emailInput).isDisplayed();
        Assertions.assertTrue(displayedEmailField);
    }
    public void checkOfPasswordFieldOfRegistrationForm(){

        boolean displayedPasswordField = WebdriverSetUp.driver.findElement(passwordInput).isDisplayed();
        Assertions.assertTrue(displayedPasswordField);
    }
    public void checkOfRegisterButtonOfRegistrationForm(){

        boolean enabledRegisterButton = WebdriverSetUp.driver.findElement(submitButton).isEnabled();
        Assertions.assertTrue(enabledRegisterButton);

    }
    public void registrationProcess(String name,String lastName,String email,String password){

        WebdriverSetUp.driver.get("http://online-sh.herokuapp.com/registration");
        WebdriverSetUp.driver.findElement(nameInput).sendKeys(name);
        WebdriverSetUp.driver.findElement(lastNameInput).sendKeys(lastName);
        WebdriverSetUp.driver.findElement(emailInput).sendKeys(email);
        WebdriverSetUp.driver.findElement(passwordInput).sendKeys(password);
        WebdriverSetUp.driver.findElement(submitButton).click();
    }

    public void checkValidationMessageOfRegistrationForm(){
        String validationMessage = WebdriverSetUp.driver.findElement(By.id("exampleInputEmail1")).getAttribute("validationMessage");
        //THEN
        Assertions.assertEquals("Адрес электронной почты должен содержать символ \"@\". В адресе \"testtest.com\" отсутствует символ \"@\".",
                validationMessage);
    }

}
