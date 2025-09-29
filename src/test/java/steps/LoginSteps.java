package steps;

import core.DriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginScreen;
import pages.ProductScreen;


public class LoginSteps {
    private LoginScreen loginPage;
    private ProductScreen productPage;
    @Given("the application is running on a mobile device")
    public void the_application_is_running_on_a_mobile_device() {
        loginPage = new LoginScreen(DriverSetup.getDriver());
    }

    @When("I enter {string} in the username field")
    public void i_enter_username_in_the_username_field(String username){
        loginPage.enterUsername(username);
    }

    @When("I enter {string} in the password field")
    public void i_enter_password_in_the_password_field(String password) {
        loginPage.enterPassword(password);
    }

    @When("I click the Login button")
    public ProductScreen i_click_the_login_button() {
        return loginPage.clickLoginButton();
    }

    @Then("I should be navigated to the Products screen")
    public void i_should_be_navigated_to_the_products_screen() {
        ProductScreen productPage = loginPage.clickLoginButton();
        Assert.assertTrue(productPage.areProductsVisible(), "The products were not displayed, login failed.");
    }

    @Then("the system should display the error message {string}")
    public void the_system_should_display_the_error_message(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

    }

}
