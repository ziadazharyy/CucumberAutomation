package stepDefs;

import org.junit.runner.RunWith;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

import java.io.IOException;

import org.junit.Assert;
import pagesObjects.LoginPage;
import resources.Base;

@RunWith(Cucumber.class)
public class TestLogin extends Base {
    public LoginPage loginPage;

    @Given("User is on {string} landing page")
    public void user_is_on_landing_page(String pageUrl) throws IOException {
        driver = initializeDriver();
        driver.get(pageUrl);
    }

    @When("Login page is opened")
    public void Login_page_is_opened() {
        loginPage = new LoginPage(driver);
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getPageUrl());
    }

    @Then("User enters {string} and {string} and clicks sign in button")
    public void user_enters_and_clicks_sign_in_button(String username, String password) {
        loginPage.login(username, password);

    }

    // region
    // Checking invalid login credentials Test Case
    @And("User enters invalid {string} and {string} and clicks sign in button")
    public void user_enters_invalid_and_clicks_sign_in_button(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("User should see an error message {string}")
    public void user_should_see_an_error_message(String errorMessage) {
        Assert.assertTrue(loginPage.getAlertMessage().getText().contains(errorMessage));
    }
    //endregion

    @And("Close browser")
    public void close_browser() {
        driver.close();
    }

}
