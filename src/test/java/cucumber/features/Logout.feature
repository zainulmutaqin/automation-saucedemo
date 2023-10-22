@saucedemo

Feature: Logout from Web Saucedemo

  @Logout
  Scenario: User Logout from Web
    Given user is already login
    And user click sidebar icon
    And user click logout
    Then user is on login page
