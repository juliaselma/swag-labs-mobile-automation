Feature: Mobile Application Login
  As a user of the Swag Labs application
  I want to log in and access the product catalog

  @smoke @login @navigation
  Scenario Outline: 1. Successful LOGIN with valid credentials
    Given the application is running on a mobile device
    When I enter "<username>" in the username field
    And I enter "<password>" in the password field
    And I click the Login button
    Then I should be navigated to the Products screen

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @negative @login
  Scenario Outline: 2. User is unable to log in with invalid or missing credentials
    Given the application is running on a mobile device
    When I enter "<username>" in the username field
    And I enter "<password>" in the password field
    And I click the Login button
    Then the system should display the error message "<expected_error_message>"

    Examples:
      | username           | password       | expected_error_message                                     |
      |locked_out_user     | secret_sauce   | Sorry, this user has been locked out.                      |
      |invalid_user        | secret_sauce   |Username and password do not match any user in this service.|
      |standard_user       | invalid_pass   |Username and password do not match any user in this service.|
      |                    |secret_sauce    |Username is required                                        |
      |locked_out_user     |                |Password is required                                        |
