@saucedemo

Feature: Order Item

  Scenario: User order item until complete
    Given user is already login in web
    When user add item to cart
    And user click Checkout
    And user input first name "Zainul"
    And user input last name "Mutaqin"
    And user input postal code "78789"
    And user click Continue
    Then user is on checkout overview page
    And user click Finish
    Then user get info checkout complete