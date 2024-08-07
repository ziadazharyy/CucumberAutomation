package pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.Base;

import java.time.Duration;

public class ProductsPage extends Base {
    private WebDriver driver;

    // Locators
    private String productsUrl = "https://www.saucedemo.com/inventory.html";
    private String cartUrl = "https://www.saucedemo.com/cart.html";
    private By checkoutButtonLocator = By.xpath("//*[@id=\"checkout\"]");
    private By thankYouText = By.xpath("/html/body/div[1]/div/div/div[2]/h2");
    private By continueButtonLocator = By.id("continue");
    private By finishButtonLocator = By.id("finish");
    private By firstNameLocator = By.xpath("//*[@id=\"first-name\"]");
    private By lastNameLocator = By.xpath("//*[@id=\"last-name\"]");
    private By zipCodeLocator = By.xpath("//*[@id=\"postal-code\"]");
    private String expectedFooterText = "© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
    private By footerLocator = By.xpath(("/html/body/div[1]/div/footer/div"));
    private By cartLocator = By.xpath("/html/body/div[1]/div/div/div[1]/div[1]/div[3]/a");
    private By addToCartButtonLocator_Jacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private By itemPriceLocator = By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div");
    private By totalItemPriceLocator = By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div[6]");
    private By backHomeButtonLocator = By.xpath("//*[@id=\"back-to-products\"]");
    private String expectedMessageText = "Thank you for your order!";
    private By removeFromCartButtonLocator = By.xpath("//*[@id=\"remove-sauce-labs-fleece-jacket\"]");
    private By itemInCartLocator = By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div[3]");
    private By continueShoppingButtonLocator = By.xpath("//*[@id=\"continue-shopping\"]");
    private By filterSelectorLocator = By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select");
    private By optionL2H_Locator = By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select/option[3]");

    // Constructor
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods

    public WebElement getFooter() {

        return driver.findElement(footerLocator);
    }

    public WebElement getItemButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButtonLocator_Jacket));

        return element;
    }

    public WebElement getCart() {
        return driver.findElement(cartLocator);
    }

    public WebElement getFinishButton() {
        return driver.findElement(finishButtonLocator);
    }

    public WebElement getThankYou() {
        return driver.findElement(thankYouText);
    }

    public WebElement getFirstName() {
        return driver.findElement(firstNameLocator);
    }

    public WebElement getLastName() {
        return driver.findElement(lastNameLocator);
    }

    public WebElement getContinueButton() {
        return driver.findElement(continueButtonLocator);
    }

    public WebElement getZipCode() {
        return driver.findElement(zipCodeLocator);
    }

    public WebElement getCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButtonLocator));
        return driver.findElement(checkoutButtonLocator);
    }

    public WebElement getItemPrice() {
        return driver.findElement(itemPriceLocator);
    }

    public WebElement getTotalItemPrice() {
        return driver.findElement(totalItemPriceLocator);
    }

    public String getExpectedMessageText() {
        return expectedMessageText;
    }

    public void scrollUntilElementIsInView(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public String getExpectedFooterText() {
        return expectedFooterText;
    }

    public WebElement getBackHomeButton() {
        return driver.findElement(backHomeButtonLocator);
    }

    public WebElement getRemoveFromCartButton() {
        return driver.findElement(removeFromCartButtonLocator);
    }

    public WebElement getItemInCartLocator() {
        return driver.findElement(itemInCartLocator);
    }

    public WebElement getContinueShoppingButton() {
        return driver.findElement(continueShoppingButtonLocator);
    }

    public WebElement getFilterSelectorLocator() {
        return driver.findElement(filterSelectorLocator);
    }
    public WebElement getOptionL2H() {
        return driver.findElement(optionL2H_Locator);
    }

    public boolean checkIfProductsPageIsOpen() {
        if (driver.getCurrentUrl().equalsIgnoreCase(productsUrl))
            return true;
        else {
            return false;
        }
    }

    public String getCartUrl() {
        return cartUrl;
    }
    public String getProductsUrl() {
        return productsUrl;
    }

}
