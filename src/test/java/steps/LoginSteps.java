package steps;

import core.DriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProductScreen;


public class LoginSteps {
    private LoginPage loginPage;
    @Given("the application is running on a mobile device")
    public void the_application_is_running_on_a_mobile_device() {
        loginPage = new LoginPage(DriverSetup.getDriver());
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

    @Then("I should be navigated to the Dashboard screen")
    public void i_should_be_navigated_to_the_dashboard_screen() {
        ProductScreen productScreen= loginPage.clickLoginButton();
        Assert.assertTrue(productScreen.areProductsVisible(), "The products were not displayed, login failed.");

    }
}
