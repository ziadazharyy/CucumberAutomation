package stepDefs;

import org.junit.Assert;
import org.junit.runner.RunWith;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

import pagesObjects.ProductsPage;
import resources.Base;

@RunWith(Cucumber.class)
public class TestCheckout extends Base {
    public ProductsPage productsPage;

    @And("Sort items with lower to higher")
    public void sort_items_with_lower_to_higher() {
        productsPage = new ProductsPage(driver);
        productsPage.getFilterSelectorLocator().click();
        productsPage.getOptionL2H().click();
        // Take screenshot
        saveScreenshot("Sorting low to high in filter", takeScreenshot());
    }

    @And("Check footer to make a scroll")
    public void check_footer_to_make_a_scroll() {
        productsPage = new ProductsPage(driver);
        productsPage.scrollUntilElementIsInView(productsPage.getFooter());
        String footerText = productsPage.getFooter().getText();
        Assert.assertEquals(footerText, productsPage.getExpectedFooterText());
        // Take screenshot
        saveScreenshot("Scroll to view footer", takeScreenshot());
    }

    @Then("User adds an item to the cart")
    public void user_adds_an_item_to_the_cart() {

        productsPage.getItemButton().click();

        // Take screenshot
        saveScreenshot("Adding item to cart", takeScreenshot());
    }

    @And("Item is successfully added to the cart")
    public void item_is_successfully_added_to_the_cart() {
        productsPage.scrollUntilElementIsInView(productsPage.getCart());

        // Take screenshot
        saveScreenshot("Item successfully added to cart", takeScreenshot());
    }

    @When("User goes to checkout")
    public void user_goes_to_checkout() {
        productsPage.getCart().click();
        saveScreenshot("Checkout", takeScreenshot());
        productsPage.getCheckout().click();

    }

    @And("User entered his info")
    public void userEnteredHisInfo() {
        productsPage.getFirstName().sendKeys("ziad");
        productsPage.getLastName().sendKeys("azhary");
        productsPage.getZipCode().sendKeys("123");

        saveScreenshot("User information during checkout", takeScreenshot());

        productsPage.getContinueButton().click();

    }

    @Then("Checkout page is displayed")
    public void checkout_page_is_displayed() {
        saveScreenshot("Checkout page", takeScreenshot());

        productsPage.scrollUntilElementIsInView(productsPage.getFinishButton());
        Assert.assertTrue(productsPage.getTotalItemPrice().getText().contains(productsPage.getItemPrice().getText()));

        productsPage.getFinishButton().click();
    }

    @And("Finished checkout")
    public void finishedCheckout() {
        Assert.assertEquals(productsPage.getThankYou().getText(),productsPage.getExpectedMessageText());
        saveScreenshot("Finished checkout", takeScreenshot());

        productsPage.getBackHomeButton().click();
        Assert.assertTrue(productsPage.checkIfProductsPageIsOpen());

    }

    // for update cart

    @When("User goes to cart")
    public void user_goes_to_cart(){
        productsPage.getCart().click();
        saveScreenshot("Goes to cart", takeScreenshot());
    }
    @And("User removes his item")
    public void user_removes_his_item(){

        Assert.assertTrue(productsPage.getItemInCartLocator().isDisplayed());
        System.out.println("displayed ");
        productsPage.getRemoveFromCartButton().click();
        saveScreenshot("User removes item from cart", takeScreenshot());

        Assert.assertFalse(productsPage.getItemInCartLocator().isDisplayed());
    }
    @Then("Try to continue shopping")
    public void try_to_continue_shopping() {
        productsPage.getContinueShoppingButton().click();
        Assert.assertTrue(productsPage.checkIfProductsPageIsOpen());

    }
    @And("User goes to cart again to check the removed items")
    public void user_goes_to_cart_again_to_check_the_removed_items(){

        productsPage.getCart().click();
        saveScreenshot("After updating cart", takeScreenshot());
        Assert.assertEquals(driver.getCurrentUrl(),productsPage.getCartUrl());
    }
}
