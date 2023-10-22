@saucedemo

Feature: Add Product

  Scenario: Add product to cart
    Given user is on product page
    When user Add Sauce Labs Backpack to Cart
    And user click cart icon
    Then user see Sauce Labs Backpack on cart