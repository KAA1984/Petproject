package AutoTestScenario;
import AutoTestPages.LoginPage;
import AutoTestPages.ProductsPage;
import AutoTestPages.RegistrationPage;
import AutoTestPages.WebdriverSetUp;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class TestCases {

        private static LoginPage loginPage;
        private static RegistrationPage registrationPage;
        private static ProductsPage productsPage;

@BeforeAll
static void init(){
    WebdriverSetUp webdriverSetUp = new WebdriverSetUp();
    loginPage = new LoginPage();
    registrationPage = new RegistrationPage();
    productsPage = new ProductsPage();

}
    // LOGIN PAGE TESTS
    @Test
            public void testLogin() {
            //Given
                String existingUserEmail = "test@test.com";
                String existingUserPassword = "test";
            //When
               loginPage.loginProcess(existingUserEmail,existingUserPassword);
            // Then
                loginPage.checkUserIsRedirectToProducts();
            }

    @Test
    public void testActingOfEmailFieldOfLoginPage(){

        loginPage.openLoginPage();
        loginPage.checkOfEmailField();

    }
    @Test
    public void testActingOfLPasswordFieldOfLoginPage(){

        loginPage.openLoginPage();
        loginPage.checkOfPasswordField();

    }
    @Test
    public void testActingOfSubmitButtonFieldOfLoginPage(){

        loginPage.openLoginPage();
        loginPage.checkOfSubmitButtonField();
    }

    @Test
    public void testValidationEmailOfLoginForm() {
        //GIVEN

        String existingUserEmail = "testtestcom";

        //WHEN
        loginPage.openLoginPage();
        loginPage.setEmail(existingUserEmail);
        loginPage.submit();

        //THEN
        loginPage.checkValidationMessage();

    }

    // REGISTRATION PAGE TESTS
            @Test
            public void testRegistration(){
            //Given
            String existingUserName = "Andrey";
            String existingUserLastName = "Kalistratov";
            String existingUserEmail = "test@test.com";
            String existingUserPassword = "test";
                //When
                registrationPage.registrationProcess(existingUserName,existingUserLastName,existingUserEmail,existingUserPassword);

                //Then
                registrationPage.checkUserIsRedirectToLogin();

            }

    @Test
    public void ValidationMessageOfTestRegistrationForm(){
        //Given
        String existingUserName = "Andrey";
        String existingUserLastName = "Kalistratov";
        String existingUserEmail = "testtest.com";
        String existingUserPassword = "test";
        //When
        registrationPage.registrationProcess(existingUserName,existingUserLastName,existingUserEmail,existingUserPassword);

        //Then
        registrationPage.checkValidationMessageOfRegistrationForm();

    }

    @Test
    public void displayedNameFieldOfRegistrationForm(){
    registrationPage.openRegistrationPage();
    registrationPage.checkOfNameFieldOfRegistrationForm();
    }

    @Test
    public void displayedLastNameFieldOfRegistrationForm(){
        registrationPage.openRegistrationPage();
        registrationPage.checkOfLastNameFieldOfRegistrationForm();
    }
    @Test

    public void displayedEmailFieldOfRegistrationForm(){
        registrationPage.openRegistrationPage();
        registrationPage.checkOfEmailFieldOfRegistrationForm();
    }
    @Test

    public void displayedPasswordFieldOfRegistrationForm(){
        registrationPage.openRegistrationPage();
        registrationPage.checkOfPasswordFieldOfRegistrationForm();
    }
    @Test

    public void enabledRegisterButtonOfRegistrationForm(){
        registrationPage.openRegistrationPage();
        registrationPage.checkOfRegisterButtonOfRegistrationForm();
    }

// PRODUCTS PAGE TESTS

    @Test
    public void testRedirectingToAddProductsPage() {

        //Given
        String existingUserEmail = "test@test.com";
        String existingUserPassword = "test";
        //When
       // loginPage.openLoginPage();
        productsPage.openProductsPage();

        loginPage.loginProcess(existingUserEmail,existingUserPassword);

        productsPage.clickAddButton();

        // Then
        checkUserIsRedirectToAddProductsPage();

    }
    private void checkUserIsRedirectToAddProductsPage() {
        String currentUrl = WebdriverSetUp.driver.getCurrentUrl();
        String expectedResultLink = "http://online-sh.herokuapp.com/products/add";
        Assertions.assertEquals(expectedResultLink, currentUrl);
    }

   @Test
   public void testAddingOfTheNewProduct(){

            //Given
       String existingUserEmail = "test@test.com";
       String existingUserPassword = "test";
       String existingNameOfProduct = "Test";
       String existingPriceOfProduct = "1";
       //When

       loginPage.loginProcess(existingUserEmail,existingUserPassword );

       productsPage.clickAddButton();

       productsPage.addProductName(existingNameOfProduct);
       productsPage.addPriceName(existingPriceOfProduct);

       productsPage.submitAddPNewProductButton();

       checkUserIsRedirectToBackProductsPage();

   }
    private void checkUserIsRedirectToBackProductsPage() {
        String currentUrl = WebdriverSetUp.driver.getCurrentUrl();
        String expectedResultLink = "http://online-sh.herokuapp.com/products";
        Assertions.assertEquals(expectedResultLink, currentUrl);
    }

    @Test
    public void testUpdateOfTheProduct(){

        //Given
        String existingUserEmail = "test@test.com";
        String existingUserPassword = "test";

        //When

        loginPage.loginProcess(existingUserEmail,existingUserPassword);

        productsPage.clickUpdateTheProductButton();

        productsPage.clearTheProductName();
        productsPage.updateTheProductName("TestUpdated7");
        productsPage.clearThePriceName();
        productsPage.updateTheProductPrice("5");

        productsPage.submitOfTheUpdatedTheProductButton();
        //Then
        checkUpdatingOfTheProduct();

    }

    private void checkUpdatingOfTheProduct() {
        WebDriverWait wait = new WebDriverWait( WebdriverSetUp.driver, Duration.ofMillis(500L));
        WebElement updatedElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[text()[contains(., 'TestUpdated7')]])")));
        Assertions.assertTrue(updatedElement.isDisplayed());
    }

    @Test
    public void testDeleteTheProduct(){

        //Given
        String existingUserEmail = "test@test.com";
        String existingUserPassword = "test";

        //When

        loginPage.loginProcess(existingUserEmail,existingUserPassword );
        productsPage.clickDeleteTheProductButton();

        //Then
        checkDeleteOfTheProduct();

    }
    private void checkDeleteOfTheProduct() {
        String actualNameProducts = null;
        String expectedNameProducts = null;
        Assertions.assertEquals(expectedNameProducts,actualNameProducts);
    }

    @Test
    public void testLogOutFromTheProductPage(){
        //Given
        String existingUserEmail = "test@test.com";
        String existingUserPassword = "test";
        //When

        loginPage.loginProcess(existingUserEmail,existingUserPassword );
        productsPage.clickLogOutButtonOnTheProductPage();

        //Then
        checkOfReturnToTheLoginPage();

    }
    private void checkOfReturnToTheLoginPage() {
        String actualNameProductsPage = "http://online-sh.herokuapp.com/login";
        String expectedPage = WebdriverSetUp.driver.getCurrentUrl();
        Assertions.assertEquals(expectedPage,actualNameProductsPage);
    }

    @AfterEach
           public void driverclose() {
        WebdriverSetUp.driver.quit();
        }
}
