package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
public class LoginSteps {
    private final TestContext context;
    public LoginSteps(TestContext context) { this.context = context; }
    @Given("the application is running on a mobile device")
    public void the_application_is_running_on_a_mobile_device() {
    }
    @When("I enter {string} in the username field")
    public void i_enter_username_in_the_username_field(String username){
        context.loginScreen.enterUsername(username);
    }
    @When("I enter {string} in the password field")
    public void i_enter_password_in_the_password_field(String password) {
        context.loginScreen.enterPassword(password);
    }
    @When("I click the Login button")
    public void i_click_the_login_button() {
        context.productScreen = context.loginScreen.clickLoginButton();
    }
    @Then("I should be navigated to the Products screen")
    public void i_should_be_navigated_to_the_products_screen() {
        Assert.assertTrue(context.productScreen.isProductsTitleVisible(), "The products were not displayed.");
    }
    @Then("the system should display the error message {string}")
    public void the_system_should_display_the_error_message(String expectedErrorMessage) {
        String actualErrorMessage = context.loginScreen.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }
    @Given("the user is successfully logged in and on the Products page")
    public void the_user_is_successfully_logged_in_and_on_the_products_page() {
        context.loginScreen.enterUsername("standard_user");
        context.loginScreen.enterPassword("secret_sauce");
        context.productScreen = context.loginScreen.clickLoginButton();
        Assert.assertTrue(
                context.productScreen.isProductsTitleVisible(),
                "Login failed: Not navigated to the Products page."
        );
    }
}
