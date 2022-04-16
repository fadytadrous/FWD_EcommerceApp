Feature: filter with color

  Scenario: Logged user could filter with color
    Given user is logged in
    And user selects specific category
    When user filters with color
    Then results should be filtered