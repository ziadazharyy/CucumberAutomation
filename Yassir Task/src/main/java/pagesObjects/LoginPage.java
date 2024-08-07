package pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class LoginPage extends Base {

    private WebDriver driver;

    private String pageUrl = "https://www.saucedemo.com/";
    // Locators
    private By usernameInputLocator = By.id("user-name");
    private By passwordInputLocator = By.id("password");
    private By loginButtonLocator = By.xpath("//*[@id=\"login-button\"]");
    private By errorMessage = By.xpath(("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3"));

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods
    public void enterUsername(String username) {
        WebElement emailInput = driver.findElement(usernameInputLocator);
        emailInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    public WebElement getAlertMessage()
    {
        return driver.findElement(errorMessage);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
    public boolean checkIfLoginPageIsOpen() {
        if(driver.getCurrentUrl().equalsIgnoreCase(pageUrl))
            return true;
        else {
            return false;
        }
    }

    public String getPageUrl() {
        return pageUrl;
    }

}
