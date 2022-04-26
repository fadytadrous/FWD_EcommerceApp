Feature: select Random Categories
  @smokeTest
  Scenario: logged user could select different Categories
    Given user is logged in
    When user selects random category
    Then category results will be shown