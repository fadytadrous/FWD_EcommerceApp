Feature: Create successful Order

  Scenario: logged user should be able to create successful order
    Given user is logged in
    When user adds mobile to cart
    And proceeds to checkout
    And fills address details
    Then successful Order will be created