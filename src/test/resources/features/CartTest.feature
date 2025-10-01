@feature @cart
Feature: Mobile Application Cart Interaction and Verification
  As a standard user
  I want to view my shopping cart
  So that I can verify items and proceed to checkout

  Background:
    Given the user is successfully logged in and on the Products page

  @cart @verification
  Scenario Outline: Verify item and details are correctly displayed in the cart
    When the user clicks the ADD TO CART button for "<productName>"
    And the user clicks the Shopping Cart icon
    Then the product "<productName>" should be listed in the cart
    And the quantity for "<productName>" should be "<expectedQty>"
    And the price for "<productName>" should be "<expectedPrice>"

    Examples:
      | productName           | expectedQty | expectedPrice |
      | Sauce Labs Backpack   | 1           | $29.99        |

  @cart @removal
  Scenario Outline: Remove an item from the Cart
    Given the user clicks the ADD TO CART button for "<Product Name>"
    And the user clicks the Shopping Cart icon
    When the user clicks the "REMOVE" button for "<Product Name>"
    Then the product "<Product Name>" should NOT be listed in the cart

    Examples:
      | Product Name |
      | Sauce Labs Backpack |

  @cart @navigation
  Scenario Outline: Navigate to the Checkout Information page
    Given the user clicks the ADD TO CART button for "<Product Name>"
    And the user clicks the Shopping Cart icon
    When the user clicks the "CHECKOUT" button
    Then the user should be navigated to the "Checkout: Your Information" page

    Examples:
      | Product Name |
      | Sauce Labs Backpack |