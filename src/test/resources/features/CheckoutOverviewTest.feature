@feature @overview
Feature: Checkout Overview - Verification and Finish

  Background:
    Given the user has added items to the cart
    And the user has entered valid shipping information
    And the user is on the Checkout: Overview screen

  #Scenario: Verify all order details are correctly displayed
    # Item details verification
    #Then the "Checkout: Overview" screen should display the correct number of items
    #And the item "Sauce Labs Backpack" should be visible with quantity "1"

    # Pricing verification
    #And the "Item Total" should be correctly calculated as "$X.XX"
    #And the "Tax" should be correctly calculated as "$Y.YY"
    #And the "Total" price should be correctly calculated as "$Z.ZZ"

    # Information verification
    #And the "Payment Information" should show "SauceCard #31337"
    #And the "Shipping Information" should show "Free Pony Express Delivery!"

  Scenario: User successfully completes the order
    When the user taps the FINISH button to resume purchase
    Then the user should be redirected to the Checkout: Complete screen
    And the order completion message "CHECKOUT: COMPLETE!" should be visible