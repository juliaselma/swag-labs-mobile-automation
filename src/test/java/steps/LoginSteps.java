package steps;

import core.DriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginScreen;
import pages.ProductScreen;


public class LoginSteps {
    private LoginScreen loginScreen;
    public static ProductScreen productScreen;
    @Given("the application is running on a mobile device")
    public void the_application_is_running_on_a_mobile_device() {
        loginScreen = new LoginScreen(DriverSetup.getDriver());
    }

    @When("I enter {string} in the username field")
    public void i_enter_username_in_the_username_field(String username){
        loginScreen.enterUsername(username);
    }

    @When("I enter {string} in the password field")
    public void i_enter_password_in_the_password_field(String password) {
        loginScreen.enterPassword(password);
    }

    @When("I click the Login button")
    public void i_click_the_login_button() {
        LoginSteps.productScreen = loginScreen.clickLoginButton();
    }

    @Then("I should be navigated to the Products screen")
    public void i_should_be_navigated_to_the_products_screen() {
        ProductScreen productScreen = loginScreen.clickLoginButton();
        Assert.assertTrue(productScreen.isProductsTitleVisible(), "The products were not displayed, login failed.");
    }

    @Then("the system should display the error message {string}")
    public void the_system_should_display_the_error_message(String expectedErrorMessage) {
        String actualErrorMessage = loginScreen.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

    }

}
