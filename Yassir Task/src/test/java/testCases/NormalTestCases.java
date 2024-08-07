package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pagesObjects.LoginPage;
import pagesObjects.ProductsPage;
import resources.Base;

public class NormalTestCases extends Base {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;

    @BeforeMethod
    public void setUp() {
        // Set up WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Initialize objects
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void loginWithValidCredentials() {

        // Navigate to the login page
        driver.get("https://www.saucedemo.com/");

        // Verify if the login page is open
        Assert.assertTrue(loginPage.checkIfLoginPageIsOpen(), "Login page is not open");

        // Enter valid username and password hen click login
        loginPage.login("standard_user","secret_sauce");

        // Verify if login is successful (redirects to inventory page)
        Assert.assertEquals(driver.getCurrentUrl(), productsPage.getProductsUrl(), "Login failed");
    }
    @Test
    public void loginWithInvalidCredentials() {

        // Navigate to the login page
        driver.get("https://www.saucedemo.com/");

        // Verify if the login page is open
        Assert.assertTrue(loginPage.checkIfLoginPageIsOpen(), "Login page is not open");

        // Enter valid username and password hen click login
        loginPage.login("invalidUsername","wrongPass");

        // Assert on Error message
        Assert.assertEquals(loginPage.getAlertMessage().getText(),"Epic sadface: Username and password do not match any user in this service");

        // Verify if login is successful (redirects to inventory page)
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getPageUrl());
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.close();
    }
}
