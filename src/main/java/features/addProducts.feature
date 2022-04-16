Feature: Logged user could add different products to Shopping cart
  Scenario: add mobile to cart
    Given user is logged in
    When user adds mobile to cart
    Then product will be added to cart