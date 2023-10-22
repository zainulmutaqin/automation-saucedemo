@saucedemo

Feature: Login to Web Saucedemo

  @Login @Positive
  Scenario: Success Login
    Given user is on web sauce demo
    When user input username "standard_user"
    And user input password "secret_sauce"
    And user click login
    Then user redirect to product page

  @Login @Positive
  Scenario: Failed Login
    Given user is on web sauce demo
    When user input username "standard"
    And user input password "secret"
    And user click login
    Then user get an error message
