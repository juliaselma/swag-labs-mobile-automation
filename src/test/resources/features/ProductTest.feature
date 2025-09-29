Feature: Product Catalog Management
  As a logged-in shopper
  I want to view products and manage my cart from the catalog page.

  Background: User logs in successfully
    Given the application is running on a mobile device
    When I enter "standard_user" in the username field
    And I enter "secret_sauce" in the password field
    And I click the Login button
    Then I should be navigated to the Products screen

  @products @smoke
  Scenario: Verify successful loading and required elements
    Then the title PRODUCTS should be visible
    And the user should see the "Sauce Labs Backpack" listed
