package AutoTestScenario;
import AutoTestPages.LoginPage;
import AutoTestPages.RegistrationPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class LoginTest {

        private static WebDriver driver;
        private static LoginPage loginPage;
        private static RegistrationPage registrationPage;

        public LoginTest() {

            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.setHeadless(false);
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);

            driver = new ChromeDriver(options);
            loginPage = new LoginPage(driver);
            registrationPage = new RegistrationPage(driver);

        }

    @Test
            public void testLogin() {
            //Given
                String existingUserEmail = "test@test.com";
                String existingUserPassword = "test";
            //When
                loginPage.openLoginPage();

                LoginTest.loginPage.setEmail(existingUserEmail);
                LoginTest.loginPage.setPassword(existingUserPassword);
                LoginTest.loginPage.submit();
            // Then
                checkUserIsRedirectToProducts();
            }

            private void checkUserIsRedirectToProducts(){
                String curruntUrl = driver.getCurrentUrl();
                Assertions.assertEquals("http://online-sh.herokuapp.com/products", curruntUrl);
            }

            @Test
            public void testRegistration(){
            //Given
            String existingUserName = "Andrey";
            String existingUserLastName = "Kalistratov";
            String existingUserEmail = "test@test.com";
            String existingUserPassword = "test";
                //When
                registrationPage.openRegistrationPage();
                LoginTest.registrationPage.setName(existingUserName);
                LoginTest.registrationPage.setLastName(existingUserLastName);
                LoginTest.registrationPage.setEmailRegistration(existingUserEmail);
                LoginTest.registrationPage.setPasswordRegistration(existingUserPassword);
                LoginTest.registrationPage.submitRegistration();

                //Then
                checkUserIsRedirectToLogin();

            }
         private void checkUserIsRedirectToLogin(){
        String curruntUrl = driver.getCurrentUrl();
        Assertions.assertEquals("http://online-sh.herokuapp.com/login", curruntUrl);
    }


    @AfterEach
           public void driverclose() {
                    driver.close();
                    driver.quit();
        }
}
