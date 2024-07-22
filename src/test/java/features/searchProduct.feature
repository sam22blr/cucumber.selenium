Feature: Search product

  @search
  Scenario Outline: Search a product
    Given User is on the greencart landing page
    Then User enters the search word <name> on the search box
    Then User gets the filtered results containing product <name>
    When User clicks on the link Top Deals
    Then User enters the search word <name> on the search field
    And User verifies the search result

    Examples: 
      | name |
      | tom  |
      | beet |
