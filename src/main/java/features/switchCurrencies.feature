Feature: switch between currencies US-Euro

  Scenario: Logged User could switch between currencies US-Euro
    Given user is logged in
    When user switches currency
    Then prices should be shown in that currency