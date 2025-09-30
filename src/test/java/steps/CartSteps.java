package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartScreen;

public class CartSteps {
    private CartScreen cartScreen;
    public CartSteps() {
        this.cartScreen = ProductSteps.cartScreen;
    }
    @Given("the user has successfully added {string} to the cart and is on the Cart page")
    public void the_user_has_successfully_added_item_and_is_on_cart_page(String productName) {
        Assert.assertNotNull(this.cartScreen, "CartScreen object is NULL. Initial setup failed.");
        Assert.assertTrue(cartScreen.isCartTitleDisplayed(), "Pre-condition failed: Not on Cart Page.");
        Assert.assertTrue(cartScreen.isProductListed(productName), "Pre-condition failed: Item not in cart.");
    }

    @Then("the product {string} should be listed in the cart")
    public void the_product_should_be_listed_in_the_cart(String productName) {
        Assert.assertTrue(
                cartScreen.isProductListed(productName),
                "The product '" + productName + "' was not found in the shopping cart."
        );
    }
    @Then("the quantity for {string} should be {string}")
    public void the_quantity_for_should_be(String productName, String expectedQty) {
        String actualQty = cartScreen.getProductQuantity(productName);
        Assert.assertEquals(actualQty, expectedQty, "Quantity for " + productName + " is incorrect.");
    }
    @Then("the price for {string} should be {string}")
    public void the_price_for_should_be(String productName, String expectedPrice) {
        String actualPrice = cartScreen.getProductPrice(productName);
        Assert.assertEquals(
                actualPrice,
                expectedPrice,
                "The price for '" + productName + "' is incorrect."
        );
    }
    @When("the user clicks the \"REMOVE\" button for {string}")
    public void the_user_clicks_the_remove_button_for(String productName) {
        cartScreen.clickRemoveButton(productName);
    }
    @Then("the product {string} should NOT be listed in the cart")
    public void the_product_should_not_be_listed_in_the_cart(String productName) {
        Assert.assertTrue(
                cartScreen.isProductNotListed(productName),
                "The product '" + productName + "' was still found in the shopping cart after removal."
        );
    }
    @When("the user clicks the \"CHECKOUT\" button")
    public void the_user_clicks_the_checkout_button() {
        ProductSteps.checkoutInformationScreen = cartScreen.clickCheckoutButton();
    }
    @Then("the user should be navigated to the \"Checkout: Your Information\" page")
    public void the_user_should_be_navigated_to_the_checkout_information_page() {
        Assert.assertNotNull(ProductSteps.checkoutInformationScreen, "Checkout page object is NULL. Navigation failed.");

        Assert.assertTrue(
                ProductSteps.checkoutInformationScreen.isCheckoutTitleDisplayed(),
                "Navigation failed: Did not land on the Checkout Information page."
        );
    }
}