Feature: search for products

  Scenario: Logged User could search for any product
    Given user is logged in
    When user searches for a product
    Then user should see search results