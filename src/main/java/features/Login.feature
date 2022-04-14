Feature: login

  Scenario: user could login with valid email and password
    Given user clicks on login
    When user enters email and password
    And clicks on login
    Then user should login successfully