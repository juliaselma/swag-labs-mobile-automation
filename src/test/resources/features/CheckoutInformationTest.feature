@feature @checkout
Feature: Checkout Information - Happy Path

  Background:
    Given the user is on the "Checkout: Information" screen

  Scenario: User successfully enters valid information and proceeds
    When the user enters the First Name "Julia"
    And the user enters the Last Name "Selma"
    And the user enters the Postal Code "29640"
    And the user taps the "CONTINUE" button
    Then the user should be redirected to the next screen

  Scenario: User successfully enters valid information and proceeds
    When the user enters the First Name "Julia"
    And the user enters the Last Name "Selma"
    And the user enters the Postal Code "29640"
    And the user taps the "CANCEL" button
    Then I should be navigated to the Products screen

