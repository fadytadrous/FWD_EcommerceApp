Feature: Logged user could select different tags

  Scenario: Logged user could select camera tag
    Given user is logged in
    And user selects specific category
    When user selects Camera tag
    Then tag results should be displayed