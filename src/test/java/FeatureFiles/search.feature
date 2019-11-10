Feature: User is going to search for vegetable and proceed to checkout.
Scenario: User will search for items and validate the results
  Given User will navigate to website
  When User searches for "Cucumber"
  Then "Cucumber" result is displayed


  Scenario Outline: Search for items and then move to the checkOut.
    Given User will navigate to website
    When User searches for "<Name>" Vegetable
    And Added items to the cart
    And User proceed to the checkout page
    Then Verify selected "<Name>" items are displayed in the checkout page
    Examples:
    |Name|
    |Brinjal|
    |Beetroot|

  @last
    Scenario: Add two or more items to the cart and validate results
    Given User will navigate to website
    When user added more than one item to the cart
    Then user proceed to the CheckOut Page
    And Verify selected items are displayed in the checkout page