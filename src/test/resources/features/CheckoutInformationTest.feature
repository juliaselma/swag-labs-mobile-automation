@feature @checkout
Feature: Checkout Information - Happy Path

  Background:
    Given the user is on the "Checkout: Information" screen

  Scenario Outline: User successfully enters valid information and proceeds
    When the user enters the First Name "<username>"
    And the user enters the Last Name "<lastname>"
    And the user enters the Postal Code "<postalCode>"
    And the user taps the "<buttonName>" button
    Then the user should be redirected to the next screen

    Examples:
      | username      | lastname     | postalCode | buttonName|
      | Julia         | Selma Acevedo| 29768      | CONTINUE  |
      |Lautaro Franco |Marchi        | M8667C     | CONTINUE  |

  Scenario Outline: User successfully enters valid information and proceeds
    When the user enters the First Name "<username>"
    And the user enters the Last Name "<lastname>"
    And the user enters the Postal Code "<postalCode>"
    And the user taps the "<buttonName>" button
    Then I should be navigated to the Products screen

    Examples:
      | username      | lastname     | postalCode | buttonName |
      | Julia         | Selma Acevedo| 29768      | CANCEL     |
      |Lautaro Franco | Marchi       | M8667C     | CANCEL     |

