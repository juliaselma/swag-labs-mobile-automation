package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CartSteps {
    private final TestContext context;
    public CartSteps(TestContext context) { this.context = context; }
    @Given("the user has successfully added {string} to the cart and is on the Cart page")
    public void the_user_has_successfully_added_item_and_is_on_cart_page(String productName) {
        Assert.assertNotNull(this.context.cartScreen, "CartScreen object is NULL. Initial setup failed.");
        Assert.assertTrue(context.cartScreen.isCartTitleDisplayed(), "Pre-condition failed: Not on Cart Page.");
        Assert.assertTrue(context.cartScreen.isProductListed(productName), "Pre-condition failed: Item not in cart.");
    }
    @Then("the product {string} should be listed in the cart")
    public void the_product_should_be_listed_in_the_cart(String productName) {
        Assert.assertTrue(
                context.cartScreen.isProductListed(productName),
                "The product '" + productName + "' was not found in the shopping cart."
        );
    }
    @Then("the quantity for {string} should be {string}")
    public void the_quantity_for_should_be(String productName, String expectedQty) {
        String actualQty = context.cartScreen.getProductQuantity(productName);
        Assert.assertEquals(actualQty, expectedQty, "Quantity for " + productName + " is incorrect.");
    }
    @Then("the price for {string} should be {string}")
    public void the_price_for_should_be(String productName, String expectedPrice) {
        String actualPrice = context.cartScreen.getProductPrice(productName);
        Assert.assertEquals(
                actualPrice,
                expectedPrice,
                "The price for '" + productName + "' is incorrect."
        );
    }
    @When("the user clicks the \"REMOVE\" button for {string}")
    public void the_user_clicks_the_remove_button_for(String productName) {
        context.cartScreen.clickRemoveButton(productName);
    }
    @Then("the product {string} should NOT be listed in the cart")
    public void the_product_should_not_be_listed_in_the_cart(String productName) {
        Assert.assertTrue(
                context.cartScreen.isProductNotListed(productName),
                "The product '" + productName + "' was still found in the shopping cart after removal."
        );
    }
    @When("the user clicks the \"CHECKOUT\" button")
    public void the_user_clicks_the_checkout_button() {
        context.checkoutInformationScreen = context.cartScreen.clickCheckoutButton();
    }
    @Then("the user should be navigated to the \"Checkout: Your Information\" page")
    public void the_user_should_be_navigated_to_the_checkout_information_page() {
        Assert.assertNotNull(context.checkoutInformationScreen, "Checkout page object is NULL. Navigation failed.");

        Assert.assertTrue(
                context.checkoutInformationScreen.isCheckoutTitleDisplayed(),
                "Navigation failed: Did not land on the Checkout Information page."
        );
    }
}