package AutoTestPages;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
public class RegistrationPage {

    private final WebDriver driver;

    By nameInput = By.xpath("//input[@name='name']");
    By lastNameInput = By.xpath("//input[@name='last_Name']");
    By emailInput = By.id("exampleInputEmail1");
    By passwordInput = By.id("exampleInputPassword1");
    By submitButton = By.xpath("//button[contains(@class,'btn-primary')]");

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    public void setName(String nameText){
        driver.findElement(nameInput).sendKeys(nameText);
    }

    public void setLastName(String lastNameText) {
        driver.findElement(lastNameInput).sendKeys(lastNameText);

    }
    public void setEmailRegistration(String emailText){
        driver.findElement(emailInput).sendKeys(emailText);
    }

    public void setPasswordRegistration(String passwordText){
        driver.findElement(passwordInput).sendKeys(passwordText);
    }
    public void submitRegistration(){
        driver.findElement(submitButton).click();
    }

    public void openRegistrationPage() {
        driver.get("http://online-sh.herokuapp.com/registration");
    }

}
