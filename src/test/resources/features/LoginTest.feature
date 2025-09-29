Feature: Mobile Application Login

  @smoke @login
  Scenario Outline: Successful login with valid credentials
    Given the application is running on a mobile device
    When I enter "<username>" in the username field
    And I enter "<password>" in the password field
    And I click the Login button
    Then I should be navigated to the Dashboard screen

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |