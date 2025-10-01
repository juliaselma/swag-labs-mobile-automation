package steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CheckoutInformationSteps {
    private final TestContext context;
    public CheckoutInformationSteps (TestContext context) { this.context = context; }

    @Given("the user is on the \"Checkout: Information\" screen")
    public void userIsOnTheScreen() {
        context.loginScreen.enterUsername("standard_user");
        context.loginScreen.enterPassword("secret_sauce");
        context.productScreen = context.loginScreen.clickLoginButton();
        context.productScreen.clickAddToCartButton("Sauce Labs Backpack");
        context.cartScreen =context.productScreen.clickCartIcon();
        context.checkoutInformationScreen =context.cartScreen.clickCheckoutButton();
        Assert.assertTrue(context.checkoutInformationScreen.isCheckoutTitleDisplayed());
    }

    @When("the user enters the First Name {string}")
    public void userEntersFirstName(String firstName) {
        context.checkoutInformationScreen.enterUsername(firstName);
    }

    @When("the user enters the Last Name {string}")
    public void userEntersLastName(String lastName) {
        context.checkoutInformationScreen.enterLastName(lastName);
    }

    @And("the user enters the Zip/Postal Code {string}")
    public void userEntersZipPostalCode(String zipCode) {
        context.checkoutInformationScreen.enterPostalCode(zipCode);
    }

    @When("the user taps the {string} button")
    public void userTapsButton(String buttonName) {
        context.checkoutInformationScreen.tapButton(buttonName);
    }

    @Then("the user should be redirected to the {string} screen")
    public void userShouldBeRedirectedToNextScreen(String nextScreen) {
        context.checkoutOverviewScreen = context.checkoutInformationScreen.tapContinue();
        Assert.assertTrue(context.checkoutOverviewScreen.isScreenDisplayed());
    }

}
