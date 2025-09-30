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
 Scenario Outline: Verify successful loading and required elements
    Then the title PRODUCTS should be visible
    And the user should see the "<productName>" listed
    Examples:
      | productName         |
      | Sauce Labs Backpack |
      |Sauce Labs Bike Light|

  @products
 Scenario Outline: Add an item to the cart and verify status
    When the user clicks the ADD TO CART button for "<productName>"
    Then the cart badge count should be <count>
    And the button for "<productName>" should display "<expectedButtonText>"
    Examples:
      | productName         | count | expectedButtonText|
      | Sauce Labs Backpack | 1     |REMOVE             |
      |Sauce Labs Bike Light|1      |REMOVE             |

  @products
 Scenario Outline: Remove an item from the cart
    When the user clicks the ADD TO CART button for "<productName>"
    Then the cart badge count should be <initialCount>
    When the user clicks the REMOVE button for "<productName>"
    Then the cart badge count should be <afterRemoveCount>
    And the button for "<productName>" should display "<expectedButtonText>"

    Examples:
      | productName         | initialCount | afterRemoveCount | expectedButtonText|
      | Sauce Labs Backpack | 1            |0                 |ADD TO CART        |
      |Sauce Labs Bike Light| 1            |0                 |ADD TO CART        |


  @products @navigation
  Scenario: Navigate to the shopping cart
    Given the user clicks the ADD TO CART button for "Sauce Labs Backpack"
    When the user clicks the Shopping Cart icon
    Then the user should be navigated to the Cart page

