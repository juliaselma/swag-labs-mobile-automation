package steps;

import core.DriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import org.testng.Assert;
import pages.ProductScreen;


public class LoginSteps {
    @Given("the application is running on a mobile device")
    public void the_application_is_running_on_a_mobile_device() {
    }

    @When("I enter {string} in the username field")
    public void i_enter_username_in_the_username_field(String username) {
        DriverSetup.LoginPage.enterUsername(username);
    }

    @When("I enter {string} in the password field")
    public void i_enter_password_in_the_password_field(String password) {
        DriverSetup.LoginPage.enterPassword(password);
    }

    @When("I click the Login button")
    public ProductScreen i_click_the_login_button() {
        return DriverSetup.LoginPage.clickLoginButton();
    }

    @Then("I should be navigated to the Dashboard screen")
    public void i_should_be_navigated_to_the_dashboard_screen() {
        ProductScreen productScreen= DriverSetup.LoginPage.clickLoginButton();
        Assert.assertTrue(productScreen.areProductsVisible(), "The products were not displayed, login failed.");

    }
}
