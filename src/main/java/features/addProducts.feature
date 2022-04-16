Feature: Logged user could add different products to Shopping cart, wishlist and comparison

  Scenario: add mobile to cart
    Given user is logged in
    When user adds mobile to cart
    Then product will be added to cart


  Scenario: add mobile to wishlist
    Given user is logged in
    When user adds mobile to wishlist
    Then product will be added to wishlist


  Scenario: add products to comparison
    Given user is logged in
    When user adds product to compare list
    Then product will be added to compare list
