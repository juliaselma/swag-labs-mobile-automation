package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckoutOverviewSteps {
    private final TestContext context;
    public CheckoutOverviewSteps (TestContext context) { this.context = context; }

    @Given("the user has added items to the cart")
    public void the_user_has_added_items_to_the_cart() {
        context.loginScreen.enterUsername("standard_user");
        context.loginScreen.enterPassword("secret_sauce");
        context.productScreen = context.loginScreen.clickLoginButton();
        context.productScreen.clickAddToCartButton("Sauce Labs Backpack");
        context.cartScreen =context.productScreen.clickCartIcon();
        context.checkoutInformationScreen =context.cartScreen.clickCheckoutButton();
    }
    @And("the user has entered valid shipping information")
    public void the_user_has_entered_valid_shipping_information() {
        context.checkoutInformationScreen.enterUsername("Julia");
        context.checkoutInformationScreen.enterLastName("Selma");
        context.checkoutInformationScreen.enterPostalCode("29640");
        context.checkoutOverviewScreen = context.checkoutInformationScreen.tapContinue();
    }
    @And("the user is on the Checkout: Overview screen")
    public void the_user_is_on_the_screen() {
        Assert.assertTrue(context.checkoutOverviewScreen.isScreenDisplayed());
    }

    @When("the user taps the FINISH button to resume purchase")
    public void the_user_taps_the_FINISH_button_to_resume_purchase() {
        context.checkoutOverviewScreen.tapFinishButton();
    }

    @Then("the user should be redirected to the Checkout: Complete screen")
    public void the_user_should_be_redirected_to_the_checkout_complete_screen() {
        context.confirmationScreen = context.checkoutOverviewScreen.tapFinishButton();
        Assert.assertTrue(context.confirmationScreen.isScreenDisplayed());
    }
    @Then("the order completion message {string} should be visible")
    public void the_order_completion_message_should_be_visible(String string) {
    }
}
