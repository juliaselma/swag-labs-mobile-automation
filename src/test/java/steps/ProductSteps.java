package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartScreen;
import pages.CheckoutInformationScreen;
import pages.ProductScreen;
import org.testng.Assert;

public class ProductSteps {
    private ProductScreen productScreen;
    public static CartScreen cartScreen;
    public static CheckoutInformationScreen checkoutInformationScreen;
    @Then("the title PRODUCTS should be visible")
    public void the_title_should_be_visible() {
        this.productScreen = LoginSteps.productScreen;
        Assert.assertTrue(productScreen.isProductsTitleVisible(), "The 'PRODUCTS' title is not visible.");
    }
    @Then("the user should see the {string} listed")
    public void the_user_should_see_the_listed(String productName) {
        this.productScreen = LoginSteps.productScreen;
        Assert.assertTrue(

                productScreen.isProductListed(productName),
                "The product '" + productName + "' was not found on the Products screen."
        );
    }
    @When("the user clicks the ADD TO CART button for {string}")
    public void the_user_clicks_the_ADD_TO_CART_button_for(String productName) {
        this.productScreen = LoginSteps.productScreen;
        productScreen.clickAddToCartButton(productName);
    }
    @Then("the cart badge count should be {int}")
    public void the_cart_badge_count_should_be(Integer expectedCount) {
        this.productScreen = LoginSteps.productScreen;
        int actualCount = productScreen.getCartBadgeCount();

        Assert.assertEquals(
                actualCount,
                expectedCount,
                "The cart badge count was not " + expectedCount + ". Found: " + actualCount
        );
    }
    @Then("the button for {string} should display {string}")
    public void the_button_for_should_display(String expectedText, String productName) {
        this.productScreen = LoginSteps.productScreen;
        Assert.assertTrue(
                productScreen.isProductButtonTextDisplayed(productName, expectedText),
                String.format("Button for '%s' did not display '%s' as expected.", productName, expectedText)
        );
    }
    @When("the user clicks the REMOVE button for {string}")
    public void the_user_clicks_the_REMOVE_button_for( String productName) {
        this.productScreen = LoginSteps.productScreen;
        productScreen.clickRemoveButton(productName);
    }
    @When("the user clicks the Shopping Cart icon")
    public void the_user_clicks_the_shopping_cart_icon() {
        this.productScreen = LoginSteps.productScreen;
        ProductSteps.cartScreen = productScreen.clickCartIcon();
    }
    @Then("the user should be navigated to the Cart page")
    public void the_user_should_be_navigated_to_the_cart_page() {
        this.productScreen = LoginSteps.productScreen;
        Assert.assertNotNull(ProductSteps.cartScreen, "CartScreen object is NULL. Navigation failed.");
        Assert.assertTrue(
                ProductSteps.cartScreen.isCartTitleDisplayed(),
                "Navigation failed: 'YOUR CART' title is not visible."
        );
    }
}
