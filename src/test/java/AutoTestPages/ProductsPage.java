package AutoTestPages;
import org.openqa.selenium.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    //By emailInput = By.id("exampleInputEmail1");
    //By passwordInput = By.id("exampleInputPassword1");
    //By submitButton = By.xpath("(//button[contains(@class,'btn-primary')]");
   // By addProductsButton = By.xpath("(//a[@href='/products/add'])");
    By productNameField = By.id("exampleInputProduct1");
    By productPriceField = By.id("exampleInputPrice1");
    By submitAddNewProductsButton = By.xpath("(//button[@class='btn btn-outline-success'])");
    By updateButton = By.xpath("//button[text() = 'Update']/preceding-sibling::input[@value='127']");
    By submitButton = By.xpath("(//button[@class='btn btn-outline-warning'])");
    By deleteButton = By.xpath("(//button[@class ='btn btn-outline-danger'][1])");
    By logOutButton = By.xpath("//a[@href ='/logout']");



/*
    public void setEmailLoginPage(String emailText){
        driver.findElement(emailInput).sendKeys(emailText);
    }

    public void setPasswordLoginPage(String passwordText){
        driver.findElement(passwordInput).sendKeys(passwordText);
    }
    public void submit(){
        driver.findElement(submitButton).click();
    }

 */
    public void openProductsPage() {
        WebdriverSetUp.driver.get("http://online-sh.herokuapp.com/products");
    }
    public void openAddProductsPage() {
        WebdriverSetUp.driver.get("http://online-sh.herokuapp.com/products/add");
    }

    public void openUpdateProductsPage() {
        WebdriverSetUp.driver.get("http://online-sh.herokuapp.com/products/update?id=127");
    }
    public void clickAddButton(){
        //driver.findElement(addProductsButton);
       // ((JavascriptExecutor)driver).executeScript("arguments[0].click()", addProductsButton);
        WebElement addProductsButton = WebdriverSetUp.driver.findElement(By.xpath("(//a[@href='/products/add'])"));
        ((JavascriptExecutor)WebdriverSetUp.driver).executeScript("arguments[0].click()", addProductsButton);
    }
    public void addProductName(String productName){
        WebdriverSetUp.driver.findElement(productNameField).sendKeys(productName);
    }

    public void addPriceName(String priceName){
        WebdriverSetUp.driver.findElement(productPriceField).sendKeys(priceName);

    }
    public void submitAddPNewProductButton(){
        WebdriverSetUp.driver.findElement(submitAddNewProductsButton).click();
    }
    public void clickUpdateTheProductButton(){

        WebElement updateButton = WebdriverSetUp.driver.findElement(By.xpath("//button[text() = 'Update']/preceding-sibling::input[@value='137']"));

        updateButton.submit();

    }
    public void updateTheProductName(String updateProductName){
        WebdriverSetUp.driver.findElement(productNameField).sendKeys(updateProductName);
    }

    public void updateTheProductPrice(String updatePriceName){
        WebdriverSetUp.driver.findElement(productPriceField).sendKeys(updatePriceName);
    }

    public void submitOfTheUpdatedTheProductButton(){

        WebdriverSetUp.driver.findElement(By.xpath("//button[@type = 'submit']")).submit();

    }
    public void clearTheProductName(){
        WebdriverSetUp.driver.findElement(productNameField).clear();
    }
    public void clearThePriceName(){
        WebdriverSetUp.driver.findElement(productPriceField).clear();
    }
    public void clickDeleteTheProductButton(){
        WebdriverSetUp.driver.findElement(deleteButton).submit();
    }

    public void clickLogOutButtonOnTheProductPage(){
        //driver.findElement(logOutButton).click();
        WebElement logOutButton = WebdriverSetUp.driver.findElement(By.xpath("//a[@href ='/logout']"));
        ((JavascriptExecutor) WebdriverSetUp.driver).executeScript("arguments[0].click()", logOutButton);
    }
}
