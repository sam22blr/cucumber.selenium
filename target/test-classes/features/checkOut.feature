Feature: Checkout product

  @checkout
  Scenario Outline: Search a product
    Given User is on the greencart landing page
    Then User enters the search word <name> on the search box
    Then User gets the filtered results containing product <name>
    And User adds <num> items to cart
    When User clicks on checkout and validate the <name> and <num> in checkout page
    Then User verifies promo code and place the order

    Examples: 
      | name | num |
      | tom  |   3 |
