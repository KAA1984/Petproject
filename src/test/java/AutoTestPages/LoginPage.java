package AutoTestPages;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
public class LoginPage {

    private final WebDriver driver;

    By emailInput = By.id("exampleInputEmail1");
    By passwordInput = By.id("exampleInputPassword1");
    By submitButton = By.xpath("//button[contains(@class,'btn-primary')]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setEmail(String emailText){
        driver.findElement(emailInput).sendKeys(emailText);
    }

    public void setPassword(String passwordText){
        driver.findElement(passwordInput).sendKeys(passwordText);
    }
    public void submit(){
        driver.findElement(submitButton).click();
    }

    public void openLoginPage() {
        driver.get("http://online-sh.herokuapp.com/login");
    }
}
