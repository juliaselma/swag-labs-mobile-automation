package steps;

import io.cucumber.java.en.Then;
import pages.ProductScreen;
import org.testng.Assert;

public class ProductSteps {
    private ProductScreen productScreen;

    public ProductSteps() {
        this.productScreen = LoginSteps.productScreen;
        if (this.productScreen == null) {
            System.err.println("ProductScreen object is NULL. Ensure login was performed.");
        }
    }
    @Then("the title PRODUCTS should be visible")
    public void the_title_should_be_visible() {
        Assert.assertTrue(productScreen.isProductsTitleVisible(), "The 'PRODUCTS' title is not visible.");
    }
    @Then("the user should see the {string} listed")
    public void the_user_should_see_the_listed(String productName) {
        Assert.assertTrue(
                productScreen.isProductListed(productName),
                "The product '" + productName + "' was not found on the Products screen."
        );
    }
}
